package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entitity.Emp;


public class FetchEmp {
	
	public static void main(String[] args) {
		
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read info from hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		//connect to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		//create session 
		Session session = sf.openSession();
		
		Emp e = session.get(Emp.class, 7369);
		
		System.out.println(e.getEname());
		
		session.close();
		
		sf.close();
		
	}

}
