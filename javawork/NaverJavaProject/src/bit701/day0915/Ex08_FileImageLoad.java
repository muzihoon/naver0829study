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

public class Ex08_FileImageLoad extends JFrame{

	JButton btnImageFile;
	Image image;
	String initImage="D:\\naver0829\\work_study\\webwork\\연예인사진\\17.jpg";
	MyCanvas myCanvas = new MyCanvas();

	public Ex08_FileImageLoad(String title)
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


	//캔바스 내부 클래스
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


	private void setDesign() {
		// TODO Auto-generated method stub
		//상단에는 패널안에 버튼 추가후 프레임에 패널 추가
		JPanel p =new JPanel();
		btnImageFile= new JButton("이미지 파일 가져오기");
		p.add(btnImageFile);
		this.add("North",p);
		this.add("Center",myCanvas);


		//사진을 Image 로 변환
		image =new ImageIcon(initImage).getImage();

		this.add("Center",myCanvas);
		
		//1. 제일먼저 간단하고 무식한 방법-비효율
		//2. 좀더 효율적이고 
		
		//파일 버튼 이벤트 - 익명 내부 클래스로 활용
		btnImageFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이미지 파일 가져오기
				FileDialog dlg = new FileDialog(Ex08_FileImageLoad.this,"이미지열기", FileDialog.LOAD);
				dlg.setVisible(true);
				//취소시 종료
				if(dlg.getDirectory()==null)
					return;
				
				//파일 경로와 파일명 가져오기
				initImage=dlg.getDirectory()+dlg.getFile();
				//image 생성
				image=new ImageIcon(initImage).getImage();
				//캔바스의 pint 메소드는 버튼을 누른다고 자동호출 되지 않는다.
				
				//그래서 강제로 호출을 해줘야 한다.
				myCanvas.repaint();
				
				//오늘의 숙제
				//패널을 사용해서 버튼 4개 만들고 FileDialog 안쓰고, 신세경, 음식, 등등 누르면 바로 변경되게. 종류별로 하나씩
				//그런데 동물 사진만 누를경우 1~8까지의 난수를 구해서 랜덤 사진으로 나오게 해보자.
			}
		});
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08_FileImageLoad s=new Ex08_FileImageLoad("이미지 뷰어");
	}
}
