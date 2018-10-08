package tp1;


import java.io.Serializable;
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
 * Define Client entity
 * 
 * @author Nicolas
 */
@Entity
public class Client implements Serializable {
    
    /**
     * Client's id for referecement
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable = false, length = 8)
    private int numClient;
    
    /**
     * Client's lastname
     */
    @Column(nullable = false)
    private String nomClient;
    
    /**
     * Client's firstname
     */
    @Column(nullable = false)
    private String prenomClient;

    /**
     * Client's birthday
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE) 
    private Date dateNaiss;
    
    /**
     * Client's account list
     */
    @ManyToMany(mappedBy = "clients")
    private Set<Account> accounts = new HashSet<Account>();

    /**
     * Client's default constructor
     */
    public Client() {
    }

    /**
     * MUTATORS
     */
    
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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        this.accounts.add(account);
    }    
}
