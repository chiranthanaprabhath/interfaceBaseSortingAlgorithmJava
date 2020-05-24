package newproject;

public class ArrayCompList<T extends Comparable<T>> implements CompList<T> {
	
	private final T[] arrayItem;
	private T currentElement;
	private int numberOfItem;
	private int currentElementIndex;
	private static final int default_Capacity=15;
	@SuppressWarnings("unchecked")
	public ArrayCompList() {
		numberOfItem=0;
		currentElementIndex=0;
		T[] temArrayItem =(T[]) new Comparable[default_Capacity];
		arrayItem = temArrayItem;
	}
	public ArrayCompList(int capacity) {
		numberOfItem=0;
		currentElementIndex=0;
		@SuppressWarnings("unchecked")
		T[] temArrayItem =(T[]) new Comparable[capacity];
		arrayItem = temArrayItem;
	}
	public int length() {
		return numberOfItem;
		
	};

	public boolean empty() {
		if(numberOfItem==0) {
			return true;
		}
		else {
			return false;
		}
		
	};

	public boolean full() {
		if(arrayItem.length == numberOfItem) {
			return true;
		}
		else {
			return false;
		}
		
	};

	public void findFirst() {
		if(!empty()) {
			currentElement=arrayItem[0];
			currentElementIndex=0;
		}
	};

	public void findNext() {
		if(!empty() && !(currentElementIndex == numberOfItem-1)) {
			currentElement=arrayItem[currentElementIndex+1];
			currentElementIndex++;
		}
		
	};

	public boolean last() {
		if(!empty() && (currentElementIndex == numberOfItem-1)) {
			return true;
		}
		else {
			return false;
		}
	};

	public void findPrevious() {
		if(!empty() && !(currentElementIndex == 0)) {
			currentElement=arrayItem[currentElementIndex-1];
			currentElementIndex--;
		}
		
	};

	public boolean first() {
		if(!empty() && (currentElementIndex == 0)) {
			return true;
		}
		else {
			return false;
		}
	};

	public T retrieve() {
		if(!empty()) {
			return currentElement;
		}
		else {
			return null;
		}
	};

	public void update(T e) {
		if(!empty()) {
			arrayItem[currentElementIndex]=e;
		}
	};

	public void insert(T e) {
		if(!full()) {
			if(empty()) {
				arrayItem[0]=e;
				currentElement=e;
				currentElementIndex=0;
				numberOfItem++;
			}
			else {
				for(int i=numberOfItem;i>currentElementIndex;i--) {
					arrayItem[i]=arrayItem[i-1];
				}
				arrayItem[currentElementIndex+1]=e;
				currentElement=e;
				currentElementIndex++;
				numberOfItem++;
			}

		}
		
	};

	public void remove() {
		if(!empty()) {
			if(numberOfItem==1) {
				arrayItem[0]=null;
				currentElement=null;
				currentElementIndex--;
				numberOfItem--;
			}
			else if(currentElementIndex == numberOfItem-1) {
				arrayItem[currentElementIndex]=null;
				currentElement=arrayItem[0];
				currentElementIndex=0;
				numberOfItem--;
			}
			else {
				int currentIndex=currentElementIndex;
				for(int i=currentIndex; i<numberOfItem;i++) {
					arrayItem[i]=arrayItem[i+1];
				}
				currentElement=arrayItem[currentIndex];
				
			}

		}
	};

	public int min(int i) {
		int position=0;
		if(!empty() && i<numberOfItem ) {
			T min=arrayItem[i];
			position = i;
			for(int x=i;x<numberOfItem;x++) {
				if(min.compareTo(arrayItem[x])>0) {
					min=arrayItem[x];
					position = x;
				}
			}
			int j = position;
			return j;
		}else {
			return -1;
		}
		
	};

	public int comp(int j) {
		if(!empty() && j<numberOfItem ) {
			 int res = currentElement.compareTo(arrayItem[j]);
			return res;
		}else {
			return 0;
		}
	};

	public void swap(int j) {
		if(!empty() && j<numberOfItem ) {
			int currentIndex=currentElementIndex;
			T swapCurrent=arrayItem[j];
			arrayItem[j]=arrayItem[currentIndex];
			arrayItem[currentIndex]=swapCurrent;
		}
	};
}
