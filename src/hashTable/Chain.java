package hashTable;

public class Chain {
	public class Node{
		public int key;
		private Employee value;
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
		
	}
	
	Node first;
	Node last;
	int size = 0;
	public void addEmployee(Employee e) {
		Node n = new Node(e);
		if(this.size==0) {
			this.first = n;
			this.last = n;
			size++;
		}
		else {
			this.last.setNext(n);
			this.last = n;
			size++;
		}
	}
	public boolean contains(Employee e) {
		Node current = this.first;
		for(int i=0;i<size;i++) {
			if(current.value.getName()==e.getName())
				return true;
			current = current.next;
		}
		return false;
	}
	public boolean hasAccess(Employee e) {
		Node current = this.first;
		for(int i=0;i<size;i++) {
			if(current.value.getName()==e.getName()) {
				return e.isAllowed();
			}
			current = current.next;
		}
		return false;
	}

}
