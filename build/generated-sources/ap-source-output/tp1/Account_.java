package tp1;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp1.BankBranch;
import tp1.Client;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-05T15:10:34")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, BankBranch> agence;
    public static volatile SetAttribute<Account, Client> clients;
    public static volatile SingularAttribute<Account, String> IBAN;
    public static volatile SingularAttribute<Account, String> libelle;
    public static volatile SingularAttribute<Account, Float> solde;
    public static volatile SingularAttribute<Account, String> num_compte;

}