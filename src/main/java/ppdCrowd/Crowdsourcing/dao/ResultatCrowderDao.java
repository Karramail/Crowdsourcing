package ppdCrowd.Crowdsourcing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ppdCrowd.Crowdsourcing.entity.Attribut;
import ppdCrowd.Crowdsourcing.entity.Comparaison;
import ppdCrowd.Crowdsourcing.entity.ComparaisonCrowder;
import ppdCrowd.Crowdsourcing.entity.ResultatCrowder;


public class ResultatCrowderDao {
	

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext
    private static EntityManager em;
    
   public ResultatCrowderDao () {
	   super();
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	   em = emf.createEntityManager();
   }
   
   public void updateNbPosNeg(ResultatCrowder c, int pos, int tot) throws Exception {
   	
   	em.getTransaction().begin();
   	c.setNbReponse_Similaire(pos);
   	c.setNbReponse_Crowder(tot);
   	em.getTransaction().commit();

   }
   
   public void creer(ResultatCrowder c) throws Exception {
   	em.getTransaction().begin();
       try {
           em.persist(c);
       } catch (Exception e) {
           throw new Exception(e);
       }
       em.getTransaction().commit();

   }
   
   public List<ResultatCrowder> getResCrowderById(int id) throws Exception {
       try {
       	return em.createQuery("SELECT c FROM ResultatCrowder c Where c.id=:id ").setParameter("id", id).getResultList(); 

       } catch ( NoResultException e ) {
           return null;
       } catch ( Exception e ) {
           throw new Exception( e );
       }
   }
   
   public List<ResultatCrowder> getResCrowderByComp(int idComp) throws Exception {
       try {
       	return em.createQuery("SELECT c FROM ResultatCrowder c Where c.id_Comparaison.id=:idComp ").setParameter("idComp", idComp).getResultList(); 

       } catch ( NoResultException e ) {
           return null;
       } catch ( Exception e ) {
           throw new Exception( e );
       }
   }
   
   public List<ResultatCrowder> getResCrowderByImport(int idImport) throws Exception {
       try {
       	return em.createQuery("SELECT c FROM ResultatCrowder c Where c.id_Comparaison.idLigne1.idFichier.id_import.id=:idImport ").setParameter("idImport", idImport).setMaxResults(10).getResultList(); 

       } catch ( NoResultException e ) {
           return null;
       } catch ( Exception e ) {
           throw new Exception( e );
       }
   }

   public void updateResChamps(ResultatCrowder resultatCrowder, int left1, int left2, int left3, int left4, int left5,
		   int tot) {
	   
	   em.getTransaction().begin();
	   if (left1 != 0 && tot != 0) {
		   resultatCrowder.setChamp1_Left((float) left1/ (float) tot);
		 }
		if (left2 != 0 && tot != 0) {
			resultatCrowder.setChamp2_Left((float) left2/ (float) tot);
		 }
		if (left3 != 0 && tot != 0) {
			resultatCrowder.setChamp3_Left((float) left3/ (float) tot);
		 }
		if (left4 != 0 && tot != 0) {
			resultatCrowder.setChamp4_Left((float) left4/ (float) tot);
		 }
		if (left5 != 0 && tot != 0) {
			resultatCrowder.setChamp5_Left((float) left5/ (float) tot);
		 }
		 em.getTransaction().commit();
	  

   }
}
