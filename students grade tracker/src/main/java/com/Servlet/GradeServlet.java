package com.Servlet;

import com.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/grade")
public class GradeServlet extends HttpServlet {

    ArrayList<Student> students = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int marks = Integer.parseInt(request.getParameter("marks"));

        students.add(new Student(name, marks));

        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;

        for (Student s : students) {
            total += s.getMarks();
            highest = Math.max(highest, s.getMarks());
            lowest = Math.min(lowest, s.getMarks());
        }

        double average = (double) total / students.size();

        request.setAttribute("students", students);
        request.setAttribute("average", average);
        request.setAttribute("highest", highest);
        request.setAttribute("lowest", lowest);

        RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
        rd.forward(request, response);
    }
}
