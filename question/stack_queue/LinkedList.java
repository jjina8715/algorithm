package stack_queue;

public class LinkedList {
	LinkedNode first; // LinekedList의 첫 node
	LinkedNode last; // LinekedList의 마지막 node

	LinkedList() {
		first = null;
		last = null;
	}

	protected void addFirst(int val) {
		LinkedNode newNode = new LinkedNode(val);
		if(first == null) {
			last = newNode;
		}else {
			newNode.next = first;
		}
		first = newNode;
	}

	protected void addLast(int val) {
		LinkedNode newNode = new LinkedNode(val);
		if(last == null) {
			first = newNode;
		}else {
			last.next = newNode;
		}
		last = newNode;
	}

	protected Boolean removeFirst() {
		if(first!=null) {
			if(first!=last) {
				first = first.next;
			}else {
				first=last=null;
			}
			return true;
		}
		return false;
	}

	protected Boolean removeLast() {
		if(last!=null) {
			if(first!=last) {
				LinkedNode cur = first;
				while(cur.next != last) {
					cur = cur.next;
				}
				last = cur;
			}else {
				first=last=null;
			}
			return true;
		}
		return false;
	}

	protected void printList() {
		LinkedNode current = first;
		while (current != null) { //current 노드가 null 아닐때 까지 실행
			System.out.println(current.val);
			current = current.next; //next 노드를 current에 덮어 씌움
		}
	}
}
