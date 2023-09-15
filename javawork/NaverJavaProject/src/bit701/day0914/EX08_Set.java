package bit701.day0914;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EX08_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Set<String> set=new HashSet<String>(); //비순차적 결과
		Set<String> set=new TreeSet<String>(); // 순서대로 나옴
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("yellow");
		set.add("balck");
		set.add("gray");
		set.add("red");
		set.add("red");
		set.add("red");
		set.add("red");
		System.out.println(set.size());//중복된거 빼고 5개로 나옴
		
		//출력 1 
		
		for(String s:set)
		{
			System.out.println(s); //비순차적인 결과
		}
	}

}
