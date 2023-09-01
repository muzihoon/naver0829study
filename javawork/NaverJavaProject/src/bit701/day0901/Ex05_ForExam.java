package bit701.day0901;

import java.util.Scanner;

public class Ex05_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		/*
		 * 1. 숫자 n 을 입력 받은후 1부터 n 까지의 총 합계를 출력하시오.
		 * 
		 * 
		 * 2. 구구단 숫자 2~9 사이의 숫자를 입력 받은 후 범위를 벗어날 경우 "잘못 입력하여 종료합니다" 출력 후 종료 제대로 입력시 해당
		 * 구구단 출력
		 * 
		 * ** 5단 **
		 * 5 x 1 = 5
		 * 5 x 2 = 10
		 * '
		 * '
		 * 5 x 9 = 45
		 * 
		 * 
		 */
				
			
		Scanner sc=new Scanner(System.in);

		// 구구단 구하기
		
		int dan;
		System.out.println("출력할 구구단은?");
		dan=sc.nextInt();
		if(dan<2|| dan>9)
		{
			System.out.println("잘못된 숫자입니다");
			return;
		}
		System.out.println("\t**"+dan+"단 **\n");
		
		for(int i=1;i<=9;i++)
		{
			System.out.printf("%8d X %d = %2d\n",dan,i,dan*i);
		}
		
		
	}

}
