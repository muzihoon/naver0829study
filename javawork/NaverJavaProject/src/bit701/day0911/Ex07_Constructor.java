package bit701.day0911;

public class Ex07_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//방법1. 메모리에 할당하고 생성하는 방법
//		Student []stu=new Student[3]; //3개로 배열 할당, 초기값은 null
//		stu[0]=new Student();
//		stu[1]=new Student("카리나");
//		stu[2]=new Student("장원영",1999,99);
//		
		
		//방법2.
		Student []stu= {
				new Student(),
				new Student("카리나"),
				new Student("장원영",2002,89),
				new Student("뉴진스",1979,100)
		};
		
		
//		for(int i=0; i<stu.length;i++)
//			stu[i].studentInfo();
		
		for(Student s:stu)
			s.studentInfo();
	}

}
