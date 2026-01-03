package jaugeNaturel;


/**
 *L'interface IJauge est une référence de type qui est utilisée 
 *pour spécifier toutes les méthodes qu'une classe de Jauge doit 
 *implémenter doit implémenter permettant ainsi à toutes 
 *les jauges de partager leur comportements communs.
 */
public interface IJauge {
	/**
	 * 
	 * @return vrai si la jauge est rouge
	 * @return faux sinon
	 */
	public boolean estRouge();
	/**
	 * 
	 * @return vrai si la jauge est verte 
	 * @return faux sinon

	 */
	public boolean estVert();
	/**
	 * 
	 * @return vrai si la jauge est bleue
	 * @return faux sinon
	 */
	public boolean estBleu();
	/**
	 * augmente de 1 la valeur de départ pour JaugeNaturel et JaugeNegatif
	 * 
	 * augmente de 0.001 la valeur de départ pour JaugeReel
	 * 
	 * déplace la postion courante de 1 de la gauche(des valeurs negatives) vers la droite(les valeurs positives)
	 */
	public void incrementer();
	/**
	 * diminue de 1 la valeur de départ pour JaugeNaturel et JaugeNegatif
	 * 
	 * diminue de 0.001 la valeur de départ pour JaugeReel
	 * 
	 * déplace la postion courante de 1 de la gauche(des valeurs positives) vers la droite(les valeurs négatives)
	 */
	public void decrementer();
	

}
