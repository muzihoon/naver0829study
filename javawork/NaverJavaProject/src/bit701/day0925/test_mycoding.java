package bit701.day0925;

public class test_mycoding {

	public void test_mycoding (String A, String B)
	{
		int answer = 0;

		// A와 B가 같아질 때까지 반복
        while (!A.equals(B)) {
            // A 문자열의 마지막 글자 가져오기
            char last = A.charAt(A.length() - 1);
            
            // A 문자열에서 마지막 글자를 제외한 나머지 부분 가져오기
            String substring = A.substring(0, A.length() - 1);
            
            // 마지막 글자를 문자열의 앞쪽으로 붙여서 이동시킴
            A = last + substring;
            
            // 변환 횟수 증가
            answer++;

            // 만약 변환 횟수가 A 문자열의 길이보다 크다면, A를 B로 만들 수 없다는 의미이므로 반복 종료
            if (answer > A.length()) {
                System.out.println("A 문자열을 B와 같게 만들 수 없습니다.");
                break;
            }
        }

        // 결과 출력
        System.out.println("최소 변환 횟수: " + answer);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_mycoding ex = new test_mycoding();
		ex.test_mycoding("Hello", "ohell");
	}

}
