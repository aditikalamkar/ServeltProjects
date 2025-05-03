package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {

    private static final String query = "INSERT INTO userrestration(name, email, contactNo) VALUES (?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String name = req.getParameter("username");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/serveletuserregistration", "root", "root");
                 PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, mobile);

                int count = ps.executeUpdate();
                if (count == 1) {
                    pw.println("<h2>Record is registered successfully!</h2>");
                } else {
                    pw.println("<h2>Record registration failed!</h2>");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                pw.println("<h1>" + e.getMessage() + "</h1>");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<h1>Driver not found: " + e.getMessage() + "</h1>");
        }

        pw.close();
    }
}
