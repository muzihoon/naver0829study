package bit701.day0904;

public class Ex09_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1="apple";
		String str2="Apple";
		String str3="Have a Good Day";
		String str4="    Happy     ";
		
		System.out.println(str3.length()); // str3의 총 길이 : 15
		System.out.println(str2.toLowerCase()); // str2을 모두 소문자로 변환해서 출력 :apple
		System.out.println(str2.toUpperCase()); // str2을 모두 대문자로 변환해서 출력 :APPLE
		System.out.println(str3.substring(5)); // 5번 인덱스 부터 끝까지 출력 : a Good Day
		System.out.println(str3.substring(7,11)); // 7~10까지 출력 : start 부터 end -1 까지 출력 : Good
		System.out.println(str3.charAt(0)); //str3에서 0번 문자 출력:H
		System.out.println(str3.charAt(7)); //str3에서 7번 문자 출력:G
		System.out.println(str1.indexOf('a')); // str1 'a'에 해당되는 첫번째 인덱스 : 0
		System.out.println(str3.lastIndexOf('a')); // str3 에서 마지막 'a' 의 위치 : 13
		System.out.println(str4.length()); //str4의 길이(공백포함) : 14
		System.out.println(str4.trim().length());//str4의 앞뒤 공백을 제거한 길이 : 5   (중간 공백은 제거 못한다.)
		System.out.println(str3.startsWith("Have"));//str3 가 Have 로 시작하면 true 아니면 false (ex:배열에서 "김"성을 가진 사람 출력)
		System.out.println(str3.endsWith("day"));//str3가 day로 끝나면 true, 대소문자 구분 :false 
		System.out.println(str1.equals(str2));//str1이 완벽하게 대소문자까지 str2와 같을때 true : false
		System.out.println(str1.equalsIgnoreCase(str2));// 대소문자 상관없이 철자만 같으면 true
		System.out.println(str1.compareTo(str2));//str1 과 str2의 차이(양수값:str1이 더 큰값, 음수값:str2가 더 큰 경우)
		System.out.println(str1.compareTo("apple"));//완전 같을 경우 0가 된다.
		
		
	}

}
