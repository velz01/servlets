package com.velz.servlet;

import com.velz.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private final EmployeeService service = EmployeeService.getInstance();
//    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Список сотрудников</h1>");
            service.findAll().forEach(employeeDto -> {
                writer.write("His name: %s".formatted(employeeDto.getName()));
            });
            System.out.println("asfasfafsfasafs");
//            System.out.println(service.findAll());
        }
    }
}
