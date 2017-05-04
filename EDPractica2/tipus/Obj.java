package tipus;

/**
 * Classe contenidora d'alumnes i assignatures
 * @author Aleix Marine i Cristina Izquierdo
 *
 * @param <T> tipus generic (Alumne/Assignatura)
 */
public class Obj <T extends Comparable<T>> implements Comparable<T> {
	private Matricula Node;
	private T obj;
	
	/**
	 * metode constructor
	 * @param obj - objecte
	 */
	public Obj(T obj) {
		Node = null;
		this.setObj(obj);
	}

	/**
	 * Getters i setters del node
	 * @return node
	 */
	public Matricula getNode() {
		return Node;
	}

	public void setNode(Matricula node) {
		Node = node;
	}

	/**
	 * Metode compareTo
	 * @return -1 si es mes petit, 1 si es mes gran i 0 si es igual
	 */
	public int compareTo(T o) {
		return this.obj.compareTo(o);
	}

	/**
	 * Getters i setters de l'objecte
	 * @return objecte
	 */
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}
