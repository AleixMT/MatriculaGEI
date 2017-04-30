package tipus;

public class ObjCursor <T extends Comparable<T>> extends Obj<T>{
	private int cursor;
	
	public ObjCursor (T obj, int cursor){
		super(obj);
		this.cursor = cursor;
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}
}
