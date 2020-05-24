package newproject;

public class LinkedCompList<T extends Comparable<T>> implements CompList<T> {

	private Node headNode;
	private int numberOfEntries;
	private int currentEntryNo;
	private Node currentNode;
	public LinkedCompList(){
		numberOfEntries = 0;
		currentEntryNo=0;
		headNode=null;
	}
	public int length() {
		return numberOfEntries;
	};

	public boolean empty() {
		return numberOfEntries == 0;
	};

	public boolean full() {
		return false;
	};

	public void findFirst() {
		currentNode=headNode;
		currentEntryNo=1;
		
	}
	;

	public void findNext() {
		if(!empty() && currentNode != null ) {
			currentNode=currentNode.next;
			currentEntryNo++;
		}
	};

	public boolean last() {
		if(currentEntryNo==numberOfEntries) {
			return true;
		}
		else {
			return false;
		}

	};

	public void findPrevious() {
		if(!empty() && currentNode != null) {
			currentNode=currentNode.prev;
			currentEntryNo--;
		}
	};

	public boolean first() {
		if(currentEntryNo==1) {
			return true;
		}
		else {
			return false;
		}
	};

	public T retrieve() {
		if(!empty() && currentNode != null) {
			return currentNode.data;
		}
		else {
			return null;
		}
	};

	public void update(T e) {
		if(!empty()) {
			currentNode.data=e;
		}
	};

	public void insert(T e) {
		if(!full()) {
			if(empty()) {
				Node newNode =new Node(e);
				newNode.next=headNode;
				newNode.prev=null;
				headNode=newNode;
				currentNode=newNode;
				numberOfEntries++;
				currentEntryNo++;
			}
			else {
				Node newNode =new Node(e);
				newNode.next=currentNode.next;
				currentNode.next=newNode;
				newNode.prev=currentNode;
		        if (newNode.next != null) 
		        	newNode.next.prev = newNode; 
				currentNode=newNode;
				numberOfEntries++;
				currentEntryNo++;
			}
			

		}
	};

	public void remove() {
		if(!empty()) {
	        if (headNode == currentNode) { 
	        	headNode = currentNode.next; 
				currentEntryNo=0;
	        } 
	        if (currentNode.next != null) { 
	        	currentNode.next.prev = currentNode.prev; 
	        } 

	        if (currentNode.prev != null) { 
	        	currentNode.prev.next = currentNode.next; 
	        } 
	        numberOfEntries--;
	        currentNode=currentNode.prev;
		}
	};

	public int min(int i) {
		int j=-1;
		if(!empty() && i<numberOfEntries ) {
	        Node current = headNode; 
	        int count = 0;
	        while (count != numberOfEntries) 
	        { 
	            if (count == i){
	            	T min=current.data;
	            	int countInRange=i;
	            	j=i;
	            	while(countInRange != numberOfEntries) {
	            		if(min.compareTo(current.data)>0) {
	            			min=current.data;
	            			j=countInRange;
	            		}
	            		countInRange++;
	            		current = current.next; 
	            	}
	            	break;
	            }
	            count++; 
	            current = current.next; 
	        } 
			return j;

		}
        else {
		return -1;
		}
	};

	public int comp(int j) {
        Node current = headNode;
        T pointValue=null;
        int count = 0;
		if(!empty() && j<numberOfEntries ) {
	        while (count != numberOfEntries) 
	        { 
	        	if (count == j){
	        		pointValue=current.data;
	        		break;
	        	}
	            count++; 
	            current = current.next; 
	        } 
			 int res = currentNode.data.compareTo(pointValue);
			return res;
		}else {
			return 0;
		}
	};

	public void swap(int j) {
        Node current = headNode;
        int count = 0;
		if(!empty() && j<numberOfEntries ) {
	        while (count != numberOfEntries) 
	        { 
	        	if (count == j){
	        		T swapCurrent=current.data;
	        		current.data=currentNode.data;
	        		currentNode.data=swapCurrent;
	        		break;
	        	}
	            count++; 
	            current = current.next; 
	        }
		}
	};
	
	private class Node{
		private T data;
		private Node next;
		private Node prev; 
		 private Node(T dataPortion) {
			 this.data=dataPortion;
			 this.next=null;
			 this.prev=null;
		 }
	}

}
