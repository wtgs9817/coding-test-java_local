package DFS_BFS;
/*
난이도: 하
핵심 주제: DFS, 인접 리스트, 방문 배열

문제 설명:
N명의 학생들이 있고, 일부 학생들은 서로 친구이다. 친구 관계는 양방향이며, 연결된 친구 그룹(서로 친구이거나, 친구의 친구이거나...)이 몇 개인지 세어라.

입력:
첫 줄에 학생 수 N (1 ≤ N ≤ 1,000)
다음 줄에 친구 관계 수 M (0 ≤ M ≤ N*(N-1)/2)
그 다음 M줄에 걸쳐 친구 관계를 나타내는 두 정수 u v가 주어진다. 이는 u번 학생과 v번 학생이 친구라는 의미이다. (1-based index)

출력:
친구 그룹의 개수 (연결 요소의 개수)

입력:
n = 5
friendships = {
  {1, 2},
  {2, 3},
  {4, 5}
}

출력:
2 
 
 */

//인접 리스트로 만들어두고 푸는 게 더 나은듯. 

import java.util.*;
public class Test_01 {
	static boolean[] visited;
	static List<Integer>[] list;
	
	
	public static int countFriendGroups(int n, int[][] friendships) {
		list = new ArrayList[n+1];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int[] arr : friendships) {
			int n1 = arr[0];
			int n2 = arr[1];
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		
		
		visited = new boolean[n+1];
		int count = 0;
		int nn = friendships[0][0];
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		return count;
		
	}
	
	
	public static void dfs(int num) {
		visited[num] = true;
		
		for(int n : list[num]) {
			if(!visited[n]) {
				dfs(n);
			}
		}

	}
	
	public static void main(String[] args) {
		int[][] arr2 = {{1, 2},
				  {2, 3},
				  {4, 5}};
	
		int count = countFriendGroups(5, arr2);
		
		System.out.println(count);
		
	}
}
