package Stack_Queue;

/*
스택 문제 2: 스택 수열

문제 설명
1부터 N까지의 수를 오름차순으로 스택에 push하며, 필요한 시점에 pop 하여 목표 수열을 만들어야 합니다.
가능한 경우 +와 - 연산의 목록을 반환하세요. 불가능하면 빈 배열을 반환하세요.

📘 백준 번호: 1874번
🟡 백준 난이도: 실버 2
🟣 프로그래머스 레벨 (추정): 레벨 2

* 전 스택 패턴을 보니 쉬웠음. 근데 문제 설명이 조금 애매해서 초반에 문제 이해하는데 조금 걸림.
 */
import java.util.*;

public class Test02 {
	
	public static List<String> solution(int N, int[] target) {
		Stack<Integer> stk = new Stack<>();
		List<String> answer = new ArrayList<>();
		int idx = 0;
		for(int i=1; i<=N; i++) {
			stk.push(i);
			answer.add("+");
			
			while(!stk.isEmpty() && target[idx] == stk.peek() ) {
				stk.pop();
				answer.add("-");
				idx++;
			}
		}
		
		if(!stk.isEmpty()) {
			answer.clear();
			answer.add("NO");
		}
		
		return answer;
	}
		
		
		

	public static void main(String[] args) {
		List<String> list = solution(5, new int[] {1,2,3,4,5});
		list = solution(5, new int[] {1,2,5,3,4});
		list = solution(5, new int[] {1,2,5,3,4});
		for(String str : list) {
			System.out.print(str + " ");
		}
		
	}

}
