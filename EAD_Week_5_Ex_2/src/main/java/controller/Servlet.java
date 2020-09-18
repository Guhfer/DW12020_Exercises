package controller;

import model.Person;
import model.PersonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({"/person"})
public class Servlet extends HttpServlet {

    private static final UUID serialVersionUID = UUID.randomUUID();

    public Servlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dados = request.getParameter("pessoas");
        System.out.println(dados);
        PersonUtil personUtil = new PersonUtil();
        List<Person> lista = personUtil.getPessoas(dados);
        request.setAttribute("lista", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
        dispatcher.forward(request, response);
    }
}
