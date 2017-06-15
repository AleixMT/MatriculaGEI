package tipus;


/**
 * Classe node relacio
 * @author Cristina Izquierdo i Aleix Marine
 *
 */
public class Matricula implements Comparable<Matricula>{
	private Alumne alumne;
	private Assignatura assignatura;
	
	private Matricula seguentH;
	private Matricula seguentV;
	
	/**
	 * Metode constructor
	 * @param a - alumne
	 * @param as - assignatura
	 * @param seguentH - seguent horitzontal
	 * @param seguentV - seguent vertical
	 */
	public Matricula(Alumne a, Assignatura as, Matricula seguentH, Matricula seguentV) {
		this.alumne = a;
		this.assignatura = as;
		this.seguentH=seguentH;
		this.seguentV=seguentV;
	}

	/**
	 * Getter de l'alumne
	 * @return alumne
	 */
	public Alumne getAlumne() {
		return alumne;
	}

	/**
	 * Setter de l'alumne
	 * @param a - alumne
	 */
	public void setAlumne(Alumne a) {
		this.alumne = a;
	}

	/**
	 * Getter de l'assignatura
	 * @return assignatura
	 */
	public Assignatura getAssignatura() {
		return assignatura;
	}
	
	public Assignatura getAs() {
		return assignatura;
	}

	/**
	 * Setter de l'assignatura
	 * @param as - assignatura
	 */
	public void setAssignatura(Assignatura as) {
		this.assignatura = as;
	}

	/**
	 * Getter del seguent horitzontal
	 * @return seguent horitzontal
	 */
	public Matricula getSeguentH() {
		return seguentH;
	}

	/**
	 * Setter del seguent horitzontal
	 * @param seguentH - seguent horitzontal
	 */
	public void setSeguentH(Matricula seguentH) {
		this.seguentH = seguentH;
	}

	/**
	 * Getter del seguent vertical
	 * @return seguent vertical
	 */
	public Matricula getSeguentV() {
		return seguentV;
	}

	/**
	 * Setter del seguent vertical
	 * @param seguentV - seguent vertical
	 */
	public void setSeguentV(Matricula seguentV) {
		this.seguentV = seguentV;
	}

	/**
	 * Metode toString
	 */
	public String toString() {
		return "\n\tNode:\nAlumne: " + alumne + "\nAssignatura: " + assignatura;
	}

	/**
	 * Metode per a clonar la matricula
	 */
	public Matricula clone(){
		return this;
	}
	
	/**
	 * Metode equals. Compara l'alumne i l'assignatura associats a la matricula
	 * @param e - matricula
	 * @return False - son diferents. True - son iguals
	 */
	public boolean equals(Matricula e){
		return (this.alumne.equals(e.getAlumne()) && this.assignatura.equals(e.getAssignatura()));
	}
	
	/**
	 * Metode compareTo. Compara l'alumne i l'assignatura associats a la matricula
	 * @param e - matricula
	 * @return -1 si es troba abans, 1 si es troba despres i 0 si es igual.
	 */
	public int compareTo(Matricula e){
		if (this.alumne.compareTo(e.getAlumne()) < 0) return -1;
		if (this.alumne.compareTo(e.getAlumne()) > 0) return 1;
		if (this.assignatura.compareTo(e.getAssignatura()) < 0) return -1;
		if (this.assignatura.compareTo(e.getAssignatura()) > 0) return 1;
		return 0;

	}
}
