package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex01_OracleShopInsert {
		DbConnect db = new DbConnect();
		
		public void shopInsert()
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("상품명 입력");
			String sang = sc.nextLine();
			
			System.out.println("가격 입력");
			int price = Integer.parseInt(sc.nextLine());
			
			System.out.println("색상 입력");
			String color = sc.nextLine();
			
			
			String sql = "insert into shop values (seq_shop.nextval,'"+sang+"',"+price+",'"+color+"')";
			System.out.println(sql);
			// 여기까지 하고 insert into shop values (seq_shop.nextval,'배고파',10000,'블루') 출력 되는지 잘 확인
			
			Connection conn = null;
			Statement stmt = null;
			
			//db 연결
			conn = db.getOracleConnection();
			//statement
			try {
				stmt = conn.createStatement();
				//실행
//				boolean b = stmt.execute(sql); // 반환타입이 boolean , (false:실행결과가 없을 경우, select가 아닌경우 다 이거나옴)
//				int n = stmt.executeUpdate(sql);// 반환타입이 int : sql 문을 성공한 갯수. 반환값으로 실행 결과를 확인 가능
//				System.out.println(b+","+n);
//				System.out.println("데이타 두번 insert 된다");
				
				// exceute는 하나만 써야하는데 지금 반환타입을 확인하기 위해 두번 쓴다.
				
				stmt.execute(sql);
				System.out.println("shop 에 데이타 추가 성공");
				
				
			} catch (SQLException e) {
				System.out.println("insert sql 문 오류:"+e.getMessage());
			}finally {
				db.dbClose(stmt, conn);
			}
			
		}

		public static void main(String[] args) {
		// TODO Auto-generated method stub
			Ex01_OracleShopInsert ex = new Ex01_OracleShopInsert();
			ex.shopInsert();
		
	}

}
