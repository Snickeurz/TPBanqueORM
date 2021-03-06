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
 * @author Nicolas
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
            throws ServletException, IOException {
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

        if (request.getParameter("codeAgence").length() == 5) {
            String adresse = request.getParameter("adresse");
            int codeAgence = Integer.parseInt(request.getParameter("codeAgence"));

            try (PrintWriter out = response.getWriter()) {
                out.print("doPost here ! Doing the traitement .. \n");
                out.print("\ncode : " + codeAgence);
                out.print("\nAdresse :  " + adresse);
                DAO_BankBranch dao_bank = DAO_BankBranch.getInstance();
                BankBranch bank = new BankBranch();
                bank.setAdresse(adresse);
                bank.setCodeAgence(codeAgence);
                boolean b = dao_bank.insert(bank);
                if (b) {
                    out.print("\nObject Bank is Sucessfully inserted into DB ! ");
                } else {
                    out.print("\nFailed to insert Object Bank ! ");
                }
                out.println("\n\nRedirection dans trois secondes..");
                String url = request.getRequestURL().toString();
                String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=bank&etat=true";
                response.sendRedirect(baseURL);
            } catch (Exception e) {
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.print("doPost here ! You must have a length of 5 digit for codeAgence .. \n");
                String url = request.getRequestURL().toString();
                String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=bank&etat=false";                
                response.sendRedirect(baseURL);
            } catch (Exception e) {

            }
        }
        processRequest(request, response);
    }

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
        int codeBankBranch = 0;
        if(request.getParameter("delete")!= null){
            codeBankBranch = Integer.parseInt(request.getParameter("delete"));
        }
        if(codeBankBranch!= 0)
        {
             try (PrintWriter out = response.getWriter()) {
                out.print("doGet here ! Deleting the bank with id : " + codeBankBranch);
                DAO_BankBranch dao_bank = DAO_BankBranch.getInstance();
                BankBranch bank = dao_bank.getByID(codeBankBranch);
                boolean remove = dao_bank.remove(bank);
                if(remove)
                {
                    out.println("Delete of BankBranch is Sucessfull");
                    String url = request.getRequestURL().toString();
                    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=bankDeleted&etat=true";                
                    response.sendRedirect(baseURL);
                }else{
                    out.println("Delete of BankBranch IS NOT Sucessfull");
                    String url = request.getRequestURL().toString();
                    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=bankDeleted&etat=false";                
                    response.sendRedirect(baseURL);
                }
            } catch (Exception e) {
            }
        }
        processRequest(request, response);
    }    
}
