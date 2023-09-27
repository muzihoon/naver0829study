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
		
		Connection conn = null; // DB 커넥션 담당 객체 생성
		Statement stmt = null; // SQL 쿼리를 실행할 객체 생성/ jdbc에서 DB와 상호작용할때 필요한 객체임
		
		//db 연결
		conn = db.getMysqlConnection(); // 내가 만들어뒀던 메서드로 MySQL 에 접속함 
		
		//statement
		try {
			stmt = conn.createStatement();//SQL 쿼리 실행용 메서드
			
			stmt.execute(sql); // // 실행한다.
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
