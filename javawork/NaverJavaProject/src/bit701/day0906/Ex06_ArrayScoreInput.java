package bit701.day0906;

import java.util.Scanner;

public class Ex06_ArrayScoreInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
				/*
				 * score 에 5개의 배열 할당 후 키보드로 직접 점수를 입력하여 배열에 저장 후
				 *  총점과 평균을 구하세요
				 */
				
				Scanner sc=new Scanner(System.in);
				//변수 선언
				int []score = new int[5]; //배열 선언
				double avg;//평균
				int sum=0;//총점
				
				//입력
				for(int i=0;i<score.length;i++)
				{
					System.out.println(i+"번 점수입력:");
					score[i]=sc.nextInt();
					//조건 추가 : 0보다 작거나 100보다 크면 "0~100 사이 점수로 입력 바람!" 출력후 다시 입력
					//continue 를 이용해서 작성해보세요. continue 사용하면 i++로 이동합니다.
					
					if(score[i]>100 || score[i]<0)
					{
						i--;
						System.out.println("\t 0~100 사이의 올바른 점수를 입력해주세요");
						
						continue;
					}
					
					sum+=score[i];
				}
				//평균계산
				avg=(double)sum/score.length;
				
				//출력
				System.out.println("입력한 점수들");
				for(int n:score)
					System.out.printf("%5d",n);
				System.out.println("\n총점:"+sum);
				System.out.println("평균:"+avg);
	}

}
