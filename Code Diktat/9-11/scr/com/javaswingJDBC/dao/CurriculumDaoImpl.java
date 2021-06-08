package com.javaswingJDBC.dao;

import com.javaswingJDBC.entity.Curriculum;
import com.javaswingJDBC.util.DaoService;
import com.javaswingJDBC.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurriculumDaoImpl implements DaoService<Curriculum> {
    @Override
    public List<Curriculum> fetchAll() throws SQLException, ClassNotFoundException {
        List<Curriculum> curriculumList=new ArrayList<>();
        String query= "SELECT id,name FROM curriculum";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()){
                        Curriculum curriculums=new Curriculum();
                        curriculums.setId(rs.getInt("id"));
                        curriculums.setName(rs.getString("name"));
                        curriculumList.add(curriculums);
                    }
                }
            }
        }
        return curriculumList;
    }

    @Override
    public int addData(Curriculum curriculum) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="INSERT INTO curriculum(id,name) VALUES(?,?)";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1,curriculum.getId());
                ps.setString(2,curriculum.getName());
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
    public int updateData(Curriculum curriculum) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="UPDATE curriculum SET name = ? WHERE id = ?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,curriculum.getName());
                ps.setInt(2,curriculum.getId());
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
    public int deleteData(Curriculum curriculum) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="DELETE FROM curriculum  WHERE id = ?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1,curriculum.getId());
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
