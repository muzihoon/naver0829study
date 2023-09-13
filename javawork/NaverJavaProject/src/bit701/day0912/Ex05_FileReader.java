package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import bit701.day0911.Account;

public class Ex05_FileReader {

	static final String SUNGJUK_FILE="D:\\naver0829/sungjuk.txt";
	Sungjuk []sung=new Sungjuk[20];
	int count;

	public Ex05_FileReader() throws IOException {
		//파일 읽어서 sung 배열에 담기 (줄단위로 읽은후 , 로 분리해서 넣기)
		//파일을 읽어온다.
		//변수를 이곳에 선언하는 이유는  try,catch,final. 부분에서도 사용할 수 있게 하기 위해
		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(SUNGJUK_FILE);
			br=new BufferedReader(fr);

			count=0;
			while(true)
			{

				//파일의 내용을 한줄씩 읽는다.
				String line=br.readLine();
				//더이상 읽을 내용이 없을 경우 while문을 종료한다. 
				if(line==null)
				{
					break;
				}
				//null 이 아닐경우 
				String []data=line.split(",");  //분리자를 적으면 된다. 분리해서 배열에 담는다.
				String name=data[0]; //0번 인덱스에는 이름을
				int kor=Integer.parseInt(data[1]); // 1번 인덱스에는 kor
				int eng=Integer.parseInt(data[2]); // 2번 인덱스에는 eng 을 저장한다.

				//Sungjuk 클래스 생성 - count 번지
				sung[count]=new Sungjuk(name, kor, eng);
				count++;

			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			//해당 파일이 없을경우 실행하는 영역
			System.out.println("파일이 없습니다");
		}

	}

	public void dataList()
	{
		//출력 - 배열에 담겨있는것을 출력만 하면 된다.
		//이름 국어 영어 총점 평균
		System.out.println("총 "+count+"명");
		System.out.println("이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(50));
		for(int i=0;i<count;i++)
		{
			Sungjuk s=sung[i];
			int tot=s.getKor()+s.getEng();
			double avg=tot/2.0;
			System.out.println(s.getName()+"\t"+s.getKor()+"\t"+s.getEng()+"\t"+tot+"\t"+avg);
		}
}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex05_FileReader ex=new Ex05_FileReader();
		ex.dataList();
	}

}
