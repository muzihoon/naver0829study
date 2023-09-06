package bit701.day0906;

import java.util.Random;

public class Ex16_MyLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 * 
		 * 6개 할당된 lotto 변수에 1~45 사이의 난수를 
		 * (중복된 경우 다시 발생) 오름차순 정렬로 출력하시오.
		 * 
		 * */ 
		
		//1~45 난수를 생성한다.
		Random r=new Random();
		int []data=new int[6]; 
		
		//배열에 난수 넣기 
		Loop:
		for(int i=0; i<data.length;i++)
		{
			data[i]=r.nextInt(45)+1;
			//중복된 경우에 다시 생성하기
			for(int j=0; j<i;j++)
			{
				if(data[i]==data[j])
				{
					i--;
					continue Loop;
				}
			}
//			System.out.println(data[i]);
		}//포문 끝
		
		//오름차순 정렬 
	
		for(int i=0; i<data.length-1;i++)
		{
			
			for(int j=i;j<data.length;j++)
			{
				if(data[j]<data[i])
				{
					int tmp=data[i];
					data[i]=data[j];
					data[j]=tmp;
				}
			}
		}//반복끝
		for(int n:data)
		System.out.println(n);
	}

}
