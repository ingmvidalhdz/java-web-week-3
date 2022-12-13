package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;

@Repository
public class EmployeeDAOJdbcImpl implements EmployeeDAO {

    @Autowired
    DataSource dataSource;

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    @Override
    public List<Employee> findAll() {
        System.out.println("Implementación DAO con JDBC: " + dataSource);

        List<Employee> listaEmpleados = new ArrayList<>();

        try {
            myConn = dataSource.getConnection();
            // create sql statement
            String sql = "select * from employee";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                // create new student object
                Employee tempEmployee = new Employee(id, firstName, lastName, email);

                // add it to the list of students
                listaEmpleados.add(tempEmployee);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listaEmpleados;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = null;
        String sql = "select * from employee where id=?";
        try ( Connection myConn = dataSource.getConnection(); 
                PreparedStatement myStmt = createPreparedStatement(myConn, theId, sql); 
                ResultSet myRs = myStmt.executeQuery();) {

            // retrieve data from result set row
            if (myRs.next()) {
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                // use the studentId during construction
                theEmployee = new Employee(theId, firstName, lastName, email);
            } else {
                throw new SQLException("Could not find employee id: " + theId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        // TODO Auto-generated method stub
        String sql = null;
        if (theEmployee.getId() == 0) {
            sql = "insert into employee (first_name, last_name, email) VALUES (?,?,?)";
        } else {
            sql = "update employee set first_name=?,last_name=?,email=? where id=" + theEmployee.getId();
        }

        try ( Connection myConn = dataSource.getConnection();  PreparedStatement myStmt = myConn.prepareStatement(sql);) {
            myStmt.setString(1, theEmployee.getFirstName());
            myStmt.setString(2, theEmployee.getLastName());
            myStmt.setString(3, theEmployee.getEmail());
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
        String sql = "delete from employee where id="+theId;
        try ( Connection myConn = dataSource.getConnection();
            PreparedStatement myStmt = myConn.prepareStatement(sql);) {
            
            System.out.println("myStmt = " + myStmt);
            myStmt.executeUpdate();
            // retrieve data from result set row
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private PreparedStatement createPreparedStatement(Connection con, int empleadoId, String sql) throws SQLException {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, empleadoId);
        return ps;
    }

}
