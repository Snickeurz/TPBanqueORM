<%-- 
    Document   : displayData
    Created on : 10 oct. 2018, 18:45:21
    Author     : Nicolas
--%>

<%@page import="Models.Account"%>
<%@page import="Models.Client"%>
<%@page import="Models.BankBranch"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Data details page</title>
    </head>
    <body>
        <!-- AFFICHAGE DES ACCOUNTS  -->
            <%
            if(request.getAttribute("listAccount") != null)
            {
                List<Account> listAccount = (List<Account>) request.getAttribute("listAccount"); 
            %>
            <div class="bg-info"><h3 class="text-center">LISTE ACCOUNT</h3></div>
                <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Libelle</th>
                    <th scope="col">IBAN</th>
                    <th scope="col">Solde</th>
                  </tr>
                </thead>
                <tbody>
                <%
                for (Account account: listAccount)
                {
                %>
                  <tr>
                    <th scope="row"><%=account.getNum_compte()%></th>
                    <td><%=account.getLibelle()%></td>
                    <td><%=account.getIBAN()%></td>
                    <td><%=account.getSolde()%></td>
                  </tr>
                  <%
                }
                 %>
            </tbody>
        </table>
                 <%
            }
              %>
              
              
     <!-- AFFICHAGE DES CLIENTS -->
       <%
            if(request.getAttribute("listClient") != null)
            {
                List<Client> listClient = (List<Client>) request.getAttribute("listClient"); 
            %>
            <div class="bg-info"><h3 class="text-center">LISTE CLIENTS</h3></div>
                <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">ID client</th>
                    <th scope="col">NOM</th>
                    <th scope="col">PRENOM</th>
                    <th scope="col">DATE NAISS</th>
                  </tr>
                </thead>
                <tbody>
                <%
                for (Client client: listClient)
                {
                %>
                  <tr>
                    <th scope="row"><%=client.getNumClient()%></th>
                    <td><%=client.getNomClient()%></td>
                    <td><%=client.getPrenomClient()%></td>
                    <td><%=client.getDateNaiss()%></td>
                  </tr>
                  <%
                }
                 %>
            </tbody>
        </table>
                 <%
            }
              %>
              
              
     <!-- AFFICHAGE DES BANKBRANCH -->
       <%
            if(request.getAttribute("listBank") != null)
            {
                List<BankBranch> listBank = (List<BankBranch>) request.getAttribute("listBank"); 
            %>
            <div class="bg-info"><h3 class="text-center">LISTE DES BANKS</h3></div>
                <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">ID BANK</th>
                    <th scope="col">ADRESSE BANK</th>
                  </tr>
                </thead>
                <tbody>
                <%
                for (BankBranch bank: listBank)
                {
                %>
                  <tr>
                    <th scope="row"><%=bank.getCodeAgence()%></th>
                    <td><%=bank.getAdresse()%></td>
                  </tr>
                  <%
                }
                 %>
            </tbody>
        </table>
                 <%
            }
              %>
    </body>
</html>
