package bit701.day0914;

public class EX01_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {10,20,30};
		for(int i=0;i<=arr.length;i++)
		{
			try {
				System.out.println(arr[i]);;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 번지를 벗어났어요"+e.getMessage()); //getMessag로 어떤 에러 발생인지 알 수 있다.
				e.printStackTrace();//에러메세지를 추적해서 출력, 정상 종료가 되었다는게 중요! (에러 발생 라인번호까지)
			}
		}//for 끝 
		System.out.println("정상종료!");
	}

}
