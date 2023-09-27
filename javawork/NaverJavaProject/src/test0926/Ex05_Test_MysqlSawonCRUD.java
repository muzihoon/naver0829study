package test0926;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex05_Test_MysqlSawonCRUD {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	public int getMenu() {
		// TODO Auto-generated method stub
		int menu = 0;
		System.out.println("1.추가 2.삭제 3.수정 4.전체조회 5.종료");
		menu = Integer.parseInt(sc.nextLine());

		return menu;
	}

	private void sawonUpdate() {
		// TODO Auto-generated method stub
		//테스트
		System.out.println("사원의 번호");
		//				String num  = sc.nextLine() ; //이렇게 해도 가능 자동 형변환,
		int num  = Integer.parseInt(sc.nextLine()) ; 
		System.out.println("수정할 이름");
		String name  = sc.nextLine(); 
		System.out.println("수정할 점수");
		int score  = Integer.parseInt(sc.nextLine()) ; 
		//				int score  = Integer.parseInt(sc.nextLine()) ; 
		System.out.println("수정할 부서");
		String buseo  = sc.nextLine(); 

		String sql = "update sawon set name = ?, score = ?, buseo = ? where num = ? " ;
		//				System.out.println(sql);
		//커넥션 연결 객체
		Connection conn = null;
		//쿼리문 담을 객체
		PreparedStatement pstmt = null;
		//DB 연결 메서드 호출
		conn = db.getMysqlConnection();

		//연결 후 쿼리 메서드 호출 
		try {
			pstmt = conn.prepareStatement(sql);

			//바인딩
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, buseo);
			pstmt.setInt(4, num);

			//실행 & 결과값 int로 반환
			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("수정 실패");
			else
				System.out.println(n+":수정 성공!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	private void sawonSelectAll() {
		// TODO Auto-generated method stub
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon";
		int cnt = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			// DB에서 담아온 데이터를 rs에 담는다.
			rs = pstmt.executeQuery();


			while(rs.next())
			{
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");

				++cnt;
				System.out.println("번호:"+num);
				System.out.println("이름:"+name);
				System.out.println("성별:"+gender);
				System.out.println("부서:"+buseo);
				System.out.println("점수:"+score);
				System.out.println("-".repeat(20));
			}

		} catch (SQLException e) {
			System.out.println("실패!");
		}finally {
			db.dbClose(pstmt, conn);
			System.out.println(cnt+"총 인원");
		}


	}

	private void sawonDelete() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 번호");
		int num = Integer.parseInt(sc.nextLine());

		String sql = "delete from sawon where num = ?";

		//테스트
		//		System.out.println(sql);

		//객체 생성
		Connection conn = null;
		PreparedStatement pstmt = null;

		//DB연결
		conn = db.getMysqlConnection();

		//생성한 객체와 커넥션 연결
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setInt(1, num);
			//실행
			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("삭제 실패");
			else
				System.out.println("삭제 성공");
		} catch (SQLException e) {
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	private void sawonInsert() {
		// TODO Auto-generated method stub

		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("1-100 사이 점수");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("성별");
		String gender = sc.nextLine();
		System.out.println("부서");
		String buseo = sc.nextLine();

		String sql = "insert into sawon (name,score,gender,buseo) values (?,?,?,?)";

		//테스트
		//		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null; 

		conn = db.getMysqlConnection();

		try {
			pstmt = conn.prepareStatement(sql);

			//바인딩 필요 

			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);

			//실행
			pstmt.execute();
			System.out.println("데이터 추가 완료!");
		} catch (SQLException e) {
			System.out.println("추가 실패");
		}finally {
			db.dbClose(pstmt, conn);
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_Test_MysqlSawonCRUD ex = new Ex05_Test_MysqlSawonCRUD();

		while(true)
		{
			int menu = ex.getMenu();
			switch(menu)
			{
			case 1 :
				ex.sawonInsert();
				break;
			case 2 :
				ex.sawonDelete();
				break;
			case 3 :
				ex.sawonUpdate();
				break;
			case 4 :
				ex.sawonSelectAll();
				break;
			default :
				System.out.println("시스템 종료");
				System.exit(0);//시스템 종료
			}
		}
	}



}
