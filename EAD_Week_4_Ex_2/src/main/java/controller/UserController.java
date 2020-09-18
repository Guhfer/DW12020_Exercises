package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@WebServlet({"/calculate"})
public class UserController extends HttpServlet {
    private static final UUID serialVersionUID = UUID.randomUUID();

    public UserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthday"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        writerPage(response, calculateYears(birthDate));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    private void writerPage(HttpServletResponse response, Integer age) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("<h2>Age:</h2>");
        out.print("<br>" + age);
        out.print("</body>");
        out.print("</html>");
    }

    private Integer calculateYears(LocalDate date) {
        return Period.between(LocalDate.now(), date).getYears();
    }
}
