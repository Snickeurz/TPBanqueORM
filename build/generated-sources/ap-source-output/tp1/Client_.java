package tp1;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp1.Account;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-08T13:33:37")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> numClient;
    public static volatile SingularAttribute<Client, String> prenomClient;
    public static volatile SingularAttribute<Client, Date> dateNaiss;
    public static volatile SetAttribute<Client, Account> accounts;
    public static volatile SingularAttribute<Client, String> nomClient;

}