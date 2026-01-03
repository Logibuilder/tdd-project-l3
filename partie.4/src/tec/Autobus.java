package tec;

import java.util.ArrayList;

public class Autobus implements Bus, Transport{
	
	private int nbMaxPlaceAssise;
	private int nbMaxPlaceDebout;
	private int arret = 0;
	
	private ArrayList<Passager> listePassager; 
	
	private JaugeNaturel jaugeAssise, jaugeDebout;
	
	
	public Autobus(int nbMaxPlaceAssise, int nbMaxPlaceDebout) {
		
		if(nbMaxPlaceAssise<0) {
			throw new IllegalArgumentException("Le nombre de place assise doit être positif");
		}else if(nbMaxPlaceDebout<0) {
			throw new IllegalArgumentException("Le nombre de place assise doit être positif");
		}
		nbMaxPlaceAssise = nbMaxPlaceAssise;
		nbMaxPlaceDebout = nbMaxPlaceDebout;
		jaugeAssise = new JaugeNaturel(-1, nbMaxPlaceAssise , 0);
		jaugeDebout = new JaugeNaturel(-1, nbMaxPlaceDebout , 0);
		listePassager = new ArrayList<>();
		
		
	}
	
	/**
	 * Ajout de deuxieme constructeur où le nombre de place assise est égale au nombre de place debout = nbPlace
	 * @param nbPlace
	 */
	public Autobus(int nbPlace) {
		// Appel du constructeur principal
		this(nbPlace, nbPlace);
	}
	
	/**
	 * Expliquer linstanciation avec ce deuxieme constructeur (tracer les appels).
	 * l'appel creer un nouveau bus avec le deuxième constructeur fait appel au premier constructeur
 	 * Dans quel cas faudrait-il tester ce nouveau code?
 	 * dans le cas où on instancie un autobus avec un seul paramètre pour vérifier que le nombre 
 	 * de places assises et debout est bien initialisé à la même valeur.
	 * 
	 */
	
	/**
	 *  Expliquer le probleme de duplication de code qui reste dans le code
	 *Expliquer le probleme de duplication dinstance qui reste dans le code
	 *Avez-vous note dautres problemes?
	 * 
	 */
	public int getNbMaxPlaceAssise() {
		return nbMaxPlaceAssise;
	}






	public void setNbMaxPlaceAssise(int nbMaxPlaceAssise) {
		this.nbMaxPlaceAssise = nbMaxPlaceAssise;
	}






	public int getNbMaxPlaceDebout() {
		return nbMaxPlaceDebout;
	}






	public void setNbMaxPlaceDebout(int nbMaxPlaceDebout) {
		this.nbMaxPlaceDebout = nbMaxPlaceDebout;
	}
	/**
	 * return la jauge qui conserne les places debouts
	 * @return
	 */
	public JaugeNaturel getJaugeAssise() {
		return jaugeAssise;
	}
	
	/**
	 * return la jauge qui conserne les places assises
	 * @return
	 */
	public JaugeNaturel getJaugeDebout() {
		return jaugeDebout;
	}





	/**
	   * vrai s'il existe des places assises.
	   * @return vrai s'il existe des places assises
	   */
	  public boolean aPlaceAssise() {
		  
		  return jaugeAssise.estVert();
	  }

	  /**
	   * vrai s'il existe des places debouts.
	   * @return vrai s'il existe des places debouts
	   */
	  public boolean aPlaceDebout() {
		  
		  return jaugeDebout.estVert();
		  
	  }

	  /**
	   * Le passager entre dans ce bus en demandant une place assise.
	   * L'état du passager est forcément dehors.
	   * Cette méthode est appelée par Passager.
	   * @param p le passager
	   */
	  public void demanderPlaceAssise(Passager p) {
		  if (p.estAssis()){
			  throw new IllegalStateException("Le passager est déjà assis");
		  }
		  if (aPlaceAssise()) {
			  p.accepterPlaceAssise();
			  jaugeAssise.incrementer();
			  listePassager.add(p);
		  }
		  
			  
		  
		  
	  }
	  /**
	   * Le passager entre dans ce bus en demandant une place debout.
	   * L'état du passager est forcément dehors.
	   * Cette méthode est appelée par passager. 
	   * Elle change l'état du passager.
	   * @param p le passager
	   */
	  public void demanderPlaceDebout(Passager p) {
		  
		  if (p.estDebout()){
			  throw new IllegalStateException("Le passager est déjà debout");
		  }
		  
		  if (aPlaceDebout()) {
			  p.accepterPlaceDebout();
			  jaugeDebout.incrementer();
			  listePassager.add(p);
		  }
		  
	  }


	  /**
	   * Change un passager d'une place assise vers une place debout.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état assis.
	   */
	  public void demanderChangerEnDebout(Passager p) {
		  if (p.estDehors() || p.estDebout()) {
			  throw new IllegalStateException("Le passager est déjà debout ou dehors");
		  }
		  if (aPlaceDebout()) {
			  p.accepterPlaceDebout();
			  jaugeAssise.decrementer();
			  jaugeDebout.incrementer();
		  }
		  
	  }

	  /**
	   * Change un passager d'une place debout vers une place assise.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état debout.
	   */
	  public void demanderChangerEnAssis(Passager p) {
		  if (p.estDehors() || p.estAssis()) {
			  throw new IllegalStateException("Le passager est déjà assis ou dehors");
		  }
		  
		  if (aPlaceAssise()) {
			  p.accepterPlaceAssise();
			  jaugeDebout.decrementer();
			  jaugeAssise.incrementer();
		  }
		  
	  }

	  /**
	   * Fait sortir un passager du bus.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état soit assis soit debout.
	   */
	  public void demanderSortie(Passager p) {
		  if (p.estDehors()) {
			  throw new IllegalStateException("Le passager est déjà dehors.");
		  }
		  
		  if (p.estAssis()) {
			  p.accepterSortie();
			  //listePassager.remove(p);
			  jaugeAssise.decrementer();
		  }else if (p.estDebout()) {
			  p.accepterSortie();
			  //listePassager.remove(p);
			  jaugeDebout.decrementer();
		  }
			  
		  
		  
		  
	  }
	  
	  /**
	   * Indique au tranport de simuler l'arrêt suivant.
	   *
	   * @throws si l'état du l'usager est incohérent par rapport à sa demande.
	   */
	  public void allerArretSuivant() throws UsagerInvalideException {
		  
		  arret += 1;
		  
		  ArrayList <Passager> listPassagerASupprimer = new ArrayList<>();
		  for (Passager p : listePassager) {
			  
			  try { 
				  p.nouvelArret(this, arret); 
				  if (p.estDehors()){ 
					  listPassagerASupprimer.add(p); 
					  } 
				  } 
			  catch (IllegalStateException e) {
				  throw new UsagerInvalideException("État invalide détecté lors de l'arrêt suivant : " + e.getMessage()); 
				  }
			  
			  
		  }
		  
		  for(Passager p : listPassagerASupprimer) {
			  listePassager.remove(p);
			  
		  }
		  
		  
	  }
	  
	  /**
	   * Redéfinit la méthode toString pour fournir une représentation textuelle de l'objet.
	   * Cette représentation inclut les informations sur l'arrêt, le nombre de places assises
	   * et le nombre de places debout.
	   *
	   * @return une chaîne contenant les détails de l'état actuel de l'objet
	   *         au format "[depart: <arret>, assis: <valeur>, debout: <valeur>]"
	   */

	  @Override
	  public String toString() {
	
		  return "[arret: "+ arret+ ", assis: " +this.jaugeAssise.getValeur()+ ", debout: "+ this.jaugeDebout.getValeur()+ "]";
	  }
	  

}
