package tipus;

public class ObjCursor <T extends Comparable<T>>{
	private T obj;
	private int cursor;
	
	public ObjCursor (T Obj, int cursor){
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
