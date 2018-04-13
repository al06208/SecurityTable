package hashTable;

public class Chain {

	//Subclasses, because we need to be classier.
	public class Node{
		//I called it a node because I'm very original.
		public int key; //a place to store the key
		private Employee value; //a place to store the everything
		private Node next = null;
		public Employee getValue() {
			return this.value;
		}
		public Node(Employee e) {
			this.value = e;
			this.key = e.getKey();
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node n) {
			this.next = n;
		}
		//mostly self-explanatory singly-linked-list-esque stuff
	}
	
	Node first;
	Node last; //since this is a seperate chain off of a hashtable, I keep track of
	//first and last node, in insertion order
	int size = 0;
	public void addEmployee(Employee e) {
		Node n = new Node(e);
		if(this.size==0) {
			//if empty, add the first node
			this.first = n;
			this.last = n;
			size++;
		}
		else {
			//otherwise, add the last node
			this.last.setNext(n);
			this.last = n;
			size++;
		}
	}
	//checking if something is in the system
	public boolean contains(Employee e) {
		//passed an entire Employee object
		Node current = this.first;
		//start at the first node
		for(int i=0;i<size;i++) {
			//iterate through tthe chain
			if(current.value.getName().equals(e.getName()))
				return true; //if the name is found, return true
			current = current.next;
			//otherwise, keep going
		}
		return false; //if you're here, it's not there
	}
	
	public boolean hasAccess(Employee e) { //very similar to contains, but
		Node current = this.first;
		for(int i=0;i<size;i++) {
			if(current.value.getName().equals(e.getName())) {
				return current.value.isAllowed(); //after finding the name, we return access status
				//rather than just its existence
			}
			current = current.next;
		}
		return false;
	}

}
