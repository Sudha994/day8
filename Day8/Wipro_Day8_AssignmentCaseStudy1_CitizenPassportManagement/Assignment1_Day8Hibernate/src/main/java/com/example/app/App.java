package com.example.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Citizen;
import com.example.entity.Passport;
import com.example.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Citizen citizen = new Citizen();
		citizen.setName("Sanjith");
		
		Passport passport = new Passport();
		passport.setPassportNumber("P1234567");
		
		citizen.setPassport(passport);
        passport.setCitizen(citizen);
        
        // Save the Citizen
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(citizen);
        transaction.commit();
             
        
        //Retrieve the Citizen with Passport
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Citizen savedCitizen = session1.get(Citizen.class, 1L);
        System.out.println("Retrieved Citizen: " + savedCitizen);
        System.out.println("Associated Passport: " + savedCitizen.getPassport());
        
        // To close 
        HibernateUtil.shutdown();
        
	}

}
