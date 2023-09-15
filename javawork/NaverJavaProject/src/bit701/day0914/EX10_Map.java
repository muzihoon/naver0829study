package bit701.day0914;

import java.util.HashMap;
import java.util.Map;

public class EX10_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map:Key와 value의 쌍으로 저장되는 형태(이때 key 는 set 타입)
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", "카리나");
		map.put("age", "22세");
		map.put("addr", "강남구");
		map.put("name", "나연"); // 같은 key값이 존재할 경우 덮어씌운다.
		System.out.println("갯수: "+map.size());
		//key 값을 알아야 value 값을 얻을 수 있다.
		System.out.println("이름: "+map.get("name"));
		System.out.println("나이: "+map.get("age"));
		System.out.println("주소: "+map.get("addr"));
		System.out.println("혈액형: "+map.get("blood")); // 해당 key 값이 존재하지 않을경우 null 값이 반환
		
		System.out.println("addr 키 값을 제거해보자");
		map.remove("addr");
		System.out.println("주소: "+map.get("addr"));// 제거 되었으므로 null 값이 반환이 된다.
	}

}
