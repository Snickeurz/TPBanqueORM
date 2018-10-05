package tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houssem Boukirat
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 11, nullable = false)
    private String num_compte;
    
    @Column(nullable = false)
    private String libelle;
    
    @Column(length = 27, nullable = false)
    private String IBAN;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private float solde;
    
    @ManyToOne
    @JoinColumn(name = "agence_fk", nullable = false)
    private BankBranch agence;
    
    @ManyToMany
    @JoinTable(name = "Account_Client",
    joinColumns = @JoinColumn(name = "num_compte", referencedColumnName = "num_compte"),
    inverseJoinColumns = @JoinColumn(name = "num_client", referencedColumnName = "numClient"))
    private Set<Client> clients = new HashSet<Client>();

    public Account() {
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Client client) {
        this.clients.add(client);
    }

    
    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        if(num_compte.length() == 11){
            this.num_compte = num_compte;
        }
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        if(IBAN.length() == 27){
           this.IBAN = IBAN;   
        }
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public BankBranch getAgence() {
        return agence;
    }

    public void setAgence(BankBranch agence) {
        this.agence = agence;
    }
    
    
    
}
