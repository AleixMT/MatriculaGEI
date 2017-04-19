package TAD;

import java.util.Arrays;
import java.util.Iterator;

import tipus.ObjReferencia;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.TADLlistaGenerica;
/**
 * Classe per a crear les llistes dinamiques
 * @author Cristina Izquierdo i Aleix Marine
 *
 * @param <T>
 */
public class LlistaDinamica<T extends Comparable<T>> implements TADLlistaGenerica<T> {
	private ObjReferencia<T> primer;
	private int numElem;
	
	public LlistaDinamica() {
		this.primer = null;
		numElem = 0;
	}

	
	public boolean afegir(T a) {
		if (this.primer==null) 	//si el primer encara no s'ha inicilitzat vol dir que estem al principi, llavors sera igual al ultim
		{
			this.primer=new ObjReferencia<T>(a, null); 	
		}
		else
		{
			ObjReferencia<T> aux = primer;
			ObjReferencia<T> preaux = null;
			boolean trobat = false;
			while (aux!= null && !trobat)
			{
				int res = aux.getObj().compareTo(a);	// Comparem l'element rebut per parametre amb el de la posicio actual
				if (res == 0 )	// Si retorna 0 vol dir que es el mateix element
				{
					return false; //per tant sortim i retornem fals perque no hem d'afegir res
				}
				else if (res > 0) break;	//si retorna major que 0 vol dir que l'element al que apunta aux va alfabeticament
				// despres de l'objecte rebut per parametre, per tant sortim del bucle.
				else	// si el resultat de res es menor de -1, vol dir que l'objecte al que apunta aux va abans que l'objecte que
				// passem per parametre, per tant actualitzem els cursors d'iteracio
				{
					preaux = aux;	//ara preaux apunta al seguent (aux)
					aux = aux.getRef();	// ara aux apunta a l'element seguent, obtingut amb la referencia 
				}
			}
			preaux.setRef(new ObjReferencia<T>(a, aux)); // Creem el nou objecte i fem que aux sigui el seguent i preaux sigui el que precedeix
		}
		numElem++;	// Part constant, afegim un element
		return true; //sempre s'afegira, mai sera plena
	}

	public T esborrar(T e) throws LlistaBuida {
		if (numElem == 0)
		{
			throw new LlistaBuida(); //comprovem que la llista no estigui buida
		}
		else
		{
			T aux = (T) e.getObj(); //agafem el valor del objecte que esborrem
			//esborrar node
			numElem--;
			return (NodeDinamic<T>) aux; //retornem el que hem esborrat
		}
	}

	public int getNumElem() throws LlistaBuida {
		return numElem;
	}


	public NodeDinamic getUltim() {
		return ultim;
	}


	public void setUltim(NodeDinamic ultim) {
		this.ultim = ultim;
	}


	public NodeDinamic getPrimer() {
		return primer;
	}


	public void setPrimer(NodeDinamic primer) {
		this.primer = primer;
	}


	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}


	@Override
	public String toString() {
		return "LlistaDinamica [ultim=" + ultim + ", primer=" + primer + ", numElem=" + numElem + "]";
	}
	
	
	
}
