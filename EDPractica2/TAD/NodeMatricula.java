package TAD;

import tipus.Matricula;

public class NodeMatricula {
	private Matricula m;
	private Matricula seguentH;
	private Matricula seguentV;
	
	public NodeMatricula(Matricula m, Matricula seguentH, Matricula seguentV)
	{
		this.m=m;
		this.seguentH=seguentH;
		this.seguentV=seguentV;
	}

	public Matricula getM() {
		return m;
	}

	public void setM(Matricula m) {
		this.m = m;
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
		return "NodeMatricula [m=" + m + ", seguentH=" + seguentH
				+ ", seguentV=" + seguentV + "]";
	}
	
	
}
