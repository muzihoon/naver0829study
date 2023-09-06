package bit701.day0906;

public class Ex03_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다양한 타입으로 배열에 저장해보자.
		char []arr1= {'A','p','p','l','e'};
		double []arr2;
		arr2=new double[] {1.7,8.9,3.4};
		String []arr3=new String[3];
		arr3[0]="사과";
		arr3[1]="오렌지";
		arr3[2]="딸기";
		
		System.out.println("*** arr1 출력 ***");
		//옆으로 애플이 나오도록 출력해봐라
		// 출력 방법 1로 해봐라
		for(int i=0; i<arr1.length;i++)
		{
			System.out.print(arr1[i]);
		}
		
		System.out.println("\n*** arr2 출력 ***");
		for(int i=0; i<arr2.length;i++)
		{
			System.out.print(arr2[i]+"\t");
		}
		
		System.out.println("\n*** arr3 출력 ***");
		for(int i=0; i<arr3.length;i++)
			System.out.println(arr3[i]);
		
		//출력 방법 2로 해봐라
		System.out.println("=".repeat(30));
		System.out.println("*** arr1 출력 ***");
		for(char n : arr1)
			System.out.print(n);
		
		System.out.println("\n*** arr2 출력 ***");
		for(double d : arr2)
			System.out.print(d+"\t");
		
		System.out.println("\n*** arr3 출력 ***");
		for(String s:arr3)
			System.out.println(s);
	}

}
