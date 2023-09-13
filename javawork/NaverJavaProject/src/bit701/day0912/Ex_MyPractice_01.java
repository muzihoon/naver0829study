package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bit701.day0911.Account;

public class Ex_MyPractice_01{

	public static final String BANK_FILE="D:/naver0829/bank.txt";
	Account []account = new Account[30]; // 배열할당
	int count;

	public Ex_MyPractice_01() throws IOException 
	{
		count=0;//초기값- 데이타를 담을 배열 번지
		FileReader fr=null;
		BufferedReader br=null;

		//파일에서 데이터를 읽어서 배열 account에 넣기

		try {
			fr= new FileReader(BANK_FILE);
			br=new BufferedReader(fr);

			while(true)
			{
				// 더이상 읽어올 데이터가  없으면 루프를 종료한다.
				String accountNo=br.readLine();
				if(accountNo==null)
					break;

				//한줄씩 읽어온다.
				String accountName=br.readLine();
				int money=Integer.parseInt(br.readLine()) ;

				//읽은 걸 생성자로 전달. 
				account[count]= new Account(accountNo,accountName,money);
				count++;
			}
			System.out.println("총"+count+"개의 계좌를 읽음");
		} catch (FileNotFoundException e) {
			System.out.println("읽어올 파일이 없습니다.");
		}
	}

	public static void showTitle()
	{
		System.out.println("-".repeat(20));
		System.out.println("  계좌 목록  ");
		System.out.println("-".repeat(20));
		System.out.println();
		System.out.println("\t계좌번호\t계좌명\t잔액");
		System.out.println("-".repeat(30));
	}

	public void accountList()
	{
		//카운트보다 작을때까지, 배열을 출력해야 한다. 
		showTitle();
		for(int i=0; i<count; i++)
		{
			account[i].accountWrite();;
		}



	}

	//입금시 호출될 메서드
	public void depositMoney(String accountNo, int money) 
	{
		//계좌번호가 맞는지 확인
		boolean find=false;
		//같은 계좌번호를 찾아서 입금을 한다.
		for(int i=0; i<count;i++)
		{
			if(account[i].isAccount(accountNo))
			{
				find=true;
				account[i].addMoney(money);
				break;
			}

		}
		//입금에 성공할 경우 성공 메세지 출력
		if(find=true)
		{
			System.out.println("입금을 완료했습니다.");
			return;
		}
		//입금에 실패할 경우 성공 메세지 출력
		System.out.println("입금에 실패했습니다.");
		return;

	}

	//출금시 호출될 메서드
	public void withdrawMoney(String accountNo, int money) 
	{

		boolean find = false;

		//같은 계좌번호를 찾아서 출금한다.
		for(int i=0;i<count;i++)
		{
			if(account[i].isAccount(accountNo))
			{
				account[i].subMoney(money);
				find=true;
				break;
			}
		}

		//출금에 성공할 경우 성공 메세지 출력
		if(find==true)
		{
			System.out.println("출금에 성공하였습니다.");
		}
		else//출금에 실패할 경우 성공 메세지 출력
			System.out.println("출금에 실패하였습니다.");

	}

	//계좌추가시 호출될 메서드
	public void addAccount(String accountNo, String accountName, int money)
	{
		//계좌과 꽉 차서 생성할 수 없을때.
		if(count==account.length)
		{
			System.out.println("계좌 생성불가");
			return;
		}

		boolean find=false;
		//같은 계좌가 있는지 일단 파악하기
		for(int i=0;i<count;i++)
		{
			if(account[i].isAccount(accountNo))
			{
				find=true;
				return;
			}
		}
		if(find)
			
			System.out.println(accountNo+"계좌는 이미 존재합니다.");
		
		else
		{
			account[count]=new Account(accountNo,accountName,money);
			count++;
			System.out.println(accountNo+"계좌추가 성공");
//				break;
		}
		

	}//계좌추가 끝

	//종료시 배열의 내용을 파일에 저장할 메서드
	public void accountFileSave() throws IOException 
	{
		//종료시 파일에 내용을 덮어쓴다.

		//저장 성공 메세지 출력

		//파일 닫기

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//생성자 호출- 파일읽기
		Ex_MyPractice_01 ex = new Ex_MyPractice_01();


		//				showTitle();//제목 같은 클래스라서 앞에 생략 가능 
		//		ex.accountList();//계좌 목록 출력

		Scanner sc=new Scanner(System.in);

		//		 while 문으로 반복한다.
		Exit:
			while(true)
			{
				ex.accountList();//계좌 목록 출력
				System.out.println("1.계좌추가 2.입금 3.출금 4.저장&종료");
				System.out.print("선택>");
				int num=Integer.parseInt(sc.nextLine());
				switch (num) {
				//계좌 추가하기
				case 1: {
					//추가할 계좌정보 입력하기
					System.out.println("계좌번호 입력>");
					String accountNo=sc.nextLine();
					System.out.println("예금주 이름 입력>");
					String accountName=sc.nextLine();
					System.out.println("예금액 입력>");
					int money=Integer.parseInt(sc.nextLine());

					//추가할 메서드 호출
					ex.addAccount(accountNo, accountName, money);
					//목록 다시한번 호출
					ex.accountList();

					break;
				}
				//입금하기
				case 2: { // 입금
					System.out.println("계좌번호>");
					String accountNo=sc.nextLine();
					System.out.println("입금 금액>");
					int money=Integer.parseInt(sc.nextLine());
					//입금 처리할 멤버 메서드 호출
					ex.depositMoney(accountNo, money);
					//계좌 목록 출력
					showTitle();
					break;

				}
				//출금하기
				case 3: {
					System.out.println("계좌번호>");
					String accountNo=sc.nextLine();
					System.out.println("출금 금액>");
					int money=Integer.parseInt(sc.nextLine());
					//입금 처리할 멤버 메서드 호출
					ex.withdrawMoney(accountNo, money);
					//계좌 목록 출력
					showTitle();
					break;


				}

				//그외 종료하기
				default:
					//					배열내용을 파일에 저장하기
					//					while 문을 빠져나갑니다.
				}//스위치 끝
			}//while 끝

	}//메인 끝
}//클래스끝
