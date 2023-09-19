package bit701.day0918;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex02_Table extends JFrame{
	
		JTable table1;
		
		JTable table2;
	
	
	
		public Ex02_Table(String title) {
			// TODO Auto-generated constructor stub
			super(title);
			//상속받은건 this로 접근가능
			this.setBounds(1000, 100, 300, 400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료해주는 메서드
			this.setDesign();
			this.setVisible(true);
		}
		
		private void setDesign() {
			// TODO Auto-generated method stub
			
			//table 2개를 넣기 위해서 2행1열로 레이아웃을 변경한다.
			this.setLayout(new GridLayout(2,1));
			
			//table1 생성
			//table1=new JTable(5, 4);
			
			//제목과 3개의 빈행을 추가하고자 할 경우(Model 을 이용)
			DefaultTableModel model =new DefaultTableModel(new String[] {"이름","나이","주소"},3);
			
			//직접 배열로 줄때는 앞에 배열 타입을 반드시 선언해줘야 한다.
			table1=new JTable(model);
			
			
			//this.add(table1);// 제목이 안나오는 이유
			this.add(new JScrollPane(table1));//scroll이 가능하도록 만들어줘야 제목도 나온다.
			
			//table 2에는 데이터를 넣어보자
			String[][]data = {
					{"강부자","56","강남구"},
					{"이순재","67","여의도"},
					{"신구","57","제주도"},
			};
			
			table2=new JTable(data,new String[] {"이름","나이","주소"});
			this.add(new JScrollPane(table2));
			
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Ex02_Table ex = new Ex02_Table("JTable");
		}

	}


