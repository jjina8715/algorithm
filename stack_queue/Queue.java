package stack_queue;

public class Queue extends LinkedList {
	Queue() {
		super();
	}

	public void add(int val) {
		super.addLast(val);
	}

	public void remove() {
		System.out.println("삭제 결과 : " + super.removeFirst());
	}

	public void printList() {
		System.out.println("----------queue print----------");
		super.printList();
		System.out.println("------------------------------");
	}
}
