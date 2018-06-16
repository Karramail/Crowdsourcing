package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.ComparaisonCrowder;


public class ComparaisonCrowderDao {

	private static final String JPQL_SELECT_ALL = "SELECT a FROM Attribut a";
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public ComparaisonCrowderDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }
    
    
    public int countCompCrowderPositifByComp(int idComp) throws Exception {
        	Long l = (Long) em.createQuery("SELECT COUNT (c) FROM ComparaisonCrowder c Where c.id_Comparaison.id =:idComp and c.isSimilaire = 1").setParameter("idComp", idComp).getSingleResult();
        	int i = l.intValue();
        	return i;
    }
    
    public int countCompCrowderByComp(int idComp) throws Exception {
    	Long l = (Long) em.createQuery("SELECT COUNT (c) FROM ComparaisonCrowder c Where c.id_Comparaison.id =:idComp").setParameter("idComp", idComp).getSingleResult(); 
    	int i = l.intValue();
    	return i;
}
    
    
    
    public List<ComparaisonCrowder> getCompCrowderByImport(int idImport) throws Exception {
        try {
        	return em.createQuery("SELECT c FROM ComparaisonCrowder c Where c.id_Comparaison.idLigne1.idFichier.id_import.id=:idImport ").setParameter("idImport", idImport).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    public List<ComparaisonCrowder> getCompCrowderByComp(int idComp) throws Exception {
        try {
        	return em.createQuery("SELECT c FROM ComparaisonCrowder c Where c.id_Comparaison.id=:idComp ").setParameter("idComp", idComp).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
}
