package controller;

import model.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/file")
@MultipartConfig
public class ServletFile extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ServletFile() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Collection<Part> parts = request.getParts();

        List<File> files = new ArrayList<>();

        if(parts != null)
            parts.stream()
                    .filter(part -> part.getName().equals("files"))
                    .forEach(part -> files.add(new File(part.getSubmittedFileName(), part.getSize(), part.getContentType())));

        request.setAttribute("files", files);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
        dispatcher.forward(request, response);
    }


}
