package Interfaces;

import tipus.Matricula;
import Exceptions.*;

/**
 * Interf�cie del TAD Multillista
 * @author Cristina Izquierdo i Aleix Marin�
 *
 */
public abstract interface TADMultillista {

	/**
	 * Afegeix una relaci�
	 * @param e - element a afegir
	 * @throws LlistaPlena
	 */
	public boolean afegir(Matricula e) throws LlistaPlena;
	
	/**
	 * Esborra un element de la llista
	 * @param e - element a esborrar
	 * @return element esborrat
	 * @throws LlistaBuida
	 */
	public Matricula esborrar(Matricula e) throws LlistaBuida;
	
	/**
	 * Consulta un element de la llista
	 * @param c - element a consultar
	 * @return element a consultar
	 * @throws LlistaBuida
	 */
	public Matricula consultar(Matricula c)throws LlistaBuida;
	
}
