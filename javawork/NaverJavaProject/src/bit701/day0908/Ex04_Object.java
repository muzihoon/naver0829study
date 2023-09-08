package bit701.day0908;

public class Ex04_Object {
	
	//인스턴스 멤버 변수 - 객체 생성을 통해 접근 할 수 있다.
	private int score;
	
	//클래스 멤버 변수 - 객체 생성없이 클래스를 통해 접근 할 수 있다.
	static public String message;
	
	//인스턴스 멤버 메서드 
	//score 에 값을 넣는 메서드(setter method)
	public void setScore(int score) // setter 메서드 생성 규칙 set+대문자
	{
		//this 일반 메서드는 무조건 있다.
		//멤버변수 score에 인자로 받은 score를 전달
		//매개변수명이 멤버변수명이랑 같을경우 멤버변수앞에 this를 붙이면 된다.
		this.score=score;
	}
	
	
	//점수를 반환하는 getter method
	public int getScore()
	{
		return score;//this.score에서 this가 생략 가능
	}
	
	
	//static 메서드는 static 멤버변수만 접근 가능
	public static void setMessage(String message)
	{
		Ex04_Object.message=message;
	}
	
	
	
	//메인 메서드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//static 메서드는 this가 없다. 왜 ? 어차피 접근 가능하니까.
		//main 메서드는 static 이므로 new로 생성을 해야 멤버 접근이 가능하다.
		//단 static은 호출 가능 
		
		Ex04_Object.setMessage("Hello World!!");
		//public 이므로 바로 출력 가능
		System.out.println(Ex04_Object.message);
		
		//static이 아닌 것을 생성하지 못하는건 this가 없어서 ?/ 
		Ex04_Object ex4=new Ex04_Object();
		ex4.setScore(89);
		System.out.println("점수 :"+ex4.getScore()); // 같은 클래스 안에 score가 멤버로 있으니까 호출가능. 같은 클래스에선 접근 제어자 의미가 없음.
		
	}

}
