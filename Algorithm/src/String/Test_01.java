package String;

/*

 문제 1: [문자열 압축]
유형: 문자열 처리 / 구현
난이도: 프로그래머스 Lv.2 ~ Lv.3 / 백준 실버 1
📜 문제 설명
문자열에서 같은 문자가 연속으로 반복될 경우, 반복되는 문자와 반복 횟수를 이용해 문자열을 압축하려고 합니다.
 
 ✨ 입력
문자열 s (길이 1 이상 1,000 이하)
모두 소문자 알파벳으로만 구성됨

🔢 출력
압축했을 때의 최소 문자열 길이
💡 예시

입력
aabbaccc

출력
7
 문자열은 뭔가 좇같다. 꼭 다시 풀어보기
 */


public class Test_01 {
	
	
	public static int solution(String s) {
		int answer = s.length();
		
		
		for(int i=1; i<=s.length()/2; i++) {
			
			String prev = s.substring(0,i);
			int count = 1;
			
			String save ="";
			
			
			for(int k=i; k<s.length(); k+=i) {
				String sub = s.substring(k, Math.min(i+k, s.length()));
				
				if(prev.equals(sub)) {
					count++;
				}
				
				else {
					save += (count >= 2 ? count : "") + prev;
					prev = sub;
					count = 1;
				}
			}
			
			save += (count >=2 ? count : "") + prev;
			answer = Math.min(answer, save.length());
		}	
			
			
		return answer;
			
		}
	
	
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		
	}
	

}
