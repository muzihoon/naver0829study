package bit701.day0913;

abstract class Animal
{
	public void breathe()
	{
		System.out.println("숨을 쉽니다");
	}
	
	public abstract void sound();
} // 인터페이스와 다르게 일반 메서드, 변수, 상수, 포함 가능 


//추상 클래스 상속

class Dog extends Animal
{
	@Override
	public void sound() //breathe는 오버라이드 안해도 된다. 
	{
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
}

class Cat extends Animal
{
	@Override
	public void sound() 
	{
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}
}

public class Ex11_Book328 {

	public static void animalSound(Animal animal)
	{
		animal.sound();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat = new Cat();
		animalSound(cat);
		
		Dog dog=new Dog();
		animalSound(dog);
		
		Animal animal = new Cat();
		animalSound(animal);
		
		Animal animal1 = new Dog();
		animalSound(animal);
		
		Animal animal2 = new Dog();
		animalSound(dog);
	}

}
