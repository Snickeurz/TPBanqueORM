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
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
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
        String num_account = request.getParameter("account");
        // TODO
        try (PrintWriter out = response.getWriter()) {
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

            //To improve ....
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 1988);
            cal.set(Calendar.MONTH, Calendar.JANUARY);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            client.setDateNaiss(cal.getTime());

            DAO_Account account_dao = DAO_Account.getInstance();
            Account account = account_dao.getByID(num_account);
            account.setClients(client);
            client.setAccounts(account);
            boolean c = client_dao.insert(client);
            boolean a = account_dao.update(account);
            if (c && a) {
                out.print("\nInsertion of Client Sucessfull");
                String url = request.getRequestURL().toString();
                String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=client&etat=true";
                response.sendRedirect(baseURL);
            } else {
                out.print("\nInsertion of Client IS NOT Sucessfull");
                String url = request.getRequestURL().toString();
                String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "?insert=client&etat=false";
                response.sendRedirect(baseURL);
            }
            out.println("\n\nRedirection dans trois secondes..");
        } catch (Exception e) {

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
        int NumClient = 0;
        if(request.getParameter("delete")!= null){
            NumClient = Integer.parseInt(request.getParameter("delete"));
        }
        if(NumClient!= 0)
        {
             try (PrintWriter out = response.getWriter()) {
                DAO_Account da = DAO_Account.getInstance();
                DAO_Client dao_client = DAO_Client.getInstance();
                Client client = dao_client.getByID(NumClient);
                boolean remove = dao_client.remove(client);
                out.println(remove);
                if(remove)
                {
                    out.println("Delete of Client is Sucessfull");
                }else{
                    out.println("Delete of Client IS NOT Sucessfull");
                }
            } catch (Exception e) {
            }
        }
        processRequest(request, response);
    }    
}
