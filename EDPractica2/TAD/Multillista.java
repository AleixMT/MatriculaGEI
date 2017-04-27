package TAD;

import tipus.Alumne;
import tipus.Assignatura;
import tipus.Matricula;
import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;


/**
 * Classe per a crear la multillista
 * Aquesta classe crear la multillista, que no será més que un "contenidor" per a dues llistes genériques
 * @author Cristina Izquierdo i Aleix Marin�
 * @param <E>
 *
 */
public class Multillista implements TADMultillista{

	private TADLlistaGenerica<Assignatura> as;
	private TADLlistaGenerica<Alumne> a;

	public Multillista(TADLlistaGenerica<Assignatura> as, TADLlistaGenerica<Alumne> a)
	{
		this.a = a;
		this.as = as;
	}
	
	/**
	 * R
	 * @param m
	 * @return
	 * @throws LlistaPlena
	 */
	public boolean afegir(Matricula m) throws LlistaPlena {
		Alumne alumne = m.getAlumne();
		Assignatura assignatura = m.getAssignatura();
		
		this.a.consultar(alumne);
		this.as.consultar(assignatura);

		return false;
	}
	
	public Assignatura[] sumariAlumne(String codi){
		Iterator<Alumne> aux = this.a.Iterator();	// Creem un iterador per a la llista d'alumnes
		int i = 0;	// iniciem l'index
		boolean trobat = false;	// boolea de trobat
		Alumne al = null;	// Inicialitzem una instancia de la classe alumne
		while (aux.hasNext() && !trobat) // iterem mentre no trobem l'element i hi hagi un element disponible
		{
			al = aux.next();	// assignem l'alumne a un element auxiliar
			if (al.compareTo(codi) == 0) trobat = true;	// si trobem que el compareTo retorna 0 (es el mateix) pugem la bandera
		}
		if (trobat == false) return null;	// Si el sortir del bucle ha sigut degut a acabar la llista vol dir que no existeix tal element, per tant retornem null i sortim
		/*
		 *  Iterarem sobre el nodes de matricula i els anem acumulant a una llista. 
		 *  Hem implementat alguns constructors extra a la classe iterator per a poder utilitzar-ho per a poder
		 *  reduir codi.
		 */
		Assignatura[] llista = new Assignatura[10000];	// Inicialitzem una llista d'Assignatures (sera el que retornem)
		Iterator<Assignatura> matr = new Iterator<Assignatura>(al);	// Creem un nou iterador parametritzat amb la classe assignatura
		while (matr.hasNext())	// mentre tingui més matricules penjant d'alumne
		{
			llista[i] = matr.next(); // Iterem i les acumulem a la llista
		}
		return llista;	// retornem la llista
	}
	
	public Matricula esborrar(Matricula e) throws LlistaBuida {
		return null;
	}

	public Matricula consultar(Matricula c) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Getters i setters per als atributs de la classe
	 */
	public TADLlistaGenerica<Assignatura> getAs() {
		return as;
	}

	public void setAs(TADLlistaGenerica<Assignatura> as1) {
		as = as1;
	}

	public TADLlistaGenerica<Alumne> getA() {
		return a;
	}

	public void setA(TADLlistaGenerica<Alumne> a) {
		this.a = a;
	}

	
	
	
}
