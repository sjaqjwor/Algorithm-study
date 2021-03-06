/*
 * 2017.01.01
 * DFS
 *
 * @problem https://www.acmicpc.net/problem/1325
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int n,m,count,max=0;
	static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] list;
	static boolean visited[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<=n;i++){
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++){
			int a = input.nextInt();
			int b = input.nextInt();
			list[b].add(a);
		}
		for(int i=1;i<=n;i++){
			count=0;
			Arrays.fill(visited, false);
			if(!visited[i]){
				dfs(i);
			}
			if(count>max){ //더 많이 해킹할 수 있다면
				max=count;
				queue.clear(); //갱신
				queue.offer(i); 
			}else if(count==max){ //같다면
				queue.offer(i); //추가
			}
		}
		while(!queue.isEmpty()){
			int v = queue.poll();
			sb.append(v+" ");
		}
		System.out.println(sb);
	}
	public static void dfs(int v){
		visited[v]=true;
		count++;
		for(int i=0;i<list[v].size();i++){
			int node = list[v].get(i);
			if(!visited[node]){
				dfs(node);
			}
		}
	}
}