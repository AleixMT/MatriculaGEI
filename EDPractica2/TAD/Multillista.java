package TAD;

import tipus.Alumne;
import tipus.Assignatura;
import tipus.Matricula;
import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;


/**
 * Classe per a crear la multillista
 * Aquesta classe crear� llistes din�miques per a alumnes i per a assignatures
 * @author Cristina Izquierdo i Aleix Marin�
 * @param <E>
 *
 */
public class Multillista<E> implements TADMultillista<E>{

	private TADLlistaGenerica<Assignatura> as;
	private TADLlistaGenerica<Alumne> a;

	public Multillista(TADLlistaGenerica<Assignatura> as, TADLlistaGenerica<Alumne> a)
	{
		this.a = a;
		this.as = as;
	}
	
	public boolean afegir(Matricula m) throws LlistaPlena {
		boolean trobat = false;
		
		
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
	public boolean afegir(Object e) throws LlistaPlena {
		// TODO Auto-generated method stub
		return false;
	}

}
