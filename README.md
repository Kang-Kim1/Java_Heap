# Data Structure - Heap
* 완전 이진 트리(Complete Binary Tree) 형태의 자료구조로 최대, 최소값을 빠르가 찾기 위해 사용
  * 노드 insert 시, 최하단 노드의 왼쪽 자식 부터 차례대로 삽입
* 데이터 입력 > 최대&최소 값 검색 시의 시간 복잡도
  * 배열 : O(n) / <b>Heap : O(log n)</b>
* PriorityQueue에 사용되는 자료구조
* 최대 값을 구하기 위한 Max Heap, 최소 값을 구하기 위한 Min Heap으로 구현할 수 있음
* Binary Search Tree는 탐색, <br>Heap은 최대&최소값 검색</br>을 위해 사용
* 조건
  * Max Heap : 각 노드의 값이 자식 노드보다 크거나 같다
  * Min Heap : 각 노드의 값이 자식 노드보다 작거나 같다

