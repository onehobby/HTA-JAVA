package exam;

public class Tv {

	private String brand;
	private int year;
	private int inch;
	
	Tv() {}
	
	Tv(String brand, int year, int inch) {
		this.brand = brand;
		this.year = year;
		this.inch = inch;
	}
	
	public void show() {
		System.out.println(brand+"에서만든 "+year+"년형 "+inch+"인치TV");
	}
	
}
