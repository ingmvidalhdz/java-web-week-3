package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Morido;

import org.hibernate.Session;

@Repository
public class MoridoDAOJdbcImpl implements MoridoDAO {

    @Autowired
    DataSource dataSource;

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    @Override
    public List<Morido> findAll() {
        System.out.println("Implementación DAO con JDBC: " + dataSource);

        List<Morido> listaMoridos = new ArrayList<>();

        try {
            myConn = dataSource.getConnection();
            // create sql statement
            String sql = "SELECT * FROM moridos";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String nombre = myRs.getString("nombre");
                String apellidos = myRs.getString("apellidos");
                int edad = myRs.getInt("edad");
                String fechaMoricion = myRs.getString("fechaMoricion");
                String horaMoricion = myRs.getString("horaMoricion");
                String lugarMoricion = myRs.getString("lugarMoricion");
                String causaMoricion = myRs.getString("causaMoricion");


                // create new student object
                Morido tempMorido = new Morido(id, nombre, apellidos, edad, fechaMoricion, horaMoricion, lugarMoricion, causaMoricion);

                // add it to the list of students
                listaMoridos.add(tempMorido);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listaMoridos;
    }

    @Override
    public Morido findById(int theId) {
        Morido theMorido = null;
        String sql = "SELECT * FROM moridos WHERE id=?";
        try ( Connection myConn = dataSource.getConnection(); 
                PreparedStatement myStmt = createPreparedStatement(myConn, theId, sql); 
                ResultSet myRs = myStmt.executeQuery();) {

            // retrieve data from result set row
            if (myRs.next()) {
                String nombre = myRs.getString("nombre");
                String apellidos = myRs.getString("apellidos");
                int edad = myRs.getInt("edad");
                String fechaMoricion = myRs.getString("fechaMoricion");
                String horaMoricion = myRs.getString("horaMoricion");
                String lugarMoricion = myRs.getString("lugarMoricion");
                String causaMoricion = myRs.getString("causaMoricion");

                // use the studentId during construction
                theMorido = new Morido(theId, nombre, apellidos, edad, fechaMoricion, horaMoricion, lugarMoricion, causaMoricion);
            } else {
                throw new SQLException("Could not find morido id: " + theId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theMorido;
    }

    @Override
    public void save(Morido theMorido) {
        // TODO Auto-generated method stub
        String sql = null;
        if (theMorido.getId() == 0) {
            sql = "INSERT INTO morido (nombre, apellidos, edad, fechaMoricion, horaMoricion, lugarMoricion, causaMoricion) VALUES (?,?,?,?,?,?,?)";
        } else {
            sql = "UPDATE morido SET nombre=?,apellidos=?,edad=?,fechaMoricion=?,horaMoricion=?,lugarMoricion=?,causaMoricion=? WHERE id=?";
        }

        try ( Connection myConn = dataSource.getConnection();  PreparedStatement myStmt = myConn.prepareStatement(sql);) {
            myStmt.setString(1, theMorido.getNombre());
            myStmt.setString(2, theMorido.getApellidos());
            myStmt.setInt(3, theMorido.getEdad());
            myStmt.setString(4, theMorido.getFechaMoricion());
            myStmt.setString(5, theMorido.getHoraMoricion());
            myStmt.setString(6, theMorido.getLugarMoricion());
            myStmt.setString(7, theMorido.getCausaMoricion());
            if(theMorido.getId()!=0) {
            	myStmt.setInt(8,theMorido.getId());
            }
            System.out.println("myStmt = " + myStmt);
            myStmt.executeUpdate();
            // retrieve data from result set row
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM morido WHERE id=?";
        try ( Connection myConn = dataSource.getConnection();
            PreparedStatement myStmt = createPreparedStatement(myConn, theId, sql);) {
            
            System.out.println("myStmt = " + myStmt);
            myStmt.executeUpdate();
            // retrieve data from result set row
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private PreparedStatement createPreparedStatement(Connection con, int moridoId, String sql) throws SQLException {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, moridoId);
        return ps;
    }

}
