
public class LQueue {
	
	private Node head;
	private Node tail;
	private int count;
	
        // method to remove an item from the queue
	public Customer remove() {
		if (isEmpty()) {
			return null;
		} else {
			Customer tmp = head.getData();
			if (count == 1) {
				// Now empty
				head = tail = null;
				count = 0;
			} else {
				head = head.getNext();
				count--;
			}
			return tmp;
		}
	}
	
        // method to add an item to the queue
	public boolean add(Customer data) {
		
		Node n = new Node();
		n.setData(data);
		n.setNext(null);
		
		if (count == 0) {
			head = tail = n;
			count = 1;
		} else {
			tail.setNext(n);
			tail = n;
			count++;
		}
		
		return true;
	}
	
        // method to check if queue is empty
	public boolean isEmpty() {
		return (count == 0);
	}
	
        // method to identify the size of the queue
	public int size() {
		return count;
	}
}
