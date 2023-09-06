package bit701.day0906;

import java.util.Scanner;

public class Ex08_ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"강호동","유재석","한채영","이효리","이승기"};
		// 이름을 검색하여 몇번째 있는지 출력
		// 없을 경우 "xxx 님은 명단에 없습니다."
		
		Scanner sc=new Scanner(System.in);
		String searchName="";
		boolean bFind=false;
		
		
		//검색할 이름 입력 
		System.out.println("검색할 이름을 입력해 주세요.");
		searchName=sc.nextLine();
		
		//for문 : 같은 이름이 있을 경우, 출력 후 bFind도 true로 변경해야함 -break; 한다. 
		for(int i=0; i<names.length;i++)
		{
			if(names[i].equals(searchName))
			{
				bFind=true;
				System.out.printf("%s님은 %d번째에 있습니다.",searchName,i+1);
				break;
			}
		}
			//bFind 값에 따라 못 찾은 경우 메세지 출력 
			if(!bFind)// if(bFind==false) 라면
			{
				System.out.printf("%s님은 명단에 없습니다.",searchName);
			}
			
	}

}
