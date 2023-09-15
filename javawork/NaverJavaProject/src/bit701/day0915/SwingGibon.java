package bit701.day0915;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGibon extends JFrame{

	public SwingGibon(String title)
	{	//this로 호출했지만 JFrame 가지고 있던것, 그리고 JFrame도 물려받은 것들
		super(title);//JFrame의 문자열을 받는 생성자 호출 
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(300,300);//프레임의 너비, 높이
		this.getContentPane().setBackground(new Color(200,255,180)); // Background만 이렇게 변경한다. -> Color 상수를 이용해 변경
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		this.setVisible(true);//ture:프레임을 보이게 하기, false:프레임 숨기기 / 색 지정 이런건 visible 전에 줘야 적용된다.
		// x 누르면 속성이 false 인거지 닫히는게 아님. 종료는 아래의 콘솔에서 빨간색 정지하고 xx 버튼 눌러야함

		//윈도우 이벤트 발생
		//this.addWindowListener(new WindowLister()) // 이렇게 하면 메서드 8개 다 오버라이드 함. 필요한건 1개지만 



		//윈도우 이벤트 발생 - 익명내부클래스 형태로 이벤트 구현, 좀 길면 따로 클래스 구현해서 사용해도 괜찮다.
		this.addWindowListener(new WindowAdapter() { //이렇게 하면 필요한것 한개만 구현 가능 
			//여기서 클래스를 구현하면 된다. 
			@Override
			public void windowClosing(WindowEvent e) {//x 버튼 클릭시 호출되는 메서드
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다.");
				//실제종료
				System.exit(0);//정상종료
				super.windowClosing(e);
			}

		}); // Listener로 끝나면 거의 인터페이스를 구현하는것 
	}


	private void setDesign() {
		// TODO Auto-generated method stub
		
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon s=new SwingGibon("안녕");
	}

}
