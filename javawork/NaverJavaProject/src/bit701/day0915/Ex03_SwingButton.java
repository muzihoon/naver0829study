package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex03_SwingButton extends JFrame implements ActionListener{
	JButton btn1,btn2;

	@Override  // 소스에서 overiedImplement 누르고 받아왔음.
	public void actionPerformed(ActionEvent e) { //순차적으로 발생하지 않음, 이벤트가 발생할때 호출된다.
		// TODO Auto-generated method stub
		if(e.getSource()==btn1)
		{
			System.out.println("버튼 1 클릭");
			this.getContentPane().setBackground(Color.black);
		}
		else
		{
			System.out.println("버튼 2 클릭");
			this.getContentPane().setBackground(Color.white);
		}
	}


	public Ex03_SwingButton(String title)
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
		btn1=new JButton("버튼 #1");//버튼 생성 
		//프레임 추가 -> this가 frame 상속 받았으니까.
		this.add(btn1,"South");//BoarderLayout(기본)인 경우는 위치를 지정해야함, North,South,East,West,Center
		
		//버튼 2는 North에 추가해보자
		btn2 = new JButton("버튼 #2");
		this.add(btn2,"North");
		
		//버튼 1,2에 이벤트가 발생되도록 추가해보자
		btn1.addActionListener(this); //()안의 this는 이벤트 메서드가 구현된 클래스의 인스턴스를 넣으면 된다. 
		btn2.addActionListener(this); //둘다 같은 이벤트 메서드가 호출된다.
		//지금은 현재 클래스를 구현했으니까 this, 외부 클래스면 new로 그 클래스.
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex03_SwingButton s =new Ex03_SwingButton("버튼");
	}

}
