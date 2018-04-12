package hashTable;

import java.util.LinkedList;

public class SecurityTable {
	Chain[] table;
	public void addEmployee(Employee e) {
		int key = e.getKey();
		table[key].addEmployee(e);
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
		for(int q=0;q<26;q++) {
			table[q] = new Chain();
		}
		while (l.size()>0) {
			this.addEmployee(l.pop());
		}
	}
	
	
}
