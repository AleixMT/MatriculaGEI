package tipus;


/**
 * Classe node relaci�
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public class Matricula {
	private Alumne a;
	private Assignatura as;
	private Matricula seguentH; //Horitzontal
	private Matricula seguentV; //Vertical
	
	public Matricula(Alumne a, Assignatura as, Matricula seguentH, Matricula seguentV) {
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
		return "Node [a=" + a + ", as=" + as + ", seguentH=" + seguentH + ", seguentV=" + seguentV + "]";
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
