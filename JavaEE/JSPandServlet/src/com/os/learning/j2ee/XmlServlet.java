package com.os.learning.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
    private static final long serialVersionUID = -4878000497879816454L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("In xmlServlet doGet");

        String name = request.getParameter("user");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello from Get: " + name + "!!!" + " you are " + age + " years old. And you are a " + gender);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("In xmlServlet doGet");

        String name = request.getParameter("user");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello from Post: " + name + "!!!" + " you are " + age + " years old. And you are a " + gender);
    }

}
