package ru.geekbrains.firstapp;

import ru.geekbrains.firstapp.persist.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        for (int i = 0; i < 10; i++) {
            Random random = new Random();

            Product product = new Product(new Long(i)
                    ,"product" + (i+1)
                    , new BigDecimal(random.nextInt(100))
            );
            resp.getWriter().println("<p>" + product.toString() + "</p>");
        }
    }
}
