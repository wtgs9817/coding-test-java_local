package DFS_BFS;
import java.util.*;

/*
🧭 문제 2. 거리두기 확인하기

유형: BFS / 시뮬레이션
난이도: 프로그래머스 Lv.3 / 백준 골드 5
권장 시간: 30분

📜 문제 설명
5×5 크기의 대기실 배열이 여러 개 주어집니다.
각 칸은 다음 중 하나의 문자입니다.

P : 사람
O : 빈 테이블
X : 파티션

모든 P 쌍에 대해 맨해튼 거리 ≤ 2인 위치에 다른 P가 존재하면 안 됩니다.
단, 파티션 X가 중간에 있으면 허용됩니다.

각 대기실이 거리두기를 잘 지켰으면 1, 아니면 0을 반환하세요.
 
 
 */


public class Test_05 {
	static Queue<int[]> que;
    static int[] answer;
    
    public static int[] solution(String[][] places) {
        answer = new int[5];
        
        for(int i=0; i<5; i++) {
            que = new ArrayDeque<>();
            for(int k=0; k<5; k++) {
                for(int j=0; j<5; j++) {
                    if(places[i][k].charAt(j) == 'P') {
                        que.offer(new int[]{i,k,j});
                    }
                }
            }
            bfs(que, places);
        }
        
        for(int i=0; i<5; i++) {
            if(answer[i] == -1) {
                answer[i] = 0;
            }
            else {
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    public static void bfs(Queue<int[]> que, String[][] places) {
        //거리 1  상 하 좌 우
        int[] x1 = {0,0,-1,1};
        int[] y1 ={-1,1,0,0};
        
        //거리 2 
        int[] x2 = {0,0,-2,2};
        int[] y2 = {-2,2,0,0};
        
        //대각선  왼쪽 상단부터 시계방향
        int[] x3 = {-1,1,1,-1};
        int[] y3 = {-1,-1,1,1};
        
        boolean flag =true;
        
        while(!que.isEmpty() && flag) {
            int[] arr = que.poll();
            int x = arr[2];
            int y = arr[1];
            int z = arr[0];
            
            
            
            
            for(int i=0; i<4; i++) {
                //거리1
                int nx1 = x + x1[i];
                int ny1 = y + y1[i];
                
                //거리2
                int nx2 = x + x2[i];
                int ny2 = y + y2[i];
                
                //대각선
                int nx3 = x + x3[i];
                int ny3 = y + y3[i];
                
                
                
                
                //거리 1 P
                if(nx1 >= 0 && nx1 < 5 && ny1 >= 0 && ny1 < 5) {
                    if(places[z][ny1].charAt(nx1) == 'P') {
                    answer[z] = -1;
                    flag = false;
                    break;
                    }    
                }
                
                
                //거리 2 P
                if(nx2 >= 0 && nx2 < 5 && ny2 >= 0 && ny2 <5) {
                    if(places[z][ny2].charAt(nx2) == 'P') {
                    int midX = (x + nx2) /2;
                    int midY = (y + ny2) /2;
                    
                        if(!(places[z][midY].charAt(midX)=='X')) {
                            answer[z] = -1;
                            flag = false;
                            break;
                        } 
                    }
                }    
                
                
                //대각선 P
                if(nx3 >= 0 && nx3 < 5 && ny3 >= 0 && ny3 <5) {
                    if(places[z][ny3].charAt(nx3) == 'P') {
                        if(!(places[z][ny3].charAt(x) == 'X' && places[z][y].charAt(nx3) == 'X')) {
                            answer[z] = -1;
                            flag = false;
                            break;
                        }   
                    } 
                }
                    
            }
            
        }
    }
	
	public static void main(String[] args) {
		String[][] places = {
			    {
			        "POOOP", 
			        "OXXOX", 
			        "OPXPX", 
			        "OOXOX", 
			        "POXXP"
			    },
			    {
			        "POOPX", 
			        "OXPXP", 
			        "PXXXO", 
			        "OXXXO", 
			        "OOOPP"
			    },
			    {
			        "PXOPX", 
			        "OXOXP", 
			        "OXPOX", 
			        "OXXOP", 
			        "PXPOX"
			    },
			    {
			        "OOOXX", 
			        "XOOOX", 
			        "OOOXX", 
			        "OXOOX", 
			        "OOOOO"
			    },
			    {
			        "PXPXP", 
			        "XPXPX", 
			        "PXPXP", 
			        "XPXPX", 
			        "PXPXP"
			    }
			};
		
		
		
		String[][] places1 = {
			    {
			        "POOOP",
			        "OXXOX",
			        "OPXPX",
			        "OOXOX",
			        "POXXP"
			    },
			    {
			        "PXXXX",
			        "OPOOX",
			        "OXOXP",
			        "OXXOX",
			        "POOXP"
			    },
			    {
			        "PXOPX",
			        "OXOXP",
			        "OXPOX",
			        "OXXOP",
			        "PXPOX"
			    },
			    {
			        "OOOXX",
			        "XOOOX",
			        "OOOXX",
			        "OXOOX",
			        "OOOOO"
			    },
			    {
			        "PXPXP",
			        "XPXPX",
			        "PXPXP",
			        "XPXPX",
			        "PXPXP"
			    }
			};

			String[][] places2 = {
			    {
			        "PXXOP",
			        "OXPXP",
			        "PXXXX",
			        "OXOXP",
			        "PXXXP"
			    },
			    {
			        "PXOXP",
			        "OXPOP",
			        "OXPXO",
			        "PXOXP",
			        "POOXP"
			    },
			    {
			        "PXOPX",
			        "OXOXP",
			        "OXPOX",
			        "OXXOP",
			        "PXPOX"
			    },
			    {
			        "POOXX",
			        "OXPXP",
			        "PXOPX",
			        "OXOXP",
			        "PXXOP"
			    },
			    {
			        "POOOP",
			        "OXXOX",
			        "OPXPX",
			        "OOXOX",
			        "POXXP"
			    }
			};

			String[][] places3 = {
			    {
			        "POOOO",
			        "OXXOX",
			        "OPXPX",
			        "OOXOX",
			        "POXXP"
			    },
			    {
			        "PXOPP",
			        "OXPXO",
			        "OXOXP",
			        "PXOOX",
			        "POOXP"
			    },
			    {
			        "PXXOX",
			        "OPOXP",
			        "OXOOX",
			        "PXOXP",
			        "OXPOP"
			    },
			    {
			        "PXOOO",
			        "OXOXP",
			        "OXPOX",
			        "OXXOX",
			        "POOXP"
			    },
			    {
			        "POOXX",
			        "OXPXP",
			        "PXXOX",
			        "OXOXP",
			        "PXOXP"
			    }
			};

			String[][] places4 = {
			    {
			        "PXXXX",
			        "XPXPX",
			        "PXPXP",
			        "XPXPX",
			        "PXXXX"
			    },
			    {
			        "PXOXP",
			        "OXPXO",
			        "OXOXP",
			        "PXOOX",
			        "POOXP"
			    },
			    {
			        "POOOP",
			        "OXXOX",
			        "OPXPX",
			        "OOXOX",
			        "POXXP"
			    },
			    {
			        "PXOPX",
			        "OXOXP",
			        "OXPOX",
			        "OXXOP",
			        "PXPOX"
			    },
			    {
			        "POOXX",
			        "OXPXP",
			        "PXOPX",
			        "OXOXP",
			        "PXXOP"
			    }
			};

			String[][] places5 = {
			    {
			        "POOPX",
			        "OXPXP",
			        "PXXXO",
			        "OXXXO",
			        "OOOPP"
			    },
			    {
			        "PXPXP",
			        "XPXPX",
			        "PXPXP",
			        "XPXPX",
			        "PXPXP"
			    },
			    {
			        "POOOP",
			        "OXXOX",
			        "OPXPX",
			        "OOXOX",
			        "POXXP"
			    },
			    {
			        "PXXOX",
			        "OPOXP",
			        "OXOOX",
			        "PXOXP",
			        "OXPOP"
			    },
			    {
			        "PXOOO",
			        "OXOXP",
			        "OXPOX",
			        "OXXOX",
			        "POOXP"
			    }
			};
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		int[] answer = solution(places);
		for(int a : answer) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		int[] answer1 = solution(places1);
		for(int a : answer1) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		int[] answer2 = solution(places2);
		for(int a : answer2) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		int[] answer3 = solution(places3);
		for(int a : answer3) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		int[] answer4 = solution(places4);
		for(int a : answer4) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		int[] answer5 = solution(places5);
		for(int a : answer5) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
	
