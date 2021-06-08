package com.javaswingJDBC.dao;

import com.javaswingJDBC.entity.Course;
import com.javaswingJDBC.entity.Curriculum;
import com.javaswingJDBC.util.DaoService;
import com.javaswingJDBC.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements DaoService<Course>{
    @Override
    public List<Course> fetchAll() throws SQLException, ClassNotFoundException {
        List<Course> courses=new ArrayList<>();
        String query= "SELECT c.id,c.name,credits,lab_session,semester,curriculum_id,m.name FROM course c JOIN curriculum m ON c.curriculum_id=m.id";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()){
                        Curriculum curriculum=new Curriculum();
                        curriculum.setId(rs.getInt("curriculum_id"));
                        curriculum.setName(rs.getString("m.name"));
                        Course course=new Course();
                        course.setId(rs.getString("c.id"));
                        course.setName(rs.getString("name"));
                        course.setCredits(rs.getInt("credits"));
                        course.setLabSession(rs.getBoolean("lab_session"));
                        course.setSemester(rs.getString("semester"));
                        course.setCurriculum(curriculum);
                        courses.add(course);
                    }
                }
            }
        }
        return courses;
    }

    @Override
    public int addData(Course course) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="INSERT INTO course(id,name,credits,lab_session,semester,curriculum_id) VALUES(?,?,?,?,?,?)";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,course.getId());
                ps.setString(2,course.getName());
                ps.setInt(3,course.getCredits());
                ps.setInt(4, course.isLabSession() ? 1 : 0);
                ps.setString(5,course.getSemester());
                ps.setInt(6,course.getCurriculum().getId());
                if(ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }else {
                    connection.rollback();
                }
            }
        }
        return result;
    }

    @Override
    public int updateData(Course course) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="UPDATE course SET credits= ?,lab_session= ?,semester= ?,curriculum_id= ? WHERE id = ? and name = ?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1,course.getCredits());
                ps.setInt(2,course.isLabSession()? 1 : 0);
                ps.setString(3,course.getSemester());
                ps.setInt(4,course.getCurriculum().getId());
                ps.setString(5,course.getId());
                ps.setString(6,course.getName());
                if(ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }else {
                    connection.rollback();
                }
            }
        }
        return result;
    }

    @Override
    public int deleteData(Course course) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="DELETE FROM course  WHERE name = ?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,course.getName());
                if(ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }else {
                    connection.rollback();
                }
            }
        }
        return result;
    }
}
