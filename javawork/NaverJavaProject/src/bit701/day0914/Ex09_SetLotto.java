package bit701.day0914;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex09_SetLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//금액을 입력하면 그 금액만큼 로또숫자를 출력하기
		
		Scanner sc=new Scanner(System.in);
		int money;
		System.out.println("로또를 구입할 금액을 입력하세요");
		try {
			money=Integer.parseInt(sc.nextLine());
			
			if(money<1000)
			{
				System.out.println("금액이 부족합니다.");
				return;
			}
			
			for(int i=1;i<=money/1000;i++)
			{
				Set<Integer> setLotto =new TreeSet<Integer>();//순서대로 정렬되서 들어간다.
				
				//6개의 난수를 구한다.
				
				while(true)
				{	
					int n=(int)(Math.random()*45)+1;
					setLotto.add(n);
					if(setLotto.size()==6)
						break;
				}
				System.out.printf("%2d 회:",i);//앞에 회수 출력
				for(Integer n:setLotto)
				{
					System.out.printf("%3d",n); // 숫자 출력
				}
				System.out.println();
			}
			
		}catch (NumberFormatException e) {
			System.out.println("금액은 숫자로만 입력해주세요:"+e.getMessage());//어떤 금액이 실수로 들어갔는지 알 수 있다.
		}
				
	}

}
