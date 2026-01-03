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
	
	
	/**
	 *  Deuxième constructeur avec validation et appel au constructeur principal
	 * @param destination
	 * 
	 * REPONSE AUX QUESTIONS :
	 * ----Expliquer l'instanciation avec ce deuxieme constructeur (tracer les appels):
	 * 	        en fait il concatène la destination et le nom del a classe (exemple: le nom du passager = "passager_4)
	 * 
	 * ----Dans quel cas faudrait-il tester ce nouveau code ?
	 * 		Si c'est les tests unitaires, vérifier la concaténation
	 * 		Si c'est les test fonctionnels , vérifier la levée d'exception
	 * 
	 * ----Expliquer le probleme de duplication de code qui reste dans le code :
	 * 		il peut rester un problème de duplication dans la logique d'initialisation des variables qui sont dupliquées dans différents constructeurs.
	 *     Par exemple, si plusieurs constructeurs initialisent les mêmes variables de manière identique, cela peut être un signe de duplication.
	 * 
	 * ----Expliquer le probleme de duplication d'instance qui reste dans le code : 
	 * 		 La duplication d'instance survient lorsque vous créez plusieurs objets avec des valeurs ou comportements similaires
	 * 		 On peut l'eviter en implémnetant sa classe en singlton( Le Singleton est un design pattern (modèle de conception) 
	 * 		 qui permet de garantir qu'une classe n'ait qu'une seule instance (objet) pendant toute la durée de vie de l'application, 
	 * 		 et de fournir un point d'accès global à cette instance. 
	 * 		 
	 */
    public PassagerStandard(int destination) {
        
        this("Passager_" + destination, destination); // Appel au constructeur principal en concaténant la classe et la destination
        
    }

	/*
	 * constructeur de passagerStandard
	 * @param : nom du passagerStandard
	 * @param : int destination
	 */
	public PassagerStandard(String nom, int destination) {
		if (destination < 0) {
			throw new IllegalArgumentException("La destination doit être supérieure à 0");
		}
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
		if (destination < 0) {
			throw new IllegalArgumentException("La destination doit être supérieure à 0");
		}
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
	 * * La méthode effectue les vérifications suivantes :
	 * 1. Vérification que l'objet bus n'est pas nul avec
	 *    `NullPointerException` 
	 * 2. Vérification que le numéro de l'arrêt est valide (strictement positif).
	 *    Si le numéro de l'arrêt est inférieur ou égal à zéro, une exception
	 *    `IllegalArgumentException` est levée.
	 * 3. Vérification que l'arrêt n'a pas déjà été dépassé par rapport à la destination
	 *    du passager. Si l'arrêt actuel est supérieur à la destination, une exception
	 *    `IllegalStateException` est levée pour signaler que l'arrêt a été dépassé.
	 * 4. Si le numéro de l'arrêt correspond à la destination du passager, alors le passager
	 *    doit sortir du bus. Dans ce cas, une demande de sortie est envoyée au bus,
	 *    via la méthode `demanderSortie` de l'objet `Autobus`.
	 *   
	 */
	public void nouvelArret(Bus bus, int numeroArret) {
		if (bus == null) {
			throw new NullPointerException("Le bus ne peut pas être nul.");
		}
		if (numeroArret <= 0) {
			throw new IllegalArgumentException("Le numéro de l'arrêt doit être positif.");
		}
		if (destination < numeroArret) {
			throw new IllegalStateException("L'arrêt " + numeroArret + " a déjà été dépassé par rapport à la destination du passager (" + destination + ").");
		}

		

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
		// Vérification si le transport est bien un Autobus.
		if (!(t instanceof Autobus)) {

			throw new UsagerInvalideException("Le transport fourni n'est pas un autobus.");

		}
		
		//on caste un autobus qui va demander une place pour le passager qui veut entrer dans le bus.
		Autobus autobus = (Autobus) t;   
			try {
			//on demande premièrement s'il ya une place assise
			autobus.demanderPlaceAssise(this);

			//on demande deuxièrement s'il ya une place debout
			if (this.estDehors()) {
				autobus.demanderPlaceDebout(this);
			} 
		 } catch (Exception e) {
		        throw new IllegalStateException("l'état du passager est incohérent");
		 }

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

