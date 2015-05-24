package challenge;

public class CustomList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	//only getter no setter since size should be managed by CustomList
	public int getSize() {
		return size;
	}
	
	public void add(String s){
		if(size == 0){
			head =  new Node();
			head.setValue(s);
			tail = head;
			size = 1;
		} else {
			Node n  = new Node();
			n.setValue(s);
			tail.setNext(n);
			tail = n;
			size = size + 1;
		}
	}
	
	/*
	 * combine the list into this list. O(1) operation.
	 */
	public CustomList addList(CustomList l){
		
		if(l == null){
			return null;
		}
		
		int inputSize = l.getSize();
		
		if(head == null){
			head = l.getHead();
			tail = l.getTail();
			size = size + inputSize;
			return this;
		}
		
		//O(1)
		tail.setNext(l.getHead());
		tail = l.getTail();
		size = size + inputSize;
		return this;
		
	}
	
	/*
	 * print list. if size is 0 return 
	 */
	public void printList(int elements){
		if(elements <= 0 || size == 0){
			return ;
		}
		int count = 1;
		//size check is made in while loop and above so head is present. no need to check for null head
		Node n = head;
		while(true){
			System.out.println(n.getValue());
			n = n.getNext();
			if(count == elements || count == size){
				break;
			}
			count ++;
		}
		
	}
	
	
	

}
