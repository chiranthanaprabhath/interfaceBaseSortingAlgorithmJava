package newproject;

public interface CompList<T extends Comparable<T>> {

	int length();

	boolean empty();

	boolean full();

	void findFirst();

	void findNext();

	boolean last();

	void findPrevious();

	boolean first();

	T retrieve();

	void update(T e);

	void insert(T e);

	void remove();

	int min(int i);

	int comp(int j);

	void swap(int j);
}