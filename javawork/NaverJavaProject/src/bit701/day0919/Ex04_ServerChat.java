package bit701.day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex04_ServerChat extends JFrame implements Runnable{
	JTextArea area;

	//접속하는 클라이언트들을 저장할 Vector
	Vector<ClientMember> listMember = new Vector<ClientMember>();

	public Ex04_ServerChat() {
		// TODO Auto-generated constructor stub
		super("채팅서버");
		this.setBounds(700,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	//1번  쓰레드의  run 메소드
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("호출"); //나오는거 확인후 지워도 무방
		//서버소켓 생성
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6000);
			area.append("서버 소켓 생성 성공\n");

			//접속하는 클라이언트들 허용
			while(true)
			{
				//대기중 상태에서
				//접속 요청하는 클라이언트를 허용한다.
				Socket socket = serverSocket.accept();
				//허용된 클라이언트들을 벡터에 추가한다.
				ClientMember clientMember = new ClientMember(socket);
				listMember.add(clientMember);
				//각 클라이언트의 run 메소드를 호출
				clientMember.start(); // Thread 상속 받았으니까

				area.append("접속허용 IP:"+socket.getInetAddress().getHostAddress()+"\n");
				//접속 요청을 허용하고 대화를 나눌 준비가 되어있는 상태.
				this.autoScroll();// 스크롤 자동

			}
		} catch (IOException e) {
			area.append("서버 소켓 생성 실패:"+e.getMessage());
		}
	}

	//접속한 클라이언트와 대화를 주고 받을 내부 클래스
	class ClientMember extends Thread  // 무조건 Thread 상태에서 주고받아야 한다.
	{
		Socket mySocket ;
		BufferedReader br; //읽기 위해서
		PrintWriter pw; //출력하기 위해서
		String nickName;

		public ClientMember(Socket socket)
		{
			mySocket = socket;
			
			// 대화를 주고 받을 수 있게 IO 클래스 얻기
			InputStream is = null;
			try {
				is = mySocket.getInputStream(); // 네트워크로 읽을 수 있게 하는 InputStream 
				br = new BufferedReader(new InputStreamReader(is)); //br로 읽는것
				pw = new PrintWriter(mySocket.getOutputStream()); //pw 로 보내는것
			} catch (IOException e) {

			}

		}

		@Override
		public void run() {
			//언제 클라이언트들이 메세지를 보낼지 모르니까 
			//super.run();
			while(true)
			{
				// 클라이언트들이 보낸 메세지를 읽는다.
				try {
					String message = br.readLine();
					//확인용 : 클라이언트가 보낸 메세지 출력
					area.append(message+"\n");
					
					//처음 접속시 : 1| 닉네임 메세지: 2|메세지
					String[] arr = message.split("\\|");
//					System.out.println(arr[0]+","+arr[1]); // 잘 분리되나 확인용

					switch (arr[0]) {
					case "1": 

						this.nickName=arr[1];
						//접속한 모든 클라이언트들한테 누가 입장했는지 알린다
						for(ClientMember mem : listMember)
						{
							mem.pw.println(this.nickName+">>님이 입장하였습니다\n");
							mem.pw.flush();//이때 비로소 전송이 된다.
						}
						break;
						
					case "2" :
						//보낸 메세지가 arr[1]에 들어왔다.
						//접속한 모든 클라이언트들한테 누가 어떤 메세지를 보냈는지 알린다.
						for(ClientMember mem : listMember)
						{
							mem.pw.println(this.nickName+">>"+arr[1]+"\n");
							mem.pw.flush();//이때 비로소 전송이 된다.
						}
						break;
					}

				} catch (IOException|ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();

					//에러 엄청 나올거라 그냥 숨긴다.
				}
			}
		}

	}


	// 자동으로 스크롤 바 최신으로 유지하게 해줌 
	public void autoScroll()
	{
		int n = area.getDocument().getLength();//총 라인수
		area.setCaretPosition(n); // 마지막줄로 위치 변경
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		area = new JTextArea();
		this.add(new JScrollPane(area));// 이렇게 하면 스크롤이 생성된다.
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_ServerChat serverChat = new Ex04_ServerChat();
		Thread th = new Thread(serverChat);
		th.start();//1번 run 메소드 호출
	}


}
