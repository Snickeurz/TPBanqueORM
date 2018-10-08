package tp1;


import java.io.Serializable;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Define Bank entity
 * 
 * @author Nicolas
 */
@Entity
public class BankBranch implements Serializable {
    
    /**
     * BankBranch's code for referencement
     */
    @Id
    @Column(length = 5, nullable = false)
    private int codeAgence;
    
    /**
     * BankBranch's adress
     */
    @Column(nullable = false)
    private String adresse;

    /**
     * BankBranch's default constructor
     */
    public BankBranch() {
    }

    /**
     * MUTATORS
     */
    
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
