package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.DAO_Account;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Modele de compte (Account)
 * @author  Nicolas SIBAUD
 */
@Entity
public class Account implements Serializable {
    
    /**
     * Numéro du compte, clé primaire qui doit avoir une taille de 11
     */
    @Id
    @Column(length = 11, nullable = false)
    private String num_compte;
    
    /**
     * Libelle du compte
     */
    @Column(nullable = false)
    private String libelle;
    
    /**
     * IBAN du compte bancaire, doit être une chaine de 27 characteres
     */
    @Column(length = 27, nullable = false)
    private String IBAN;
    
    /**
     * solde du compte bancaire
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private float solde;
    
    /**
     * Relation ManyToOne: une agence peut avoir plusieurs comptes bancaires.<br>
     * Le nom de la colonne dans la BDD pour la clé etrangère est "agence_fk"
     */
    @ManyToOne
    @JoinColumn(name = "agence_fk", nullable = false)
    private BankBranch agence;
    
    /**
     * Relatation ManyToMany: un client peut avoir plusieurs comptes bancaires et vice-versa<br>
     */
    @ManyToMany
    @JoinTable(name = "Account_Client",
    joinColumns = @JoinColumn(name = "num_compte", referencedColumnName = "num_compte"),
    inverseJoinColumns = @JoinColumn(name = "num_client", referencedColumnName = "numClient"))
    private Set<Client> clients = new HashSet<Client>();

    public Account() {
    }

    /**
     * Getteur pour avoir une liste contenant tous les clients rattachés à un compte bancaire
     * @return Set de clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Setteur pour ajouter un client dans le compte bancaire.
     * @param client le client à ajouter
     */
    public void setClients(Client client) {
        this.clients.add(client);
    }

    /**
     * Getteur de l'identifiant du compte bancaire
     * @return num_compte
     */
    public String getNum_compte() {
        return num_compte;
    }

    /**
     * Setteur de l'identifiant du compte bancaire
     * @param num_compte : account ID
     */
    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;    
    }
    /**
     * Getteur du libellé du compte bancaire
     * @return libelle
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * Setteur du libellé du compte bancaire
     * @param libelle 
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    /**
     * Getteur du IBAN du compte bancaire
     * @return  IBAN
     */
    public String getIBAN() {
        return IBAN;
    }
    /**
     * Setteur du IBAN du compte bancaire.
     * @param IBAN une chaine de charactere de 27 characteres
     */
    public void setIBAN(String IBAN) {
        if(IBAN.length() == 27){
           this.IBAN = IBAN;   
        }
    }
    /**
     * Getteur du solde du compte
     * @return solde
     */
    public float getSolde() {
        return solde;
    }
    /**
     * Setteur du solde du compte bancaire
     * @param solde 
     */
    public void setSolde(float solde) {
        this.solde = solde;
    }
    /**
     * Getteur pour avoir l'agence bancaire du compte (Object)
     * @return objet Agence
     */
    public BankBranch getAgence() {
        return agence;
    }
    /**
     * Setteur de l'agence 
     * @param agence 
     */
    public void setAgence(BankBranch agence) {
        this.agence = agence;
    }
    
    /**
     * Méthode qui vérifie si le compte bancaire n'est plus rattaché a aucun client<br>
     * si il ne reste aucun client, on supprime le compte bancaire
     * @return 
     */
    public int verifyClientsStatus(){
        if(getClients().isEmpty()){
            DAO_Account daccount = DAO_Account.getInstance();
            System.out.println(daccount.remove(this));
        }
        return 0;
    }

    @Override
    public String toString() {
        return ""+clients.size();
    }
    
    
    
    
}
