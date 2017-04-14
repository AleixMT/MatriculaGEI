package tipus;


/**
 * Classe node relaci�
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public class Matricula implements Comparable<Matricula>{
	private Alumne a;
	private Assignatura as;
	
	public Matricula(Alumne a, Assignatura as) {
		this.a = a;
		this.as = as;
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

	@Override
	public String toString() {
		return "Node [a=" + a + ", as=" + as +"]";
	}

	public Matricula clone(){
		return this;
	}
	
	public boolean equals(Matricula e){
		return (this.a.equals(e.getAlumne()) && this.as.equals(e.getAssignatura()));
	}
	
	public int compareTo(Matricula e){
		if (this.a.compareTo(e.getAlumne()) < 0) return -1;
		if (this.a.compareTo(e.getAlumne()) > 0) return 1;
		if (this.as.compareTo(e.getAssignatura()) < 0) return -1;
		if (this.as.compareTo(e.getAssignatura()) > 0) return 1;
		return 0;

	}
}
