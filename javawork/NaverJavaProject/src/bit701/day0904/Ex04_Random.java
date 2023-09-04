package bit701.day0904;

import java.util.Random;

public class Ex04_Random {
	public static void main(String[] args) {
		
		Random r=new Random();
		for(int i=0; i<5; i++)
		{
			int n=r.nextInt(10); // 0~9 사이의 난수 발생
			System.out.println(n);
		}
		System.out.println("=".repeat(30));
		
		for(int i=0; i<5; i++)
		{
			int n=r.nextInt(100)+1; // 1~100 사이의 난수 발생
			System.out.println(n);
		}
		System.out.println("=".repeat(30));
		
		for(int i=0; i<5; i++)
		{
			int n=r.nextInt(26)+65; // 대문자 나오게 하는 방법 65~90
			System.out.println((char)n);
		}
		System.out.println("=".repeat(30));
		
		
		
	}
}
