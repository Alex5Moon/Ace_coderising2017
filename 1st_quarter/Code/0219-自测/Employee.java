public class Employee {
	private String id;
	private String name;
	private int age;
	private Employee(){
	}
	public Employee(String name, int age) {
		this.id = "1001";
		this.name = name;
		this.age = age;
	}
	private String getID(){
		return this.id;
	}
	public void sayHello(){
		System.out.println("Hello, name ="+ name + " age = "+age);
	}
}
