package bit701.day0914;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex15_MyListStudent {

	List<Student> list=new ArrayList<Student>();
	Scanner sc= new Scanner(System.in);

	public Ex15_MyListStudent() {
		// TODO Auto-generated constructor stub
		list.add(new Student("카리나", 90,"o"));
		list.add(new Student("다니엘", 100,"ab"));
		list.add(new Student("하니", 70,"a"));
		list.add(new Student("혜린", 40,"b"));
		list.add(new Student("혜인", 50,"ab"));
		//		System.out.println("총 "+list.size()+"명");
	}


	//메뉴
	public int getMenu()
	{
		int num=0;
		System.out.println("\n1.학생 추가 2.학생삭제 3.학생 검색 4.전체출력 5.종료");
		System.out.print("선택하세요>>");
		try {
			num=Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			num=4;//번호에 문자가 들어간 경우 4번. 전체출력으로 하기
		}
		return num;
	}


	public void addStudent()
	{
		System.out.println("학생 정보를 추가합니다.");
		System.out.print("학생명:");
		String name=sc.nextLine();
		System.out.println("점수는:");
		int score=0;
		try {
			score = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e)
		{
			//점수에 문자가 잘못 입력될 경우 30점으로 주기
			score=30;
		}
		System.out.println("혈액형");
		String blood=sc.nextLine();

		//Student 객체 생성후 setter 로 값 넣기 
		Student s=new Student();
		s.setName(name);
		s.setScore(score);
		s.setBlood(blood);
		//list 추가
		list.add(s);
		System.out.println(list.size()+"번째 학생정보 추가됨!");
	}

	public void deleteStudent()
	{
		System.out.println("학생 정보를 삭제합니다.");
		//이름을 입력 후 for문으로 해당 이름을 찾아서 삭제하기
		System.out.println("학생명:");
		String name=sc.nextLine();
		

		for(int i=0; i<list.size();i++)
		{
			Student d=list.get(i);
			//list의 0번 인덱스의 저장된 이름과 입력된 이름을 비교한다.
			if(d.getName().equals(name))
			{
				list.remove(i);
				System.out.println("삭제가 완료되었습니다.");
				return;
			}
		}

	}

	public void searchStudent()
	{
		System.out.println("학생 정보를 검색합니다.");
		//이름을 입력후 해당 학생이 있는경우 이름, 점수, 혈액형 출력
		//만약 없을 경우"xxx 님은 명단에 없습니다"
		String name = sc.nextLine();
//		Student s = new Student();

		int num=0;
		for(int i=0;i<list.size();i++)
		{
			Student d=list.get(i);
			if(d.getName().equals(name))
			{
				num++;
//				name =d.getName();
				int score =(int)d.getScore();
				String blood =d.getBlood();

				System.out.println("\t번호\t이름\t점수\t혈액형");
				System.out.printf("\t%2d\t%s\t%3d\t%s\n",num,name,score,blood.toUpperCase());
				System.out.println("-".repeat(50));
				return;

			}
		}
	}

	public void listStudent()
	{
		System.out.println("전체 학생 정보 출력");
		//번호 이름 점수 혈액형 순으로 출력(단 혈액형은 대문자로 변환해서 출력)
		int num=0;
		for(Student s:list)
		{
			num++;
			String name=s.getName();
			int score=(int)s.getScore();
			String blood=s.getBlood();

			System.out.println("\t번호\t이름\t점수\t혈액형");
			System.out.printf("\t%2d\t%s\t%3d\t%s\n",num,name,score,blood.toUpperCase());
			System.out.println("-".repeat(50));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex15_MyListStudent ex=new Ex15_MyListStudent();

		Exit:
			while(true)
			{
				switch (ex.getMenu())
				{
				case 1:
					ex.addStudent();
					break;
				case 2:
					ex.deleteStudent();
					break;
				case 3:
					ex.searchStudent();
					break;
				case 4:
					ex.listStudent();
					break;
				default:
					System.out.println("** 프로그램 종료 **");
					break Exit;
				}
			}
	}

}
