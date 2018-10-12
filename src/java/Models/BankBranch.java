package Models;


import java.io.Serializable;
import javax.persistence.*;


/**
 * Modele de banque (BankBranch)
 * @author Nicolas SIBAUD
 */
@Entity
public class BankBranch implements Serializable {
    
    /**
     * Code de l'agence bancaire, primary Key de 5 digits
     */
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 5, nullable = false)
    private int codeAgence;
    
    /**
     * l'adresse du compte bancaire
     */
    @Column(nullable = false)
    private String adresse;

    public BankBranch() {
    }

    public int getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "BankBranch{" + "codeAgence=" + codeAgence + ", adresse=" + adresse + '}';
    }
    
    
    
    
    
}
