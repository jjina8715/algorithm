package stack_queue;

public class Stack extends LinkedList{
	Stack(){
		 super(); //LinkedList의 생성자를 실행
	}
	
	public void add(int val) {
		super.addFirst(val);
	}
	
	public void remove() {
		System.out.println("삭제 결과 : " + super.removeFirst());
	}
	
	public void printList() {
		System.out.println("----------stack print----------");
		super.printList();
		System.out.println("------------------------------");
	}
}

