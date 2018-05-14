package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Attribut;
import ppdCrowd.Crowdsourcing.entity.Comparaison;
import ppdCrowd.Crowdsourcing.entity.Fichier;


public class AttributDao {

	private static final String JPQL_SELECT_ALL = "SELECT a FROM Attribut a";
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public AttributDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }


    // Enregistrement d'une nouvelle ligne

    public void creer(Attribut a) throws Exception {

        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception(e);
        }
        em.getTransaction().commit();

    }
    
 public void updateAtrLAndR( Attribut a, Float res) throws Exception {
    	
    	em.getTransaction().begin();
    	if (res > 0.5) {
    		a.setTypeAtr("Left");
    	}else {
    		a.setTypeAtr("Right");
    	}
    	a.setResultat(res);
        em.getTransaction().commit();

    }


    // Recherche de toutes les lignes

    public List<Attribut> getAllAttributs() throws Exception {
        try {
        	return em.createQuery(JPQL_SELECT_ALL).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    
    public List<Attribut> getAttributByImport(int idImport) throws Exception {
        try {
        	return em.createQuery("SELECT a FROM Attribut a Where a.idImport.id =:idImport").setParameter("idImport", idImport).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
}
