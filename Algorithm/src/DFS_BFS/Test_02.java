package DFS_BFS;
/*
문제 설명
네트워크 상에 N대의 컴퓨터가 있고, 일부 컴퓨터끼리는 직접 연결되어 있다. 1번 컴퓨터가 바이러스에 걸렸을 때, 1번을 통해 직간접적으로 감염되는 컴퓨터의 수를 구하세요. (1번은 제외)

제한 사항
컴퓨터 수 n: 2 이상 100 이하
연결 정보 수 m: 1 이상 n×(n-1)/2 이하
연결 정보는 중복되지 않음
컴퓨터 번호는 1번부터 시작

입출력 예
입력:
n = 7
connections = [[1,2],[2,3],[1,5],[5,2],[5,6],[4,7]]

** 향상된 for문으로 list 탐색하는 게 자꾸 안떠오르네 구조 공부 좀 해야할듯.

출력:
4
 */


import java.util.*;

public class Test_02 {
	static boolean[] visited;
	static List<Integer>[] list;
	static int count = 0;
	static boolean[][] arr;
	
	
	static Queue<Integer> que;
	//방법3 bfs
	public static int solution(int n, int[][] connections) {
		que = new ArrayDeque<>();
		arr = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		
		for(int[] num : connections) {
			int a = num[0];
			int b = num[1];
			
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		bfs(1);
		
		return count;
		
	}
	
	
	public static void bfs(int num) {
		que.offer(num);
		visited[num] = true;
		
		while(!que.isEmpty()) {
			int n2 = que.poll();
			
			for(int i=1; i<arr.length; i++) {
				if(arr[n2][i] && !visited[i]) {
					visited[i] = true;
					que.offer(i);
					count++;
				}
			}
		}
		
	}
	
	
	
	
	
	/*
	//방법2 
	public static int solution(int n, int[][] connections) {
		arr = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int[] cn : connections) {
			int a = cn[0];
			int b = cn[1];
			
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		visited[1] = true;
		dfs(1, connections);
		
		return count;
	
	}
	
	public static void dfs(int n, int[][] connections) {
		
		for(int i=1; i<arr.length; i++) {
			if(arr[n][i] && !visited[i]) {
				visited[i] = true;
				count++;
				dfs(i, connections);
			}
		}
	}
	
	*/
	
	/*
	
	public static int solution(int n, int[][] connections) {
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int[] arr : connections) {
			int a1 = arr[0];
			int a2 = arr[1];
			
			list[a1].add(a2);
			list[a2].add(a1);
		}
		
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
				break;
			}
		}
		
		return count;
	}

	
	public static void dfs(int n) {
		
		for(int num : list[n]) {
			if(!visited[num]) {
				visited[num] = true;
				count++;
				dfs(num);
				
			}		
	}
		
		
		
	}
	*/
	public static void main(String[] args) {
		int[][] connections = {
			    {1, 2},
			    {2, 3},
			    {1, 5},
			    {5, 2},
			    {5, 6},
			    {4, 7}
			};
		
		System.out.println(solution(7, connections));
	}
}
