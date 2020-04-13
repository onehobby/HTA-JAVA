package demo1.person;

public class Course<T> {

	private String name;
	private T t;
	
	public Course(String name) {
		this.name = name;
	}
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	public String getName() {
		return name;
	}
}
