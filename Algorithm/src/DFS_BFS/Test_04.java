package DFS_BFS;

import java.util.*;

/*
🧩 문제 제목: 토마토 (Tomato)

(유형: BFS, 다중 시작점 탐색)
난이도: 백준 기준 Gold 5 / 프로그래머스 기준 Lv.3~4

📘 문제 설명
창고에 토마토 상자가 쌓여 있습니다.
각 칸에는 익은 토마토, 익지 않은 토마토, 또는 비어 있는 칸이 있습니다.
하루가 지날 때마다,
익은 토마토의 인접한 상하좌우 칸의 익지 않은 토마토는 익게 됩니다.
당신의 목표는 모든 토마토가 다 익는 데 걸리는 최소 일수를 구하는 것입니다.
단, 처음부터 모든 토마토가 익어 있다면 0일을 출력합니다.
그리고 어떤 토마토는 절대 익지 못할 수도 있습니다.
이 경우 -1을 출력하세요.

🔢 입력 형식
M N
(토마토 상태가 담긴 N줄)
M: 상자의 가로 칸 수 (열)
N: 상자의 세로 칸 수 (행)

1 ≤ M, N ≤ 1000

값	의미
1	익은 토마토
0	익지 않은 토마토
-1	빈 칸 (토마토 없음)
🧮 출력 형식
모든 토마토가 익는 최소 일수
(또는 -1)

 */



public class Test_04 {
	
	
	static Queue<int[]> que;
	
	public static int solution(int[][] tomatoes) {
		int a = tomatoes.length;
		int b = tomatoes[0].length;
		
		 que = new ArrayDeque<>();
		
		int answer = 0;
		
		for(int y=0; y<a; y++) {
			
			for(int x=0; x<b; x++) {
				if(tomatoes[y][x] == 1) {
					que.offer(new int[] {y,x});
				}
			}
		}
		bfs(tomatoes);
		
		
		boolean flag = true;
		for(int y=0; y<a; y++) {	
			for(int x=0; x<b; x++) {
				if(tomatoes[y][x] == 0) {
					flag = false;
					break;
				}
				
				if(tomatoes[y][x] > 0) {
					answer = Math.max(answer, tomatoes[y][x]);
				}
			}
			if(!flag) break;
		}

		if(!flag) return -1;
		return answer-1;	
	}
	
	
	public static void bfs(int[][] tomatoes) {
		
		//상 하 좌 우
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int x = arr[1];
			int y = arr[0];
			
			
			for(int i=0; i<4; i++) {
				int fy = dy[i] + y;
				int fx = dx[i] + x;
				
				if(fx < 0 || fx >= tomatoes[0].length || fy < 0 || fy >= tomatoes.length) continue;
				
				if(tomatoes[fy][fx] == -1) continue;
				
				if(tomatoes[fy][fx] == 0) {
					tomatoes[fy][fx] = tomatoes[y][x] + 1;   // 현재 1인 값에 +1 을 하는 거라 나중에 값계산 때 -1 해줘야 함. 
					que.offer(new int[] {fy,fx});
				}				
			}
		
		}
	}
	
	public static void main(String[] args) {
		int[][] map = {
	            {0, 0, -1, 0, 0, 0},
	            {0, 0, 1, 0, -1, 0},
	            {0, 0, -1, 0, 0, 0},
	            {0, 0, 0, 0, -1, 1}
	        };
		
		int[][] map2 = {
			    {0, 0, -1, 0, 0, 0},
			    {0, 0,  1, 0, -1, 0},
			    {0, 0, -1, 0, 0, 0},
			    {0, 0,  0, 0, -1, 1}
			};
		
		int[][] badCase = {
			    {0, 0, 0, 0},
			    {1, -1, 0, 1},
			    {0, 0, 0, 0}
			};

	        System.out.println(solution(badCase)); 
	        
	}
	

}
