package bit701.day0914;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex14_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List 는 데이터를 넣은 순차적으로 저장되고 중복데이타도 저장됨(Set 과 달리)
		List<String> list=new Vector<String>();
		list.add("장미꽃");
		list.add("안개꽃");
		list.add("장미꽃");
		list.add("국화꽃");
		list.add("할미꽃");
		
		System.out.println("출력 1 방법");
		for(int i=0; i<list.size();i++)
		{
			String s=list.get(i);
			System.out.print(s+" ");
		}
		
		System.out.println("\n=========\n 출력 2 방법"); // // 제일 많이 쓰는 방법 1,2
		for(String s:list)
		{
			System.out.print(s+" ");
		}
		
		System.out.println("\n=========\n 출력 3 방법");
		Iterator<String> iter=list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
		
		System.out.println("\n=========\n 출력 4 방법");
		{
			Object []data=list.toArray();// toArray() 오브젝트로 반환한다.
			for(Object ob:data)
				System.out.print((String)ob+" ");
		}
	}

}
