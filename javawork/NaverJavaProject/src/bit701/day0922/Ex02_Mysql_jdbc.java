package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02_Mysql_jdbc {

	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
//	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701"; // 8버전은 이러면 에러발생 Time zone
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul"; // 8버전은 이러면 에러발생 Time zone
	// 문자열로 인식한다
	
	public Ex02_Mysql_jdbc() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER); // 클래스 이름을 찾는 메서드
			System.out.println("MySQL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL 드라이버 오류:"+e.getMessage());
			
		}
	}
	
	public void sawonAllDatas()
	{
		Connection conn=null;
		
		Statement stmt = null; 
		ResultSet rs = null;
		String sql = "select * from sawon order by score desc";
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			System.out.println("MySQL 연결 성공");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//rs.next() : 다음 데이터로 이동을 하고 true 반환, 이동할 데이터가 없을 경우 false 반환
			
			
			System.out.println("사원번호사원명\t점수\t성별\t부서명");
			System.out.println("=".repeat(40));
			
			//총 인원을 카운트해보자
			int count = 0;
			int total = 0;
			
			while(rs.next())
			{
				String num = rs.getString("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String deptName = rs.getString("buseo");
				
				total+=score;
				count++;
				
				System.out.println(num+"\t"+name+"\t"+score+"\t"+gender+"\t"+deptName);
			}
			
			System.out.println("\n총점:"+total);
			double avg=(double)total/count;
			System.out.printf("평균: %3.1f\n",avg);
		} catch (SQLException e) {
			System.out.println("MySQL 연결 실패:"+e.getMessage());
		} finally {
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex02_Mysql_jdbc ex = new Ex02_Mysql_jdbc();
		ex.sawonAllDatas();
	}

}