package com.velz.servlet;

import com.velz.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {
    public static final String USER = "user";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UserDto attribute = (UserDto) session.getAttribute(USER);
        if (attribute == null) {
            attribute = UserDto.builder().id(25L).name("krokozyabrius").build();
            session.setAttribute(USER, attribute);
        }
    }
}
