/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAO_BankBranch;
import Models.BankBranch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicol
 */
@WebServlet(name = "servletBank", urlPatterns = {"/servletBank"})
public class servletBank extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {    
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletBank</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletBank at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");          
        }
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
         
        if(request.getParameter("codeAgence").length()==5)
        {
            String adresse = request.getParameter("adresse");
            int codeAgence = Integer.parseInt(request.getParameter("codeAgence"));

            try(PrintWriter out = response.getWriter())
            {
                out.print("doPost here ! Doing the traitement .. \n");
                out.print("\ncode : " + codeAgence);
                out.print("\nAdresse :  " + adresse);
                DAO_BankBranch dao_bank = DAO_BankBranch.getInstance();
                BankBranch bank = new BankBranch();
                bank.setAdresse(adresse);
                bank.setCodeAgence(codeAgence);
                boolean b = dao_bank.insert(bank);
                if(b)
                {
                    out.print("\nObject Bank is Sucessfully inserted into DB ! ");
                }else{
                    out.print("\nFailed to insert Object Bank ! ");
                }
            }catch(Exception e)
            {
            }
        }else{
            
            try(PrintWriter out = response.getWriter())
            {
            out.print("doPost here ! You must have a length of 5 digit for codeAgence .. \n");
            }catch(Exception e)
            {
                
            }
        }
        processRequest(request, response);
    }

}