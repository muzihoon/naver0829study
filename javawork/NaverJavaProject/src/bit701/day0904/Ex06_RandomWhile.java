package bit701.day0904;

import java.util.Scanner;

public class Ex06_RandomWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int rnd,count,num;
		
		Exit:
		while(true)
		{
			
			rnd=(int)(Math.random()*100)+1;
			count=0;
			
			while(true)
			{
				System.out.print(++count+":");
//				num=sc.nextInt(); // 스캐너 수업 첫번째 시간 - 숫자 입력후 문자열을 입력받는 경우 입력안되는 현상 발생
				num=Integer.parseInt(sc.nextLine());
				if(num>rnd)
					System.out.println("\t"+num+"보다 작습니다.");
				else if(num<rnd)
					System.out.println("\t"+num+"보다 큽니다.");
				else {
					System.out.println("\t ** 정답입니다.("+rnd+")");
					// 계속할지 묻는다.
					System.out.println("계속하려면 y를 입력해 주세요. (y가 아닐경우 종료)");
					String ans=sc.nextLine();
					if(ans.equalsIgnoreCase("y"))
					{
						System.out.println("새로운 난수를 발생하겠습니다.");
						continue Exit;// 바깥쪽 while 문의 조건식으로 이동한다.
					}
					else {
						break Exit;// 두개의 while문을 모두 빠져나간다.
					}
				}
				
			}//2중 while 끝
			
			
		}//첫번째 while 끝
		
		System.out.println("*** 프로그램 종료 ***");
		
	}

}
