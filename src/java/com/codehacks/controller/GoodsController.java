package com.codehacks.controller;

import com.codehacks.dao.GoodsDAO;
import com.codehacks.dao.GoodsDaoImpl;
import com.codehacks.model.Goods;
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
@WebServlet(name = "items", urlPatterns = {"/items"})
public class GoodsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String address = "welcome.jsp";
        
        if (request.getParameter("submitButton").equals("SUBMIT")) {
            String emailAdd = request.getParameter("emailAdd");
            String itemName = request.getParameter("itemName");
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            String currentLocationOfGood = request.getParameter("currentLocationOfGood");

            if ( itemName != null && quantity > 0
                    && currentLocationOfGood != null) 
            {
                Goods goods = new Goods();
                goods.setEmailAddress(emailAdd);
                goods.setName(itemName);
                goods.setQuantity(quantity);
                goods.setCurrentLocationOfGood(currentLocationOfGood);

                GoodsDAO goodsDAO = new GoodsDaoImpl();
                goodsDAO.persistGoods(goods);
                
                request.setAttribute("customerGood", goods);
                address = "viewgoods.jsp";
                
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
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
        return "Welcome things";
    }
}
