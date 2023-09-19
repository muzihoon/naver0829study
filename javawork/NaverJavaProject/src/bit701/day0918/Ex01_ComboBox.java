package bit701.day0918;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex01_ComboBox extends JFrame{
	
	JPanel p = new JPanel();// 다른 메서드에서 사용하게 하려고 
	JComboBox<String> combo;
	JRadioButton rbYellow,rbMagenta,rbGray,rbBlue;
	JLabel lblMessage;
	
	
	public Ex01_ComboBox(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		//상속받은건 this로 접근가능
		this.setBounds(1000, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료해주는 메서드
		this.setDesign();
		this.setVisible(true);// 모든 컴포넌트는 visible 되기전에 넣어야 한다.
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		Vector<String> list = new Vector();
		list.add("빨강");
		list.add("초록");
		list.add("분홍");
		list.add("오렌지");
		
		//콤보박스 생성
		combo=new JComboBox<String>(list);
		//상단에 추가
//		this.add("North",combo);// 상단 전체에 추가
		JPanel pTop= new JPanel();
		pTop.add(combo);
		this.add("North",pTop);
		
		//p 패널에 라벨 추가
		lblMessage=new JLabel("Have a Nice Day!!");
		lblMessage.setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
		p.add(lblMessage);
		
		//Center 에는 JPanel p를 추가
		p.setBackground(Color.red);
		this.add("Center",p);
		
		//콤보박스 이벤트  // ItemListener 이거 자동완성 하면 익명 내부 클래스 형태로 오버라이딩 된다. 안드로이드도 이렇게 만든다.
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//선택한 문자열을 얻어보자
				String selectColor=(String)combo.getSelectedItem();
//				System.out.println(selectColor);
				//jdk8부터 switch 에서 String 도 가능 
				switch(selectColor)
				{
				
				case "빨강":
					p.setBackground(Color.red);
					break;
				case "분홍":
					p.setBackground(Color.pink);
					break;
				case "오렌지":
					p.setBackground(Color.orange);
					break;
				case "초록":
					p.setBackground(Color.green);
					break;
					
				}
			}
		});
		
		//하단에 4개의 라디오 버튼 추가하기- 버튼 그룹에 추가
		ButtonGroup bg = new ButtonGroup();
		rbYellow=new JRadioButton("노랑");
		rbBlue=new JRadioButton("파랑");
		rbMagenta=new JRadioButton("핫핑크");
		rbGray=new JRadioButton("회색");
		
		bg.add(rbYellow);
		bg.add(rbBlue);
		bg.add(rbMagenta);
		bg.add(rbGray);
		
		//4개의 라디오 버튼을 일단 패널에 묶어서 넣은 후 프레임에 추가하기 - 패널에 추가 
		JPanel pBottom = new JPanel();
		pBottom.add(rbBlue);
		pBottom.add(rbYellow);
		pBottom.add(rbGray);
		pBottom.add(rbMagenta);
		
		this.add("South",pBottom);
		
		
		//글자색 변경 이벤트 (배열이 아니므로 각각 이벤트 추가)
		rbYellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.yellow);
			}
		});
		rbMagenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.magenta);
			}
		});
		rbGray.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.gray);
			}
		});
		rbBlue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.BLUE);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_ComboBox ex = new Ex01_ComboBox("ComboBox");
	}

}
