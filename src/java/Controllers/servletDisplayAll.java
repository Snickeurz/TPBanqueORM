/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.*;
import DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicol
 */
@WebServlet(name = "servletDisplayAll", urlPatterns = {"/servletDisplayAll"})
public class servletDisplayAll extends HttpServlet {

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
            throws ServletException, IOException 
    {
        String param = request.getParameter("entity");        
        switch(param)
        {
            case "account":
                DAO_Account dao_account = DAO_Account.getInstance();
                List<Account> listAccount = (List<Account>) dao_account.getAll();                
                request.setAttribute("listAccount", listAccount);
                request.getRequestDispatcher("/displayData.jsp").forward(request, response);
                break;
            case "client":
                DAO_Client dao_client = DAO_Client.getInstance();
                List<Client> listClient = (List<Client>) dao_client.getAll();               
                request.setAttribute("listClient", listClient);
                request.getRequestDispatcher("/displayData.jsp").forward(request, response);
                break;
            case "bankbranch":
                DAO_BankBranch dao_bank = DAO_BankBranch.getInstance();
                List<BankBranch> listBank = (List<BankBranch>) dao_bank.getAll();
                request.setAttribute("listBank", listBank);
                request.getRequestDispatcher("/displayData.jsp").forward(request, response);
                break;
            default:
                try(PrintWriter out = response.getWriter())
                {
                    out.print("bad request");   
                }catch(Exception e)
                {
                }
                break;
        }
        processRequest(request, response);
    }
}
