package tec;

public class PassagerStandard implements Passager, Usager{
	/**
	 * l'attribut nom du passagerStandard
	 */
	public String nom;
	
	/*
	 * constructeur de passagerStandard
	 * @param : nom du passagerStandard
	 * @param : int destination
	 */
	public PassagerStandard(String nom, int destination) {
		//TO_DO
	}
	/**
	   * fournit le nom de l'usager.
	   */
	  public String nom() {
		//TO_DO
		  return null;
	  };

	  /**
	   * Retourne vrai si le passager est hors du bus.
	   * @return vrai si le passager est hors du bus.
	   */
	  public boolean estDehors() {
		//TO_DO
		  return false;
	  }
	  	
	  /**
	   * Retourne vrai si le passager est assis dans le bus.
	   * @return vrai si le passager est assis dans le bus.
	   */
	  public boolean estAssis() {
		//TO_DO
		  return false;
	  };
	  
	  /**
	   * Retourne vrai si le passager est debout dans le bus.
	   * @return vrai si le passager est debout dans le bus.
	   */
	  public boolean estDebout() {
		//TO_DO
		  return false;
	  };

	  /**
	   * Change l'état du passager en hors du bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterSortie() {
		  //TO_DO
	  }
	  /**
	   * Change l'état du passager en assis. 
	   * Le passager est dans le bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterPlaceAssise() {
		  //TO_DO
	  }
	  /**
	   * Change l'état du passager en debout.
	   * Le passager est dans le bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterPlaceDebout() {
		  //TO_DO
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
		  //TO_DO
	  }
	  /**
	   * Fournit à l'usager le transport auquel il peut accéder.
	   * Cette méthode réalise le caractère du passager à la montée.
	   * 
	   * @param t le transport dans lequel désire monter l'usager.
	   * @throws si l'état de l'usager est incohérent par rapport à sa demande.
	   */
	  public void monterDans(Transport t) throws UsagerInvalideException {
		// TODO Auto-generated method stub
	  }

}
