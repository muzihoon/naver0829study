package bit701.day0912;

class SuperB
{
	protected void processA()
	{
		System.out.println("부모가 가진 메서드A");
	}
}

class SubB extends SuperB
{
	@Override //어노테이션
	protected void processA() {  //부모가 가지고 있으면 pro 자동완성 하면 나온다. 
		// TODO Auto-generated method stub
		super.processA();//부모가 먼저 작업을 하고 
		System.out.println("자식이 가진 오버라이드메서드");//나머지는 자식 클래스에서 작업을 완성을 하겠다. 이런뜻임
	}
	
	public void processB() 
	{
		System.out.println("자식만이 갖고 있는 메서드 B");
	}
	
}
//////////////////////
public class Ex07_InheriOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubB sub1=new SubB();
		sub1.processA();
		
		SuperB sub2=new SubB();
		sub2.processA();// 오버라이드가 된 상태면 자식이 가진 메서드가 호출된다.
//		sub2.processB();// 오버라이드 된거 아니라서 선언을 자식으로 해야한다. 
		
		//다형성의 기본 원리 - 오버라이드 된것만 호출이 된다.
		//선언은 부모클래스로, 생성은 자식클래스로
		//processB는 호출할 수 없다.
		//왜? 자식이 가진것중 오버라이드 된거만 호출이 가능하다.
		
		SubB sub3=new SubB();
		sub3.processB();
	}

}
