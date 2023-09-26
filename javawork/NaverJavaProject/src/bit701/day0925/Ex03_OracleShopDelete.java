package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex03_OracleShopDelete {

	DbConnect db = new DbConnect();
	
	public void shopDelete()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 상품명 입력");
		String sang = sc.nextLine();
		String sql = "delete from shop where sang_name = '"+sang+"'";
		System.out.println(sql);
		
		
		//테스트 완료
		//connection 연결
		Connection conn = null; // 연결
		Statement stmt = null; // 쿼리 할당
		
		//db 연결
		conn = db.getOracleConnection();
		//statement
		
		try {
			stmt = conn.createStatement();
			// 실행 - 성공적으로 삭제된 레코드의 갯수를 알고 싶으면 ? executeUpdate
			
			int n = stmt.executeUpdate(sql);
			if(n==0)
				System.out.println(sang+" 상품은 목록에 없습니다.");
			else
				System.out.println("총 "+n+"개의 "+sang+" 상품을 삭제했습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex03_OracleShopDelete ex = new Ex03_OracleShopDelete();
		ex.shopDelete();
	}

}
