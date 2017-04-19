package tipus;


/**
 * Classe node relaci�
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public class Matricula implements Comparable<Matricula>{
	private Alumne alumne;
	private Assignatura assignatura;
	
	private Matricula seguentH;
	private Matricula seguentV;
	
	public Matricula(Alumne a, Assignatura as, Matricula seguentH, Matricula seguentV) {
		this.alumne = a;
		this.assignatura = as;
		this.seguentH=seguentH;
		this.seguentV=seguentV;
	}

	public Alumne getAlumne() {
		return alumne;
	}

	public void setAlumne(Alumne a) {
		this.alumne = a;
	}

	public Assignatura getAssignatura() {
		return assignatura;
	}

	public void setAssignatura(Assignatura as) {
		this.assignatura = as;
	}

	public Alumne getA() {
		return alumne;
	}

	public void setA(Alumne a) {
		this.alumne = a;
	}

	public Assignatura getAs() {
		return assignatura;
	}

	public void setAs(Assignatura as1) {
		assignatura = as1;
	}

	public Matricula getSeguentH() {
		return seguentH;
	}

	public void setSeguentH(Matricula seguentH) {
		this.seguentH = seguentH;
	}

	public Matricula getSeguentV() {
		return seguentV;
	}

	public void setSeguentV(Matricula seguentV) {
		this.seguentV = seguentV;
	}

	@Override
	public String toString() {
		return "Node [a=" + alumne + ", as=" + assignatura +"]";
	}

	public Matricula clone(){
		return this;
	}
	
	public boolean equals(Matricula e){
		return (this.alumne.equals(e.getAlumne()) && this.assignatura.equals(e.getAssignatura()));
	}
	
	public int compareTo(Matricula e){
		if (this.alumne.compareTo(e.getAlumne()) < 0) return -1;
		if (this.alumne.compareTo(e.getAlumne()) > 0) return 1;
		if (this.assignatura.compareTo(e.getAssignatura()) < 0) return -1;
		if (this.assignatura.compareTo(e.getAssignatura()) > 0) return 1;
		return 0;

	}
}
