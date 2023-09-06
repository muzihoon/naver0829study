package bit701.day0906;

import java.util.Scanner;

public class Ex11_ArrayRankInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 
		 *  총 4명의 이름과 점수를 입력하면 이름과 점수 등수를 
		 *  출력하는 프로그램을 작성하시오
		 *  단, 점수가 0~100 을 벗어날 경우 다시 입력하시오.
		 *  
		 *  예 :
		 *  		0번 이름 : 송혜고
		 *  		0번 점수 : 99
		 *  
		 *  *  		1번 이름 : 강하동
		 *  		1번 점수 : 120
		 *  				다시 입력하세요
		 *  		1번 이름 : 강하동
		 *  		1번 점수 : 60
		 *  
		 *  		번호 이름  점수 등수 
		 *  		-------------------
		 *  		  1	 강호동 99
		 *  
		 *  */ 
		//변수 선언
		Scanner sc=new Scanner(System.in);
		String []names=new String[4];
		int []score = new int[4];
		int []rank = new int[4];
		
		
		//입력 
		for(int i=0;i<names.length;i++)
		{
			System.out.println(i+"번 이름:");
			names[i] =sc.nextLine();
			System.out.println(i+"번 점수:");
			score[i] =Integer.parseInt(sc.nextLine());
			
			if(score[i]<0 || score[i]>100)
			{
				System.out.println("\t다시 입력바람");
				i--;
				continue;
			}
			System.out.println();
		}
		//등수 구하기
		for(int i=0; i<score.length;i++)
		{
			rank[i]=1;
			for(int j=0; j<score.length;j++)
			{
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		
		//출력 부
		System.out.println("번호\t 이름\t 점수\t 등수");
		System.out.println("-".repeat(30));
		for(int i=0; i<score.length;i++)
		{
			System.out.println(i+1+"\t"+names[i]+"\t"+score[i]+"\t"+rank[i]);
			
		}
	}

}
