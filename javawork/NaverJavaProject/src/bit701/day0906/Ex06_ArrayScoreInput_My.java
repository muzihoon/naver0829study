package bit701.day0906;

import java.util.Scanner;

public class Ex06_ArrayScoreInput_My {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * score 에 5개의 배열 할당 후 키보드로 직접 점수를 입력하여 배열에 저장 후
		 *  총점과 평균을 구하세요
		 */
		
		Scanner sc=new Scanner(System.in);
		int []arr1 = new int[5]; //배열 선언
		
		int sum=0;//총점
		double avg=0;//평균
		int count=0;
		
		while(true) {
			System.out.println("점수를 입력하세요");
			int score = Integer.parseInt(sc.nextLine());
			
			
			for(int i=0;i<arr1.length;i++)
			{
				arr1[i]=sc.nextInt();
				sum+=arr1[i];
				++count;
			}
			//평균 계산하기
			if(count==arr1.length)
				break;
		}
		
		avg=(double)sum/arr1.length;
		System.out.println("총점 수갯수:"+arr1.length);
		System.out.println("총점"+sum);
		System.out.println("평균"+avg);
	}

}
