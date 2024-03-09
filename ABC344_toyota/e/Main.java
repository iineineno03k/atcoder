package ABC344_toyota.e;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ListNode {
  int val;
  ListNode prev, next;

  ListNode(int val) {
    this.val = val;
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    Map<Integer, ListNode> nodeMap = new HashMap<>();
    ListNode dummyHead = new ListNode(0); // ダミーヘッド
    ListNode tail = dummyHead; // 末尾を追跡

    for (int i = 0; i < N; i++) {
      int num = scanner.nextInt();
      ListNode newNode = new ListNode(num);
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
      nodeMap.put(num, newNode);
    }

    int Q = scanner.nextInt();
    for (int i = 0; i < Q; i++) {
      int type = scanner.nextInt();
      if (type == 1) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        ListNode nodeX = nodeMap.get(x);
        ListNode newNode = new ListNode(y);
        // YをXの後ろに挿入
        newNode.next = nodeX.next;
        newNode.prev = nodeX;
        if (nodeX.next != null) {
          nodeX.next.prev = newNode;
        }
        nodeX.next = newNode;
        nodeMap.put(y, newNode);
        if (nodeX == tail) { // 更新が末尾で行われた場合、tailを更新
          tail = newNode;
        }
      } else if (type == 2) {
        int x = scanner.nextInt();
        ListNode toDelete = nodeMap.get(x);
        if (toDelete.prev != null) {
          toDelete.prev.next = toDelete.next;
        }
        if (toDelete.next != null) {
          toDelete.next.prev = toDelete.prev;
        } else { // Xが末尾だった場合、tailを更新
          tail = toDelete.prev;
        }
        nodeMap.remove(x);
      }
    }

    // 結果を出力
    ListNode current = dummyHead.next;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}
