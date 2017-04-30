package TAD;
import tipus.Obj;
import tipus.ObjReferencia;
import Interfaces.*;
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
	
	/**
	 * Métode d'esborrat. No el farem servir així que no és necessari
	 */
	public T esborrar(T e) throws Exceptions.LlistaBuida {
		return null;
	}

	/**
	 * Busca un objecte T a la llista igual que el passat per parámetre i retorna l'objecte Obj wrapper de la llista 
	 */
	public Obj<T> consultar(T c) {
		ObjReferencia<T> aux = primer;
		while (aux!=null){
			if (aux.getObj().equals(c)) return (Obj<T>)aux;
			aux = aux.getRef();
		}
		return null;
	}
	
	/**
	 * Métode iterator. Retorna un objecte iterable d'aquesta classe
	 */
	public Iterator<T> Iterator()
	{
		return new Iterator<T>(this);
	}

	/** 
	 * getters i setters
	 */
	public ObjReferencia<T> getPrimer() { return primer;}
	public int getNumElem() { return this.numElem;}
	public void setPrimer(ObjReferencia<T> primer) {this.primer = primer;}
}
