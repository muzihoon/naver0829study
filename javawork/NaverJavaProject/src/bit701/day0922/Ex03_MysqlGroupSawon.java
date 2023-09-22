package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex03_MysqlGroupSawon {

	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul"; // 8버전은 이러면 에러발생 Time zone
	
	public Ex03_MysqlGroupSawon() {
		try {
			Class.forName(MYSQL_DRIVER); // 클래스 이름을 찾는 메서드
			System.out.println("MySQL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL 드라이버 오류:"+e.getMessage());
			
		}
	}
	
	public void sawonBunseok()
	{
		
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		//rs.next() : 다음 데이터로 이동을 하고 true 반환, 이동할 데이터가 없을 경우 false 반환
		
		String sql = "select buseo,count(*) count, max(score) maxscore, min(score) minscore, "
				+ "avg(score) avgscore from sawon group by buseo";
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			System.out.println("MySQL 연결 성공");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("부서명\t인원수\t최고점수\t최소점수\t평균");
			System.out.println("=".repeat(50));
			
			while(rs.next())
			{
				String deptName = rs.getString("buseo");
				int count = rs.getInt("count");
				int maxscore = rs.getInt("maxscore");
				int minscore = rs.getInt("minscore");
				int avg = rs.getInt("avgscore");
				
				System.out.println(deptName+"\t"+count+"\t"+maxscore+"\t\t"+minscore+"\t\t"+avg);
			}
			
		} catch (SQLException e) {
			System.out.println("MySQL 연결 실패:"+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
				//열린 역순으로 닫기
			} catch (SQLException|NullPointerException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}// 메소드 끝
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex03_MysqlGroupSawon ex = new Ex03_MysqlGroupSawon();
		ex.sawonBunseok();
	}

}
