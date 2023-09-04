package bit701.day0904;

import java.util.Scanner;

public class Ex05_RandomWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 * 1~100 사이의 난수 발생 후 숫자 알아맞추기 
		 * 
		 * 65가 발생시 
		 *  1:60
		 *    60보다 크다
		 *  2:70
		 *     70보다 작습니다.
		 *     .
		 *     .
		 *     .
		 *  5:65
		 *  정답입니다(65) - 맞출경우 종료 
		 * */
		
		Scanner sc=new Scanner(System.in);
		
		//1~100 사이의 난수 발생
		int rnd=(int)(Math.random()*100)+1;
		//회수를 구할 변수
		int count=0;
		//입력 받을 변수
		int num;
		
		while(true)//몇번에 맞출지 모르니까
		{
			System.out.print(++count+":");
			num=sc.nextInt();
			if(num>rnd)
				System.out.println("\t"+num+"보다 작습니다.");
			else if(num<rnd)
				System.out.println("\t"+num+"보다 큽니다.");
			else {
				System.out.println("\t"+num+"정답 입니다.("+rnd+")");
				break;
				
			}
		}//반복문 끝
		System.out.println("*** 프로그램 종료 ***");
	}

}
