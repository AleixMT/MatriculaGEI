package TAD;
import java.util.ArrayList;

import tipus.ObjNode;
import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;

/**
 * 
 * @author amt
 *
 * @param <T>
 * @param <E>
 */
public class LlistaJavaUtil<T extends Comparable<T>, E> implements TADLlistaGenerica<T,E> {
	private ArrayList<E> llista;
	
	/**
	 * Métode afegir, wrapper del métode add(Object)/add(Object, innt (index)
	 * Funciona igual que els altres però en aquest cas la major part de la informació es controlada per l'arrayList.
	 * Nosaltres només hem de controlar que l'ordre en afegir sigui l'adequat.
	 */
	@SuppressWarnings("unchecked")
	public boolean afegir(T a) throws LlistaPlena {
		if (llista.size() == 0){	//Si la llista esta buida
			this.llista.add((E)(new ObjNode<T>(a)));	// afegim pel final 
			return true;	// i retornem true
		}
		else	//Si la llista ja té algun element
		{
			for (int i = 0; i< this.llista.size(); i++)	// iterem sobre la llista fins a numElems-1
			{
				int res = ((ObjNode<T>)this.llista.get(i)).getObj().compareTo(a);	// Comparem l'objecte actual al rebut per parametre i emmagatzemem resultat
				if (res == 0) return false;	// Si l'objecte es igual a un que ja hi ha a la llista sortim i n l'afegim, retornant false
				if (res > 0)	// Si l'objecte es major vol dir que aquest va just després
				{
					this.llista.add(i, (E)new ObjNode<T>(a));	//Afegim en la posicio. L'array List sencarregara de moure tots els elements
					return true;	// retornem cert
				}
			}
		}
		this.llista.add((E)new ObjNode<T>(a));	// Si hem arribat aquí vol dir que hem arribat al final de la llista, però o hi havia cap objecte igual.
		// per tant afegim pel final
		return true;	// retornem cert
	}
	
	/**
	 * Métode per a borrar un element, alhora que es retornat
	 */
	public T esborrar(T e) throws LlistaBuida {
		return null;
	}

	public E consultar(T c) {
		return null;
	}

	public int getNumElem() {
		return this.llista.size();
	}

	public Iterator<T,E> Iterator() {
		return new Iterator<T,E>(this);
	}
	

	
	
}
