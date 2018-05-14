package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Attribut;
import ppdCrowd.Crowdsourcing.entity.Fichier;


public class ResultatDao {

	private static final String JPQL_SELECT_ALL = "SELECT a FROM Attribut a";
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public ResultatDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }
    
    
    public int countResultatPositifByComp(int idComp) throws Exception {
        	Long l = (Long) em.createQuery("SELECT COUNT (r) FROM Resultat r Where r.idTuple.id =:idComp and r.identique = 1").setParameter("idComp", idComp).getSingleResult();
        	int i = l.intValue();
        	return i;
    }
    
    public int countResultatNegatifByComp(int idComp) throws Exception {
    	Long l = (Long) em.createQuery("SELECT COUNT (r) FROM Resultat r Where r.idTuple.id =:idComp and r.identique = 0").setParameter("idComp", idComp).getSingleResult(); 
    	int i = l.intValue();
    	return i;
}
}
