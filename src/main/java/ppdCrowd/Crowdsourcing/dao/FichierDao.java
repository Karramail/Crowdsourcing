package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Fichier;


public class FichierDao {

	private static final String JPQL_SELECT_ALL = "SELECT f FROM Fichier f";
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public FichierDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }


    // Enregistrement d'une nouvelle ligne

    public void creer(Fichier f) throws Exception {

        try {
            em.persist(f);
        } catch (Exception e) {
            throw new Exception(e);
        }
        em.getTransaction().commit();

    }


    // Recherche de toutes les lignes

    public List<Fichier> getAllFichiers() throws Exception {
        try {
        	return em.createQuery(JPQL_SELECT_ALL).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    
    public List<Fichier> getFichiersByTheme(int idTheme) throws Exception {
        try {
        	return em.createQuery("SELECT f FROM Fichier f Where f.id_theme.id=:idTheme").setParameter("idTheme", idTheme).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
}
