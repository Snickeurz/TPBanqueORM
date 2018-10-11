/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAO_Account;
import DAO.DAO_BankBranch;
import Models.Account;
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
@WebServlet(name = "servletAccount", urlPatterns = {"/servletAccount"})
public class servletAccount extends HttpServlet {

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
        
       
        //int num_compte = Integer.parseInt(request.getParameter("num_compte"));
        String num_compte = request.getParameter("num_compte");
        String IBAN = request.getParameter("IBAN");
        String libelle = request.getParameter("libelle");
        float solde = Float.parseFloat(request.getParameter("solde"));
        int idBank = Integer.parseInt(request.getParameter("bank"));
        try(PrintWriter out = response.getWriter())
        {
            if(num_compte.length() != 11 && IBAN.length() != 27){
                out.println("taille des donnés incorect");
                
            }
            out.print("doPost here ! Doing the traitement .. \n");
            out.print("\nnum : " + num_compte);
            out.print("\nIban : " + IBAN);
            out.print("\nLibelle : " + libelle);
            out.print("\nsolde : " + solde);
            out.print("\nidBank : " + idBank);
            out.print("\n\nRedirection dans 3 secondes..");
            DAO_Account dao_account = DAO_Account.getInstance();
            Account account = new Account();
            account.setNum_compte(num_compte);
            account.setIBAN(IBAN);
            account.setLibelle(libelle);
            account.setSolde(solde);
            DAO_BankBranch b_dao = DAO_BankBranch.getInstance();
            BankBranch bank = null;
            try{
                bank = b_dao.getByID(idBank);
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
            account.setAgence(bank);
            boolean b = dao_account.insert(account);  
            if(b)
            {
                out.print("Object Account is Sucessfully inserted into DB ! ");
                String url = request.getRequestURL().toString();
                String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=account&etat=true";
                response.sendRedirect(baseURL);
            }else{
                out.print("Failed to insert Object Account ! ");
                String url = request.getRequestURL().toString();
                String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=account&etat=false";
                response.sendRedirect(baseURL);
            }
            out.println("\n\nRedirection dans trois secondes..");
        }catch(Exception e)
        {
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
        String NumAccount = "";
        if(request.getParameter("delete")!= null){
            NumAccount = request.getParameter("delete");
        }
        if(!NumAccount.isEmpty())
        {
             try (PrintWriter out = response.getWriter()) {
                out.print("doGet here ! Deleting the Account with id : " + NumAccount);
                DAO_Account dao_account = DAO_Account.getInstance();
                Account account = dao_account.getByID(NumAccount);
                boolean remove = dao_account.remove(account);
                if(remove)
                {
                    out.println("Delete of Account is Sucessfull");
                }else{
                    out.println("Delete of Account IS NOT Sucessfull");
                }
            } catch (Exception e) {
            }
        }
        processRequest(request, response);
    }    
}
