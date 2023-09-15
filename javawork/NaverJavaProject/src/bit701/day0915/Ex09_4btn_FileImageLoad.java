package bit701.day0915;

import java.awt.Canvas;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;import bit701.day0912.EX08_InheriConst;
import bit701.day0915.Ex04_SwingButton.MyColorButton;

public class Ex09_4btn_FileImageLoad extends JFrame{

	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	Image image;
	String initImage="D:\\naver0829\\work_study\\webwork\\연예인사진\\17.jpg";
	
	MyCanvas myCanvas = new MyCanvas();

	public Ex09_4btn_FileImageLoad(String title)
	{	//this로 호출했지만 JFrame 가지고 있던것, 그리고 JFrame도 물려받은 것들
		super(title);//JFrame의 문자열을 받는 생성자 호출 
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(500,600);//프레임의 너비, 높이
		//		this.getContentPane().setBackground(new Color(200,255,180)); // Background만 이렇게 변경한다. -> Color 상수를 이용해 변경

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


	//캔버스 내부 클래스
	class MyCanvas extends Canvas
	{	//처음 시작시 자동호출, 프레임 크기 변경시 자동호출
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);

			//System.out.println(image.getWidth(this));//사진 너비 출력 코드
			if(image.getWidth(this)>=300)
				g.drawImage(image, 60, 10, 370, 450, this);
			else	//300 미만 너비를 가진 이미지는 원래 사이즈대로 출력
				g.drawImage(image, 60, 10, this);
		}
	}
	
	class MyColorButton implements ActionListener
	{
		
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//버튼을 클릭하
			
			
			String foodImage="D:\\naver0829\\work_study\\webwork\\음식사진\\5.jpg";
			String animalImage;
			String carImage="D:\\naver0829\\work_study\\webwork\\mycar\\mycar1.png";
			
			System.out.println(e.getSource());
			if(e.getSource()==btn1)
			{
				image=new ImageIcon(initImage).getImage();
				myCanvas.repaint();
			}else if(e.getSource()==btn3){
				image=new ImageIcon(carImage).getImage();
				myCanvas.repaint();
			}else if(e.getSource()==btn4){
				image=new ImageIcon(foodImage).getImage();
				myCanvas.repaint();
			}else
			{
				int ran=(int)(Math.random()*8)+1;
				animalImage="D:\\naver0829\\work_study\\webwork\\이쁜동물이미지\\C"+ran+".png";
				//image 생성
				image=new ImageIcon(animalImage).getImage();
				myCanvas.repaint();
			}
			
		}
		
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		//상단에는 패널안에 버튼 추가후 프레임에 패널 추가
		
		//여기는 배열로 한번 해볼 수 있다.
		//패널로 추가하는 과정
		JPanel p =new JPanel();
		btn1= new JButton("연예인");
		btn2= new JButton("동물");
		btn3= new JButton("자동차");
		btn4= new JButton("음식");
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		p.add(btn4);
		
		//버튼을 누를때 작동되는 이벤트
		btn1.addActionListener(new MyColorButton());
		btn2.addActionListener(new MyColorButton());
		btn3.addActionListener(new MyColorButton());
		btn4.addActionListener(new MyColorButton());
		
		//버튼을 가진 패널을 프레임 North에 보낸다.
		this.add("North",p);
		this.add("Center",myCanvas);
		
		//사진을 Image 로 변환. 초기 시작시 이미지
		image =new ImageIcon(initImage).getImage();
		
		//this는 거의 최상위 클래스를 지칭한다.
		//this는 화면에서 가져오는거. 여기에 선언되어 있는 클래스를 찾아오는 경우가 대부분이다.
		//super는 상속
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex09_4btn_FileImageLoad s=new Ex09_4btn_FileImageLoad("이미지 뷰어");
	}
}
