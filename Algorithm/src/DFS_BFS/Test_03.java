package DFS_BFS;

/*

🧩 문제: 안전 영역 (Safe Zone)
📘 문제 설명

N×N 크기의 지역이 있습니다.
각 칸은 해당 지역의 높이를 나타냅니다.

비가 내리면 일정 높이 이하의 지역은 모두 물에 잠깁니다.
비의 양(강수량)을 0부터 최대 높이까지 바꿔가며,
**잠기지 않은 안전 영역(서로 연결된 지역)**의 개수를 구하세요.

모든 강수량 중에서 가장 많은 안전 영역 개수를 출력하세요.
인접한 지역은 상하좌우로만 연결됩니다 (대각선 X)

첫째 줄: N (2 ≤ N ≤ 100)
다음 N줄: 각 칸의 높이 (1 ≤ 높이 ≤ 100)


FloodFill Algorithm 사용  https://velog.io/@jungedlin/FloodFill
 */
import java.util.*;

public class Test_03 {
	static boolean[][] visited;
	static int answer = 0;
	static Queue<int[]> que = new ArrayDeque<>();
	
	//BFS
	public static int solution(int[][] map, int rain) {
		int a = map.length;
		int b = map[0].length;
		
		visited = new boolean[a][b];
		
		for(int y=0; y<a; y++) {
			for(int x=0; x<b; x++) {
				if(!visited[y][x] && map[y][x] > rain) {
					que.offer(new int[] {y,x});
					visited[y][x] = true;
					bfs(rain, map);
					answer++;
				}			
			}
		}
		
		return answer;
	}
	
	public static void bfs(int rain, int[][] map) {
		
		
		//상 하 좌 우 
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int xx = arr[1];
			int yy = arr[0];
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + xx;
				int ny = dy[i] + yy;
				
				if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
				
				if(!visited[ny][nx] && map[ny][nx] > rain) {
					visited[ny][nx] = true;
					que.offer(new int[] {ny, nx});
					
				}				
			}		
		}
		
		
	}
	
	
	
	
	//DFS
	/*
	 public static int solution(int[][] map, int rain) {
	         
	        int qw = map.length;
	        int er = map[0].length;
	        visited = new boolean[qw][er];
	        
	        
	        for(int i=0; i<qw; i++) {
	        	for(int k=0; k<er; k++) {
	        		
	        		if(!visited[i][k] && map[i][k] > rain) {
	        			dfs(i,k,rain, map);
	        			answer++;
	        		}
	        	}
	        }
	                
	        return answer;
	    }
	 
	 public static void dfs(int y, int x, int rain, int[][] map) {
		 visited[y][x] = true;
		 //상 하 좌 우  x축 y축 헷갈리지 않게 확인하기
		 int[] nx = {0, 0, -1, 1};
		 int[] ny = {-1, 1, 0, 0};
		 
		 
		 for(int j=0; j<4; j++) {
			 int idxX = nx[j] + x;
			 int idxY = ny[j] + y;
			 
			 if(idxX < 0 || idxX >= map[0].length  || idxY < 0 || idxY >= map.length ) continue;
			 
			 
			 if(!visited[idxY][idxX] && map[idxY][idxX] > rain) {
				 dfs(idxY, idxX, rain, map);		 
			 }
			  
		 }
		 
		 
	 }
	 */
	 
	public static void main(String[] args) {
		 int N = 5;
	        int[][] map = {
	            {6, 8, 2, 6, 2},
	            {3, 2, 3, 4, 6},
	            {6, 7, 3, 3, 2},
	            {7, 2, 5, 3, 6},
	            {8, 9, 5, 2, 7}
	        };
	        
	        
	        System.out.println(solution(map, N));
		
	}

	
	

}
