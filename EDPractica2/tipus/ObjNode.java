package tipus;

public class ObjNode <T extends Comparable<T>> extends Obj{
	private T obj;
	
	public ObjNode(T obj){
		super();
		this.obj = obj;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	
}
