package TAD;

import java.util.Arrays;
import java.util.Iterator;

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
	private T primer;
	private int numElem;
	
	public LlistaDinamica() {
		this.ultim = null;
		this.primer = null;
		numElem = 0;
	}

	
	public boolean afegir(T a) {
		if (this.primer==null) 	//si el primer encara no s'ha inicilitzat vol dir que estem al principi, llavors sera igual al ultim
		{
			this.primer=a; 	
		}
		else
		{
			
		}
		numElem++;
		return true; //sempre s'afegira, mai sera plena
	}

	public NodeDinamic<T> esborrar(NodeDinamic<T> e) throws LlistaBuida {
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
