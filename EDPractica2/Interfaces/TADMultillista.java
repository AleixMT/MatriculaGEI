package Interfaces;

import tipus.Matricula;
import Exceptions.*;

/**
 * Interficie del TAD Multillista
 * @author Cristina Izquierdo i Aleix Marine
 *
 */
public abstract interface TADMultillista {

	/**
	 * Afegeix una relacio
	 * @param e - element a afegir
	 * @throws LlistaPlena - llista plena
	 * @return true si s'ha afegit, false si no
	 */
	public boolean afegir(Matricula e) throws LlistaPlena;
	
	/**
	 * Esborra un element de la llista
	 * @param e - element a esborrar
	 * @return element esborrat
	 * @throws LlistaBuida - llista buida
	 */
	public Matricula esborrar(Matricula e) throws LlistaBuida;
	
	/**
	 * Consulta un element de la llista
	 * @param c - element a consultar
	 * @return element a consultar
	 * @throws LlistaBuida - llista buida
	 */
	public Matricula consultar(Matricula c)throws LlistaBuida;
	
}
