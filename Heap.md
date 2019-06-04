# Heap

### 힙(heap)이란?

- 완전 이진 트리의 일종, 우선순위 큐를 위하여 만들어진 자료구조
- 여러개의 값들 중에서 최댓값이나 최솟값을 빠르게 찾아내도록 만들어진 자료구조 
- 일종의 반정렬 상태(느슨한 정렬 상태)를 유지
  - 부모 노드 의 키 값이 자식 노드의 값보다 항상 큰/작은 이진 트리
- 중복된 값을 허용

### heap의 종류

- 최대 힙(max heap)
  - 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리
  - key(부모 노드) >= key(자식 노드)
- 최소 힙(min heap)
  - 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리
  - key(부모 노드) <= key(자식 노드)

### heap의 구현

- 힙을 저장하는 표준적인 자료구조는 배열이다.
- 구현을 쉽게 하기 위해 배열의 첫번째 인덱스인 0은 사용하지 않는다.
- 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다.
- 힙에서의 부모 노드와 자식 노드의 관계
  - 왼쪽 자식의 인덱스 = (부모의 인덱스) * 2
  - 오른쪽 자식의 인덱스 = (부모의 인덱스) * 2 + 1
  - 부모의 인덱스 = (자식의 인덱스) / 2

```c
#define MAX_ELEMENT 200

typedef struct{
    int key;
}element;

typedef struct{
    element heap[MAX_ELEMENT];
    int heapSize;
}HeapType;
```

### heap의 삽입

1. 힙에 새로운 요소가 들어오면, 새로운 노드를 힙의 마지막 노드에 이어서 삽입

2. 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다

- c언어

```c
void insertMaxHeap(HeapType *h, element item){
    int i;
    i = ++(h->heapSize);
    while((i!=1)&&(item.key > h->heap[i/2].key)){
        h->heap[i] = h->heap[i/2];
        i /= 2;
    }
    h->heap[i] = item;
}
```

- java

```java
void insertMaxHeap(int x){
    maxHeap[++heapSize] = x;
    for(int i = heapsize; i>1; i/=2){
        if(maxHeap[i/2] < maxHeap[i])
            swap(i/2, i);
        else
            break;
    }
}
```

### heap의 삭제

1. 최대 힙에서 삭제연산은 최댓값을 가진 요소를 삭제라는 것이고,  최댓값은 루트노드이므로 루트노드가 삭제된다
2. 삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.
3. 힙을 재구성한다.

- c언어

```c
element deleteMaxHeap(HeapType *h){
    int parent, child;
    element item, temp;
    
    item = h->heap[1];
    temp = h->heap[(h->heapSize)--];
    parent = 1;
    child = 2;
    
    while(child <= h->heapSize){
        if((child < h->heapSize) && ((h->heap[child].key) < h->heap[child+1].key)){
            child++;
        }
        if(temp.key >= h->heap[child].key){
            break;
        }
        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}
```

- java

```java
int deleteMaxHeap(){
    if(heapSize == 0)
        return 0;
    int item = maxHeap[1];
    maxHeap[1] = maxHeap[heapSize];
    maxHeap[heapSize--] = 0;
    for(int i = 1; i*2<=heapSize;){
        if(maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]){
            break;
        }else if(maxHeap[i*2] > maxHeap[i*2+1]){
            swap(i, i*2);
            i = i*2;
        }else{
            swap(i, i*2+1);
            i = i*2+1;
        }
    }
    return item;
}
```

<https://gmlwjd9405.github.io/2018/05/10/algorithm-heap-sort.html>



























 