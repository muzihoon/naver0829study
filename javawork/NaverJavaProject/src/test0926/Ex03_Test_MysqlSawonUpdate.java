package test0926;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex03_Test_MysqlSawonUpdate {

	DbConnect db = new DbConnect();
	
	public void sawonUpdate() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//테스트
		System.out.println("사원의 번호");
//		String num  = sc.nextLine() ; //이렇게 해도 가능 자동 형변환,
		int num  = Integer.parseInt(sc.nextLine()) ; 
		System.out.println("수정할 이름");
		String name  = sc.nextLine(); 
		System.out.println("수정할 점수");
		int score  = Integer.parseInt(sc.nextLine()) ; 
//		int score  = Integer.parseInt(sc.nextLine()) ; 
		System.out.println("수정할 부서");
		String buseo  = sc.nextLine(); 
		
		String sql = "update sawon set name ='"+name+"',score ='"+score+"',buseo ='"+buseo+"' where num = "+num ;
//		System.out.println(sql);
		//커넥션 연결 객체
		Connection conn = null;
		//쿼리문 담을 객체
		Statement stmt = null;
		//DB 연결 메서드 호출
		conn = db.getMysqlConnection();
		
		//연결 후 쿼리 메서드 호출 
		try {
			stmt = conn.createStatement();
			
			//실행 결과 값을 반환 
			int n = stmt.executeUpdate(sql);
			if(n==0)
				System.out.println("수정 실패");
			else
				System.out.println(n+":수정 성공!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex03_Test_MysqlSawonUpdate ex = new Ex03_Test_MysqlSawonUpdate();
		ex.sawonUpdate();
	}


}
