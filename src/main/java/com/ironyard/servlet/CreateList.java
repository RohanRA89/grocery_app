package com.ironyard.servlet;

import com.ironyard.com.ironyard.service.GroceryService;
import com.ironyard.data.GroceryItem;
import com.ironyard.data.IronYardUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rohanayub on 1/31/17.
 */
@WebServlet(name = "CreateList" , urlPatterns = "/list")
public class CreateList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroceryService gs = new GroceryService();
        IronYardUser user = (IronYardUser) request.getSession().getAttribute("ironyard_user");
        List<GroceryItem> listCreatedItem = gs.getAll(user);
        request.setAttribute("groceryList",listCreatedItem);

        String nextJSP = "/home.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }
}
