package Models;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas SIBAUD
 */

@Entity
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable = false, length = 8)
    private int numClient;
    
    @Column(nullable = false)
    private String nomClient;
    
    @Column(nullable = false)
    private String prenomClient;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;

    @ManyToMany(mappedBy = "clients")
    private Set<Account> accounts = new HashSet<Account>();

    public Client() {
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public void notifyAccounts(){
        
        for(Account account : accounts){
            account.getClients().remove(this);
            account.verifityClientsStatus();
        }
    }
    

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        this.accounts.add(account);
    }
    
}
