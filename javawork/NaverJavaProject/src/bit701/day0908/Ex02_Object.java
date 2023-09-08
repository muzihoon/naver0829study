package bit701.day0908;


 class Bitcamp{ 
	 // 파일 이름과 같지 않아서 public을 붙일 수 없다.
	 //그외는 같은 패키지에서만 호출이 가능하다. 
	 //다른 패키지에서 호출하려면 파일 이름과 클래스 이름이 같아야함.
	 
	 //클래스를 만들면 무조건 private으로 만든다
	 //setter와 getter 메서드를 사용해서 가져오고 설정함.
	
	 
	 //인스턴스 멤버 변수 - 생성된 인스턴스로만 접근이 가능해서, 인스턴스 생성후 이름으로 접근 가능
	 String name;
	 String address;
	 //클래스 멤버 변수  - 인스턴스로 생성 안해도 접근 가능, 클래스 이름으로 접근 가능
	 static final String STUDYNAME="네이버 클라우드 3기 자바웹";
}

public class Ex02_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bitcamp stu1=new Bitcamp();
		stu1.name="이미자";
		stu1.address="여의도";
		
		Bitcamp stu2=new Bitcamp();
		stu2.name="이기자";
		stu2.address="제주도";
		
		System.out.println("*** 학생 정보 1 **");
		System.out.println("이름:"+stu1.name);
		System.out.println("주소:"+stu1.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);
		
		System.out.println("=".repeat(30));
		System.out.println("*** 학생 정보 2 **");
		System.out.println("이름:"+stu2.name);
		System.out.println("주소:"+stu2.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);
		
	}

}
