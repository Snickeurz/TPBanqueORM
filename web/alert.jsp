<%
    String insert = null;
    String etat = null;
    if(request.getParameterMap().containsKey("insert") && request.getParameter("insert") != null){
        insert = request.getParameter("insert");
        etat = request.getParameter("etat");
    }
    if(insert != "" && insert != null && etat != "" && etat != null)
    {   
        if(etat.equals("true"))
        {
                    if(insert.equals("bank")){
                        %>
                         <div class="alert alert-success font-weight-bold" role="alert">La Banque a été crée avec succès</div>
                        <%
                    }else if(insert.equals("bankDeleted"))
                    {
                        %>
                         <div class="alert alert-success font-weight-bold" role="alert">La Banque a été supprimé avec succès</div>
                        <%
                    }   
                    if(insert.equals("account")){
                        %>
                        <div class="alert alert-success font-weight-bold" role="alert">Le compte a été crée avec succès</div>
                        <%
                    }else if(insert.equals("accountDeleted"))
                    {
                        %>
                         <div class="alert alert-success font-weight-bold" role="alert">L'account a été supprimé avec succès</div>
                        <%
                    }
                    if(insert.equals("client")){
                        %>
                        <div class="alert alert-success font-weight-bold" role="alert">Le client a été crée avec succès</div>
                        <%
                    }else if(insert.equals("clientDeleted"))
                    {
                        %>
                         <div class="alert alert-success font-weight-bold" role="alert">Le client a été supprimé avec succès</div>
                        <%
                    }
          
        }else
        {
                if(insert.equals("bank")){
                        %>
                      <div class="alert alert-danger font-weight-bold" role="alert">  La Banque n'a pas été crée, un problème est survenue</div>
                        <%
                }else if(insert.equals("bankDeleted"))
                    {
                        %>
                        <div class="alert alert-danger font-weight-bold" role="alert">  La Banque n'a pas été supprimé, un problème est survenue</div>
                        <%
                    }
                if(insert.equals("account")){
                        %>
                        <div class="alert alert-danger font-weight-bold" role="alert">Le compte n'a pas été crée, un problème est survenue</div>
                        <%
                }else if(insert.equals("accountDeleted"))
                    {
                        %>
                        <div class="alert alert-danger font-weight-bold" role="alert">  L'account n'a pas été supprimé, un problème est survenue</div>
                        <%
                    }
                if(insert.equals("client")){
                        %>
                       <div class="alert alert-danger font-weight-bold" role="alert"> Le client n'a pas été crée, un problème est survenue</div>
                        <%
                }else if(insert.equals("clientDeleted"))
                    {
                        %>
                        <div class="alert alert-danger font-weight-bold" role="alert">  Le client n'a pas été supprimé, un problème est survenue</div>
                        <%
                    }
        }
    }
%>