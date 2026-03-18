import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 
public class CourseSchedule {
    public static void sort(int[] ans, ArrayList<Integer>[] adj, int[] indeg, int v){
        Queue<Integer>  q= new LinkedList<>();
         for(int i=0; i<v; i++){
            if(indeg[i]==0){
                q.add(i);
            }
         } 
         int i=0;
          while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
 
            for(int neighbour:adj[node]){
                indeg[neighbour]--;
                 if(indeg[neighbour]==0){
                    q.add(neighbour);
                 }
            }
          }
 
          if (i != v) {
            ans[0] = -1; // marker for cycle
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
 
        String[] first = br.readLine().split(" ");
        int numCourses = Integer.parseInt(first[0]);
        int size  = Integer.parseInt(first[1]);
        ArrayList<Integer>[] adj =  new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>(); // ✅ initialize each list
        }
        int[] indeg =  new int[numCourses];
        for(int i=0; i<size; i++){
            String[] pre = br.readLine().split(" ");
            int u = Integer.parseInt(pre[0]) - 1;
            int v = Integer.parseInt(pre[1]) - 1;
             indeg[v]++;
              adj[u].add(v);
        }
         int ans[] = new int[numCourses];
 
 
        sort(ans, adj,indeg,numCourses);
 
         if (ans[0] == -1){
            out.println("IMPOSSIBLE");
         }else{
 
        for(int i=0;i<numCourses; i++){
            out.print((ans[i]+1) + " ");
        }
    }
 
       out.flush();
        //   ret/urn ans;
 
    }
}
