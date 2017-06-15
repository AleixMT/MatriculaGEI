package tipus;
/**
 * Classe Assignatura.
 * @author Aleix Marine
 *
 */
public class Assignatura implements Comparable<Assignatura> {
	private Integer codi;
	private String nom;
	private Integer credits;
	private Integer curs;
	private Integer quadrimestre;
/**
 * Rep els parametres per a crear la nova Assignatura 
 * @param codi - codi assignatura
 * @param nom - nom assignatura
 * @param credits - n credits
 * @param curs - curs
 * @param quadrimestre - quadrimestre
 */
	public Assignatura(Integer codi, String nom, Integer credits, Integer curs, Integer quadrimestre) {
	this.codi = codi;
	this.nom = nom;
	this.credits = credits;
	this.curs = curs;
	this.quadrimestre = quadrimestre;
	
}


	/**
	 * Getter del codi
	 * @return codi assignatura
	 */
	public Integer getCodi() {
		return codi;
	}

	/**
	 * Setter del codi
	 * @param codi assignatura
	 */
	public void setCodi(Integer codi) {
		this.codi = codi;
	}

	/**
	 * Getter del nom
	 * @return nom assignatura
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter del nom
	 * @param nom assignatura
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter dels credits
	 * @return credits assignatura
	 */
	public Integer getCredits() {
		return credits;
	}

	/**
	 * Setter dels credits 
	 * @param credits assignatura
	 */
	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	/**
	 * Getter del curs
	 * @return curs
	 */
	public Integer getCurs() {
		return curs;
	}

	/**
	 * Setter del curs
	 * @param curs - curs 
	 */
	public void setCurs(Integer curs) {
		this.curs = curs;
	}

	/**
	 * Getter del quadrimestre
	 * @return quadrimestre
	 */
	public Integer getQuadrimestre() {
		return quadrimestre;
	}

	/**
	 * Setter del quadrimestre
	 * @param quadrimestre - quadrimestre
	 */
	public void setQuadrimestre(Integer quadrimestre) {
		this.quadrimestre = quadrimestre;
	}
	
	/**
	 * Metode toString de la classe
	 */
	public String toString() {
		return "\n\tAssignatura:\ncodi: " +codi + "\nnom: "+nom + "\ncredits: "+credits + "\ncurs: " + curs + "\nquadrimestre:" + quadrimestre + "\n";
	}
	
	/**
	 * Metode compareTo
	 * @param codi assignatura
	 * @return -1 - codi assignatura de la classe es mes petit que el passat per parametre
	 * @return 1 - codi assignatura de la classe es mes gran que el passat per parametre
	 * @return 0 - codi assignatura de la classe es igual al passat per parametre
	 */
	public int compareTo (int codi){
		if (this.codi < codi) return -1;
		if (this.codi > codi) return 1;
		return 0;
	}
	
	/**
	 * Metode compareTo d'assignatura
	 * Compara curs, quadrimestre i nom de l'assignatura.
	 * @param o - assignatura
	 * @return -1 si es mes petit, 1 si es mes gran, 0 si es igual.
	 */
	public int compareTo (Assignatura o){
		if (o.curs<this.curs) return 1;
		if (o.curs>this.curs) return -1;
		if (o.quadrimestre<this.quadrimestre) return 1;
		if (o.quadrimestre>this.quadrimestre) return -1;
		return (this.nom.compareTo(o.getNom()));
	}
	
	/**
	 * Metode per a clonar una assignatura
	 */
	public Assignatura clone(){
		return this;
	}
	
	/**
	 * Metode equals. Compara els codis de dues assignatures
	 * @param a - assignatura a comparar
	 * @return False - es diferent. True - es igual
	 */
	public boolean equals(Assignatura a){
		return (this.codi.compareTo(a.getCodi()) == 0);
	}
	
	
}
