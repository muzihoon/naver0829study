package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex04_MysqlSawonDelete {

	
	DbConnect db = new DbConnect();
	
	public void sawonDelete()
	{
		// 사원명 입력후 해당 사원 삭제
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름");
		String name = sc.nextLine();
		String sql = "delete from sawon where name = '"+name+"'";
		System.out.println(sql);
		
		//테스트
		
		//커넥션 연결
		Connection conn = null;
		Statement stmt = null;
		conn = db.getMysqlConnection();
		
		
		//db 연결
		try {
			stmt = conn.createStatement();
			// 결과값이 0이면 xxx 사원은 없습니다.
			// n이면 총 n명의 xxx 사원정보를 삭제했습니다.
			
			int n = stmt.executeUpdate(sql);
			//결과값 반환 받는다.
			if (n==0)
			{
				System.out.println(name+"사원은 없습니다.");
			}
			else {
				System.out.println("총 :"+n+" 명의 "+name+" 사원정보를 삭제했습니다.");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		//statement 문 작성
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_MysqlSawonDelete ex = new Ex04_MysqlSawonDelete();
		ex.sawonDelete();
	}

}
