package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Attribut;
import ppdCrowd.Crowdsourcing.entity.Comparaison;
import ppdCrowd.Crowdsourcing.entity.Ligne;


public class ComparaisonDao {

	private static final String JPQL_SELECT_ALL = "SELECT c FROM Comparaison c";
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public ComparaisonDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }


    // Enregistrement d'une nouvelle ligne

    public void creer(Comparaison c) throws Exception {
    	em.getTransaction().begin();
        try {
            em.persist(c);
        } catch (Exception e) {
            throw new Exception(e);
        }
        em.getTransaction().commit();

    }


    // Recherche de toutes les lignes

    public List<Comparaison> getAllComparaison() throws Exception {
        try {
        	return em.createQuery(JPQL_SELECT_ALL).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    
    public List<Comparaison> getComparaisonByTheme(int idTheme) throws Exception {
        try {
        	return em.createQuery("SELECT c FROM Comparaison c Where c.idLigne1.idFichier.id_theme.id=:idTheme").setParameter("idTheme", idTheme).setMaxResults(10).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    public List<Comparaison> getComparaisonByImport(int idImport) throws Exception {
        try {
        	return em.createQuery("SELECT c FROM Comparaison c Where c.idLigne1.idFichier.id_import.id=:idImport ").setParameter("idImport", idImport).setMaxResults(10).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
}
