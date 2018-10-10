<%@page import="Models.Account"%>
<%@page import="java.util.List"%>
<%@page import="Models.BankBranch"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TP ORM</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
          <div class="jumbotron">
            <h1 class="text-center">Formulaire création</h1>
            <div class="row">
                <div class="col"><a class="btn btn-info" href="${pageContext.request.contextPath}/servletDisplayAll?entity=client"> VOIR TOUTES LES INFOS CLIENT</a></div>
                <div class="col"><a class="btn btn-info" href="${pageContext.request.contextPath}/servletDisplayAll?entity=bankbranch">BANK VOIR TOUTES LES INFOS BANK </a></div>
                <div class="col"><a class="btn btn-info" href="${pageContext.request.contextPath}/servletDisplayAll?entity=account">ACCOUNT VOIR TOUTES LES INFOS ACCOUNT</a></div>
            </div>
          </div>
        </div>

        <br>
        <div class="row">
            <!-- CLIENT FORM -->
            <div class="col">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/servletClient" >
                        <fieldset>
                        <!-- Form Name -->
                        <legend>Formulaire ajout client</legend>

                        <!-- Nom client input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="bank_id">Nom client : </label>  
                          <div class="col">
                            <input name="clientName" type="text" placeholder="Bove.." class="form-control input-md" required>
                            <span class="help-block">Le nom du client</span>  
                          </div>
                        </div>

                        <!-- Prenom client input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="textinput">Prenom client : </label>  
                          <div class="col">
                            <input name="prenomClient" type="text" placeholder="Jose" class="form-control input-md" required>
                            <span class="help-block">Le prenom du client</span>  
                          </div>
                        </div>
                        
                        
                        <!-- Numéro client input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="numClient">Numéro client : </label>  
                          <div class="col">
                              <input name="numClient" type="text" placeholder="12345678" class="form-control input-md" required maxlength="8">
                            <span class="help-block">Le numéro du client</span>  
                          </div>
                        </div>
                        
                         <!-- Account FK client input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="textinput">Account : </label>  
                          <div class="col">
                              <select name="account">
                                  <%
                                       List<Account> listAccount = (List<Account>) request.getAttribute("listAccount"); 
                                for (Account account: listAccount) {
                                    int AccountCode = account.getNum_compte();
                                    String AccountLibelle = account.getLibelle();
                                    %>
                                    <option value="<%=AccountCode %>"><%=AccountLibelle %></option>
                                     <%
                                }   
                                      %>
                                  
                              </select>
                            <span class="help-block">Le numéro de compte lié au client</span>  
                          </div>
                        </div>
                        
                        <button type="submit" class="btn float-right">Créer le client</button>
                        </fieldset>
                    </form>
            </div>
            
            <!-- BANK FORM -->
            <div class="col">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/servletBank" method="POST" >
                        <fieldset>
                        <!-- Form Name -->
                        <legend>Formulaire ajout bankBranch</legend>

                        <!-- Bank adresse input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="bank_id">Adresse bank : </label>  
                          <div class="col">
                            <input name="adresse" type="text" placeholder="Marseille.." class="form-control input-md">
                            <span class="help-block">Le nom que devra avoir la banque</span>  
                          </div>
                        </div>

                        <!-- bank Code input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="textinput">Code agence : </label>  
                          <div class="col">
                            <input name="codeAgence" type="text" placeholder="12345" class="form-control input-md" maxlength="5">
                            <span class="help-block">Le code de l'agence</span>  
                          </div>
                        </div>
                        <button type="submit" class="btn btn-info float-right">Créer la banque</button>
                        </fieldset>
                    </form>
            </div>
            
            <!-- Account form -->
            <div class="col">                
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/servletAccount" method="POST">
                        <fieldset>
                        <!-- Form Name -->
                        <legend>Formulaire ajout Account</legend>

                        <!-- Numero compte input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="bank_id">Numero compte : </label>  
                          <div class="col">
                              <input name="num_compte" type="text" placeholder="564654" class="form-control input-md" required maxlength="11">
                            <span class="help-block">Le numéro de compte</span>  
                          </div>
                        </div>

                        <!-- IBAN compte input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="textinput">IBAN compte : </label>  
                          <div class="col">
                              <input name="IBAN" type="text" placeholder="José" class="form-control input-md" required maxlength="27">
                            <span class="help-block">Le numéro IBAN du compte</span>  
                          </div>
                        </div>
                      
                        <!-- Libelle compte input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="textinput">Libelle compte : </label>  
                          <div class="col">
                              <input name="libelle" type="text" placeholder="Someone's account" class="form-control input-md" required>
                            <span class="help-block">Le libelle du compte</span>  
                          </div>
                        </div>
                        
                        <!-- Solde compte input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="textinput">Solde compte : </label>  
                          <div class="col">
                              <input name="solde" type="text" placeholder="123456" class="form-control input-md" required maxlength="10">
                            <span class="help-block">Le solde du compte</span>  
                          </div>
                        </div>
                        
                        <!-- BankBranch FK compte input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="textinput">Bank : </label>  
                          <div class="col">
                              <select name="bank">
                                  <%
                                       List<BankBranch> listBank = (List<BankBranch>) request.getAttribute("listBank"); 
                                for (BankBranch bank: listBank) {
                                    int FieldCode = bank.getCodeAgence();
                                    String FieldAdresse = bank.getAdresse();
                                    %>
                                    <option value="<%=FieldCode %>"><%=FieldAdresse %></option>
                                     <%
                                }   
                                      
                                      %>
                                  
                              </select>
                            <span class="help-block">Le code BankBranch lié au compte</span>  
                          </div>
                        </div>
                        <button type="submit" class="btn btn-info float-right">Créer le compte</button>
                        </fieldset>
                    </form>
            </div>
        </div>
    </body>
</html>
