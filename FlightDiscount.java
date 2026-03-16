import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
 
public class FlightDiscount {
    static class Pair{
        int v;
        long wt;
        int used;
 
        Pair(int v , long wt, int used){
            this.v= v;
            this.wt= wt;
            this.used=used;
        }
 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String [] first= br.readLine().split(" ");
        int n= Integer.parseInt(first[0]);
        int m= Integer.parseInt(first[1]);
 
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
 
        for(int i=0;i<m;i++){
            String []flight= br.readLine().split(" ");
            int u = Integer.parseInt(flight[0]);
            int v = Integer.parseInt(flight[1]);
            long wt = Long.parseLong(flight[2]);
 
            adj.get(u).add(new Pair(v,wt,0));
        }
 
        long [][]ans = new long[n+1][2];
        for(long i[]:ans) Arrays.fill(i,Long.MAX_VALUE);
 
        ans[1][0]=0;
        PriorityQueue<Pair> pq= new PriorityQueue<>(Comparator.comparingLong(a -> a.wt));
 
        pq.add(new Pair(1,0,0));
 
        while(!pq.isEmpty()){
            Pair node= pq.poll();
            int v= node.v;
            long wt = node.wt;
            int used= node.used;
 
            if(wt > ans[v][used]) continue;
 
            for(Pair neigh: adj.get(v)){
                if(ans[neigh.v][used]> wt+neigh.wt){
                    ans[neigh.v][used]=wt+neigh.wt;
 
                    pq.add(new Pair(neigh.v,ans[neigh.v][used], used));
                }
 
                if(used==0){
                    if(ans[neigh.v][1]> wt+neigh.wt/2){
                        ans[neigh.v][1]=wt+neigh.wt/2;
                        pq.add(new Pair(neigh.v,ans[neigh.v][1], 1));
                    }
                }
            }
        }
 
//        out.println(ans[n-1][1]) ;
//        out.println(ans[n-1][0]);
//        out.println(ans[n][0]);
        out.println(Math.min(ans[n][0],ans[n][1]));
        out.flush();
    }
