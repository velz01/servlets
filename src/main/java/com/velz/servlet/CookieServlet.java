package com.velz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet { //
    private static final String UNIQ_ID = "uniq_id";
    private final AtomicInteger counter = new AtomicInteger();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null || Arrays.stream(cookies).filter(cookie -> UNIQ_ID.equals(cookie.getName())).findFirst().isEmpty()) {
            Cookie cookie = new Cookie(UNIQ_ID, "1");
            cookie.setPath("/cookies");
            cookie.setMaxAge(15 * 60);
            resp.addCookie(cookie);
            counter.incrementAndGet();
        }
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(counter.get());
        }
    }
}
