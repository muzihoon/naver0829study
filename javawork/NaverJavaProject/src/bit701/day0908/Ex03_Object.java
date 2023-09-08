package bit701.day0908;

public class Ex03_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체 배열을 이용해서 데이터를 출력해보자.
		Bitcamp[]bit=new Bitcamp[3];// 3개의 데이터가 들어갈 변수로 할당만 했음, 초기값은 null이다. 스택 메모리에 할당된 상태
		
		
		// 객체는 생성을 해줘야 한다. 이렇게만 하면 NullPointerException 나. bit[0] 의 값은 null 이다
		//메모리 할당을 한거지 객체를 생성한게 아니다. 메모리 할당 -스택 메모리, 객체 생성 - 힙 메모리
		
		//배열 갯수만큼 Bitcamp 객체를 생성 - 힙 메모리에 생성된 상태
		for(int i=0; i<bit.length;i++)
		{
			bit[i]=new Bitcamp();
		}
		
		//static은 100명의 회사원이 같이 사용하는 한개의 전화번호부- 100번 써도 값이 똑같음 
		//instance는 같은 회사에 속한 100명의 직원 - 100명 모두 속성이 다름 
		
		
		//0번 데이타
		bit[0].name="캔디";
		bit[0].address="대구";

		//1번 데이타
		bit[1].name="안쏘니";
		bit[1].address="서울";
		
		//2번 데이타
		bit[2].name="테리우스";
		bit[2].address="부산";
		
		
		//출력 #1
		for(int i=0; i<bit.length;i++)
		{
			System.out.println("*** 학생 정보 "+(i+1)+"***");
			System.out.println("이름 : "+bit[i].name);
			System.out.println("주소 : "+bit[i].address);
			System.out.println("스터디반 : "+Bitcamp.STUDYNAME);
			System.out.println("=".repeat(30));
			
		}
//		
		//출력 #2
				for(Bitcamp b:bit)
				{
					System.out.println("*** 학생 정보***");
					System.out.println("이름 : "+b.name);
					System.out.println("주소 : "+b.address);
					System.out.println("스터디반 : "+Bitcamp.STUDYNAME);
					System.out.println("=".repeat(30));
					
				}
	
				
	}
}
