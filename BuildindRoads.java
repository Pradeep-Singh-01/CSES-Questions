import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
 
public class BuildingRoads {
 
    public static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
 
    public static boolean union(int x, int y, int[] parent, int[] rank) {
        int parent_x = find(x, parent);
        int parent_y = find(y, parent);
        if (parent_x == parent_y) {
            return false;
        }
 
        int rank_x = rank[parent_x];
        int rank_y = rank[parent_y];
        if (rank_x > rank_y) {
            parent[parent_y] = parent_x;
 
        } else if (rank_x < rank_y) {
            parent[parent_x] = parent_y;
        } else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
        return true;
 
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        PrintWriter out = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        int city = Integer.parseInt(firstLine[0]);
        int road = Integer.parseInt(firstLine[1]);
        int[][] roads = new int[road][2];
        int[] parent = new int[city + 1];
        int[] rank = new int[city + 1];
 
        for (int i = 1; i <= city; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < road; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            int[] arr = new int[]{u, v};
            roads[i] = arr;
            union(u, v, parent, rank);
        }
 
       
 
    
       ArrayList<Integer> reps = new ArrayList<>();
        for (int i = 1; i <= city; i++) {
            if (find(i, parent) == i) {
                reps.add(i);
            }
        }
 
        int count = reps.size() - 1;
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(reps.get(i) + " " + reps.get(i + 1));
        }
    }
}
