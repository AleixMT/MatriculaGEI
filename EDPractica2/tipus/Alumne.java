package tipus;

/**
 * Classe Alumne
 * @author Cristina Izquierdo
 *
 */
public class Alumne implements Comparable<Alumne>{
	private String codi;
	private String nom;
	/**
	 * M�tode constructor per la classe alumne
	 * @param codi: codi de l'alumne
	 * @param nom: nom de l'alumne
	 */
	public Alumne(String codi, String nom) {
		this.nom = nom;
		this.codi = codi;
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
	 * M�tode per a comparar un alumne amb un altre mitjan�ant el seu nom a partir de una instancia d'alumne 
	 */
	public int compareTo(Alumne o) {
		return (this.nom.compareTo(o.nom));
	}
	
	/**
	 * M�tode per a comparar un alumne amb un altre mitjancant el codi d'alumne aportat per un string
	 */
	public int compareTo(String codi) {
		return (this.codi.compareTo(codi));
	}
	
	/**
	 * M�tode toString de la classe Alumne
	 */
	@Override
	public String toString() {
		return "Alumne:\ncodi: " + codi + "\nnom: " + nom + "\n\n";
	}
	
	public Alumne clone(){
		return this;
	}
	
	public boolean equals(Alumne a){
		return (this.nom == a.getNom() && this.codi == a.getCodi());
	}
	 
}
