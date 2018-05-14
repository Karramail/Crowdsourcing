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
import ppdCrowd.Crowdsourcing.dao.ComparaisonDao;
import ppdCrowd.Crowdsourcing.dao.FichierDao;
import ppdCrowd.Crowdsourcing.dao.LigneDao;
import ppdCrowd.Crowdsourcing.dao.ResultatAttributDao;
import ppdCrowd.Crowdsourcing.dao.ResultatDao;
import ppdCrowd.Crowdsourcing.dao.ThemeDao;
import ppdCrowd.Crowdsourcing.entity.Attribut;
import ppdCrowd.Crowdsourcing.entity.Comparaison;
import ppdCrowd.Crowdsourcing.entity.Fichier;
import ppdCrowd.Crowdsourcing.entity.Ligne;
import ppdCrowd.Crowdsourcing.entity.ResultatAttribut;
import ppdCrowd.Crowdsourcing.entity.Theme;


@Controller
public class MyWebService {

	List<Comparaison> tabRes = new ArrayList<Comparaison>();
	int moyChamps1, moyChamps2, moyChamps3, moyChamps4;
	int percentMin = 45;
	boolean champs1= false, champs2= false, champs3 = false, champs4 = false;
	
	LigneDao ligneDao = new LigneDao();
	
	ThemeDao themeDao = new ThemeDao();
	
	FichierDao fichierDao = new FichierDao();
	
	ComparaisonDao compDao = new ComparaisonDao();
	
	AttributDao atrDao = new AttributDao();
	
	ResultatDao resDao = new ResultatDao();
	
	ResultatAttributDao resAtrDao = new ResultatAttributDao();
	
	@PersistenceContext
	static	EntityManager entityManager;
	
	
	public MyWebService() {
		super();
	}

	//fonction permettant de récuperer l'ensemble des lignes contenues dans un fichier passé en paramètre
	public List<Ligne> getLignes(int numfichier){
		return entityManager.createQuery("SELECT l FROM LIGNE l WHERE idFichier.id = :numfichier").setParameter("numfichier", numfichier).getResultList(); 
	}


	@RequestMapping(value = "/ligne", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Ligne> getLignes() throws Exception{
		return ligneDao.getAllLignes();
	}
	
	@RequestMapping(value = "/theme", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Theme> getThemes() throws Exception{
		return themeDao.getAllThemes();
	}
	
	@RequestMapping(value = "/fichier", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Fichier> getFichiers() throws Exception{
		return fichierDao.getAllFichiers();
	}
	
	@RequestMapping(value = "/fichierByTheme/{idTheme}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Fichier> getFichiersByTheme(@PathVariable("idTheme") int idTheme) throws Exception{
		return fichierDao.getFichiersByTheme(idTheme);
	}

	@RequestMapping(value = "/comparaison", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Comparaison> getComparaisons() throws Exception{
		return compDao.getAllComparaison();
	}
	
	@RequestMapping(value = "/comparaisonByTheme/{idTheme}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Comparaison> getComparaisonByTheme(@PathVariable("idTheme") int idTheme) throws Exception{
		return compDao.getComparaisonByTheme(idTheme);
	}
	
	@RequestMapping(value = "/comparaisonByImport/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Comparaison> getComparaisonByImport(@PathVariable("idImport") int idImport) throws Exception{
		return compDao.getComparaisonByImport(idImport);
	}

	@RequestMapping(value = "/attributByImport/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Attribut> getAttributByImport(@PathVariable("idImport") int idImport) throws Exception{
		return atrDao.getAttributByImport(idImport);
	}
	
	
	@GetMapping(value = "/traitement/{idFichier1}/{idFichier2}")
	@ResponseBody
	public String detectTuples(@PathVariable int idFichier1, @PathVariable int idFichier2){
		algo detect = new algo();
		List<Ligne> tabLigne = new ArrayList<Ligne>();
		List<Ligne> tabLigne2 = new ArrayList<Ligne>();

		int i=0, j=0;

		tabLigne = getLignes(idFichier1);
		tabLigne2 = getLignes(idFichier2);

		for ( i = 0; i < tabLigne.size(); i++) {
			Ligne l1 = tabLigne.get(i);
			for ( j = 0; j < tabLigne2.size(); j++) {
				Comparaison c = new Comparaison();
				Ligne l2 = tabLigne2.get(j);
				c.setIdLigne1(l1);
				c.setIdLigne2(l2);
				c.setResChamp1(algo.pecentageOfTextMatch(l1.getChamps1(), l2.getChamps1()));
				c.setResChamp2(algo.pecentageOfTextMatch(l1.getChamps2(), l2.getChamps2()));
				c.setResChamp3(algo.pecentageOfTextMatch(l1.getChamps3(), l2.getChamps3()));
				c.setResChamp4(algo.pecentageOfTextMatch(l1.getChamps4(), l2.getChamps4()));
				tabRes.add(c);
			}
		}
		return "Traitement Terminé";
	}
	
	
	@RequestMapping(value = "/countPosNeg/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String CountResultatPosNegByComp(@PathVariable("idImport") int idImport) throws Exception{
		 List<Comparaison> comp = compDao.getComparaisonByImport(idImport);
		 for (Comparaison c : comp) {
			 int pos = resDao.countResultatPositifByComp(c.getId());
			 int neg = resDao.countResultatNegatifByComp(c.getId());
			 compDao.updateNbPosNeg(c, pos, neg);
		 }
		return "traitement effectué";
	}
	
	@RequestMapping(value = "/matriceSimilitude/{idImport}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String CreateMatriceSimilitude(@PathVariable("idImport") int idImport) throws Exception{
		 List<Comparaison> comp = compDao.getComparaisonByImport(idImport);
		 List<Attribut> atr = atrDao.getAttributByImport(idImport);
		 int left = 0;
		 int tot = 0;
		 Float fin = (float) 0;
		 for (Comparaison c : comp) {
			 for (Attribut a : atr) {
				 List <ResultatAttribut> res = resAtrDao.getResByCompAndAtr(c.getId(), a.getId());
				 left = 0;
				 tot = 0;
				 fin = (float) 0;
				 for (ResultatAttribut r : res) {
					 if (r.getTypeAtr().equals("Left")) {
						 left ++;
					 }
					 tot ++;
				 }
				 if (left != 0 && tot != 0) {
					 fin = (float) (left/tot);
				 }
				 compDao.updateCompAtr(c, fin, a);
			 }
		 }
		return "traitement effectué";
	}


	@GetMapping(value = "attributs")
	@ResponseBody
	public String attributs(){
		int sumChamps1 = 0, sumChamps2 = 0, sumChamps3 = 0, sumChamps4 = 0;

		int j =0;

		for ( j = 0; j < tabRes.size(); j++) {
			sumChamps1 += tabRes.get(j).getResChamp1();
			sumChamps2 += tabRes.get(j).getResChamp2();
			sumChamps3 += tabRes.get(j).getResChamp3();
			sumChamps4 += tabRes.get(j).getResChamp4();	
		}
		moyChamps1 = sumChamps1/j;
		moyChamps2 = sumChamps2/j;
		moyChamps3 = sumChamps3/j;
		moyChamps4 = sumChamps4/j;

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

		String s = champs1 +" "+ champs2 + " "+ champs3 + " " + champs4; 
		s = s + "/n" + "Voici les pourcentages de ressemblance entre les attributs  : " + " / champs 1 : " + moyChamps1 +"% "+ " / champs 2 : " + moyChamps2 +"% "+ " / champs 3 : " + moyChamps3 +"% "+ " / champs 4 : " + moyChamps4 +"% ";

		return s;
	}

	@GetMapping(value = "afficheQuestions")
	@ResponseBody
	public void afficheQuestions(){

		String sqlString = "ceci est un test";
		int i = 0;
		for (Comparaison c : tabRes) {
			System.out.println(i + "/" + tabRes.size());
			i ++;

			if ((champs1 == true && c.getResChamp1() >= percentMin) || (champs1 == false)) {
				if((champs2  == true && c.getResChamp2() >= percentMin) || (champs2 == false)) {
					if ((champs3  == true && c.getResChamp3() >= percentMin) || (champs3 == false)){
						if ((champs4  == true && c.getResChamp4() >= percentMin) || (champs4 == false)){
							entityManager.persist(c);
							entityManager.flush();
							
						}
					}
				}
			}
		}
		entityManager.getTransaction().commit();
	}


}






