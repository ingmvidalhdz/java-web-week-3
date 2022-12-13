package com.code.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CandidateDbUtil {

	private DataSource dataSource;

	public CandidateDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Candidate> getCandidates() throws Exception {

		List<Candidate> candidates = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "select * from candidates order by last_name";

			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String phone = myRs.getString("phone");
				String department = myRs.getString("department");
				String degree = myRs.getString("degree");

				// create new student object
				Candidate tempCandidate = new Candidate(id, firstName, lastName, email, phone, department, degree);

				// add it to the list of students
				candidates.add(tempCandidate);
			}

			return candidates;
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addCandidate(Candidate theCandidate) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into candidates " + "(name, last_name, email, phone, department, degree) "
					+ "values (?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setString(1, theCandidate.getName());
			myStmt.setString(2, theCandidate.getLastName());
			myStmt.setString(3, theCandidate.getEmail());
			myStmt.setString(4, theCandidate.getPhone());
			myStmt.setString(5, theCandidate.getDepartment());
			myStmt.setString(6, theCandidate.getDegree());

			// execute sql insert
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Candidate getCandidate(String theCandidateId) throws Exception {

		Candidate theCandidate = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int candidateId;

		try {
			// convert student id to int
			candidateId = Integer.parseInt(theCandidateId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected student
			String sql = "select * from candidates where id=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, candidateId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String phone = myRs.getString("phone");
				String department = myRs.getString("department");
				String degree = myRs.getString("degree");

				// use the studentId during construction
				theCandidate = new Candidate(candidateId, firstName, lastName, email, phone, department, degree);
			} else {
				throw new Exception("Could not find candidate id: " + candidateId);
			}

			return theCandidate;
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateCandidate(Candidate theCandidate) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create SQL update statement
			String sql = "update candidates " + "set name=?, last_name=?, email=?, phone=?, department=?, degree=? "
					+ "where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theCandidate.getName());
			myStmt.setString(2, theCandidate.getLastName());
			myStmt.setString(3, theCandidate.getEmail());
			myStmt.setString(4, theCandidate.getPhone());
			myStmt.setString(5, theCandidate.getDepartment());
			myStmt.setString(6, theCandidate.getDegree());
			myStmt.setInt(7, theCandidate.getId());
			// execute SQL statement
			myStmt.execute();
                        
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteCandidate(String theCandidateId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// convert student id to int
			int candidateId = Integer.parseInt(theCandidateId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to delete student
			String sql = "delete from candidates where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, candidateId);

			// execute sql statement
			myStmt.execute();
		} finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}
	}
}
