package bit701.day0906;

import java.util.Scanner;

public class Ex12_MyArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"강호동","유재석","한채영","이효리","이승기",
				"강남길","이민정","이서진","손미나","유미리"};
		/*
		 * 검색할 성은? 이
		 * 				4:이효리
		 * 				5:이승기
		 * 				7:이민정
		 * 				8:이서진
		 * 					총 4명
		 * 
		 * 검색할 성은? 박
		 * '박' 씨 성을 가진 멤버는 없습니다.
		 * 
		 * 검색할 성은? 끝
		 * 종료합니다
		 * 
		 * 변수 : String searchSung
		 * 			int count;
		 * 			boolean bFind;
		 * 
		 * startsWith 이용해서 프로그램 작성해보세요. 
		 * 
		 * 
		 */
		
		//변수 선언
		
		Scanner sc=new Scanner(System.in);
		
		String searchSung="";
		int count;
		boolean bFind;
		
		//입력
		while(true)
		{
			//입력을 받는다.
			System.out.println();
			System.out.println("검색할 성은?");
			searchSung=sc.nextLine();
			
			
			count=0;
			
			//검색한다.
				for(int i=0;i<names.length;i++)
				{
					//names의 인덱스 하나마다 대조해서 찾아본다.
					bFind=names[i].startsWith(searchSung);
					
						
					if(searchSung.equals("끝"))
					{
						System.out.println("검색을 종료합니다.");
						break;
					}
					
					//있으면 ? 출력 
					if(bFind==true)
					{
						System.out.println("\t"+i+":"+names[i]);
						
						++count;
					}
					
				}//for 끝
				//없으면 ? 없다고 출력
				if(count==0)
				System.out.printf("%s씨성을 가진 사람이 없습니다",searchSung);
				
					System.out.printf("\n총%d명\n",count);
		}
		//찾기
		
		//출력
	}

}
