package bit701.day0911;

import java.util.Date;

public class Student {
	
		private String name;
		private int birthYear;
		private int score;
		
		Student()
		{
//			name="카리나";
//			birthYear=2000;
//			score=50;
			//한줄로 줄여봐라
			this("카리나",2000,50); //같은 생성자중에 파라미터 인자가 맞는 걸 호출한다.
		}
		
		Student(String name)
		{
//			this.name=name;
//			birthYear=2000;
//			score=50;
			// 한줄로 줄여봐라
			this(name,2000,50); // 위 코드와 내부적으로 완전 동일히다.
		}
		
		Student(String name,int birthYear, int score)
		{
			this.name=name;
			this.birthYear=birthYear;
			this.score=score;
		}
		
		public void studentInfo()  // 단순 데이터 확인용은 toString으로 만들어도 된다. 
		{
			System.out.println("*** 학생정보 ***");
			System.out.println("이름 :"+name);
			
			int year=new Date().getYear()+1900;
			
			System.out.println("태어난 년도:"+birthYear+",나이:"+(year-birthYear));
			System.out.println("점수:"+score+"점");
//			System.out.println("등급 :"+MyStudent.getAverage());
			System.out.println("-".repeat(30));
		}
	
}
