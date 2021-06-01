public class Heap {
  private ArrayList<Integer> heapNodes;

  // index 0 = dummy
  public Heap(int data) {
    this.heapNodes = new ArrayList<Integer>();
    this.heapNodes.add(null);
    this.heapNodes.add(data);
  }

  // 부모노드 = index / 2
  // 자식노드 = 우측 : index * 2 + 1 / 좌측 : index* 2
  public boolean insert(int data) {
    if (this.heapNodes == null) {
      this.heapNodes = new ArrayList<Integer>();
      this.heapNodes.add(null);
      this.heapNodes.add(data);

      return true;
    }

    this.heapNodes.add(data);
    int currIndex = this.heapNodes.size() - 1;

    while (isMovableUP(currIndex)) {
      int parentIndex = currIndex / 2;
      Collections.swap(this.heapNodes, currIndex, parentIndex);
      currIndex = parentIndex;

    }
    return true;
  }

  private boolean isMovableUP(int index) {
    if (index <= 1)
      return false;

    if (this.heapNodes.get(index) > this.heapNodes.get(index / 2)) {
      return true;
    }

    // TODO Auto-generated method stub
    return false;
  }

  public Integer pop() {
    int removedDate;
    int index;
    int rightChildIdx;
    int leftChildIdx;

    if (this.heapNodes == null)
      return null;
    else {
      removedDate = this.heapNodes.get(1);
      this.heapNodes.set(1, heapNodes.remove(heapNodes.size() - 1));
      index = 1;
    }

    while (this.isMovableDOWN(index)) {
      leftChildIdx = index * 2;
      rightChildIdx = leftChildIdx + 1;

      // 왼쪽만 있을 경우
      if (rightChildIdx >= this.heapNodes.size()) {
        // Child 노드가 더 클 경우
        if (this.heapNodes.get(leftChildIdx) > this.heapNodes.get(index)) {
          Collections.swap(this.heapNodes, index, leftChildIdx);
          index = leftChildIdx;
        }
      // 양쪽 모두 자식이 있을 경우
      } else {
        // 왼쪽 노드가 더 클 경우
        if (this.heapNodes.get(leftChildIdx) > this.heapNodes.get(rightChildIdx)) {
          if (this.heapNodes.get(leftChildIdx) > this.heapNodes.get(index)) {
            Collections.swap(this.heapNodes, index, leftChildIdx);
            index = leftChildIdx;
          }
        }
        // 오른쪽 노드가 더 클 경우
        if (this.heapNodes.get(leftChildIdx) < this.heapNodes.get(rightChildIdx)) {
          if (this.heapNodes.get(rightChildIdx) > this.heapNodes.get(index)) {
            Collections.swap(this.heapNodes, index, rightChildIdx);
            index = leftChildIdx;
          }
        }
      }
    }
    return removedDate;
  }

  private boolean isMovableDOWN(int index) {
    int leftChildIdx = index * 2;
    int rightChildIdx = leftChildIdx + 1;
    int len = this.heapNodes.size();

    // 자식노드가 없을 경우
    if (leftChildIdx >= len) {
      return false;
    }
    // 왼쪽 자식노드만 있을 경우
    else if (rightChildIdx >= len) {
      if (this.heapNodes.get(leftChildIdx) > this.heapNodes.get(index))
        return true;
      return false;
      // 양쪽 자식노드가 있을 경우
    } else {
      // 오른쪽 자식 노드가 더 클 경우
      if (this.heapNodes.get(leftChildIdx) < this.heapNodes.get(rightChildIdx)) {
        if (this.heapNodes.get(rightChildIdx) > this.heapNodes.get(index))
          return true;
        return false;
        // 왼쪽 자식 노드가 더 클 경우
      } else {
        if (this.heapNodes.get(leftChildIdx) > this.heapNodes.get(index))
          return true;
        return false;
      }
    }
  }
}
