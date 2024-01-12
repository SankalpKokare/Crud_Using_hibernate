package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entitity.Emp;

public class UpdateEmp {
		
	public static void main(String[] args) {
		

		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
										
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
										
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
										
				//create session
				Session session = sf.openSession();	
		
				Emp e =  session.get(Emp.class, 212);
				e.setEname("Willam");
				
				//saving entity in transaction
				Transaction tr = session.beginTransaction();
				
				session.update(e);
				
				tr.commit();
				
				System.out.println("Emp update");
				
				session.close();
				
				sf.close();
			
				
				
		
		
	}
	
}
