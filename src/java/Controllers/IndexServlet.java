/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAO_Account;
import DAO.DAO_BankBranch;
import DAO.DAO_Client;
import Models.Account;
import Models.BankBranch;
import Models.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EnterPoint of application. Give to index.jsp a bunch of list for display in forms.
 * 
 * @author Nicolas
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // GET LIST BANKBRANCH
        DAO_BankBranch d = DAO_BankBranch.getInstance();
        List<BankBranch> listBank = d.getAll();
        // GET LIST CLIENT
        DAO_Client dc = DAO_Client.getInstance();
        List<Client> listClient = dc.getAll();
        // GET LIST ACCOUNT
        DAO_Account da = DAO_Account.getInstance();
        List<Account> listAccount = da.getAll();
        
        // Buff attributes
        request.setAttribute("listBank", listBank );
        request.setAttribute("listClient", listClient );
        request.setAttribute("listAccount", listAccount);
        //Send attributes to main JS page
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
