package bit701.day0911;

import java.util.Scanner;

public class BackApplication2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
						
		Account2 []account=new Account2[3]; //배열의 자리 할당 
		//1번
		Scanner sc=new Scanner(System.in);
				
		int idx=0;
		
		Exit:
		while(true)
		{
			//계좌생성 실행결과
			System.out.println("=".repeat(70));
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("=".repeat(70));
			System.out.println("선택 >");
			int num = Integer.parseInt(sc.nextLine()); // 사용자가 입력한 번호
			
			switch (num) 
			{ 
				case 1:
				{
					if(idx==account.length)
					{
						System.out.print("생성불가\n");
						break;
					}
					System.out.println("---------\n계좌생성\n----------");
					System.out.print("계좌번호>");
					String accountNo=sc.nextLine();
					System.out.print("계좌주>");
					String accountName=sc.nextLine();
					System.out.print("초기입금액>");
					int money = Integer.parseInt(sc.nextLine());
					
					account[idx]=new Account2(accountNo,accountName,money); //배열 선언 
					idx++;
					break;
							
				}//case1 끝
				
				case 2 :
				{
					//accountWrite 매서드로 호출
					for(int i=0;i<idx;i++)
					{
						account[i].accountWrite();
					
					}
					break;
					
				}//2의 끝
				
				
				case 3 :
				{
					//입력

					System.out.println("---------\n예금\n----------");
					System.out.println("계좌번호:");
					String accountNo=sc.nextLine();
					for(int i=0;i<idx;i++)
					{
						if(account[i].isAccount(accountNo))
						{
							System.out.println("예금액:");
							int money=Integer.parseInt(sc.nextLine());
							account[i].addMoney(money);
								System.out.println("예금에 성공했습니다.");
							break;
						}
//						
					}
					break;
					
				}//case3
				
				case 4 :
				{
					//입력

					System.out.println("---------\n출금\n----------");
					System.out.println("계좌번호:");
					String accountNo=sc.nextLine();
					for(int i=0;i<idx;i++)
					{
						if(account[i].isAccount(accountNo))
						{
							System.out.println("출금액:");
							int money=Integer.parseInt(sc.nextLine());
							account[i].subMoney(money);
								System.out.println("출금에 성공했습니다.");
								break;
						}
						
					}
					break;
					
						
					
				}//case4
				
				//종료
				case 5 :
				{
					System.out.println("프로그램 끝");
					break Exit;
					
				}
			}//switch 끝
			
		}//while의 끝
			
	 
	}//메인 끝
}//클래스 끝
