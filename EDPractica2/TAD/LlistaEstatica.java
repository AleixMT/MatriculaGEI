package TAD;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;

public class LlistaEstatica<T extends Comparable<T>> implements TADLlistaGenerica<NodeEstatic<T>> {
	private NodeEstatic<T>[] llista;
	private int numElem;
	private int primer;
	
	private int[] buits;
	private int numElemsbuits;
	
	@SuppressWarnings("unchecked")
	public LlistaEstatica(int dim) {
		this.llista = (NodeEstatic<T>[]) new Comparable[dim];
		this.primer = -1;
		this.numElem = 0;
		
		this.buits = new int[dim];
		
		//Anem carregant les posicions buides. Desapilarem a la posicio numElemsBuits, de tal manera que les carregarem
		//a la inversa, tenint les posicions buides amb menor index en les posicions de major index en buits[]
		for (int i=buits.length; i>-1; i--)
		{
			this.buits[i] = i;
		}
		this.numElemsbuits=dim;
	}

	public boolean afegir(NodeEstatic<T> a) throws LlistaPlena {
		if (!this.esPlena())
		{
			int aux = this.primer;
			int preaux = -1;
			boolean trobat = false;
			int posicio;
			if (this.esBuida())
			{
				posicio = this.desapilarBuits();
				this.primer = posicio;
				this.llista[posicio] = a;
				this.numElem++;
			}
			else
			{
				while (aux!=-1 && !trobat)
				{
					int res = this.llista[aux].getObj().compareTo(a.getObj());
					if (res == 0 )
					{
						return false;
					}
					else if (res < 0) break;
					else
					{
						preaux = aux;
						aux = this.llista[aux].getRef();
					}
				}
			}
			posicio = this.desapilarBuits();
			this.llista[preaux].setRef(posicio);
			this.llista[posicio].setRef(aux);
			this.numElem++;
			return true;
		}
		else
		{
			throw new LlistaPlena();
		}
	}

	public NodeEstatic<T> esborrar(NodeEstatic<T> e) throws LlistaBuida {

		return null;
	}

	
	public int desapilarBuits(){
		this.numElemsbuits--;
		return this.buits[this.numElemsbuits];
	}
	
	public void apilarBuits(int n){
		this.buits[this.numElemsbuits]=n;
	}
	
	public boolean buitsEsPlena()
	{
		if (this.buits.length == this.numElemsbuits)
		{
			return true;
		}
		else return false;
	}
	
	public boolean buitsEsBuida()
	{
		if (this.numElemsbuits==0)
		{
			return true;
		}
		else return false;
	}
	
	public boolean esPlena()
	{
		return this.llista.length == this.numElem;
	}
	
	public boolean esBuida()
	{
		return this.numElem == 0;
	}
	
	public NodeEstatic<T>[] getLlista() {
		return llista;
	}

	public void setLlista(NodeEstatic<T>[] llista) {
		this.llista = llista;
	}

	public int getNumElem() {
		return numElem;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	public int getPrimer() {
		return primer;
	}

	public void setPrimer(int primer) {
		this.primer = primer;
	}

	public int[] getBuits() {
		return buits;
	}

	public void setBuits(int[] buits) {
		this.buits = buits;
	}

	public int getNumElemsbuits() {
		return numElemsbuits;
	}

	public void setNumElemsbuits(int numElemsbuits) {
		this.numElemsbuits = numElemsbuits;
	}

	public IteratorEstatic<T> Iterator()
	{
		return new IteratorEstatic<T>(this);
	}
	

	
	
}
