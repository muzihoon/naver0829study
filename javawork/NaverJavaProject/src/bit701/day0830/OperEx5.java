package bit701.day0830;

public class OperEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//증감 연산자 : ++(1씩 증가),--(1씩 감소)
		//변수 앞에 붙일 경우 (전치) 1순위
		//변수 뒤에 붙일 경우 (후치) 끝 순위
		//단, 단항으로 사용할 경우 상관없다. = 1개만 있으니까 앞뒤 상관없다는 말
		
		int a=5;
		int b=5;
		//단항으로 연산할 경우
		++a;
		++b;
		System.out.println(a);//1증가
		System.out.println(b);//1증가
		System.out.println(++a);//먼저 증가 후 출력 :7
		System.out.println(b++);//먼저 출력 후 증가 :6 실제 메모리는 :7
		System.out.println("a="+a+",b="+b);//7,7
		
		a=b=5;
		int m=++a;//증가 후 대입
		int n=b++;//대입 후 증가
		System.out.printf("a=%d,b=%d,n=%d,n=%d\n",a,b,m,n);//6,6,6,5
	}

}
