package bit701.day0914;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex11_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String,String>();
		map.put("name", "캔디");
		map.put("kor","90");
		map.put("blood","AB");
		map.put("ipsaday","1989-12-12");
		map.put("hp","010-2222-4444");
		
		//key 값들을 얻은 후 key 에 해당하는 value를 얻어보자.
		Set<String> keys=map.keySet(); // 모든 키를 set 객체에 담아서 리턴한다.
		for(String key:keys)
		{
			String v=map.get(key);
			System.out.println(key+":"+v);
		}
		
	}

}
