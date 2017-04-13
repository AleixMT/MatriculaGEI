package TAD;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.TADMultillista;

/**
 * Classe per a crear la multillista amb llistes est�tiques
 * Aquesta classe crear� llistes din�miques per a alumnes i per a assignatures
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public class Multillista<T extends Comparable<T>> implements TADMultillista{

	private T[] llista;

	
	public Multillista(int elems)
	{
		this.llista = (T[])new Comparable[elems];
		this.numElem = 0;
		this.cim = -1;
		
		this.buits = new int[elems];
		for (int i=0; i<this.llista.length ; i++)
		{
			this.buits[i]= i;
		}
		this.numElembuits = elems;
	}
	public boolean afegir(T e) throws LlistaPlena {
		boolean trobat = false;
		int aux = cim;
		while (aux!= -1 && trobat == false)
		{
			if (this.llista[aux].compareTo(e) == 0 ) return false;
			if (this.llista[aux].compareTo(e) > 0)
			{
				this.llista[aux].
			}
		}
		return false;
	}

	@Override
	public Object esborrar(Object e) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultar(Object c) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

}
