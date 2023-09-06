package bit701.day0906;

public class Ex14_ArrayStringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"한가인","강호동","강호남","Candy","손미나"};
		//selection sort - 문자열 비교시 
		for(int i=0; i<names.length-1;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
				//a.compareTo(b) : a가 b 보다 클경우 무조건 양수값이 나온다.
				if(names[i].compareTo(names[j])>0) //오름차순 정렬 바꾸면 내림차순
				{
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}//포문 끝
		
		for(String s:names)
			System.out.println(s);
	}

}