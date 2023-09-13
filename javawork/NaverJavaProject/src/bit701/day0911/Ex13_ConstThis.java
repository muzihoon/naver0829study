package bit701.day0911;

	class Kiwi
	{
			String name;
			int age;
		
			Kiwi(){
			this("홍길동",20);// 3번째 생성자가 호출된다. 파라미터 맞는 생성자를 찾아서 호출한다.
		}
		
			Kiwi(String name){
			this(name,30);//3번재 생성자가 호출된다
		}
		
		
			Kiwi(String name,int age)
		{
			this.name=name;
			this.age=age;
		}
		public void writeData()
		{
			System.out.println("name :"+name+"\tage:"+age);
		}
	
	}

public class Ex13_ConstThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성자에서 this의 
		
		Kiwi []karr= {
				new Kiwi(),
				new Kiwi("Kim"),
				new Kiwi("Lee",35)
		};
		for(Kiwi k:karr)
		{
			k.writeData();
		}
	}

}
