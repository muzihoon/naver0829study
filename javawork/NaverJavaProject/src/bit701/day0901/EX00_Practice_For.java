package bit701.day0901;

import java.text.NumberFormat;
import java.util.Scanner;

public class EX00_Practice_For {

	public static void main(String[] args) {
		/*
		 *  구구단을 출력할 시작단 입력
		 *  4
		 *  구구단을 출력할 끝 단 입력
		 *  6
		 *  
		 *  시작단이 끝단보다 적으면 둘을 바꾼다.
		 *  
		 *     4단    5단     6단  - 단일 for문으로 돌린다
		 *    4x1=4  5x1=5   6x1=6	- 다중 for 문 1이 바깥 포문 4~6이 안쪽 for문 
		 *    4x2=8  5x2=10  6x2=12
		 *  
		 */
		//스캐너
		Scanner sc=new Scanner(System.in);
		//입력을 받는다
		System.out.println("시작단을 입력하세요");
		int start=sc.nextInt();
		System.out.println("끝단을 입력하세요");
		int end=sc.nextInt();
		
		//만약 시작단이 끝단보다 크면 둘을 바꾼다.
		int tmp = 0;
		if(start>end)
		{
			tmp=start;
			start=end;
			end=tmp;
		}
		
		//제목을 출력한다.
		for(int dan=start; dan<=end; dan++)
			System.out.printf("\t% d단",dan);
			System.out.println();
		//구구단을 출력한다.
		//2x1=2  3x1=3  4x1=4  5x1=5
		for(int i=1; i<=9; i++)
		{
			for(int dan=start; dan<=end; dan++)
			{
				System.out.printf("\t%dx%d=%d",dan,i,dan*i);
			}
				System.out.println();
		}
	}
}
