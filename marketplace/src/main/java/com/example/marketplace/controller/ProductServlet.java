package com.example.marketplace.controller;

import com.example.marketplace.model.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

    private final List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        createProducts(products);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/viewer/products.jsp").forward(request, response);
    }

    static void createProducts(List<Product> products) {
        products.add(new Product(1, "Socks", 5));
        products.add(new Product(2, "Laptop", 150));
        products.add(new Product(3, "Soap", 3));
    }

}
