package bit701.day0906;

public class Ex05_ArrayMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]data;
		data=new int[] {5,-100,130,89,-211,-9,123,58,110};
		int max,min;
		System.out.println(data.length);
		
		//1번째 방법
		//최대값, 최소값 구하기
		max=data[0];// 첫번째 데이타를 최대값에 저장한다.
		min=data[0];// 첫번째 데이타를 최소값에 저장한다.
		//2번째 부터 끝까지 비교해서 더 큰 값이 나오면 max 값을 변경한다.
		for(int i=1;i<data.length;i++)
		{
			if(max<data[i])
				max=data[i];
		}
		System.out.println("max="+max);
		//2번째 부터 끝까지 비교, 더 작은 값이 나오면 min 값 변경
		for(int i=1;i<data.length;i++)
		{
			if(min>data[i])
				min=data[i];
		}
		System.out.println("min="+min);
		
//		//2번째 방법
//		
//		for(int n : data)
//		{
//			if(max<data)
//				max=data;
//		}
	}

}
