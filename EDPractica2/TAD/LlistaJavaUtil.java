package TAD;
import java.util.ArrayList;

import tipus.Obj;
import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;

/**
 * Classe per a crear les llistes amb la coleccio java.util
 * @author Aleix Marine i Cristina Izquierdo
 *
 * @param <T> tipus generic
 */
public class LlistaJavaUtil<T extends Comparable<T>> implements TADLlistaGenerica<T> {
	private ArrayList<Obj<T>> llista;
	
	/**
	 * Metode afegir, wrapper del metode add(Object)/add(Object, int (index)
	 * Funciona igual que els altres pero en aquest cas la major part de la informacio es controlada per l'arrayList.
	 * Nosaltres nomes hem de controlar que l'ordre en afegir sigui l'adequat.
	 */
	
	public LlistaJavaUtil(){
		this.llista = new ArrayList<Obj<T>>();
	}
	public boolean afegir(T a) throws LlistaPlena {
		if (llista.size() == 0){	//Si la llista esta buida
			this.llista.add(new Obj<T>(a));	// afegim pel final 
			return true;	// i retornem true
		}
		else	//Si la llista ja te algun element
		{
			for (int i = 0; i< this.llista.size(); i++)	// iterem sobre la llista fins a numElems-1
			{
				int res = ((Obj<T>)this.llista.get(i)).getObj().compareTo(a);	// Comparem l'objecte actual al rebut per parametre i emmagatzemem resultat
				if (res == 0) return false;	// Si l'objecte es igual a un que ja hi ha a la llista sortim i n l'afegim, retornant false
				if (res > 0)	// Si l'objecte es major vol dir que aquest va just despres
				{
					this.llista.add(i, new Obj<T>(a));	//Afegim en la posicio. L'array List sencarregara de moure tots els elements
					return true;	// retornem cert
				}
			}
		}
		this.llista.add(new Obj<T>(a));	// Si hem arribat aqui vol dir que hem arribat al final de la llista, pero o hi havia cap objecte igual.
		// per tant afegim pel final
		return true;	// retornem cert
	}
	
	/**
	 * Metode per a borrar un element, alhora que es retornat. Tampoc el necessitem per al problema que ens demanen
	 */
	public T esborrar(T e) throws LlistaBuida {
		return null;
	}

	/**
	 * metode consultar
	 */
	public Obj<T> consultar(T c) {
		return null;
	}

	/**
	 * getter del numero d'elements de la llista
	 * @return numero d'elements
	 */
	public int getNumElem() {
		return this.llista.size();
	}

	/**
	 * metode iterator del java.util
	 */
	public Iterator<T> Iterator() {
		return new Iterator<T>(this);
	}
	
	/**
	 * getter de la llista
	 * @return llista
	 */
	public ArrayList<Obj<T>> getLlista() {
		return llista;
	}
	
	/**
	 * metode toString
	 */
	public String toString(){
		String retorn = "";
		for (int i = 0; i < this.getNumElem(); i++)
		{
			retorn += this.llista.get(i).getObj().toString();
		}
		retorn += "\n" + this.llista.size() + " elements.";
		return retorn;
	}
}
