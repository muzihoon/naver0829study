package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex02_FileReader {
	static final String FILENAME="D:/naver0829/memo1.txt";
	public static void main(String[] args) throws IOException
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME); // 줄 단위로 읽는 멤버 메서드가 없다. 그래서 2차 생성을 하겠다->BufferedReader 
			br=new BufferedReader(fr); //타입이 Reader 타입으로 되어있는데 모든 종류를 다 읽을 수 있다.
			
			//br.readLine()이 한줄씩 읽는다. 그런데 더이상 읽을 내용이 없을경우 null 값을 반환.
			//대부분 2줄 이상이고 몇줄이 저장된지 모르니까 while 문으로 읽는다. 
			while(true)
			{
				//파일의 내용을 한줄씩 읽는다.
				String line=br.readLine();
				//더이상 읽을 내용이 없을 경우 while문을 종료한다. 
				if(line==null)
				{
					break;
				}
				System.out.println(line);//append? 쓰고 \n해야함  콘솔에 추가하는걸 area에 추가하는거로 하면 된다.
			}
			
			
		} catch (FileNotFoundException e) {
			// 해당 파일이 없을 경우 예외가 발생하며 catch 영역이 실행된다.
			System.out.println("해당 파일을 찾을 수 없어요:"+e.getMessage());
		}
		
		//열려있는 자원들을 열려진 역순으로 닫는다.
		br.close();
		fr.close();
		
	}
}
