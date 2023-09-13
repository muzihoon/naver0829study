package bit701.day0913;

abstract class AbstEx1
{
	int a =100;
	final String str="abstract test";//상수
	public String getStr()
	{
		return str;
	}
	
	//추상메서드 추가 - 미완성 메서드
	abstract public int getA();
}

abstract class AbstEx2 extends AbstEx1
{
	@Override
	public int getA() {
		// TODO Auto-generated method stub
		return a;
	}
	//새로운 추상메서드를 추가 하는 순간
	abstract public void show();
}

 class AbstEx3 extends AbstEx2
{
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("마지막 기능구현한 클래스");
	}
}

public class Ex04_InheriAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AbstEx1 ex1=new AbstEx1();//오류발생 -abstract 클래스는 객체 생성을 할 수 없다.
		
//		AbstEx1 ex1=new AbstEx2();
//		System.out.println("a="+ex1.getA());
//		System.out.println("str="+ex1.getStr());
		
		AbstEx3 ex3=new AbstEx3();
		System.out.println("a="+ex3.getA());
		System.out.println("str="+ex3.getStr());
//		System.out.println("show="+ex3.show()); // void 타입이라서 이렇게 하면 안된다고 한다.
		ex3.show();
		
		System.out.println();
		AbstEx1 ex4=new AbstEx3();
		System.out.println("a="+ex4.getA());
		System.out.println("str="+ex4.getStr());
//		ex4.show();//오류발생 : show()는 AbstEx2에서 선언이 되어있다.
	}

}
