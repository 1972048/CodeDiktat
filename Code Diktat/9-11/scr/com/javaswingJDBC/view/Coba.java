package com.javaswingJDBC.view;

import com.javaswingJDBC.dao.CourseDaoImpl;
import com.javaswingJDBC.dao.CurriculumDaoImpl;
import com.javaswingJDBC.entity.Course;
import com.javaswingJDBC.entity.Curriculum;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Coba {
    private JPanel root;
    private JTextField IDT;
    private JTextField NT;
    private JComboBox CC;
    private JButton Caddbutton;
    private JButton Save;
    private JButton Update;
    private JButton Delete;
    private JButton Reset;
    private JTable tableCourse;
    private JCheckBox yesCheckBox;
    private JTextField CT;
    private JComboBox SC;
    private CourseDaoImpl courseDao;
    private CurriculumDaoImpl curriculumDao;
    private List<Course> courses;
    private List<Curriculum> curriculumList;
    private DefaultComboBoxModel<Curriculum> curriculumsDefaultComboBoxModel;
    private CourseTableModel courseTableModel;
    private Course selectedCourse;

    public Coba() {
        Update.setEnabled(false);
        CC.setSelectedIndex(-1);
        courseDao = new CourseDaoImpl();
        curriculumDao = new CurriculumDaoImpl();
        courses = new ArrayList<>();
        curriculumList = new ArrayList<>();
        try {
            courses.addAll(courseDao.fetchAll());
            curriculumList.addAll(curriculumDao.fetchAll());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        curriculumsDefaultComboBoxModel = new DefaultComboBoxModel<>(curriculumList.toArray(new Curriculum[0]));
        CC.setModel(curriculumsDefaultComboBoxModel);
        courseTableModel = new CourseTableModel(courses);
        tableCourse.setModel(courseTableModel);
        tableCourse.setAutoCreateRowSorter(true);
        Caddbutton.addActionListener(e -> {
            String newC = JOptionPane.showInputDialog(root, "New Curriculum name");
            if (newC  != null && !newC.trim().isEmpty()) {
                Curriculum curriculum = new Curriculum();
                curriculum.setName(newC);
                try {
                    if (curriculumDao.addData(curriculum) == 1) {
                        curriculumList.clear();
                        curriculumList.addAll(curriculumDao.fetchAll());
                        curriculumsDefaultComboBoxModel.removeAllElements();
                        curriculumsDefaultComboBoxModel.addAll(curriculumList);
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
            ;
        });

        Save.addActionListener(e -> {
            if (IDT.getText().trim().isEmpty() || NT.getText().trim().isEmpty() || CT.getText().isEmpty() || CC.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(root, "Please fill id, name, credits, semester, and curriculum", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Course course = new Course();
                course.setId(IDT.getText());
                course.setName(NT.getText());
                course.setSemester(String.valueOf(SC.getSelectedItem()));
                course.setCredits(Integer.parseInt(CT.getText()));
                course.setLabSession(yesCheckBox.contains(1,0));;
                course.setCurriculum((Curriculum) CC.getSelectedItem());
                try {
                    if (courseDao.addData(course) == 1) {
                        courses.clear();
                        courses.addAll(courseDao.fetchAll());
                        courseTableModel.fireTableDataChanged();
                        clear();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        Update.addActionListener(e -> {
            if (IDT.getText().trim().isEmpty() || NT.getText().trim().isEmpty() || CT.getText().isEmpty() || CC.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(root, "Please fill name, credits, semester, and curriculum", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                selectedCourse.setName(NT.getText());
                selectedCourse.setSemester(NT.getText());
                selectedCourse.setSemester(String.valueOf(SC.getSelectedItem()));
                selectedCourse.setCredits(Integer.parseInt(CT.getText()));
                selectedCourse.setLabSession(yesCheckBox.contains(1,0));
                selectedCourse.setCurriculum((Curriculum) CC.getSelectedItem());
                try {
                    if (courseDao.updateData(selectedCourse) == 1) {
                        courses.clear();
                        courses.addAll(courseDao.fetchAll());
                        courseTableModel.fireTableDataChanged();
                        clear();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
            clear();
        });

        Delete.addActionListener(e -> {
            int result =JOptionPane.showConfirmDialog(root, "Are you sure want to delete", " ",1,JOptionPane.QUESTION_MESSAGE);
            if(result== JOptionPane.YES_OPTION) {
                try {
                    if (courseDao.deleteData(selectedCourse) == 1) {
                        courses.clear();
                        courses.addAll(courseDao.fetchAll());
                        courseTableModel.fireTableDataChanged();
                        clear();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        Reset.addActionListener(e -> clear());

        tableCourse.getSelectionModel().addListSelectionListener(e -> {
            if (!tableCourse.getSelectionModel().isSelectionEmpty()) {
                int selectedIndex = tableCourse.convertRowIndexToModel(tableCourse.getSelectedRow());
                selectedCourse = courses.get(selectedIndex);
                if (selectedCourse != null) {
                    IDT.setText(selectedCourse.getId());
                    NT.setText(selectedCourse.getName());
                    CT.setText(String.valueOf(selectedCourse.getCredits()));
                    CC.setSelectedItem(selectedCourse.getCurriculum());
                    IDT.setEnabled(false);
                    Save.setEnabled(false);
                    Update.setEnabled(true);
                    yesCheckBox.setSelected(selectedCourse.isLabSession());
                }
            }
        });
    }

    private void clear() {
        IDT.setText("");
        NT.setText("");
        CT.setText("");
        Save.setEnabled(true);
        Update.setEnabled(false);
        tableCourse.clearSelection();
        selectedCourse = null;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Coba");
        frame.setContentPane(new Coba().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static class CourseTableModel extends AbstractTableModel {

        private List<Course> courses;
        private final String[] COLUMNS = {"ID", "NAME", "CREDITS", "SEMESTER","CURRICULUM"};


        private CourseTableModel(List<Course> courses) { this.courses = courses; }

        @Override
        public int getRowCount() {
            return courses.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> courses.get(rowIndex).getId();
                case 1 -> courses.get(rowIndex).getName();
                case 2 -> courses.get(rowIndex).getCredits();
                case 3 -> courses.get(rowIndex).getSemester();
                case 4 -> courses.get(rowIndex).getCurriculum().getName();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0, columnIndex) != null) {
                return getValueAt(0, columnIndex).getClass();
            } else {
                return Object.class;
            }
        }
    }
}

