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
import ppdCrowd.Crowdsourcing.entity.Import;


public class ImportDao {

	private static final String JPQL_SELECT_ALL = "SELECT i FROM Imports i";
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public ImportDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }


    // Enregistrement d'une nouvelle ligne

    public void creer(Import i) throws Exception {

        try {
            em.persist(i);
        } catch (Exception e) {
            throw new Exception(e);
        }
        em.getTransaction().commit();

    }


    // Recherche de toutes les lignes

    public List<Attribut> getAllImports() throws Exception {
        try {
        	return em.createQuery(JPQL_SELECT_ALL).getResultList(); 

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    public Import getImportById(int idImport) throws Exception {
        try {
        	List<Import> imp = em.createQuery("SELECT i FROM Import i Where i.id =:idImport").setParameter("idImport", idImport).getResultList(); 
        	return imp.get(0);
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
    
    public List<Import> getImportByUser(int idDemandeur) throws Exception {
        try {
        	return em.createQuery("SELECT i FROM Import i Where i.id_demandeur.id =:idDemandeur").setParameter("idDemandeur", idDemandeur).getResultList(); 
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new Exception( e );
        }
    }
}
