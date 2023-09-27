package bit701.day0926;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DbConnect;

public class Ex02_SawonSwingCRUD2 extends JFrame{
	JTextField tfName,tfScore;
	JComboBox<String> cbGender,cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearch, btnAll;

	// 추가 : 데이터 추가
	// 삭제 : 테이블 클릭시 데이터 삭제
	// 조회 : 부서명 입력받아 해당 부서만 출력
	// 전체조회 : 다시 전체 데이터 조회

	DbConnect db = new DbConnect();

	public Ex02_SawonSwingCRUD2() 
	{
		super("사원관리");
		this.setBounds(1000,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	private void setDesign() {
		// TODO Auto-generated method stub

		//상단
		tfName = new JTextField(4);
		tfScore = new JTextField(4);
		String[] cbTitle = {"남자","여자"};
		String[] cbBu = {"홍보부","특수부","인사부","교육부","운영","비서실"};
		cbGender = new JComboBox<String>(cbTitle);
		cbBuseo = new JComboBox<String>(cbBu);

		//패널에 버튼을 추가
		JPanel pTop = new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("점수"));
		pTop.add(tfScore);
		pTop.add(new JLabel("성별"));
		pTop.add(cbGender);
		pTop.add(new JLabel("부서"));
		pTop.add(cbBuseo);

		this.add("North",pTop);

		//하단
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSearch = new JButton("조회");
		btnAll = new JButton("전체조회");

		//패널에 만든 버튼 추가
		JPanel pBottom = new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		

		this.add("South",pBottom);

		//Center Table
		String[] title = {"번호","이름","점수","성별","부서"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		//초기 db 데이터 가져오기
		sawonSelectAll();

		//버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//데이터를 가져온다
				String name = tfName.getText();
				
				String gender = (String)cbGender.getSelectedItem();
				String buseo = (String)cbBuseo.getSelectedItem();
				//이름이나 전화번호 입력 안했을 경우 종료
				if(name.length()==0)
				{
					JOptionPane.showMessageDialog(Ex02_SawonSwingCRUD2.this, "이름을 입력해주세요");
					return;
				}
				
				int score = 0;
				try {
					score = Integer.parseInt(tfScore.getText());
				} catch (NumberFormatException e1) {
					score=0; // 점수에 문자를 넣으면 그냥 0점으로
				}
				
				if(score<0 || score>100)
				{
					JOptionPane.showMessageDialog(Ex02_SawonSwingCRUD2.this, "점수는 0-100 사이의 값으로 입력해주세요");
					return;
				}
				
				
				//db에 insert 하는 메서드 호출
				insertSawon(name, score, gender, buseo);
				//db로 부터 다시 데이터를 가져와서 출력
				sawonSelectAll();
				//입력값 초기화
				tfName.setText("");
				tfScore.setText("");


			}
		});
		
		//삭제
		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				//선택한 행번호를 얻는다
				int row = table.getSelectedRow();
				System.out.println(row); // 선택안하면 -1
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex02_SawonSwingCRUD2.this,"삭제할 행을 선택해주세요");
				}else {
					//row행의 0번열이 num 값
					String num = table.getValueAt(row, 0).toString(); //getValueAt 반환타입이 Object라서 
					deleteSawon(num);
					//삭제후 데이터를 다시 불러온다
					sawonSelectAll();

				}


			}
		});
		
		//조회
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//검색할 이름 입력받기
				String searchName = JOptionPane.showInputDialog("검색할 부서명을 입력해주세요");
				System.out.println(searchName);
				if(searchName == null)
					return ; // 취소 누를 경우 이벤트 종료
				else
					searchSawon(searchName);//이름이 포함된 모든 데이터 테이블에 출력
			}
		});
		
		//전체조회
		btnAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sawonSelectAll();
			}
		});

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_SawonSwingCRUD2 ex = new Ex02_SawonSwingCRUD2();


	}


	//db에 추가
	public void insertSawon(String name, int score, String gender, String buseo)
	{
		//확인
		//		System.out.println(name);
		//		System.out.println(gender);
		//		System.out.println(score);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into sawon values (null,?,?,?,?)";
		//컬럼 안쓰면 순서대로 넣어야 한다.
		
		//커넥션, 프리페어드, sql , sql을 pstmt에 , 바인딩, 실행, 닫기 
		//

		try {
			pstmt = conn.prepareStatement(sql);
			// ? 3개 바인딩 
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);

			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//db 삭제하는 메서드
	public void deleteSawon(String num)
	{	
		//스트링으로 받는이유. Object를 int로 변환하려면 String으로 바꾸고 다시int로 해야함 
		//System.out.println(num); //확인완료

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from sawon where num = ?";


		try {
			pstmt = conn.prepareStatement(sql);
			//? 바인딩 1개
			pstmt.setString(1, num);

			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("삭제할 학생이 존재하지 않아요");
			else
				System.out.println( n+"명 학생정보 삭제 완료!");

			//실행
			pstmt.execute();
			System.out.println("데이터 삭제 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	public void searchSawon(String searchName) {
		// TODO Auto-generated method stub
		//이름이 포함된 모든 데이터 테이블에 출력한다.

		//기존 테이블의 데이타를 모두 지운다
		tableModel.setRowCount(0);

		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from sawon where buseo like ?";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+searchName+"%");
			rs=pstmt.executeQuery();

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");



				//Vector 에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

				//테이블에 추가
				tableModel.addRow(data);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	//db method
	//db 에서 전체 데이터를 가져와서 테이블에 출력하는 메서드

	public void sawonSelectAll()
	{
		//기존 테이블의 데이터를 모두 지운다.
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon order by num desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next())
			{	//모델이 가진게 정확하게 Vector를 원한다.
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");


				//Vector에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

				//테이블에 추가
				tableModel.addRow(data);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}


}
