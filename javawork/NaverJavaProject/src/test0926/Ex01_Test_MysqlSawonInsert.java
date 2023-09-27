package test0926;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex01_Test_MysqlSawonInsert {

	DbConnect db = new DbConnect();
	
	public void sawonInsert() {
		// TODO Auto-generated method stub
		
		//테스트를 한다
		Scanner sc = new Scanner(System.in);
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("1-100 사이 점수");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("성별");
		String gender = sc.nextLine();
		System.out.println("부서");
		String buseo = sc.nextLine();
		
		String sql = "insert into sawon values (null,'"+name+"','"+score+"','"+gender+"','"+buseo+"')";
//		System.out.println(sql);
		//커넥션 객체 생성
		Connection conn = null;
		//문장 객체 생성
		Statement stmt = null;
		
		
		//커넥션 연결
		conn = db.getMysqlConnection();
		//statement 
		try {
			//stmt 에 쿼리 실행할 메서드 호출 
			stmt = conn.createStatement();
			//실행
			stmt.execute(sql);
			System.out.println("데이터 입력에 성공했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터 입력에 실패했습니다.");
		}finally {
			//닫기
			db.dbClose(stmt, conn);
		}
			
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex01_Test_MysqlSawonInsert ex = new Ex01_Test_MysqlSawonInsert();
		ex.sawonInsert();
	}
	
}
