package com.code.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CandidateControllerServlet
 */
@WebServlet("/CandidateControllerServlet")
public class CandidateControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CandidateDbUtil candidateDbUtil;

    @Resource(name = "jdbc/web_candidates") //SE COMENTO PARA HACER USO DE JNDI
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        // create our student db util ... and pass in the conn pool / datasource
        try {
            //https://www.digitalocean.com/community/tutorials/tomcat-datasource-jndi-example-java
            /*Context ctx = new InitialContext(); //USO DE JNDI
			dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/javatechie"); //USO DE JNDI
			System.out.println("Demo con JNDI, Datasource: "+dataSource);*/
            candidateDbUtil = new CandidateDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            // if the command is missing, then default to listing students
            if (theCommand == null) {
                theCommand = "LIST";
            }

            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listCandidates(request, response);
                    break;

                case "ADD":
                    addCandidate(request, response);
                    break;

                case "LOAD":
                    loadCandidates(request, response);
                    break;

                case "UPDATE":
                    updateCandidate(request, response);
                    break;

                case "DELETE":
                    deleteCandidate(request, response);
                    break;

                default:
                    listCandidates(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteCandidate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student id from form data
        String candidateId = request.getParameter("candidateId");

        // delete student from database
        candidateDbUtil.deleteCandidate(candidateId);

        // send them back to "list students" page
        listCandidates(request, response);
    }

    private void updateCandidate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student info from form data
        int id = Integer.parseInt(request.getParameter("candidateId"));
        String firstName = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String degree = request.getParameter("degree");

        // create a new student object
        Candidate theCandidate = new Candidate(id, firstName, lastName, email, phone, department, degree);
        System.out.println("En update" + theCandidate);

        // perform update on database
        candidateDbUtil.updateCandidate(theCandidate);

        // send them back to the "list students" page
        listCandidates(request, response);

    }

    private void loadCandidates(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student id from form data
        String theCandidateId = request.getParameter("candidateId");

        // get student from database (db util)
        Candidate theCandidate = candidateDbUtil.getCandidate(theCandidateId);

        // place student in the request attribute
        request.setAttribute("THE_CANDIDATE", theCandidate);

        // send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/update-candidate-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addCandidate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form data
        String firstName = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String degree = request.getParameter("degree");

        // create a new student object
        Candidate theCandidate = new Candidate(firstName, lastName, email, phone, department, degree);
        System.out.println("theCandidate = " + theCandidate);
        // add the student to the database
        System.out.println("theCandidate = " + theCandidate);
        candidateDbUtil.addCandidate(theCandidate);

        // send back to main page (the student list)
        listCandidates(request, response);
    }

    private void listCandidates(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get students from db util
        List<Candidate> candidates = candidateDbUtil.getCandidates();

        for (Candidate c : candidates) {
            System.out.println(c);
        }

        candidates.add(new Candidate(999, "Name", "LastName", "Email", "Phone", "Department", "Degree"));
        // add students to the request
        request.setAttribute("LISTA_CANDIDATOS", candidates);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-candidates.jsp");
        dispatcher.forward(request, response);
    }

}
