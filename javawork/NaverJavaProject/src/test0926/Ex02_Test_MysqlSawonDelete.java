package test0926;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex02_Test_MysqlSawonDelete {

	DbConnect db = new DbConnect();
	
	public void sawonDelete() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//테스트
		System.out.println("번호");
		String num = sc.nextLine();
		String sql = "delete from sawon where num = '"+num+"'";
		System.out.println(sql);
		
		//커넥션 연결 객체
		Connection conn = null;
		//쿼리문 담을 객체
		Statement stmt = null;
		
		//DB 연결 메서드 호출
		
		conn = db.getMysqlConnection();
		
		
		try {
			//쿼리문 전달 메서드 호출
			stmt = conn.createStatement();
			
			int n = stmt.executeUpdate(sql);// 실행 후 결과 반환
			if(n==0)
			{
				System.out.println("삭제 실패 !");
				return;
			}else {
				System.out.println("삭제 성공 !");
				System.out.println(n+": 총 삭제 개수");
			}
//			stmt.execute(sql);//실행
		} catch (SQLException e) {
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
		//실행
		
		//닫기
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_Test_MysqlSawonDelete ex = new Ex02_Test_MysqlSawonDelete();
		ex.sawonDelete();
	}


}
