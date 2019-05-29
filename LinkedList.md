

# Linked List

- 요소와 요소 간의 연결(link)을 이용해서 리스트를 구현한 것
- 리스트는 노드(요소)들의 모임이다. 따라서 내부적으로 노드를 가지고 있어야 한다. 노드는 최소 노드의 값과 다음 노드, 이 두 가지를 알고 있어야 한다. ![2939](C:\Users\student\Desktop\2939.png)
- 만약 구현하는 언어가 c라면 구조체, 객체지향 언어라면 객체에 데이터 필드와 링크 필드를 만든다. 링크 필드에서 다음 노드의 포인터나 참조값을 저장해서 노드와 노드를 연결시키는 방법을 사용한다.
- HEAD: linked list를 사용하기 위해서는 이 head가 가리키는 첫번째 노드를 찾아야 한다. 

- 데이터 추가

  - 시작부분에 추가

    - 새로운 노드를 생성 

      새로운 노드의 다음 노드로 첫번째 노드를 가리킨다

       HEAD가 새로 만들어진 노드를 가리키도록 값을 변경

    ```JAVA
    Vertex temp = new Vertex(input);
    temp.next = head;
    head = temp;
    ```

  - 중간에 추가

    - HEAD를 참조해서 첫번째 노드를 찾는다 

      값을 넣을 자리를 반복문으로 찾는다 

      새로운 노드를 생성 

      값을 넣을 자리 바로 앞의 노드의 다음 노드로 새로운 노드를 지정

      새로운 노드의 다음 노드로 앞의 노드가 가리켰던 노드를 지정

    - 배열이 추가/삭제가 느린데 반해 linked list의 경우 추가/삭제가 될 요소의 이전, 이후 노드의 참조값(next)만 변경하면 되기 때문에 속도가 빠르다.

    ```java
    Vertex temp1 = head;
    while(--k!=0)
        temp1 = temp1.next;
    Vertex temp2 = temp1.next;
    Vertex newVertex = new Vertex(input);
    temp1.next = newVertex;
    newVertex = temp2;
    ```

- 데이터 제거

  - 우선 head를 이용해서 첫번째 노드를 찾는다

    다음 노드로 이동을 반복 지울 노드를 찾는다

    지울 노드의 앞의 노드의 next를 지울 노드의 다음 노드로 변경

  ```java
  Vertex cur = head;
  while(--k!=0)
      cur = cur.next;
  Vertex deleted = cur.next;
  cur.next = cur.next.next;
  delete deleted
  ```

- 인덱스를 이용한 데이터 조회

  - 인덱스를 이용하여 데이터를 조회할 때 linked list는 head가 가리키는 노드부터 시작해서 순차적으로 노드를 찾아가는 과정을 거친다. 만약 찾는 값이 마지막에 있다면 모든 노드를 탐색하게 된다.

- trade off

  - trade off는 어떤 특성이 좋아지면 다른 특성이 나빠지는 상황을 의미한다. array list와 linked list는 이의 좋은 사례라 할 수 있다.

  ![2885](C:\Users\student\Desktop\2885.png)

- Single Linked List 구현

  - HEAD는 첫번째 노드를 지정, TAIL은 마지막 노드를 지정, SIZE는 노드의 크기를 의미, 객체 Node는 내부적으로  data와 next변수를 가진다. 
  
- ![2947](C:\Users\student\Desktop\2947.png)
  
  - ```java
    public class LinkedList{
        private Node head;
        private Node tail;
        private int size = 0;
        private class Node{
            private Object data;
            private Node next;
            public Node(Object input){
    			this.data = input;
                this.next = null;
            }
            public String toString(){
                return String.valueOf(this.data);
            }
        }
    }
    ```
  ```
  
  ```
  
- 데이터 추가
  
  - 시작에 추가
  
      ```java
      public void addFirst(Object input){
          Node newNode = new Node(input);
          newNode.next = head;
          head = newHead;
          size++;
          if(head.next==null){
              tail = head;
          }
      }
    ```
  
  - 끝에 추가
  
    - tail이 없이도 구현이 가능하지만 tail을 사용할 시 훨씬 효율적
  
        ```java
        public void addLast(Object input){
          Node newNode = new Node(input);
      if(size == 0){
        		addFirst(input);
            }else{
        		tail.next = newNode;
                tail = newNode;
                size++;
            }
        }
      ```
      
    - 중간에 추가
    
      - 특정 위치의 노드를 찾아내는 방법
    
        ```java
        Node node(int index){
        	Node tmp = head;
            for(int i = 0; i<index;i++)
                tmp = tmp.next;
            retuen tmp;
        }
        ```
    
      - node 메소드를 이용한 추가 메소드
    
      ```java
      public void add(int k, Object input){
          if(k==0){
              addFirst(input);
          }else{
              Node tmp1 = node(k-1);
              Node tmp2 = temp1.next;
              Node newNode = new Node(input);
              tmp1.next = newNode;
              newNode.next = tmp2;
              size++;
              if(newNode.next == null)
                  tail=newNode;
          }
          
      }
      ```
    
  - 출력
  
    ```java
    public String toString(){
        if(head==null){
            return "[]";
        }
        Node temp = head;
        String str = "{";
        while(temp.next!=null){
            str+=temp.data+", ";
            temp = temp.next;
        }
        str+=temp.next;
        return str+"]";
    }
    ```
  
  - 삭제
  
    - 처음 노드 삭제
  
    ```java
    public Object removeFirst(){
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }
    ```
  
    - 중간 노드 삭제
  
    ```java
    public Object remove(int k){
        if(k==0) 
            return removeFirst();
        Node temp = node(k-1);
        Node deleted = temp.next;
        temp.next = temp.next.next;
        Object data = deleted.data;
        if(deleted == tail)
            tail = temp;
    }
    ```
  
    

https://opentutorials.org/module/1335/8857#entirecode

http://www.nextree.co.kr/p6506/





[참고](https://opentutorials.org/module/1335)