package tipus;

import TAD.Node;
/**
 * Classe Alumne
 * @author Cristina Izquierdo
 *
 */
public class Alumne{
	private String codi;
	private String nom;
	private Node node;
	
	/**
	 * Mètode constructor per la classe alumne
	 * @param codi: codi de l'alumne
	 * @param nom: nom de l'alumne
	 */
	public Alumne(String codi, String nom) {
		this.nom = nom;
		this.codi = codi;
		this.node = null;
	}

	/**
	 * Getter del codi de l'alumne
	 * @return codi
	 */
	public String getCodi() {
		return codi;
	}

	/**
	 * Setter del codi de l'alumne
	 * @param codi: codi de l'alumne
	 */
	public void setCodi(String codi) {
		this.codi = codi;
	}
 
	/**
	 * Getter del nom de l'alumne
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter del nom de l'alumne
	 * @param nom: nom de l'alumne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Mètode per a comparar un alumne amb un altre mitjançant el seu nom
	 */
	public int compareTo(Alumne o) {
		return (this.nom.compareTo(o.nom));
	}

	/**
	 * Mètode toString de la classe Alumne
	 */
	@Override
	public String toString() {
		return "Alumne:\ncodi: " + codi + "\nnom: " + nom + "\n\n";
	}
	
	
}
