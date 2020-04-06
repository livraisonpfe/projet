package net.javaguides.springboot.springsecurity;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.springsecurity.model.Gouvernerat;
import net.javaguides.springboot.springsecurity.repository.RepositoryGover;
//import org.springframework.test.context.jdbc.Sql;


@SpringBootApplication


public class Application {
	/*RepositoryGover repgouv;
	  public  Application(RepositoryGover repgouv){
	        this.repgouv = repgouv;
	    }*/

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	
		
	}
	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Gouvernerat g1=new Gouvernerat();
		g1.setNom("mednine");
		Gouvernerat g2=new Gouvernerat();
		g2.setNom("tunis");
		repgouv.save(g1);
		repgouv.save(g2);
		*/
	}

