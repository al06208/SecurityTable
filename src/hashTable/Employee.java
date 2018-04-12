package hashTable;

public class Employee {
	private String name;
	private boolean allowed;
	
	public String getName() {
		return name;
	}
	public boolean isAllowed() {
		return allowed;
	}
	public int getKey() {
		int key = name.charAt(0);
		key-=65;
		return key;
	}
	public Employee(String name, boolean access) {
		this.name=name.toUpperCase();
		this.allowed=access;
	}
	
}
