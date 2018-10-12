package Models;

import DAO.TestDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas SIBAUD
 */
public class Main {
    
    public static void main(String [] args)
	{
		TestDAO d = new TestDAO();
                d.test();
	}
}
