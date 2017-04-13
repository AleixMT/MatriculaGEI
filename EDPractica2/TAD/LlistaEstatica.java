package TAD;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;

public class LlistaEstatica<T extends Comparable<T>> implements TADLlistaGenerica<NodeEstatic<T>> {
	private NodeEstatic<T>[] llista;
	private int numElem;
	private int primer;
	
	private int[] buits;
	private int numElemsbuits;
	
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
		int aux = this.primer;
		boolean trobat = false;
		while (aux!=-1 && !trobat)
		{
			
			aux = this.llista[aux].getRef();
		}
		return false;
	}

	public NodeEstatic<T> esborrar(NodeEstatic<T> e) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeEstatic<T> consultar(NodeEstatic<T> c) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumElem() throws LlistaBuida {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(NodeEstatic<T> c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean equals() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public NodeEstatic<T> next() {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
}
