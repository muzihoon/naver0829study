package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EX01_oracleJdbc {

	static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	// 문자열로 인식한다
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	public EX01_oracleJdbc() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 오류:"+e.getMessage());
			
		}
	}
	
	public void shopAllDatas()
	{
		Connection conn = null;
		
		Statement stmt = null; // 무조건 java.sql
		ResultSet rs = null; // 무조건 java.sql ( select 일 경우에만 필요)
		String sql = "select * from shop order by sang_no";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
			System.out.println("오라클 연결 성공");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // select 일 경우에만 executeQuery 필요함(반환 타입이 ResultSet)
			
			//rs.next() : 다음 데이터로 이동을 하고 true 반환, 이동할 데이터가 없을 경우 false 반환
			
			System.out.println("상품번호상품명\t가격\t색상");
			System.out.println("=".repeat(40));
			
			int total = 0;
			while(rs.next())
			{
				// 데이터를 가져올때 인덱스로 가져오거나 컬럼명으로 가져온다
				// 일단 인덱스로 가져와보자.
				//String num = rs.getString(1);
				//String pdName = rs.getString(2);
				//int price = rs.getInt(3);
				//String color = rs.getString(4);
				
				String num = rs.getString("sang_no");
				String pdName = rs.getString("sang_name");
				int price = rs.getInt("sang_price");
				String color = rs.getString("sang_color");
				
				total+=price;
				
				System.out.println(num+"\t"+pdName+"\t"+price+"\t"+color);
			}
			System.out.println("\n총금액:"+total);
			
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패:"+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
				// 열린 역순으로 닫아라.
			} catch (SQLException|NullPointerException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EX01_oracleJdbc ex = new EX01_oracleJdbc();
		ex.shopAllDatas();
	}

}
