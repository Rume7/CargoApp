package com.codehacks.controller;

import com.codehacks.dao.RegisterDAO;
import com.codehacks.dao.RegisterDaoImpl;
import com.codehacks.helper.EmailHelper;
import com.codehacks.model.RegisteredUser;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    
    private final RegisterDAO registerDAO = new RegisterDaoImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String address;
            
            if (request.getParameter("registerButton").equals("REGISTER")) {
                if (request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
                    
                    RegisteredUser registerUser = new RegisteredUser();
                    registerUser.setFirstName(request.getParameter("firstName"));
                    registerUser.setLastName(request.getParameter("lastName"));
                    registerUser.setUserName(request.getParameter("username"));
                    registerUser.setPassword(request.getParameter("password"));
                    String emailAddress = request.getParameter("emailAddress");
                    registerUser.setEmail(emailAddress);
                    
                    // Check if the user is not registered 
                    if (!registerDAO.checkIfUserExist(registerUser)) {
                        // Save in a database
                        registerDAO.registerUser(registerUser);
                        // Check your email and click the link to confirm registration.
                        //EmailHelper.sendEmail3(emailAddress);
                        address = "login.jsp";
                    } else {
                        // Enter new registration details
                        address = "register.jsp";
                    }
                } else {
                    address = "register.jsp";
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
