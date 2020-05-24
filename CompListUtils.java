package newproject;

public class CompListUtils {
	
	public static <T extends Comparable<T>> void insertionSort(CompList<T> l, int k) {
		int n = l.length(); 
		int swapCount=0;
		int cycles=1;
		boolean flag =false;
		while(!(swapCount==k) && cycles<n) {
			if(!flag) {
				l.findFirst();
			}
			if(l.comp(cycles)>0) {
				l.swap(cycles);
				cycles=1;
				swapCount++;
				flag=false;
			}
			else {
				l.findNext();
				cycles++;
				flag=true;
			}
			
		}
        
        
	}

	public static <T extends Comparable<T>> void selectionSort(CompList<T> l, int k) {
		int n = l.length();
		int swapCount=0;
		int cycles=1;
		l.findFirst();
		while(!(swapCount==k) && cycles<n) {
			int a=l.min(cycles);
			if(l.comp(a)>0) {
				l.swap(a);
				l.findNext();
				swapCount++;
				cycles++;
			}
			else {
				l.findNext();
				cycles++;
			}
			
		}
		
	}

	public static <T extends Comparable<T>> void bubbleSort(CompList<T> l, int k) {
		int n = l.length(); 
		int swapCount=0;
		int cycles=1;
		int sortedCycle=0;
		l.findFirst();
		while(!(swapCount==k) && cycles<n+1) {

			if(cycles==n) {
				cycles=1;
				l.findFirst();
			}
			if(l.comp(cycles)>0) {
				l.swap(cycles);
				sortedCycle=0;
				cycles++;
				swapCount++;
				l.findNext();
			}
			else {
				l.findNext();
				cycles++;
				sortedCycle++;
			}
			if(sortedCycle==n-1) {
				break;
			}
		}
	}


	public static <T extends Comparable<T>> CompList<T> selectSmallestK(CompList<T> l, int k) {
		CompList<T> newl = new ArrayCompList<T>(l.length());
		l.findFirst();
		for(int z=0;z<l.length();z++) {
			
			newl.insert(l.retrieve());
			l.findNext();
		}
		CompList<T> returnNewl = new ArrayCompList<T>(k);
		for(int i=0;i<k;i++) {
			newl.findFirst();
			for(int y=0;y<newl.min(0);y++) {
				newl.findNext();
			}
			returnNewl.insert(newl.retrieve());
			newl.remove();
		}
		return returnNewl;
	}

}
