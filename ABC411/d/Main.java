package d;

import java.util.*;

public class Main {
    static class Operation {
        int type, time;
        String data;
        Operation(int type, int time, String data) {
            this.type = type;
            this.time = time;
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int Q = sc.nextInt();
        
        List<Operation>[] pcOperations = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            pcOperations[i] = new ArrayList<>();
        }
        
        List<int[]> serverHistory = new ArrayList<>();
        
        for (int time = 0; time < Q; time++) {
            int type = sc.nextInt();
            if (type == 1) {
                int p = sc.nextInt();
                pcOperations[p].add(new Operation(1, time, null));
            } else if (type == 2) {
                int p = sc.nextInt();
                String s = sc.next();
                pcOperations[p].add(new Operation(2, time, s));
            } else {
                int p = sc.nextInt();
                serverHistory.add(new int[]{p, time});
            }
        }
        
        if (serverHistory.isEmpty()) {
            System.out.println("");
        } else {
            int[] lastUpdate = serverHistory.get(serverHistory.size() - 1);
            System.out.println(buildPCString(lastUpdate[0], lastUpdate[1], pcOperations, serverHistory, new HashMap<>()));
        }
        
        sc.close();
    }
    
    private static String buildPCString(int pc, int upToTime, List<Operation>[] pcOperations, 
                                      List<int[]> serverHistory, Map<String, String> memo) {
        String key = pc + ":" + upToTime;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        StringBuilder result = new StringBuilder();
        
        for (Operation op : pcOperations[pc]) {
            if (op.time >= upToTime) break;
            
            if (op.type == 1) {
                String serverContent = getServerContentAtTime(op.time, serverHistory, pcOperations, memo);
                result = new StringBuilder(serverContent);
            } else {
                result.append(op.data);
            }
        }
        
        String res = result.toString();
        memo.put(key, res);
        return res;
    }
    
    private static String getServerContentAtTime(int targetTime, List<int[]> serverHistory,
                                               List<Operation>[] pcOperations, Map<String, String> memo) {
        for (int i = serverHistory.size() - 1; i >= 0; i--) {
            int[] update = serverHistory.get(i);
            if (update[1] < targetTime) {
                return buildPCString(update[0], update[1], pcOperations, serverHistory, memo);
            }
        }
        return "";
    }
}