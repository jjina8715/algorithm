package stack_queue;

public class Main {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.printList();
		s.remove();
		s.remove();
		s.remove();
		s.printList();
		
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.printList();
		q.remove();
		q.remove();
		q.printList();
	}
}
