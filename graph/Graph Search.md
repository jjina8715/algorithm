# Graph Search

- 하나의 정점으로부터 시작하여 차례대로 모든 정점들을 한 번씩 방문하는 것

1. 깊이 우선 탐색(DFS, Depth-First Search)

   - 어떤 한 노드에서 시작해서 다음 분기(branch)로 너어가기 전에 해당 분기를 완벽하게 탐색하는 방법
     - 즉, 넓게(wide) 탐색하기 전에 깊게(deep) 탐색하는 것
     - 모든 노드를 방문하고자 하는 경우에 이 방법을 선택
     - BFS보다 조금 더 간단, 속도 자체는 느리다.
   - 특징
     - 순환 알고리즘의 형태
     - 전위 순회(Pre-Order Traversals)를 포함한 다른 형태의 트리 순회는 모두 DFS의 한 종류이다
     - 이 방법을 사용해서 그래프를 탐색할 경우, 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다.(검사하지 않으면 무한루프의 가능성 )

   - 과정

     1. a노드(시작 노드)를 방문, 방문한 노드는 방문했다고 표시

     2. a와 인접한 노드들을 차례로 순회, 없으면 종료

     3. a와 이웃한 노드b를 방문했다면, a와 인접한 또 다른 노드를 방문하기 전에 b의 이웃 노드들을 전부 방문해야 한다.

        (b를 시작 노드로 DFS를 다시 시작)

     4. 

         b의 분기를 전부 완벽하게 탐색한 후에 a의 다른 이웃 노드를 방문



<http://ddmix.blogspot.com/2015/06/cppalgo-21-weighted-graph.html>

<https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html>

[libre](https://librewiki.net/wiki/%EC%8B%9C%EB%A6%AC%EC%A6%88:%EC%88%98%ED%95%99%EC%9D%B8%EB%93%AF_%EA%B3%BC%ED%95%99%EC%95%84%EB%8B%8C_%EA%B3%B5%ED%95%99%EA%B0%99%EC%9D%80_%EC%BB%B4%ED%93%A8%ED%84%B0%EA%B3%BC%ED%95%99/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EA%B8%B0%EC%B4%88)