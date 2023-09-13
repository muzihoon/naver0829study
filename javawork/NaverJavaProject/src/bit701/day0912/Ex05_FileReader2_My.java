package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import bit701.day0911.Account;

public class Ex05_FileReader2_My {

	static final String SUNGJUK_FILE="D:\\naver0829/sungjuk2.txt";
	Sungjuk []sung=new Sungjuk[20];
	int count;

	public Ex05_FileReader2_My() throws IOException   
	{
		//파일 읽어서 sung 배열에 담기 (줄단위로 읽은후 , 로 분리해서 넣기)
		FileReader fr=null;
		BufferedReader br=null;

			fr= new FileReader(SUNGJUK_FILE);
			br= new BufferedReader(fr);
			count=0;

			while(true)
			{
				String line = br.readLine();	
				//null인지 확인 
				if(line==null)
					break;
				//배열에 이름 국어 영어 따로 저장

				String data[]= line.split(","); //배열 1,2,3, 생성된다.
				String name=data[0];
				int kor = Integer.parseInt(data[1]);
				int eng = Integer.parseInt(data[2]);

				//배열에 담은것을 생성자 호출로 선언
				sung[count]=new Sungjuk(name,kor,eng);
				count++;
			}//while 끝
		br.close();
		fr.close();


	}// 메서드 끝






	public void dataList()
	{
		//출력 - 배열에 담겨있는것을 출력만 하면 된다.
		//이름 국어 영어 총점 평균
		System.out.println("총 "+count+"명");
		System.out.println("이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(50));
		for(int i=0;i<count;i++)
		{
			//배열에 담긴걸 출력하는 
			Sungjuk s=sung[i];
			int total=s.getEng()+s.getKor();
			double avg=total/2.0;
			System.out.println(s.getName()+"\t"+s.getKor()+"\t"+s.getEng()+"\t"+total+"\t"+avg);

		}


	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex05_FileReader2_My ex=new Ex05_FileReader2_My();
		ex.dataList();
	}

}
