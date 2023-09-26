package bit701.day0925;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex09_StudentCrud {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	public int getMenu()
	{
		System.out.println("1.추가 2.삭제 3.수정 4.전체출력 5.검색 6.종료");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}

	//insert

	public void insertStudent () 
	{
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("혈액형");
		String blood = sc.nextLine();
		blood = blood.toUpperCase();
		System.out.println("핸드폰");
		String phone= sc.nextLine();
		//		System.out.println("날짜");
		//		String writeday = "CURRENT_TIMESTAMP";

		String sql = """
					insert into student (name,blood,phone,writeday) 
					values (?,?,?,CURRENT_TIMESTAMP)
				""";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);

			//실행
			pstmt.execute();
			System.out.println("데이터 추가를 성공했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}


	}

	//delete

	public void deleteStudent () 
	{
		// 이름	
		System.out.println("이름");
		String name = sc.nextLine();

		String sql = """
					delete from student where name = ? 

				""";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);

			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("삭제할 학생이 존재하지 않아요");
			else
				System.out.println( n+"명 학생정보 삭제 완료!");

			//실행
			pstmt.execute();
			System.out.println("데이터 삭제를 성공했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//update

	public void updateStudent () 
	{
		//이름 
		//혈액형
		//폰

		System.out.println("번호");
		int num= Integer.parseInt(sc.nextLine());
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("혈액형");
		String blood = sc.nextLine();
		blood = blood.toUpperCase();
		System.out.println("핸드폰");
		String phone = sc.nextLine(); 

		String sql = """
					update student set name = ?, blood = ?, phone= ? where num = ?

				""";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			pstmt.setInt(4, num);

			//실행
			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("수정할 사원이 존재하지 않아요");
			else
				System.out.println( n+"명 사원정보 수정 완료!");

			//실행
			pstmt.execute();//주의 : sql문 없다.
			System.out.println("학생정보를 수정하였습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}



	//전체 출력

	public void selectAll () 
	{
		System.out.println("번호\t이름\t혈액형\t핸드폰\t날짜");
		System.out.println("=".repeat(50));

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		String sql = "select * from student order by num";
		conn = db.getMysqlConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String  phone = rs.getString("phone");
				Date date = rs.getDate("writeday");
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	//검색 = 번호 끝 4자리로 검색

	public void searchPhone () 
	{
		System.out.println("검색할 번호 끝자리 4 입력");
		String phone = sc.nextLine();

		String sql = "select * from student where phone like ?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+phone);
			//실행
			rs = pstmt.executeQuery();
			int cnt = 0;
			
			
			System.out.println("전화번호 "+phone+" 검색 결과");
			System.out.println("번호\t이름\t혈액형\t전화\t날짜");
			System.out.println("=".repeat(40));
			
	

			while(rs.next())
			{
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone1 = rs.getString("phone");
				Date writeday = rs.getDate("writeday");

				System.out.println(++cnt);
				System.out.println("이름:"+name);
				System.out.println("혈액형:"+blood);
				System.out.println("핸드폰:"+phone1);
				System.out.println("날짜:"+writeday);
				System.out.println("-".repeat(20));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex09_StudentCrud ex = new Ex09_StudentCrud();

		while(true)
		{
			System.out.println("-".repeat(40));
			int menu = ex.getMenu();
			System.out.println("-".repeat(40));
			switch(menu)
			{
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAll();
				break;
			case 5:
				ex.searchPhone();
				break;
			default:
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);
			}
		}

	}

}
