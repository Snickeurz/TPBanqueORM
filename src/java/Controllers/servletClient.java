/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.*;
import Models.*;
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
@WebServlet(name = "servletClient", urlPatterns = {"/servletClient"})
public class servletClient extends HttpServlet {

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
        
        String prenom = request.getParameter("prenomClient");
        String nom = request.getParameter("nomClient");
        int num_client = Integer.parseInt(request.getParameter("numClient"));
        int num_account = Integer.parseInt(request.getParameter("account"));
        // TODO
        try(PrintWriter out = response.getWriter())
        {
              out.print("doPost here ! Doing the traitement .. \n");
              out.print("\nPrenom : " + prenom);
              out.print("\nNom :  " + nom);
              out.print("\nNum client : " + num_client);
              out.print("\nNum account : " + num_account);
              DAO_Client client_dao = DAO_Client.getInstance();
              Client client = new Client();
              client.setNomClient(nom);
              client.setPrenomClient(prenom);
              client.setNumClient(num_client);

              DAO_Account account_dao = DAO_Account.getInstance();
              Account account = account_dao.getByID(num_account);
              
              client.setAccounts(account);
              client_dao.insert(client);
                
        }catch(Exception e)
        {
            
        }
        processRequest(request, response);
    }
}
