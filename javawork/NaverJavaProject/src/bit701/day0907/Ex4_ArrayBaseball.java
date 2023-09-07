package bit701.day0907;

import java.util.Scanner;

public class Ex4_ArrayBaseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]com= new int[3];
		int[]user= new int[3];
		
		String strNum;
		Scanner sc=new Scanner(System.in);
		int ball, strike;
		
		//1~9사이의 중복되지 않는 숫자를 배열에 담는다.
		for(int i=0; i<com.length;i++)
		{
			com[i] = (int)(Math.random()*9)+1;;
			for(int j=0; j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}//반복끝
		System.out.printf("%d%d%d\n",com[0],com[1],com[2]);
		while(true)
		{
			System.out.print(">>");
			strNum=sc.nextLine();
			//strNum의 각 숫자를 user 배열에 정수 형태로 넣기
			user[0]=strNum.charAt(0); // '1' 은 정수로 49이다(아스키코드표 참조)- : '1' - '0' =1(49-48) 
			user[1]=strNum.charAt(1);
			user[2]=strNum.charAt(2);
			
			//System.out.printf("%d,%d,%d\n",user[0],user[1],user[2]);
			
			//user 와 com을 비교하여 숫자가 있지만 자리수가 안맞을 경우는 ball을 증가 
			//자리수까지 맞을 경우는 strike를 증가 한다.
			//strike 이 3이면 정답이므로 "축하합니다. 정답입니다" 출력 후 종료
			ball = 0;
			strike=0;
			
			//다중 for 문 써야함. 
			for(int i =0; i<com.length; i++)
			{
				System.out.println(user[i]);
				for(int j=0;j<user.length; j++)
				{
					//숫자는 있지만 자리수가 안맞으면 ball
					//숫자가 있는것을 확인하는 방법은 ? 
					//숫자가 같으면 
					if(com[i]==(user[i]-(user[i]-1)))
					{
						ball++;
						
						//자리수도 같으면?
						if(i==j)
						{
							strike++;
						}
					}
					
				}
			}// 포 끝
			
			System.out.printf("스트라이크 : %d\n 볼 : %d\n",strike,ball);
			
			//종료
			if(strNum.equalsIgnoreCase("q")){
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
		
	}
}
