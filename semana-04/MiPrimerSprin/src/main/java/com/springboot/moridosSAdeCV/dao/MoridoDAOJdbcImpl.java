package com.springboot.moridosSAdeCV.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.moridosSAdeCV.entity.Morido;

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
            String sql = "select * from moridos";

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
                String fechaMoricion = myRs.getString("fecha_moricion");
                String horaMoricion = myRs.getString("hora_moricion");
                String lugarMoricion = myRs.getString("lugar_moricion");
                String causaMoricion = myRs.getString("causa_moricion");


                // create new student object
                Morido tempMorido = new Morido (id, nombre, apellidos, edad, fechaMoricion, horaMoricion, lugarMoricion, causaMoricion);

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
        String sql = "select * from moridos where id=?";
        try ( Connection myConn = dataSource.getConnection(); 
                PreparedStatement myStmt = createPreparedStatement(myConn, theId, sql); 
                ResultSet myRs = myStmt.executeQuery();) {

            // retrieve data from result set row
            if (myRs.next()) {
                String nombre = myRs.getString("nombre");
                String apellidos = myRs.getString("apellidos");
                int edad = myRs.getInt("edad");
                String fechaMoricion = myRs.getString("fecha_moricion");
                String horaMoricion = myRs.getString("hora_moricion");
                String lugarMoricion = myRs.getString("lugar_moricion");
                String causaMoricion = myRs.getString("causa_moricion");

                // use the studentId during construction
                theMorido = new Morido(theId, nombre, apellidos, edad, fechaMoricion, horaMoricion,lugarMoricion, causaMoricion);
                System.out.println("theMorido = " + theMorido.toString());
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
            sql = "insert into moridos (nombre, apellidos, edad, fecha_moricion, hora_moricion, lugar_moricion, causa_moricion) VALUES (?,?,?,?,?,?,?)";
        } else {
            sql = "update moridos set nombre=?,apellidos=?,edad=?,fecha_moricion=?,hora_moricion=?,lugar_moricion=?,causa_moricion=? where id=?";
        }
        System.out.println("sql = " + sql);
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
        String sql = "delete from moridos where id=?";
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
