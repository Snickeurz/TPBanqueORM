/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebPackage;

import DAO.*;
import Models.*;
import java.util.Calendar;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * This is a web service that test CRUD logic on entities.
 * Update is not implemented yet.
 * 
 * @author Nicolas
 */
@WebService(serviceName = "bankWS")
public class bankWS
{
    private DAO_BankBranch dao_bank = DAO_BankBranch.getInstance();
    private DAO_Client dao_client = DAO_Client.getInstance();
    private DAO_Account dao_account = DAO_Account.getInstance();
    
    /*************
     * GET BY ID *
     *************/
    
    /**
     * This is a Client web service operation.
     * 
     * @param idClientToSearch int the id to search
     * @return a Client
     */
    @WebMethod(operationName = "clientOperationSearch")
    public Client getClientById(@WebParam(name = "client") int idClientToSearch) {
        return dao_client.getByID(idClientToSearch);
    }
    
    /**
     * This s a Account web service operation.
     * 
     * @param idAccountToSearch String the id to search
     * @return an Account
     */
    @WebMethod(operationName = "accountOperationSearch")
    public Account getAccountById(@WebParam(name = "account") String idAccountToSearch) {
        return dao_account.getByID(idAccountToSearch);
    }
    /**
     * This is a BankBranch web service operation.
     * 
     * @param idBankToSearch int the id to search
     * @return a BankBranch
     */
    @WebMethod(operationName = "bankOperationSearch")
    public BankBranch getBankById(@WebParam(name = "bank") int idBankToSearch) {
        return dao_bank.getByID(idBankToSearch);
    }
    
    /***********
     * GET ALL *
     ***********/
    
    /**
     * 
     * @return all the Clients
     */
    @WebMethod(operationName="getAllClients")
    public List<Client> getAllClients()
    {
        return (List<Client>) dao_client.getAll();
    }
    /**
     * 
     * @return all the BankBranch
     */
    @WebMethod(operationName="getAllBankBranchs")
    public List<BankBranch> getAllBankBranchs()
    {
        return (List<BankBranch>) dao_bank.getAll();
    }
    /**
     * 
     * @return all Accounts
     */
    @WebMethod(operationName="getAllAccounts")
    public List<Account> getAllAccounts()
    {
        return (List<Account>) dao_account.getAll();
    }
    
    /**********
     * CREATE *
     **********/
    
    /**
     * This is web service operation for creating a BankBranch.
     * 
     * @param adresseBankBranch String the adress off the bankbranch
     * @param codeBankBranch int the code of the bankbranch
     * @return true if insertion is okay, else return false
     */
    @WebMethod(operationName="createBankBranch")
    public boolean createBankBranch(@WebParam(name = "Adresse") String adresseBankBranch, 
            @WebParam(name = "CodeAgence") int codeBankBranch)
    {
        if(codeBankBranch >= 0 && codeBankBranch <= 99999)
        {
            BankBranch bank = new BankBranch();
            bank.setCodeAgence(codeBankBranch);
            bank.setAdresse(adresseBankBranch);
            return dao_bank.insert(bank);
        }else{
            return false;
        }
    }
    /**
     * This is web service operation for creating an Account.
     * 
     * @param accountNumber String the account idenficator
     * @param accountIBAN String the account's IBAN number
     * @param accountLibelle String the account's libelle
     * @param accountSolde int the account's solde
     * @param accountIdBankBranch int the Id of BankBranch associated to this account
     * @return true if insertion of account is okay, else return false
     */
    @WebMethod(operationName="createAccount")
    public boolean createAccount(@WebParam(name = "accountNumber") String accountNumber,
            @WebParam(name = "accountIBAN") String accountIBAN,
            @WebParam(name = "accountLibelle") String accountLibelle,
            @WebParam(name = "accountSolde") int accountSolde,
            @WebParam(name = "accountIdBankBranch") int accountIdBankBranch)
    {
       if(accountNumber.length()>11)
       {
           Account account = new Account();
           account.setNum_compte(accountNumber);
           account.setIBAN(accountIBAN);
           account.setLibelle(accountLibelle);
           account.setSolde(accountSolde);
           BankBranch bank = dao_bank.getByID(accountIdBankBranch);
           account.setAgence(bank);
           return dao_account.insert(account);
       }else{
           return false;
       }
    }
    /**
     * This is web service operation for creating a Client.
     * 
     * @param NomClient String the lastname of the Client
     * @param PrenomClient String the firstname of the Client
     * @param NumeroClient int the client's identificator
     * @param NumeroAccountAssociated String the account's number associated
     * @return true if insertion of Client is okay, else return false
     */
    @WebMethod(operationName="createClient")
    public boolean createClient(@WebParam(name = "NomClient") String NomClient,
            @WebParam(name = "PrenomClient") String PrenomClient,
            @WebParam(name = "NumeroClient") int NumeroClient,
            @WebParam(name = "NumeroAccountAssociated") String NumeroAccountAssociated)
    {
        if(NumeroClient >= 0 && NumeroClient <= 99999)
        {
           Client client = new Client();
           client.setNomClient(NomClient);
           client.setPrenomClient(PrenomClient);
           client.setNumClient(NumeroClient);
           Account account = dao_account.getByID(NumeroAccountAssociated);
           client.setAccounts(account);
           Calendar cal = Calendar.getInstance();
           cal.set(Calendar.YEAR, 1993);
           cal.set(Calendar.MONTH, Calendar.JANUARY);
           cal.set(Calendar.DAY_OF_MONTH, 1);
           client.setDateNaiss(cal.getTime());
           return dao_client.insert(client);
        }else{
            return false;
        }
    }
    
    
    /**********
     * DELETE *
     **********/
    /**
     * This is web service operation for deleting a Client.
     * 
     * @param NumClient int the Client to delete
     * @return true if delete is okay, else return false
     */
    @WebMethod(operationName="deleteClient")
    public boolean deleteClient(@WebParam(name="NumClient") int NumClient)
    {
        Client client = dao_client.getByID(NumClient);
        return dao_client.remove(client);
    }
    /**
     *  This is web service operation for deleting a BankBranch.
     * 
     * @param BankCode int the BankBranch identificator
     * @return true if bankbranch is deleted, else return false
     */
    @WebMethod(operationName="deleteBankBranch")
    public boolean deleteBankBranch(@WebParam(name="BankCode") int BankCode)
    {
        BankBranch bank = dao_bank.getByID(BankCode);
        return dao_bank.remove(bank);
    }
    /**
     * This is web service operation for deleting a BankBranch.
     * 
     * @param NumCompte String the account identificator
     * @return true if Account is deleted, else return false
     */
    @WebMethod(operationName="deleteAccount")
    public boolean deleteAccount(@WebParam(name="NumCompte") String NumCompte)
    {
        Account account = dao_account.getByID(NumCompte);
        return dao_account.remove(account);
    }
}
