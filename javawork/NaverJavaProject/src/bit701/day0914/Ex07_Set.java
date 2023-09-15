package bit701.day0914;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex07_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set 인터페이스의 특징 : 1.순차적이 아니다 2.중복허용을 안한다
//		Set<Integer> set=new HashSet<Integer>();	//비순차적, 그런데 이 경우에는 오름차순으로 나왔다. 거의 이거 씀
		Set<Integer> set=new TreeSet<Integer>();	//
		System.out.println(set.size());//size 는 데이타의 갯수(배열은 length)
		set.add(30);
		set.add(27);
		set.add(1);
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);
		System.out.println(set.size());//5 (5는 1번만 계산) 들어가지는데 덮어씌워지는 것
		
		//컬렉션들을 출력하는 방법 여러가지가 있다.
		
		//출력 1
		System.out.println("-".repeat(10));
		for(Integer n:set) // 이 방법을 제일 많이 쓴다.
			System.out.println(n);
		System.out.println("-".repeat(10));
		
		//출력 2
		Iterator<Integer>iter=set.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println("-".repeat(10));
				

	}

}
