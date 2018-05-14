package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.ResultatAttribut;


public class ResultatAttributDao {

	private static final String JPQL_SELECT_ALL = "SELECT a FROM Attribut a";
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public ResultatAttributDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }
    
   public List<ResultatAttribut> getResByCompAndAtr(int idComp, int idAttribut) throws Exception {
       try {
       	return em.createQuery("SELECT r FROM ResultatAttribut r Where r.idResultat.idTuple.id =:idComp and r.idAttribut.id = :idAttribut").setParameter("idComp", idComp).setParameter("idAttribut", idAttribut).getResultList(); 

       } catch ( NoResultException e ) {
           return null;
       } catch ( Exception e ) {
           throw new Exception( e );
       }
   }
   
}
