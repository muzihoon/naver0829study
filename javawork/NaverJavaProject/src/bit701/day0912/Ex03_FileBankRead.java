package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bit701.day0911.Account;

public class Ex03_FileBankRead {

	public static final String BANK_FILE="D:/naver0829/bank.txt";
	Account []account = new Account[30]; // 배열할당
	int count;

	public Ex03_FileBankRead() throws IOException 
	{
		//파일에서 데이터를 읽어서 배열 account에 넣기
		count=0;//초기값- 데이타를 담을 배열 번지
		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(BANK_FILE);
			br=new BufferedReader(fr);

			while(true)
			{
				String accountNo=br.readLine();//예외를 던지면 자신을 호출한 곳으로 던져진다.
				if(accountNo==null) // 더이상 읽어올 데이터가  없으면 루프를 종료한다.
					break;
				String accountName=br.readLine();
				int money= Integer.parseInt(br.readLine());

				//count  번지의 배열에 담는다.
				account[count]=new Account(accountNo,accountName,money);
				count++;

			}
			System.out.println("총"+count+"개의 계좌를 읽음");
		} catch (FileNotFoundException e) {
			//해당 파일이 없을경우 실행하는 영역
			System.out.println("파일이 없습니다");
		}

		// 지역변수라 소멸되서 닫지 않는다. 멤버 변수라면 반드시 닫아야 한다. 
	}

	public static void showTitle()
	{
		System.out.println("-".repeat(20));
		System.out.println("  계좌 목록  ");
		System.out.println("-".repeat(20));
		System.out.println();
		System.out.println("계좌번호\t계좌명\t잔액");
		System.out.println("-".repeat(30));
	}

	public void accountList()
	{
		//카운트보다 작을때까지, 배열을 출력해야 한다. 
		//6개의 계좌를 읽었다. 이것을 출력해라. 
		showTitle();//제목 출력  일반 메서드에서 static 메서드를 호출가능. 반대로 static 메서드에서 일반 메서드 호출 불가능. 같은 static만 호출 가능. 
		//this가 없기 때문에
		for(int i=0; i<count;i++)
		{
			account[i].accountWrite();
		}
	}

	//입금시 호출될 메서드
	public void depositMoney(String accountNo, int money) 
	{
		//같은 계좌번호를 찾아서 입금을 한다.
		boolean find=false;
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
		if(find)
			System.out.println(accountNo+"계좌에"+money+ "원을 입금했어요");
		//입금에 실패할 경우 성공 메세지 출력
		else
			System.out.println(accountNo+"계좌가 없네요!!!");
	}

	//출금시 호출될 메서드
	public void withdrawMoney(String accountNo, int money) 
	{
		//같은 계좌번호를 찾아서 출금한다.
		boolean find=false;
		for(int i=0; i<count;i++)
		{
			if(account[i].isAccount(accountNo))
			{
				find = true;
				account[i].subMoney(money);
				break;
			}
		}
	}

	//계좌추가시 호출될 메서드
	public void addAccount(String accountNo, String accountName, int money)
	{
		//계좌과 꽉 차서 생성할 수 없을때.
		if(count==account.length)
		{
			System.out.println("이미 계좌가 찼어요. 삭제후 다시 추가하세요");
			return;//메서드가 여기서 종료됨
		}

		//같은 계좌가 있는지 일단 파악하기
		boolean find=false;
		for(int i=0; i<count;i++)
		{
			if(account[i].isAccount(accountNo))
			{
				find=true;
				break;
			}
		}
		//같은 계좌가 있다는 사실을 메세지로 출력
		if(find)
			System.out.println(accountNo+"계좌는 이미 존재합니다.");
		else 
		{
			//없다면 ? 생성자를 통해 데이터 전달 - 계좌 추가 성공 메세지 전달. 
			//count 번지의 생성자를 통해서 데이터를 전달한다. 아직 count의 이전까지만 되어있다.

			account[count]=new Account(accountNo, accountName, money);
			count++; 
			System.out.println(accountNo+"계좌를 추가했습니다.");
		}
	}

	//종료시 배열의 내용을 파일에 저장할 메서드
	public void accountFileSave() throws IOException 
	{
		//종료시 파일에 내용을 덮어쓴다.
		FileWriter fw=null;
		fw=new FileWriter(BANK_FILE);
		for(int i=0;i<count;i++) // count 이전에만 저장해야 한다.  
		{
			fw.write(account[i].getAccountName()+"\n");
			fw.write(account[i].getAccountNo()+"\n");
			fw.write(account[i].getMoney()+"\n");
		}
		//메세지 출력
		System.out.println("배열의 계좌정보를 파일에 저장했습니다!");
		//파일 닫기
		fw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex03_FileBankRead ex=new Ex03_FileBankRead();//생성자 호출- 파일읽기


		//		showTitle();//제목 같은 클래스라서 앞에 생략 가능 
		//		ex.accountList();//계좌 목록 출력

		Scanner sc=new Scanner(System.in);

		// while 문으로 반복한다.
		Exit:
			while(true)
			{
				System.out.println("1.계좌추가 2.입금 3.출금 4.저장&종료");
				System.out.print("선택>");
				int num=Integer.parseInt(sc.nextLine());
				switch (num) {
				//계좌 추가하기
				case 1: {
					//추가할 계좌정보 입력하기
					System.out.println("추가할 계좌번호는?");
					String accounNo=sc.nextLine();
					System.out.println("예금주명");
					String accounName=sc.nextLine();
					System.out.println("초기 입금액은?");
					int money=Integer.parseInt(sc.nextLine());

					//추가할 메서드 호출
					ex.addAccount(accounNo, accounName, money);
					//목록 다시한번 호출
					ex.accountList();
					break;
				}
				//입금하기
				case 2: { // 입금
					System.out.println("입금할 계좌 번호는 ?");
					String accountNo=sc.nextLine();
					System.out.print("입금할 금액은?");
					int money = Integer.parseInt(sc.nextLine());
					//입금 처리할 멤버 메서드 호출
					ex.depositMoney(accountNo, money);
					//계좌 목록 출력
					ex.accountList();

					break;
				}
				//출금하기
				case 3: {
					// 출금
					System.out.println("출금할 계좌 번호는 ?");
					String accountNo=sc.nextLine();
					System.out.print("출금할 금액은?");
					int money = Integer.parseInt(sc.nextLine());
					//출금 처리할 멤버 메서드 호출
					ex.withdrawMoney(accountNo, money);
					//계좌 목록 출력
					ex.accountList();

					break;
				}

				//그외 종료하기
				default:
					ex.accountFileSave();//배열내용을 파일에 저장하기
					System.out.println("파일 저장후 종료합니다.");
					break Exit ; //while 문을 빠져나갑니다.
				}//스위치 끝
			}//while 끝

	}//메인 끝
}//클래스끝
