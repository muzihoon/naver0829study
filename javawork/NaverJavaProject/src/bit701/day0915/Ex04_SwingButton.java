package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex04_SwingButton extends JFrame{
	JButton btn1,btn2,btn3;

	public Ex04_SwingButton(String title)
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

	//버튼 이벤트를 이번에는 내부클래스로 만들어보자.
	class MyColorButton implements ActionListener
	{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getSource());
			if(e.getSource()==btn1)
				Ex04_SwingButton.this.getContentPane().setBackground(Color.orange);
			else 
				Ex04_SwingButton.this.getContentPane().setBackground(Color.magenta);
				
		}
		
	}
	private void setDesign() {
		// TODO Auto-generated method stub
		// 자바에서 제공하는 레이아웃을 안쓰고 직접 위치지정을 할 경우
		this.setLayout(null);
		
		//버튼 1 생성 
		btn1=new JButton("오렌지색");
		btn1.setBounds(20, 50, 100, 50); //x,y,width,height
		this.add(btn1);
		
		//버튼 2 생성 
		btn2=new JButton("분홍색");
		btn2.setBounds(130, 50, 100, 50); //x,y,width,height
		this.add(btn2);
		
		//버튼 1,2는 내부클래스 MyColorButton 의 이벤트를 호출해보자
		btn1.addActionListener(new MyColorButton());
		btn2.addActionListener(new MyColorButton());
		
		//btn3 생성
		btn3 =new JButton("버튼 글자& 배경색 변경");
		btn3.setBounds(40,130,180,50);
		this.add(btn3);
		
		//btn3은 익명 내부클래스 형태로 생성 
		//가장 많이 쓰는 방법중 하나, 대신 버튼마다 모두 코드가 다르게 된다.
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn1.setBackground(Color.green);
				btn1.setForeground(Color.red);
				
				btn2.setBackground(Color.pink);
				btn2.setForeground(Color.blue);
				
				btn3.setBackground(Color.black);
				btn3.setForeground(Color.yellow);
				
			}
		});
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_SwingButton s=new Ex04_SwingButton("안녕");
	}

}
