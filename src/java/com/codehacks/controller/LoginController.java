package com.codehacks.controller;

import com.codehacks.dao.RegisterDAO;
import com.codehacks.dao.RegisterDaoImpl;
import com.codehacks.model.Client;
import com.codehacks.model.RegisteredUser;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author E238958
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String address = "login.jsp";
        if (request.getParameter("loginButton").equals("LOGIN")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Client userClient = new Client();
            userClient.setEmail(email);
            userClient.setPassword(password);
            
            // To obtain the username of the logged in client
            RegisterDAO reg = new RegisterDaoImpl();
            RegisteredUser registeredUser = reg.getUser(email);
            
            if ((userClient.getEmail()).equals(registeredUser.getEmail()) &&
                (userClient.getPassword()).equals(registeredUser.getPassword())) {
                   request.setAttribute("newClient", registeredUser);
                   address = "welcome.jsp";
                }
            } else {
                address = "login.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
