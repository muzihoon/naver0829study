package bit701.day0913;

interface RemoteControl
{
	//상수
	final int MAX_VOLUME=10;
	final int MIN_VOLUME=0;
	
	//추상 메서드
	void turnOn();
	void TurnOff();
	void setVolume(int volume);
	
	//jdk8 에서 추가된 기능
	//디폴트 인스턴스 메서드 - 인터페이스임에도 기능 구현 가능하다. 바로 호출 할 수 있는건 아님, 구현은 해야함 오버라이드 안해도 호출가능
	default void setMute(boolean mute)
	{
		if(mute) 
		{
			System.out.println("무음 처리 합니다.");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음 해제 합니다.");
		}
	}
}

class Televesion implements RemoteControl
{
	private int volume;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV 를 켭니다!");
	}

	@Override
	public void TurnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV 를 끕니다!");
	
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		
		if(volume>RemoteControl.MAX_VOLUME)
		{
			this.volume=RemoteControl.MAX_VOLUME;
		}else if(volume<MIN_VOLUME)
		{
			this.volume=MIN_VOLUME;
		}else
		{
//			System.out.println("2 작동완료");
			this.volume=volume;
		}
		System.out.println("현재 볼륨은 "+this.volume+"입니다."); //여기서 volume 하면 내가 넣은거만 나온다.this.volume으로 해야함
	}
	
}

public class Ex13_Book348 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc=null;
		rc=new Televesion();
		rc.turnOn();
		rc.TurnOff();
		rc.setVolume(-11);
		//디폴트 매서드 호출
		rc.setMute(false);
		rc.setMute(true);

//		RemoteControl rc2=null;//인터페이스라 생성할 수 없다.
//		rc2.setMute(false);// 에러발생, 반드시 구현하는 클래스가 있어야만 호출이 가능하다.
	}

}
