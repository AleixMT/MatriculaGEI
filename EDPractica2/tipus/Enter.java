package tipus;

public class Enter {
	
	private int valor;
	
	public Enter(int valor) {
		this.valor=valor;
	}

	public int hashCode(){
		/* opcio 1 
		 * return valor;
		 */
		
		/* opcio 3
		 * agafar els dígits del centre
		 */
		
		String numCadena=String.valueOf(valor);
		int longitud=numCadena.length();
		int meitat=longitud/2;
		int resultat=0;
		
		if ((meitat-1)>=0) resultat=resultat+Integer.parseInt(numCadena.charAt(meitat-1)+"");
		resultat=resultat*10+Integer.parseInt(numCadena.charAt(meitat)+"");
		if ((meitat+1)<longitud) resultat=resultat*10+Integer.parseInt(numCadena.charAt(meitat+1)+"");
		
		//System.out.println(valor + " resultat "+ resultat);
		
		return resultat;
		/*
		int producte=valor*valor;
		if (producte<0) producte=producte*(-1);
		*/
		
		
	}
	
	public String toString(){
		return valor+"";
	}
	
	public boolean equals(Object e){
		return ((Enter)e).getValor()==this.valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
