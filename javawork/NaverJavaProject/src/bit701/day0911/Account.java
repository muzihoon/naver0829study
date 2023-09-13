package bit701.day0911;
// 교재 클래스 부분 20번 문제
public class Account {

	private String accountNo; // 계좌번호
	private String accountName; // 계좌주
	private int money;// 잔액

	//3개의 값을 전달 받는 생성자 만들기 
	public Account(String accountNo, String accountName, int money)
	{
		this.accountNo=accountNo;
		this.accountName=accountName;
		this.money=money;
	}
	//계좌번호가 맞을 경우 true를 반환해주는 메서드 
	// isAccount(String accountNo) : 맞을경우 true 반환, 틀릴경우 false 반환
	public boolean isAccount(String accountNo)
	{
		if(this.accountNo.equals(accountNo))
		{
			return true;
		}
		else
			return false;
	}

	//외부에서 입금시 money에 추가하는 메서드(addMoney)
	public int addMoney(int addMoney)
	{
		this.money+=addMoney;
		return money;
	}
	//외부에서 출금시 money에서 감소하는 메서드(subMoney)
	public int subMoney(int subMoney)
	{
		this.money-=subMoney;
		return money;
	}

	//출력해주는 메서드   계좌번호  예금주  잔액 (accountWrite)-+
	public void accountWrite() 
	{
		System.out.println("\t계좌번호\t예금주\t잔액");
		System.out.println("\t"+accountNo+"\t\t"+accountName+"\t"+money);
		System.out.println("=".repeat(50));
	}

	//getter 메서드 생성 - source 에서 자동으로 생성하기.
	public String getAccountNo() {
		return accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public int getMoney() {
		return money;
	}

}
