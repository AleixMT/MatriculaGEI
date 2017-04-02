package TAD;

public class Canco implements Comparable<Canco> {
	private int codi;
	private String nom;
	private String autor;
	private String dataHora;
	
	public Canco(int codi, String nom, String autor, String data) {
		this.nom=nom;
		this.codi=codi;
		this.autor=autor;
		this.dataHora=data;
	}

	

	public int getCodi() {
		return codi;
	}



	public void setCodi(int codi) {
		this.codi = codi;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getDataHora() {
		return dataHora;
	}



	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}



	@Override
	public String toString() {
		return "Canco [codi=" + codi + ", nom=" + nom + ", autor=" + autor + ", dataHora=" + dataHora + "]";
	}



	@Override
	public int compareTo(Canco o) {
		return (this.autor.compareTo(o.autor));
	}
	
	
}
