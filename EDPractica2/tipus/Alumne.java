package tipus;

/**
 * Classe Alumne
 * @author Cristina Izquierdo
 *
 */
public class Alumne implements Comparable<Alumne>{
	private String codi;
	private String nom;
	
	private Matricula ref;
	private Alumne seguent;
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
	
	public Matricula getRef() {
		return ref;
	}


	public void setRef(Matricula ref) {
		this.ref = ref;
	}
	
	

	public Alumne getSeguent() {
		return seguent;
	}


	public void setSeguent(Alumne seguent) {
		this.seguent = seguent;
	}


	/**
	 * M�tode per a comparar un alumne amb un altre mitjan�ant el seu nom
	 */
	public int compareTo(Alumne o) {
		return (this.nom.compareTo(o.nom));
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
