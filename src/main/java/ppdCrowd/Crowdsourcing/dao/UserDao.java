package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Attribut;
import ppdCrowd.Crowdsourcing.entity.Import;
import ppdCrowd.Crowdsourcing.entity.Utilisateur;


public class UserDao {
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public UserDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }


    // Enregistrement d'une nouvelle ligne

    public void creer(Utilisateur u) throws Exception {

        try {
            em.persist(u);
        } catch (Exception e) {
            throw new Exception(e);
        }
        em.getTransaction().commit();

    }

}
