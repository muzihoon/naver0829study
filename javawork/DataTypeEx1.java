public class DataTypeEx1 {
	public static void main(String []args)
	{
	   //�� ������ ����� �� �Դϴ�.
	   /*
		2023.08.30
		����Ÿ Ÿ�� ����
	 */
	// byte �� 1 byte ũ���� ������ Ÿ�� �Դϴ�.
	// ũ��� -128~127 �� ���ڸ� ������ �����մ�
	byte a=127;
	System.out.println("a="+a);
	

	byte b=(byte)200;//���� �߻�, ���� ����ȯ
	System.out.println("b="+b); // ���� ������ ���� ��� �� �ս� �߻�
	
	//����� ���ڷ� �Ѿ���� ���ڿ��� Ȯ���غ���.
	System.out.println(args[0]);//�迭�� ù���ڿ� ���
	}
}