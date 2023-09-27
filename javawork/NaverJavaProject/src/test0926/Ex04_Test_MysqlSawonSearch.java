package test0926;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex04_Test_MysqlSawonSearch {

	DbConnect db = new DbConnect();
	
	public void sawonSearch() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//테스트
//		System.out.println("사원의 번호");
//		int num  = Integer.parseInt(sc.nextLine()) ; 
		System.out.println("검색할 이름");
		String name  = sc.nextLine(); 
		
		String sql = "select * from sawon where name like'%"+name+"%'";
		System.out.println(sql);
		//커넥션 연결 객체
		Connection conn = null;
		
		//쿼리문 담을 객체
		Statement stmt = null;
		
		//db 연결
		conn = db.getMysqlConnection();
		
		//메소드 호출
		
		try {
			// 쿼리문을 전달할 객체를 생성 
			stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);
			System.out.println(name+" 검색 결과");
			 
			 int cnt = 0;
			 while(rs.next())
			 {
				 int num = rs.getInt("num");
				 String name1 = rs.getString("name");
				 int score = rs.getInt("score");
				 String gender = rs.getString("gender");
				 String buseo = rs.getString("buseo");
				 
				 System.out.println(++cnt);
				 System.out.println("이름:"+name);
				 System.out.println("성별:"+gender);
				 System.out.println("부서:"+buseo);
				 System.out.println("점수:"+score);
				 System.out.println("-".repeat(20));
			 }
			
		} catch (SQLException e) {
			System.out.println("실패!");
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_Test_MysqlSawonSearch ex = new Ex04_Test_MysqlSawonSearch();
		ex.sawonSearch();
	}


}
