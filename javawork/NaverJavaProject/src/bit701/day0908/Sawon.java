package bit701.day0908;

public class Sawon { 
	//이 변수들은 여기 클래스에서만 호출이 가능하다. 다른 클래스에서 호출이 안된다.
	 private String sawonNo;
	 private String name;
	 private int age;
	
	
	 //변수가 static이면 setter는 static 메서드로 만들어야한다. -> static 변수는 
	 
	//각각의 getter와 setter를 만들어보자
	// setter method 
	public void setSawonNo(String sawonNo) 
	{
		this.sawonNo=sawonNo;
	}
	
	public  void setName(String name)
	{
		this.name=name;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	//getter 메서드
	
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getSawonNo(){
		return sawonNo;
	}
	
}
