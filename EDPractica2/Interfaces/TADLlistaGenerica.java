package Interfaces;

import tipus.Obj;
import TAD.Iterator;
import Exceptions.*;

/**
 * Interface per a definir una llista generica.
 * @author Cristina Izquierdo i Aleix Marine
 *
 */
public abstract interface TADLlistaGenerica<T extends Comparable<T>> {
	
	/**
	 * Afegeix un element a la llista
	 * @param a - element a afegir
	 * @throws LlistaPlena
	 */
	public boolean afegir(T a) throws LlistaPlena;
	
	/**
	 * Esborra un element de la llista
	 * @param e - element a esborrar
	 * @return element esborrat
	 * @throws LlistaBuida
	 */
	public T esborrar(T e) throws LlistaBuida;
	
	/**
	 * Consulta un element de la llista
	 * @param c - element a consultar
	 * @return element a consultar
	 * @throws LlistaBuida
	 */
	public Obj<T> consultar(T c);
	
	/**
	 * Getter del numero d'elements
	 * @return numero d'elements a la llista
	 * @throws LlistaBuida
	 */
	public int getNumElem();
	
	/**
	 * Crea un nou iterador per a la propia classe i ho retorna
	 * @return objecte iterable de la llista
	 */
	public Iterator<T> Iterator();
	
	/**
	 * metode toString
	 * @return String amb els elements de la llista
	 */	
	public String toString();
}
