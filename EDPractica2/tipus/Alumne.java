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
	 * Metode constructor per la classe alumne
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
	 * Metode per a comparar un alumne amb un altre a partir el seu nom a partir de una instancia d'alumne 
	 */
	public int compareTo(Alumne o) {
		int res = this.nom.compareTo(o.nom);
		if (res != 0) return res;
		return this.codi.compareTo(o.codi);
	}
	
	/**
	 * Metode per a comparar un alumne amb un altre a partir el codi d'alumne aportat per un string
	 * @param codi per a comparar
	 * @return negatiu si l'objecte va abans que l'argument, positiu si es al reves i 0 si son iguals
	 */
	public int compareTo(String codi) {
		return this.codi.compareTo(codi);
	}
	
	/**
	 * Metode toString de la classe Alumne
	 */
	@Override
	public String toString() {
		return "\n\tAlumne:\ncodi: " + codi + "\nnom: " + nom + "\n\n";
	}
	
	public Alumne clone(){
		return this;
	}
	
	public boolean equals(Alumne a){
		return (this.nom.equals(a.getNom()) && this.codi.equals(a.getCodi()));
	}
	 
}
