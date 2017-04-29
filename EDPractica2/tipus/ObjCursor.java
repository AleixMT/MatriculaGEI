package tipus;

public class ObjCursor <T extends Comparable<T>> extends Obj{
	private T obj;
	private int cursor;
	
	public ObjCursor (T Obj, int cursor){
		super();
		this.obj = Obj;
		this.cursor = cursor;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}
}
