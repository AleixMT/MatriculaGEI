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
 * @param codi
 * @param nom
 * @param credits
 * @param curs
 * @param quadrimestre
 */
	public Assignatura(Integer codi, String nom, Integer credits, Integer curs, Integer quadrimestre) {
	this.codi = codi;
	this.nom = nom;
	this.credits = credits;
	this.curs = curs;
	this.quadrimestre = quadrimestre;
	
}

	public Integer getCodi() {
		return codi;
	}

	public void setCodi(Integer codi) {
		this.codi = codi;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Integer getCurs() {
		return curs;
	}

	public void setCurs(Integer curs) {
		this.curs = curs;
	}

	public Integer getQuadrimestre() {
		return quadrimestre;
	}

	public void setQuadrimestre(Integer quadrimestre) {
		this.quadrimestre = quadrimestre;
	}

	public String toString() {
		return codi + nom + credits + " credits"+ ", curs " + curs + ", " + quadrimestre +" quadrimestre"
				+ "]";
	}
	
	public int compareTo (Assignatura o){
		if (o.curs<this.curs) return -1;
		if (o.curs>this.curs) return 1;
		if (o.quadrimestre<this.quadrimestre) return -1;
		if (o.quadrimestre>this.quadrimestre) return -1;
		return (o.nom.compareTo(this.nom));
	}
	
	public Assignatura clone(){
		return this;
	}
	
	public boolean equals(Assignatura a){
		return (this.codi==a.getCodi() && this.credits == a.getCredits() && this.curs == a.getCurs() && this.nom.equals(a.getNom()) && this.quadrimestre == a.getQuadrimestre());
	}
	
	
}
