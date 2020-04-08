package exam;

public class Rectangle {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle() {}
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int square() {
		int result = 0;
		result = width * height;
		return result;
	}
	
	public void show() {
		System.out.println("x좌표: " + x + " y좌표: " + y +" 넓이 :" +  square());
	}
	
	boolean contains(Rectangle r) {
		boolean result = false;
		if(x<r.x && y<r.y) {
			System.out.println(r + "을 포함하지 않습니다.");
			if(width > r.width && height > r.height) {
				System.out.println(r + "을 포함합니다.");
				return true;
			} 
		}
		return result;
	}
	
}
