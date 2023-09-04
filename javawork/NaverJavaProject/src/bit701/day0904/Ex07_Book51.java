package bit701.day0904;

public class Ex07_Book51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//json 데이타 {"키":"값"}
		String jdata="{\"name\":\"이진\"}"; // \"문자\" 형식으로 하는것 같
		System.out.println(jdata);
		
		String jdat5="{\"name\":\"영훈\",\"age\":\"32\"}";
		System.out.println(jdat5);
		//jdk13 에서 추가된 텍스트 블록 문법 """
		String jdata2=
				"""
{"name":"캔디","address","역삼동"}
				
				""";
		
		System.out.println(jdata2);
		
		String name="마이클 잭슨";
		int age=32;
		String jdata3="{\"name\":\""+name+"\",\"age\":"+age+"}";
		System.out.println(jdata3);
		
		//텍스트 블록 문법에 변수값을 넣는 방법. jdk 13에서 추가된 방법 
		String jdata4="""
{"name":"%s","age":%d}
				""".formatted(name,age);
		System.out.println(jdata4);
		
			String str1="red\nblue\ngreen"; //\n으로 줄바꿈 하고있다.
			System.out.println(str1);
			
			String str2="""
					
					red
					blue
					green
					pink
					""";
		System.out.println(str2);
	}//메인끝

}
