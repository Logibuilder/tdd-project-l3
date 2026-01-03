package tec;

import tec.EtatPassager.Etat;

public class PassagerStandard implements Passager, Usager{
	/**
	 * l'attribut nom du passagerStandard
	 */
	public String nom;
	
	public EtatPassager getEtat() {
		return etat;
	}
	public void setEtat(EtatPassager etat) {
		this.etat = etat;
	}
	public int destination;
	
	EtatPassager etat = new EtatPassager(Etat.DEHORS);

	
	/*
	 * constructeur de passagerStandard
	 * @param : nom du passagerStandard
	 * @param : int destination
	 */
	public PassagerStandard(String nom, int destination) {
		this.nom = nom;
		this.destination = destination;
		
	}
	/**
	   * fournit le nom de l'usager.
	   */
	/**
	 * Retourne le nom associé à cet objet.
	 *
	 * @return le nom de l'objet
	 */
	public String nom() {
	    return nom;
	}

	/**
	 * Définit le nom de cet passagerStandard.
	 *
	 * @param nom le nouveau nom à attribuer à passagerStandard
	 */
	public void setNom(String nom) {
	    this.nom = nom;
	}

	/**
	 * Retourne la destination associée à cet passagerStandard.
	 *
	 * @return la destination de l'objet
	 */
	public int getDestination() {
	    return destination;
	}

	/**
	 * Définit la destination de cet passagerStandard.
	 *
	 * @param destination la nouvelle destination à attribuer à passagerStandard
	 */
	public void setDestination(int destination) {
	    this.destination = destination;
	}
	

	/**
	   * Retourne vrai si le passager est hors du bus.
	   * @return vrai si le passager est hors du bus.
	   */
	  public boolean estDehors() {
		
		  return etat.estExterieur();
	  }
	  	
	  /**
	   * Retourne vrai si le passager est assis dans le bus.
	   * @return vrai si le passager est assis dans le bus.
	   */
	  public boolean estAssis() {
		  return etat.estAssis();
	  };
	  
	  /**
	   * Retourne vrai si le passager est debout dans le bus.
	   * @return vrai si le passager est debout dans le bus.
	   */
	  public boolean estDebout() {
		  return etat.estDebout();
	  };

	  /**
	   * Change l'état du passager en hors du bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterSortie() {
		  etat.setEtat(Etat.DEHORS);
		  
	  }
	  /**
	   * Change l'état du passager en assis. 
	   * Le passager est dans le bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterPlaceAssise() {
		  etat.setEtat(Etat.ASSIS);
	  }
	  /**
	   * Change l'état du passager en debout.
	   * Le passager est dans le bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterPlaceDebout() {
		  etat.setEtat(Etat.DEBOUT);
	  }
	  /**
	   * Indique au passager qu'il est arrivé à un nouvel arrêt. Cette methode
	   * fixe le comportement (changer de place ou sortir). 
	   * Cette méthode est appelée par Bus.
	   *
	   * @param bus le bus dans lequel se trouve le passager.
	   * @param numeroArret numero de l'arrêt.
	   */
	  public void nouvelArret(Bus bus, int numeroArret) {
		  if (numeroArret == destination) {
			  
			  Autobus autobus  = (Autobus) bus;
			  
			  autobus.demanderSortie(this);
			  
			  // état déjà changé dans accepterSortie gérer par demanderSortie
			  //etat.setEtat(Etat.DEHORS);
			  
			  }
	  }
	  /**
	   * Fournit à l'usager le transport auquel il peut accéder.
	   * Cette méthode réalise le caractère du passager à la montée.
	   * 
	   * @param t le transport dans lequel désire monter l'usager.
	   * @throws si l'état de l'usager est incohérent par rapport à sa demande.
	   */
	  public void monterDans(Transport t) throws UsagerInvalideException {
		  
		  //on caste un autobus qui va demander une place pour le passager qui veut entrer dans le bus.
		  Autobus autobus = (Autobus) t;   

		  //on demande premièrement s'il ya une place assise
		  autobus.demanderPlaceAssise(this);
		  
		  //on demande deuxièrement s'il ya une place debout
		  if (this.estDehors()) {
			  autobus.demanderPlaceDebout(this);
		  } //Sinon le passager ne monte pas dans le bus parce qu'il n'y a pas de place.

	  }
	  /**
	   * la fonction string qui décrit un état passager
	   * @return 
	   * <ul>
 *           <li>"nom assis" : si l'objet est assis.</li>
 *           <li>"nom debout" : si l'objet est debout.</li>
 *           <li>"nom dehors" : si l'objet est en dehors des autres états.</li>
 *       </ul>
	   */
	  @Override
	  public String toString() {
		  String etat = "";
		  if (this.estAssis()) {
			  etat = "assis";
		  } else  if (this.estDebout()) {
			  etat = "debout";
		  } else {
			  etat = "dehors";
		  }
		  return nom + " " + etat;
	  }
}
