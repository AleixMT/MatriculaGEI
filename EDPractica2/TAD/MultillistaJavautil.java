package TAD;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.TADMultillista;

/**
 * Classe per a crear la multillista amb la llibreria de java.util.collection
 * @author Cristina Izquierdo i Aleix Mariné
 *
 */
public class MultillistaJavautil implements TADMultillista {

	@Override
	public boolean afegir(Object e) throws LlistaPlena {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object esborrar(Object e) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultar(Object c) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

}
