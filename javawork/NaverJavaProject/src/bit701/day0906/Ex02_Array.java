package bit701.day0906;

public class Ex02_Array {
	public static void main(String[] args) {
	//배열 선언시 초기값을 지정하는 경우 
		int []arr= {5,8,10,4,20}; //자바스크립트 배열은 [], 객체의 기호가 {} 다. 혼동할 수 있으니 잘 알아두자
		System.out.println("arr 의 할당 갯수:"+arr.length);
		
		// 출력 방법 1 
		System.out.println("*** 출력1 ***");
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
		
		//출력 방법 2
		System.out.println();
		System.out.println("*** 출력2 ***");
		for(int n : arr)
		{
			System.out.println(n);
		}
		
		//출력 방법 3
		System.out.println();
		System.out.println("*** 출력3 ***");
		System.out.println("=".repeat(30));
		int[]arr2;
		
		arr2=new int[] {3,6,8,10,30};// 선언을 한 후 나중에 값을 한꺼번에 지정할 경우
		for(int i=0; i<arr2.length;i++)
			System.out.printf("[%2d:%2d]",i,arr2[i]);
		System.out.println();
		for(int n:arr2)
			System.out.printf("%3d",n);
		System.out.println();
	}
}
