package ABC317_gamefreak.d;

import java.util.*;

class District implements Comparable<District> {
  int x, y, z;

  public District(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public int compareTo(District other) {
    return Integer.compare(z, other.z);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    District[] districts = new District[n];
    int totalTakahashiSeats = 0, totalAokiSeats = 0, totalSeats = 0;

    for (int i = 0; i < n; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      int z = scanner.nextInt();
      totalSeats += z;
      districts[i] = new District(x, y, z);

      if (x > y) {
        totalTakahashiSeats += z;
      } else if (x < y) {
        totalAokiSeats += z;
      }
    }

    int votesToSwitch = Integer.MAX_VALUE;
    int takahashiSeatsNeeded = (totalSeats / 2) + 1;

    Arrays.sort(districts);

    for (int i = 0; i < n; i++) {
      int neededSeatsToWin = takahashiSeatsNeeded - totalTakahashiSeats;
      int peopleToMove = (districts[i].y - districts[i].x) / 2 + 1;

      if (neededSeatsToWin <= 0) {
        // 高橋派が既に過半数を獲得している場合、votesToSwitchを0に設定
        votesToSwitch = 0;
        break;
      }

      // How to achieve more seats than needSeatsToWin with the least peopleToMove?
    }

    System.out.println(votesToSwitch);
  }
}
