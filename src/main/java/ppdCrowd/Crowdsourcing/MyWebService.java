package ppdCrowd.Crowdsourcing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ppdCrowd.Crowdsourcing.entity.Ligne;


@Controller
public class MyWebService {
	
		
	Connection connection = null;  // For making the connection
	Statement statement = null;    // For the SQL statement
	ResultSet rs = null;    // For the result set, if applicable
	
	@PersistenceContext
	static	EntityManager entityManager;
	
	
	public MyWebService() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();

	}

	
	@GetMapping(value = "hello")
	@ResponseBody
	public String accueil(){
		return "Hello CrowdMerde";
	}

	@RequestMapping(value = "/ligne", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Ligne> getLignes() throws SQLException{

	//	connection();
		return entityManager.createQuery("SELECT l FROM Ligne l").getResultList(); 
	}
	
	
	
//	public void connection(){
//		// Connection string for your SQL Database server.
//		// Change the values assigned to your_server, 
//		// your_user@your_server,
//		// and your_password.
//		String connectionString = 
//				"jdbc:sqlserver://ppdserveur.database.windows.net:1433" + ";" +  
//						"database=PPD" + ";" + 
//						"user=projetsql@ppdserveur" + ";" +  
//						"password=Ppdcrowd1";
//
//		// The types for the following variables are
//		// defined in the java.sql library.
//		
//		try
//		{
//			// Ensure the SQL Server driver class is available.
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//			// Establish the connection.
//			connection = DriverManager.getConnection(connectionString);
//			//connection.close();
//			// Provide a message when processing is complete.
//			System.out.println("Connection ouverte");
//
//		}
//		// Exception handling
//		catch (ClassNotFoundException cnfe)  
//		{
//
//			System.out.println("ClassNotFoundException " +
//					cnfe.getMessage());
//		}
//		catch (Exception e)
//		{
//			System.out.println("Exception " + e.getMessage());
//			e.printStackTrace();
//		}		
//	}
//		
//	public void deconnexion()
//	{
//		try
//		{
//			// Close resources.
//			if (null != connection) connection.close();
//			if (null != statement) statement.close();
//			if (null != rs) rs.close();
//		}
//		catch (SQLException sqlException)
//		{
//			// No additional action if close() statements fail.
//		}
//	}
}
