package tp1;


import java.io.Serializable;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houssem Boukirat
 */

@Entity
public class BankBranch implements Serializable {
    
    @Id
    @Column(length = 5, nullable = false)
    private int codeAgence;
    
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
    
    
    
    
}
