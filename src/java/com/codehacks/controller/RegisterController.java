package com.codehacks.controller;

import com.codehacks.dao.LoginDAO;
import com.codehacks.dao.LoginDaoImpl;
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
@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private final RegisterDAO registerDAO = new RegisterDaoImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String address = "register.jsp";

        if (request.getParameter("registerButton").equals("REGISTER")) {
            if (request.getParameter("password").equals(request.getParameter("confirmPassword"))) {

                RegisteredUser registerUser = new RegisteredUser();
                registerUser.setFirstName(request.getParameter("firstName"));
                registerUser.setLastName(request.getParameter("lastName"));
                registerUser.setUserName(request.getParameter("username"));
                String password = request.getParameter("password");
                registerUser.setPassword(password);
                String emailAddress = request.getParameter("emailAddress");
                registerUser.setEmail(emailAddress);

                // Check if the user is not registered 
                if (!registerDAO.checkIfUserExist(registerUser)) {
                    // Save in a database
                    registerDAO.registerUser(registerUser);
                    Client client = new Client(emailAddress, password);
                    LoginDAO loginDao = new LoginDaoImpl();
                    loginDao.createLogin(client);
                    // Check your email and click the link to confirm registration.
                    //EmailHelper.sendEmail3(emailAddress);
                    address = "login.jsp";
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
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
