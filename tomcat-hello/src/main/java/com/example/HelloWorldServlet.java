package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HelloWorldServlet extends HttpServlet {
    private static final String SHARED_FILE = "/usr/local/tomcat/shared/message.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String message = "Hello, World!";
        try {
            Path path = Paths.get(SHARED_FILE);
            if (Files.exists(path)) {
                byte[] bytes = Files.readAllBytes(path);
                message = new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            // ignore and use default message
        }
        resp.getWriter().write(message);
    }
}
