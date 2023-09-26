package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex02_MysqlSawonInsert {
	
	DbConnect db = new DbConnect();
	
	public void sawonInsert()
	{
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
		System.out.println(sql);
		
		// 테스트 완료
		
		Connection conn = null;
		Statement stmt = null;
		
		//db 연결
		conn = db.getMysqlConnection();
		
		//statement
		try {
			stmt = conn.createStatement();
			
			stmt.execute(sql);
			System.out.println("sawon 에 데이터 추가 성공");
		} catch (SQLException e) {
			System.out.println("insert sql 문 오류 :"+e.getMessage());;
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_MysqlSawonInsert ex = new Ex02_MysqlSawonInsert();
		ex.sawonInsert();
	}

}
