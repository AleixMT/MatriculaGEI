package TAD;

import tipus.Alumne;
import tipus.Assignatura;

/**
 * Classe node relació
 * @author Cristina Izquierdo i Aleix Mariné
 *
 */
public class Node {
	private Alumne a;
	private Assignatura as;
	private Node seguentH; //Horitzontal
	private Node seguentV; //Vertical
	
	public Node(Alumne a, Assignatura as, Node seguentH, Node seguentV) {
		super();
		this.a = a;
		this.as = as;
		this.seguentH = seguentH;
		this.seguentV = seguentV;
	}

	public Alumne getAlumne() {
		return a;
	}

	public void setAlumne(Alumne a) {
		this.a = a;
	}

	public Assignatura getAssignatura() {
		return as;
	}

	public void setAssignatura(Assignatura as) {
		this.as = as;
	}

	public Node getSeguentH() {
		return seguentH;
	}

	public void setSeguentH(Node seguentH) {
		this.seguentH = seguentH;
	}

	public Node getSeguentV() {
		return seguentV;
	}

	public void setSeguentV(Node seguentV) {
		this.seguentV = seguentV;
	}

	@Override
	public String toString() {
		return "Node [a=" + a + ", as=" + as + ", seguentH=" + seguentH + ", seguentV=" + seguentV + "]";
	}


	public boolean equals(Node e){
		return (this.a.equals(e.getAlumne()) && this.as.equals(e.getAssignatura()));
	}
	
}
