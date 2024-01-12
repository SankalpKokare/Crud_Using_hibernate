package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entitity.Emp;

public class InsertEmp {

	public static void main(String[] args) throws ParseException {
		
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
										
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
										
				//Connect to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
										
				//create session
				Session session = sf.openSession();	
				

				//LocalDate.parse("2000-09-08").get
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date bdate_p = new java.util.Date(sdf.parse("2000-09-08").getTime());
				java.sql.Date bdate = new java.sql.Date(bdate_p.getTime());
				
				
				//create entity
				Emp e = new Emp(200,"John","coder",7654, bdate,3000.00,0.00,11);
				
				//transaction 
				Transaction tr = session.beginTransaction();
				
				session.persist(e);  //insert query
				
				tr.commit();
				
				session.close();
				
				sf.close();
				
				System.out.println(e);
				

		
	}
	
}
