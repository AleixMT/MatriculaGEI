package TAD;


import tipus.ObjCursor;
import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;

public class LlistaEstatica<T extends Comparable<T>> implements TADLlistaGenerica<T> {
	private ObjCursor<T>[] llista;
	private int numElem;
	private int primer;
	
	private int[] buits;
	private int numElemsbuits;
	
	@SuppressWarnings("unchecked")
	public LlistaEstatica(int dim) {
		this.llista = (ObjCursor[]) new Object[dim];
		this.primer = -1;
		this.numElem = 0;
		
		this.buits = new int[dim];
		
		//Anem carregant les posicions buides. Desapilarem a la posicio numElemsBuits, de tal manera que les carregarem
		//a la inversa, tenint les posicions buides amb menor index en les posicions de major index en buits[]
		for (int i=buits.length; i>-1; i--)
		{
			this.buits[i] = i;
		}
		this.numElemsbuits=dim;
	}

	public boolean afegir(T a) throws LlistaPlena {
		int posicio;
		int preaux = -1; // preaux fara referencia a l'element just anterior. Inicialitzem en -1 de manera arbitraria		
		int aux = this.primer;	// aux salvara la posicio del primer		
		if (!this.esPlena())	//Si no esta plena, afegim un element
		{
			if (this.esBuida()) //si la llista esta buida procedirem diferent
			{
				posicio = this.desapilarBuits();	// Treiem un enter de la llista de buits
				this.primer = posicio;				//Fem que el primer apunti a aquesta posicio (ja que sera la primera)
				this.llista[posicio] = new ObjCursor<T>(a, -1);		// En aquesta posicio creem un nou objecte ObjCursor, passantli l'objecte
				// rebut per parametre i com a referencia posarem -1, ja que sera l'ultim element
				this.numElem++; // modifiquem el nombre d'elements en consecuencia
				return true; // Com hem afegit, sortim
			}
			else
			{
				boolean trobat = false;	// flag d'objecte trobat
				while (aux!=-1 && !trobat)	// mentre aux (ultim element consultat) no sigui l'ultim element (no apunti a -1)
				// i no haguem trobat el objecte que correspon (per a l'ordre)
				{
					int res = this.llista[aux].getObj().compareTo(a);	// Comparem l'element rebut per parametre amb el de la posicio actual
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
						aux = this.llista[aux].getCursor();	// ara aux apunta a l'element seguent, aquest cursor 
						// l'obtenim preguntant-li el seu cursor a l'element al que apuntava aux abans d'actualitzar-se.
					}
				}
			}
			/**
			 * Ja hem trobat l'element. Hem de conectar les referencies de tal manera que: preaux -> a -> aux
			 */
			posicio = this.desapilarBuits();	// Obtenim la nova posicio on posarem el nou element
			this.llista[preaux].setCursor(posicio);	// Assignem el cursor, que apuntara a la nova posicio
			this.llista[posicio] = new ObjCursor<T>(a, aux);	// En la nova posicio buida creem un nou objecte. La referencia sera a aux llavors
			// Llavors el cicle esta tancat
			this.numElem++;	// incrementem el nombre d'elements
			return true;	// Sortim
		}
		else
		{
			throw new LlistaPlena();
		}
		
	}

	public T esborrar(T e) throws LlistaBuida {

		return null;
	}

	
	public int desapilarBuits(){
		this.numElemsbuits--;
		return this.buits[this.numElemsbuits];
	}
	
	public void apilarBuits(int n){
		this.buits[this.numElemsbuits]=n;
		this.numElemsbuits++;
	}
	
	public boolean buitsEsPlena()
	{
		if (this.buits.length == this.numElemsbuits)
		{
			return true;
		}
		else return false;
	}
	
	public boolean buitsEsBuida()
	{
		if (this.numElemsbuits==0)
		{
			return true;
		}
		else return false;
	}
	
	public boolean esPlena()
	{
		return this.llista.length == this.numElem;
	}
	
	public boolean esBuida()
	{
		return this.numElem == 0;
	}

	public Iterator<T> Iterator()
	{
		return new Iterator<T>(this);
	}

	public T consultar(T c) {
		int aux = this.primer;
		while (aux!=-1)
		{
			if (this.llista[aux].getObj().equals(c)) return this.llista[aux].getObj();
			else aux = llista[aux].getCursor();
		}
		return null;
	}

	public int getNumElem(){
		return this.numElem;
	}
	
}
