package bit701.day0913;
//익명 내부 클래스 (Anonymous Inner Class)

abstract class AnonySuper
{
	abstract public void show();
	abstract public void play();
}

interface BitInter
{
	public void study();
	public void draw();
}

class AnonyClass 
{
	//어디에서 클래스라는 이름이 나오지 않는다. 그러나 익명 내부 클래스임
	//이 형태가 바로 익명 내부 클래스 형태이다. 탐색기에서 보면 외부클래스명 $1 이런식으로 class 이름이 만들어져있다.
	
	//상속받지 않고 바로 호출하고 싶다.
	AnonySuper anony = new AnonySuper() {
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("오늘은 N-Time 날");
		}
		
		@Override
		public void play() {
			// TODO Auto-generated method stub
			System.out.println("노는날 아닙니다 !!");
		}
	};
	
	//interface BitInter 를 익명 내부 클래스 형태로 구현하여 메인에서 호출해보세요.
	
	BitInter bit = new BitInter() {
		
		@Override
		public void study() {
			// TODO Auto-generated method stub
			System.out.println("비트캠프에서 공부를 합니다.");
			
		}
		
		@Override
		public void draw() {
			// TODO Auto-generated method stub
			System.out.println("그림을 그립니다.");
		}
	};
	
}

public class Ex14_AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonyClass a =new AnonyClass();
		a.anony.show();
		a.anony.play();
		
		a.bit.study();
		a.bit.draw();
		
	}

}
