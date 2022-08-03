package com.example.marketplace.controller;

import com.example.marketplace.model.Customer;
import com.example.marketplace.model.Product;
import com.example.marketplace.model.ShoppingItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingServlet", urlPatterns = {
        "/product", "/cart"})
public class ShoppingServlet extends HttpServlet {

    private final List<Product> products = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private static final String CART_ATTRIBUTE = "cart";

    @Override
    public void init() throws ServletException {
        ProductServlet.createProducts(products);
        CustomerServlet.createCustomers(customers);
    }




    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
            IOException {
        int productId = 0;
        try {
            productId = Integer.parseInt(
                    request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Product product = getProduct(productId);
        ShoppingItem item = new ShoppingItem(product);
        HttpSession session = request.getSession();
        session.setAttribute("item", item);
        getServletContext()
                .getRequestDispatcher("/viewer/product.jsp")
                .forward(request, response);
    }

    private Product getProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    private Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
            IOException {
        // add to cart
        int productId = 0;
        int customerId = 0;
        //int[] buyers = {0, 0, 0};
        try {
            productId = Integer.parseInt(
                    request.getParameter("id"));
            customerId = Integer.parseInt(request.getParameter("userid"));

        } catch (NumberFormatException e) {
        }
        HttpSession session = request.getSession();
        List<ShoppingItem> cart = (List<ShoppingItem>) session
                .getAttribute(CART_ATTRIBUTE);

        Product product = getProduct(productId);
        Customer customer = getCustomer(customerId);
        ShoppingItem shoppingItem = new ShoppingItem(product);
        if (product != null && customerId != 0 && customer.getMoneyAmount() >= product.getPrice()) {
            Customer[] updatedBuyers = shoppingItem.getBuyers();
            updatedBuyers[customerId - 1] = getCustomer(customerId);
            customer.setMoneyAmount(customer.getMoneyAmount() - product.getPrice());
            shoppingItem.setBuyers(updatedBuyers);
        }
        if (cart == null) {
            cart = new ArrayList<ShoppingItem>();
            session.setAttribute(CART_ATTRIBUTE, cart);
        }
        cart.add(shoppingItem);
        getServletContext()
                .getRequestDispatcher("/viewer/cart.jsp")
                .forward(request, response);
    }
}