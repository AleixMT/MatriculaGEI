package tipus;

public class Cadena {
private String valor;
	
	public Cadena(String valor) {
		this.valor=valor;
	}

	public int hashCode(){
		return valor.hashCode();
	}
	
	public String toString(){
		return valor;
	}
	
	@Override
	public boolean equals(Object e){
		return ((Cadena)e).getValor().equals(this.valor);
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
