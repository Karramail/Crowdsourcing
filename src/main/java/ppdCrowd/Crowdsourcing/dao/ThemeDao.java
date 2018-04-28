package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Theme;


public class ThemeDao {

	private static final String JPQL_SELECT_ALL = "SELECT t FROM Theme t";

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public ThemeDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }


    // Enregistrement d'une nouvelle ligne

    public void creer(Theme t) throws Exception {

        try {
            em.persist(t);
        } catch (Exception e) {
            throw new Exception(e);
        }
        em.getTransaction().commit();

    }


    // Recherche de toutes les lignes

    public List<Theme> getAllThemes() throws Exception {
        try {
        	return em.createQuery(JPQL_SELECT_ALL).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
}
