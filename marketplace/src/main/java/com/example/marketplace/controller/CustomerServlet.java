package com.example.marketplace.controller;

import com.example.marketplace.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {

    private final List<Customer> customers = new ArrayList<>();
    
    @Override
    public void init() throws ServletException {
        createCustomers(customers);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/viewer/customers.jsp").forward(request, response);
    }

    static void createCustomers(List<Customer> customers) {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Charles");
        customer1.setLastName("Oliveira");
        customer1.setMoneyAmount(300);
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Tony");
        customer2.setLastName("Ferguson");
        customer2.setMoneyAmount(100);
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Jiri");
        customer3.setLastName("Prochazka");
        customer3.setMoneyAmount(500);
        customers.add(customer3);
    }

}