package controller;

import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet({"/student"})
public class Servlet extends HttpServlet {

    private static final UUID serialVersionUID = UUID.randomUUID();

    public Servlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("nome");
        String emails = request.getParameter("emails");

        List<String> listCourses = new ArrayList<>(Arrays.asList(request.getParameterValues("cursos")));
        List<String> listEmails = splitStudentEmails(emails);

        Student student = new Student(name, listEmails, listCourses);

        request.setAttribute("student", student);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }


    private List<String> splitStudentEmails(String emails) {

        return Arrays.asList(emails.split("\r\n"));
    }
}
