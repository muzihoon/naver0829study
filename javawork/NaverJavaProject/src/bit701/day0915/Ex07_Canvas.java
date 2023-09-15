package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex07_Canvas extends JFrame{ //Canvas는 JFrame이 있어야 하는데 자바는 다중상속이 안되니 내부 클래스를 쓴다.
	//캔바스 멤버변수로 선언
	MyCanvas myCanvas=new MyCanvas();
	
	
	public Ex07_Canvas(String title)
	{	//this로 호출했지만 JFrame 가지고 있던것, 그리고 JFrame도 물려받은 것들
		super(title);//JFrame의 문자열을 받는 생성자 호출 
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(500,500);//프레임의 너비, 높이
		//this.getContentPane().setBackground(new Color(200,255,180)); // Background만 이렇게 변경한다. -> Color 상수를 이용해 변경
		
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

	//캔바스 내부 클래스 - 기능을 가진 멤버 변수 처럼 사용한다.
	class MyCanvas extends Canvas
	{
		String imageIcon1="D:\\naver0829\\work_study\\webwork\\이쁜동물이미지\\C7.png";
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			//원그리기
			g.setColor(new Color(255, 100, 255));
			g.drawOval(50, 50, 100, 100);
			
			//채워진 원
			g.setColor(Color.orange);
			g.fillOval(200, 50, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(Color.green);
			g.drawRect(50,200, 100, 100);
			
			//채워진 사각형
			g.setColor(Color.pink);
			g.fillRect(200, 200, 100, 100);
			
			Image image1=new ImageIcon(imageIcon1).getImage();
			//이미지 그리기
			g.drawImage(image1, 300, 220, this);
			
			//크기변경해서 출력
			g.drawImage(image1, 300, 30, 100, 100, this);
		}
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.add(myCanvas,"Center");
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex07_Canvas s=new Ex07_Canvas("캔바스");
	}
}
