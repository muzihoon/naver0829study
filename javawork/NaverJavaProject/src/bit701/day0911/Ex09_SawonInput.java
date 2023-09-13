package bit701.day0911;

import java.util.Scanner;

public class Ex09_SawonInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int sawon;
		Sawon []sa=new Sawon[3];
		//입력할 인원수를 입력한후 배열 할당
//		System.out.println("정보를 입력할 인원수는?");
//		sawon=Integer.parseInt(sc.nextLine());
		
		//3명의 사원에 대한 정보 입력후 배열 생성하기
//		sa=new Sawon[sawon];
		
		//할당할 갯수만큼 데이타 입력
		for(int i=0;i<3;i++)
		{
			System.out.println(i+"번 사원명");
			String name=sc.nextLine();
			System.out.println("\t기본급은?");
			int gibon=Integer.parseInt(sc.nextLine());
			System.out.println("\t수당은??");
			int sudang=Integer.parseInt(sc.nextLine());
			System.out.println("\t가족수는??");
			int familySu=Integer.parseInt(sc.nextLine());
			
			
			//객체 생성
			sa[i]=new Sawon(name,gibon,sudang,familySu);
		}
		
		//출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(70));
		for(Sawon s:sa)
		{
			System.out.println(s.getName()+"\t"+s.getGibon()+"\t"+s.getSudang()+"\t"+s.getfamilySu()+"\t"+s.getFamilySudang()+"\t\t"+s.getTax()+"\t"+s.getNetPay());
		}
	}

}
