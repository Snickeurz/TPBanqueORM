package Models;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Modele de Client
 * @author Nicolas SIBAUD
 */

@Entity
public class Client implements Serializable {
    
    /**
     * l'identifiant du client, primary Key de 8 digits
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable = false, length = 8)
    private int numClient;
    
    /**
     * Nom du client
     */
    @Column(nullable = false)
    private String nomClient;
    
    /**
     * Prénom du client
     */
    @Column(nullable = false)
    private String prenomClient;

    /**
     * Date de naissance du client
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;

    /**
     * La liste des comptes bancaires du clients
     */
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

    
    /**
     * Méthode qui notifie les comptes bancaires que le client<br>
     * n'est plus associé avec ce compte bancaire<br>
     * pour supprimer ce client de la liste des clients du compte bancaire<br>
     * et notifier le compte de cette suppréssion pour qu'il appelle sa méthode {@link Account#verifyClientsStatus }
     */
    public void notifyAccounts(){
        for(Account account : accounts){
            account.getClients().remove(this);
            account.verifyClientsStatus();
        }
    }
    

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return "Client{" + "numClient=" + numClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", dateNaiss=" + dateNaiss + ", accounts=" + accounts.size() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.numClient != other.numClient) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
