package Stack_Queue;
/*
스택 문제 1: 오큰수
문제 설명
정수로 이루어진 배열 numbers가 주어집니다. 각 원소에 대해 오른쪽에 있으면서 자신보다 큰 수 중 가장 왼쪽에 있는 수를 찾아 반환하세요.
해당하는 수가 없다면 -1을 대신 넣습니다.

📘 백준 번호: 17298번
🟡 백준 난이도: 실버 4
🟣 프로그래머스 레벨 (추정): 레벨 2~3 (효율성 O(N) 필요)


문제 자체는 어려운 문제는 아닌데 for 문 안에 부분 발상을 못했었음. 다시 풀어보기
 */


import java.util.*;

public class Test01 {
	static Stack<Integer> stk = new Stack<>();
	
	public static int[] solution(int[] numbers) {
		int n = numbers.length;
		int[] answer = new int[n];
		
		for(int i=0; i<n; i++) {
			
			while(!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
				int idx = stk.pop();
				answer[idx] = numbers[i];
			}
			
			stk.push(i);
		}
		
		while(!stk.isEmpty()) {
			int idx = stk.pop();
			answer[idx] = -1;
		}
		
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		int[] answer = solution(new int[] {9,1,3,2,6});
		
		for(int n : answer) {
			System.out.print(n +" ");
		}
	}
	
	
}
