package hashTable;

import java.util.LinkedList;

public class SecurityTable {
	Chain[] table = new Chain[26];
	public void addEmployee(Employee e) {
		table[e.getKey()].addEmployee(e);
	}
	public boolean hasAccess(String name) {
		Employee e = new Employee(name,false);
		return table[e.getKey()].hasAccess(e);
	}
	public boolean contains(String name) {
		Employee e = new Employee(name, false);
		return table[e.getKey()].contains(e);
	}
	public void initialize(LinkedList<Employee> l) {
		table = new Chain[26];
		while (l.size()>0) {
			this.addEmployee(l.pop());
		}
	}
	
	
}
