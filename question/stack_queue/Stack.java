package stack_queue;

public class Stack extends LinkedList{
	Stack(){
		 super(); //LinkedList�� �����ڸ� ����
	}
	
	public void add(int val) {
		super.addFirst(val);
	}
	
	public void remove() {
		System.out.println("���� ��� : " + super.removeFirst());
	}
	
	public void printList() {
		System.out.println("----------stack print----------");
		super.printList();
		System.out.println("------------------------------");
	}
}

