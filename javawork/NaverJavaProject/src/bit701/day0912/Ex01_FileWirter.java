package bit701.day0912;

import java.io.FileWriter;
import java.io.IOException;

public class Ex01_FileWirter {

	static final String FILENAME="D:/naver0829/memo1.txt";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 파일에 개인정보 저장하기
		FileWriter fw=null;
		
		//생성
		fw=new FileWriter(FILENAME); //스트링으로 생성한다. 예외 발생, ctr+1 누르면 처리방법 나온다.
		//memo1.txt 있으면 덮어쓰고 없으면 생성한다.
		
		//파일에 내용 저장하기 - write 여러가지로 오버로딩 되어있는걸 볼 수 있다. String을 선택했다.
		fw.write("이름:카리나\n");
		fw.write("핸드폰:010-2323-4545\n");
		fw.write("------------------------\n");
		
		//파일닫기 - 파일은 무조건 닫아줘야 한다. 
		fw.close(); // 화면이나 콘솔에 나오지는 않는다. 
		System.out.println("탐색기를 열고 momo1.txt 파일을 확인하세요");
		
		//실행결과 
		
	}

}
