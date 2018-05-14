package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Fichier;
import ppdCrowd.Crowdsourcing.entity.Ligne;


public class LigneDao {

	private static final String JPQL_SELECT_ALL = "SELECT l FROM Ligne l";

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public LigneDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }


    // Enregistrement d'une nouvelle ligne

    public void creer(Ligne l) throws Exception {

        try {
            em.persist(l);
        } catch (Exception e) {
            throw new Exception(e);
        }
        em.getTransaction().commit();

    }


    // Recherche de toutes les lignes

    public List<Ligne> getAllLignes() throws Exception {
        try {
        	return em.createQuery(JPQL_SELECT_ALL).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    // Recherche de toutes les lignes d'un fichier

    public List<Ligne> getLignesByFichier(int idFichier) throws Exception {
        try {
        	return em.createQuery("SELECT l FROM Ligne l Where l.idFichier.id=:idFichier").setParameter("idFichier", idFichier).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
}
