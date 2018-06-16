package ppdCrowd.Crowdsourcing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ppdCrowd.Crowdsourcing.dao.AttributDao;
import ppdCrowd.Crowdsourcing.dao.ComparaisonCrowderDao;
import ppdCrowd.Crowdsourcing.dao.ComparaisonDao;
import ppdCrowd.Crowdsourcing.dao.FichierDao;
import ppdCrowd.Crowdsourcing.dao.LigneDao;
import ppdCrowd.Crowdsourcing.dao.ResultatCrowderDao;
import ppdCrowd.Crowdsourcing.dao.ThemeDao;
import ppdCrowd.Crowdsourcing.entity.Attribut;
import ppdCrowd.Crowdsourcing.entity.Comparaison;
import ppdCrowd.Crowdsourcing.entity.ComparaisonCrowder;
import ppdCrowd.Crowdsourcing.entity.Fichier;
import ppdCrowd.Crowdsourcing.entity.Ligne;
import ppdCrowd.Crowdsourcing.entity.ResultatCrowder;
import ppdCrowd.Crowdsourcing.entity.Theme;


@Controller
public class MyWebService {

	List<Comparaison> tabRes = new ArrayList<Comparaison>();
	int moyChamps1, moyChamps2, moyChamps3, moyChamps4, moyChamps5;

	boolean champs1= false, champs2= false, champs3 = false, champs4 = false, champs5 = false;

	LigneDao ligneDao = new LigneDao();

	ThemeDao themeDao = new ThemeDao();

	FichierDao fichierDao = new FichierDao();

	ComparaisonDao compDao = new ComparaisonDao();

	AttributDao atrDao = new AttributDao();

	ComparaisonCrowderDao compCrowderDao = new ComparaisonCrowderDao();

	ResultatCrowderDao resCrowderDao = new ResultatCrowderDao();

	@PersistenceContext
	static	EntityManager entityManager;


	public MyWebService() {
		super();
	}

	//fonction permettant de récuperer l'ensemble des lignes contenues dans un fichier passé en paramètre
	public List<Ligne> getLignes(int numfichier){
		return entityManager.createQuery("SELECT l FROM LIGNE l WHERE idFichier.id = :numfichier").setParameter("numfichier", numfichier).getResultList(); 
	}
	
	// permet de récupérer l'ensemble des Lignes de la BDD
	@RequestMapping(value = "/ligne", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Ligne> getLignes() throws Exception{
		return ligneDao.getAllLignes();
	}

	// permet de récupérer l'ensemble des Thèmes de la BDD	
	@RequestMapping(value = "/theme", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Theme> getThemes() throws Exception{
		return themeDao.getAllThemes();
	}
	// permet de récupérer l'ensemble des Fichiers de la BDD
	@RequestMapping(value = "/fichier", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Fichier> getFichiers() throws Exception{
		return fichierDao.getAllFichiers();
	}

	//permet de récuperer l'ensemble des Bomparaisons de la BDD
	@RequestMapping(value = "/comparaison", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Comparaison> getComparaisons() throws Exception{
		return compDao.getAllComparaison();
	}

	// permet de récupérer l'ensemble des Fichiers de la BDD selon un thème particulier 
	@RequestMapping(value = "/fichierByTheme/{idTheme}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Fichier> getFichiersByTheme(@PathVariable("idTheme") int idTheme) throws Exception{
		return fichierDao.getFichiersByTheme(idTheme);
	}
	
	// permet de récupérer l'ensemble des Lignes de la BDD selon un fichier particulier 
	@RequestMapping(value = "/ligneByFichier/{idFichier}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Ligne> getLignesByFichier(@PathVariable("idFichier") int idFichier) throws Exception{
		return ligneDao.getLignesByFichier(idFichier);
	}

	// permet de récupérer l'ensemble des Comparaisons de la BDD selon un thème particulier
	@RequestMapping(value = "/comparaisonByTheme/{idTheme}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Comparaison> getComparaisonByTheme(@PathVariable("idTheme") int idTheme) throws Exception{
		return compDao.getComparaisonByTheme(idTheme);
	}

	// permet de récupérer l'ensemble des Comparaisons de la BDD selon un import particulier
	@RequestMapping(value = "/comparaisonByImport/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Comparaison> getComparaisonByImport(@PathVariable("idImport") int idImport) throws Exception{
		return compDao.getComparaisonByImport(idImport);
	}

	// permet de récupérer l'ensemble des Attributs de la BDD selon un import particulier
	@RequestMapping(value = "/attributByImport/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Attribut> getAttributByImport(@PathVariable("idImport") int idImport) throws Exception{
		return atrDao.getAttributByImport(idImport);
	}


	@GetMapping(value = "/traitement/{idFichier1}/{idFichier2}/{percentMinimum}")
	@ResponseBody
	public String detectTuples(@PathVariable int idFichier1, @PathVariable int idFichier2, @PathVariable int percentMinimum) throws Exception{
		algo detect = new algo();
		List<Ligne> tabLigne = new ArrayList<Ligne>();
		List<Ligne> tabLigne2 = new ArrayList<Ligne>();

		int i=0, j=0;
		
		tabLigne = 	ligneDao.getLignesByFichier(idFichier1);
		tabLigne2 = ligneDao.getLignesByFichier(idFichier2);
		
		for ( i = 0; i < tabLigne.size(); i++) {
			Ligne l1 = tabLigne.get(i);
			System.out.println(i);
			for ( j = 0; j < tabLigne2.size(); j++) {
				Comparaison c = new Comparaison();
				
				Ligne l2 = tabLigne2.get(j);
				
				c.setIdLigne1(l1);
				c.setIdLigne2(l2);
				c.setLevChamp1(algo.pecentageOfTextMatch(l1.getChamps1(), l2.getChamps1()));
				c.setLevChamp2(algo.pecentageOfTextMatch(l1.getChamps2(), l2.getChamps2()));
				c.setLevChamp3(algo.pecentageOfTextMatch(l1.getChamps3(), l2.getChamps3()));
				c.setLevChamp4(algo.pecentageOfTextMatch(l1.getChamps4(), l2.getChamps4()));
				c.setLevChamp5(algo.pecentageOfTextMatch(l1.getChamps4(), l2.getChamps4()));
				tabRes.add(c);
			}
		}
		attributs(percentMinimum);
		persistComparaison(percentMinimum);
		return "Traitement Terminé";
	}


	@RequestMapping(value = "/countPosNeg/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String CountResultatPosNegByComp(@PathVariable("idImport") int idImport) throws Exception{
		List<Comparaison> comp = compDao.getComparaisonByImport(idImport);
		for (Comparaison c : comp) {
			int pos = compCrowderDao.countCompCrowderPositifByComp(c.getId());
			int tot = compCrowderDao.countCompCrowderByComp(c.getId());
			List<ResultatCrowder> res = resCrowderDao.getResCrowderByComp(c.getId());
			if (res == null || res.isEmpty()){
				ResultatCrowder rc = new ResultatCrowder();
				rc.setId_Comparaison(c);
				rc.setNbReponse_Crowder(tot);
				rc.setNbReponse_Similaire(pos);
				resCrowderDao.creer(rc);
			}else {
				resCrowderDao.updateNbPosNeg(res.get(0), pos, tot);
			}
			
		}
		return "traitement effectué";
	}

	@RequestMapping(value = "/matriceSimilitude/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String CreateMatriceSimilitude(@PathVariable("idImport") int idImport) throws Exception{

		 List<Comparaison> comp = compDao.getComparaisonByImport(idImport);
		 int left1, left2, left3, left4, left5;
		 int tot = 0;
		 Float fin = 0f;
		 for (Comparaison c : comp) {
				 List <ComparaisonCrowder> res = compCrowderDao.getCompCrowderByComp(c.getId());
				 left1 = 0;
				 left2 = 0;
				 left3 = 0;
				 left4 = 0;
				 left5 = 0;
				 tot = 0;
				 fin = 0f;
				 if (res != null && !res.isEmpty()) {
					 for (ComparaisonCrowder cc : res) {
						 if (cc.isSimilaire()) {
							 if (cc.isChamp1_Left()) {
								 left1 = left1 + 1;
							 }
							 if (cc.isChamp2_Left()) {
								 left2 = left2 + 1;
							 }
							 if (cc.isChamp3_Left()) {
								 left3 = left3 + 1;
							 }
							 if (cc.isChamp4_Left()) {
								 left4 = left4 + 1;
							 }
							 if (cc.isChamp5_Left()) {
								 left5 = left5 + 1;
							 }
						 }
						 tot ++; 
					 }
				 }
				 List<ResultatCrowder> rcs = resCrowderDao.getResCrowderByComp(c.getId());
					if (rcs == null || rcs.isEmpty()){
						ResultatCrowder rc = new ResultatCrowder();
						rc.setId_Comparaison(c);
						if (left1 != 0 && tot != 0) {
							 rc.setChamp1_Left((float) left1/ (float) tot);
						 }
						if (left2 != 0 && tot != 0) {
							 rc.setChamp2_Left((float) left2/ (float) tot);
						 }
						if (left3 != 0 && tot != 0) {
							 rc.setChamp3_Left((float) left3/ (float) tot);
						 }
						if (left4 != 0 && tot != 0) {
							 rc.setChamp4_Left((float) left4/ (float) tot);
						 }
						if (left5 != 0 && tot != 0) {
							 rc.setChamp5_Left((float) left5/ (float) tot);
						 }
						resCrowderDao.creer(rc);
					}else {
						resCrowderDao.updateResChamps(rcs.get(0), left1, left2, left3, left4, left5, tot);
					}
			 }

		return "traitement effectué";
	}
	
	@RequestMapping(value = "/modelDependency/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String CreateMD(@PathVariable("idImport") int idImport) throws Exception{
		List<ResultatCrowder> res = resCrowderDao.getResCrowderByImport(idImport);
		List<Attribut> atr = atrDao.getAttributByImport(idImport);
		Float left1 = 0f, left2 = 0f, left3 = 0f, left4 = 0f, left5 = 0f;
		int tot = 0;
		for (ResultatCrowder r : res) {
			if (r.getNbReponse_Crowder() != 0 && r.getNbReponse_Similaire() != 0) {
				if (r.getNbReponse_Similaire()*2 >r.getNbReponse_Crowder()) {
					left1 = left1 + r.getChamp1_Left();
					left2 = left2 + r.getChamp2_Left();
					left3 = left3 + r.getChamp3_Left();
					left4 = left4 + r.getChamp4_Left();
					left5 = left5 + r.getChamp5_Left();
					tot++;
				}
			}
			
		}
		for (Attribut a : atr) {
			if (a.getPlace() == 1) {
				if (left1 != 0f && tot != 0) {
					atrDao.updateAtrLAndR(a, left1 / (float) tot);
				}else {
					atrDao.updateAtrLAndR(a, 0f);
				}
			}else if (a.getPlace() == 2) {
				if (left2 != 0f && tot != 0) {
					atrDao.updateAtrLAndR(a, left2 / (float) tot);
				}else {
					atrDao.updateAtrLAndR(a, 0f);
				}
			}else if (a.getPlace() == 3) {
				if (left3 != 0f && tot != 0) {
					atrDao.updateAtrLAndR(a, left3 / (float) tot);
				}else {
					atrDao.updateAtrLAndR(a, 0f);
				}
			}else if (a.getPlace() == 4) {
				if (left4 != 0f && tot != 0) {
					atrDao.updateAtrLAndR(a, left4 / (float) tot);
				}else {
					atrDao.updateAtrLAndR(a, 0f);
				}
			}else if (a.getPlace() == 5) {
				if (left5 != 0f && tot != 0) {
					atrDao.updateAtrLAndR(a, left5 / (float) tot);
				}else {
					atrDao.updateAtrLAndR(a, 0f);
				}
			}
		}
		return "traitement effectué";
	}


	public void attributs(int percentMin){
		int sumChamps1 = 0, sumChamps2 = 0, sumChamps3 = 0, sumChamps4 = 0, sumChamps5 = 0;

		int j =0;

		for ( j = 0; j < tabRes.size(); j++) {
			sumChamps1 += tabRes.get(j).getLevChamp1();
			sumChamps2 += tabRes.get(j).getLevChamp2();
			sumChamps3 += tabRes.get(j).getLevChamp3();
			sumChamps4 += tabRes.get(j).getLevChamp4();	
			sumChamps5 += tabRes.get(j).getLevChamp5();	
		}
		moyChamps1 = sumChamps1/j;
		moyChamps2 = sumChamps2/j;
		moyChamps3 = sumChamps3/j;
		moyChamps4 = sumChamps4/j;
		moyChamps5 = sumChamps5/j;

		if (moyChamps1 >= percentMin) {
			champs1 =true;
		}
		if (moyChamps2 >= percentMin) {
			champs2 =true;
		}
		if (moyChamps3 >= percentMin) {
			champs3 =true;
		}
		if (moyChamps4 >= percentMin) {
			champs4 =true;
		}
		if (moyChamps5 >= percentMin) {
			champs5 =true;
		}

	}


	public void persistComparaison(int percentMin) throws Exception{
		int i =0;
		if (champs1 == true){
			tabRes.removeIf(c -> c.getLevChamp1() <= percentMin);
		}
		if (champs2 == true){
			tabRes.removeIf(c -> c.getLevChamp2() <= percentMin);
		}
		if (champs3 == true){
			tabRes.removeIf(c -> c.getLevChamp3() <= percentMin);
		}
		if (champs4 == true){
			tabRes.removeIf(c -> c.getLevChamp4() <= percentMin);
		}
		if (champs5 == true){
			tabRes.removeIf(c -> c.getLevChamp5() <= percentMin);
		}

		  for (Comparaison c : tabRes) {
			  compDao.creer(c);
	   		  i++;
	   		  System.out.println(i+"/"+tabRes.size());
		}
			

	}
}






