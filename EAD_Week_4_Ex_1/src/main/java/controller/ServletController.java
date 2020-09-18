package controller;

import domain.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet({"/student"})
public class ServletController extends HttpServlet {

    private static final UUID serialVersionUID = UUID.randomUUID();

    public ServletController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("nome");
        String emails = request.getParameter("emails");

        List<String> listCourses = new ArrayList<>(Arrays.asList(request.getParameterValues("cursos")));
        List<String> listEmails = splitStudentEmails(emails);

        Student student = new Student(name, listEmails, listCourses);

        writerPage(student, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    private void writerPage(Student student, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<body>");
        out.print("<h2>Dados do aluno:</h2>");
        out.print("<br>Nome: " + student.getName());
        out.print("<br>Email: " + student.getEmails());
        out.print("<br>Cursos escolhidos:");
        out.print("<ul>");
        student.getCourses().forEach(course -> {
            out.print("<li>" + course);
        });
        out.print("</ul>");
        out.print("</body>");
        out.print("</html>");
    }

    private List<String> splitStudentEmails(String emails) {

        return Arrays.asList(emails.split("\r\n"));
    }
}
