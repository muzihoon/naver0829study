package bit701.day0913;


//interface 는 기능구현을 할 메서드들의 목록을 나열해놓는 일을 한다.
//interface 에는 상수와 추상메서드만 구현이 가능하다 
//그래서 구분을 할 필요가 없기 때문에 final , abstract 단어는 안쓴다. 
//어차피 100% 상수와 추상 메서드로만 구성이 되어있기 때문이다. 
//interface 도 new로 생성할 수 없다.

interface InterA
{
	int SCORE=100;// final 상수임
	public void play(); //abstract 메서드임
	public void study(); 
}


//일반 클래스가 interface 를 구현할 경우 implements 로 구현
//인터페이스를 구현한 경우 반드시 모든 메서드를 오버라이드 해야만 한다
class My implements InterA
{
	int myscore=SCORE;

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("SCORE="+SCORE);//상수 출력 
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		//SCORE=90; //오류발생, FINAL 상수는 변경할 수 없음
		myscore=80;
		System.out.println("점수 변경함:"+myscore);
	}

	//My 클래스만이 가지고 있는 메서드
	public void processMy()
	{
		System.out.println("My 클래스가 단독으로 처리하는 작업");
	}

}
public class Ex05_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA a=new My();
		a.play();
		a.study();
		//a.processyMy();//오류발생- 오버라이드 메서드가 아니므로 My로 선언시에만 호출 가능
		System.out.println("--------------------------");
		My b=new My();
		b.play();
		b.study();
		b.processMy();
	}

}
