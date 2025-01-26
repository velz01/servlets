package com.velz.other.servlet2;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

//@WebServlet("/download")
public class DownloadServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"file.json\"");
        resp.setContentType("application/json");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        byte[] jsonFile = Files.readAllBytes(Path.of("resources", "random.json"));
        InputStream resource = DownloadServlet.class.getClassLoader().getResourceAsStream("random.json");
        try (ServletOutputStream writer = resp.getOutputStream()) {
            writer.write(resource.readAllBytes());
        }
    }
}
