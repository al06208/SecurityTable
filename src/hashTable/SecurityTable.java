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
		//make a fake employee so we can more easily compare
		return table[e.getKey()].hasAccess(e);
	}
	public boolean contains(String name) {
		Employee e = new Employee(name, false);
		//make a fake employee so we can more easily compare
		return table[e.getKey()].contains(e);
	}
	//super heurgh
	public void initialize(LinkedList<Employee> l) {
		//generated with the linkedlist from the security interface
		table = new Chain[26];
		for(int q=0;q<26;q++) {
			table[q] = new Chain();
		}
		//just really make sure the table is clean when you initialize. Rally.
		while (l.size()>0) {
			this.addEmployee(l.pop()); //pop an element and hash it
		}
	}
	
	
}
