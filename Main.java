package newproject;


public class Main {

	private static <T extends Comparable<T>> void print(CompList<T> l) {
		System.out.println("---------------------------");
		if (l.empty()) {
			System.out.println("empty");
			return;
		}
		l.findFirst();
		while (!l.last()) {
			System.out.print(l.retrieve() + ", ");
			l.findNext();
		}
		System.out.println(l.retrieve());
		System.out.println("---------------------------");
	}

	private static CompList<Integer> getList() {
		CompList<Integer> l = new LinkedCompList<Integer>();
		l.insert(5);
		l.insert(4);
		l.insert(3);
		l.insert(2);
		l.insert(1);
		return l;
	}

	public static void main(String[] args) {
		System.out.println("Insertion sort:");
		{
			CompList<Integer> l = getList();
			print(l);
			CompListUtils.insertionSort(l, 2);
			print(l);
		}
		{
			CompList<Integer> l = getList();
			print(l);
			CompListUtils.insertionSort(l, 5);
			print(l);
		}
		System.out.println("Selection sort:");
		{
			CompList<Integer> l = getList();
			print(l);
			CompListUtils.selectionSort(l, 1);
			print(l);
		}
		{
			CompList<Integer> l = getList();
			print(l);
			CompListUtils.selectionSort(l, 2);
			print(l);
		}
		System.out.println("Bubble sort:");
		{
			CompList<Integer> l = getList();
			print(l);
			CompListUtils.bubbleSort(l, 2);
			print(l);
		}
		{
			CompList<Integer> l = getList();
			print(l);
			CompListUtils.bubbleSort(l, 5);
			print(l);
		}
		
		System.out.println("Select sammlest k:");
		{
			CompList<Integer> l = getList();
			print(l);
			print(CompListUtils.selectSmallestK(l, 2));
			print(CompListUtils.selectSmallestK(l, 3));
			print(CompListUtils.selectSmallestK(l, 5));
			print(l);
		}
	}

}
