package bit701.day0901;

import java.util.Scanner;

public class EX06_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		/*
		 *  구구단을 출력할 시작단 입력
		 *  4
		 *  구구단을 출력할 끝 단 입력
		 *  6
		 *  
		 *     4단    5단     6단  - 단일 for문으로 돌린다
		 *    4x1=4  5x1=5   6x1=6	- 다중 for 문 1이 바깥 포문 4~6이 안쪽 for문 
		 *    4x2=8  5x2=10  6x2=12
		 *  
		 */
		
		
//		//구구단을 출력할 시작단과 끝단을 입력한다.
//		//선언
//		System.out.println("시작단을 입력해주세요");
//		int dan1=sc.nextInt();
//		System.out.println("끝단을 입력해주세요");
//		int dan2=sc.nextInt();
//		
//		//계산
//		if(dan1<2|| dan1>9 && dan2<2|| dan2>9)
//		{
//			System.out.println("잘못된 숫자입니다");
//			return;
//		}
//		System.out.println("\t**"+dan1+"단 **\n");
//		
//		for(int i=dan1;i<=dan2;i++)
//		{
//			for(int j=1;j<=9;j++ )
//			{
//				
//				System.out.printf("%8d X %d = %2d\n",i,j,i*j);
//			}
//			
//		}
		
		System.out.println("구구단을 출력할 시작단 입력");
		int start=sc.nextInt();
		
		System.out.println("구구단을 출력할 끝단 입력");
		int end=sc.nextInt();
		
		//start 가 end 보다 클 경우 두 변수의 값을 바꿔보자
		if(start>end) {
			int tmp = start;
			start = end;
			end = tmp; 
		}
		
		//제목 출력
		for(int dan=start;dan<=end;dan++)
		{
			System.out.printf("%7d단",dan);
		}
		System.out.println("\n");
		
		
		for(int i=1;i<=9;i++)
		{
			for(int dan=start;dan<=end;dan++)
			{
				System.out.printf("%5dx%d=%2d",dan,i,dan*i);
			}
			System.out.println();
		}
		
		
		
		
	}//메인끝

}
