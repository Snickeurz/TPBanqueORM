<%
    String insert = null;
    String etat = null;
    if(request.getParameter("insert")!=null){
        insert = request.getParameter("insert");
        etat = request.getParameter("etat");
    }
    if(insert != "" && etat != "")
    {   
        if(etat.equals("true"))
        {
         
                    if(insert.equals("bank")){
                        %>
                         <div class="alert alert-success font-weight-bold" role="alert">La Banque a �t� cr�e avec succ�s</div>
                        <%
                      }
                    if(insert.equals("account")){
                        %>
                        <div class="alert alert-success font-weight-bold" role="alert">Le compte a �t� cr�e avec succ�s</div>
                        <%
                    }
                    if(insert.equals("client")){
                        %>
                        <div class="alert alert-success font-weight-bold" role="alert">Le client a �t� cr�e avec succ�s</div>
                        <%
                    }
          
        }else
        {
                if(insert.equals("bank")){
                        %>
                      <div class="alert alert-danger font-weight-bold" role="alert">  La Banque n'a pas �t� cr�e, un probl�me est survenue</div>
                        <%
                }
                if(insert.equals("account")){
                        %>
                        <div class="alert alert-danger font-weight-bold" role="alert">Le compte n'a pas �t� cr�e, un probl�me est survenue</div>
                        <%
                }
                if(insert.equals("client")){
                        %>
                       <div class="alert alert-danger font-weight-bold" role="alert"> Le client n'a �t� cr�e, un probl�me est survenue</div>
                        <%
                }
        }
    }
%>