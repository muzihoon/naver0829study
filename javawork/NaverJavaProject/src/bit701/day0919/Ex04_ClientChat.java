package bit701.day0919;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex04_ClientChat extends JFrame implements Runnable,ActionListener{
	//클래스는 하나의 상속이지만, 인터페이스는 동시 구현 가능
	String nickName;
	JTextArea area;
	JTextField tfNickName, tfMessage, tfServerIp;
	JButton btnSend, btnConnect;
	Socket clientSocket;

	//소켓이 생성 된 다음에 얻어줘야 한다.
	BufferedReader br;
	PrintWriter pw;


	public Ex04_ClientChat() {
		// TODO Auto-generated constructor stub
		this.setBounds(1000,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		//메세지 입력 후 엔터를 누르거나 전송 버튼을 누를경우 같은 코드가 실행된다.
		if(ob==tfMessage || ob==btnSend)
		{
			System.out.println("메세지 보냄");
			//서버에 "2|메세지" 이런식으로 보낸다.
			pw.println("2|"+tfMessage.getText()+"\n");
			pw.flush();//네트워크로 실제 전송
			
			//입력한 문자열 지우기
			tfMessage.setText("");
			tfMessage.requestFocus();
		}
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("호출");

		//서버에 접속 
		try {
			clientSocket = new Socket(tfServerIp.getText(), 6000); // 소켓 생성

			// 대화를 주고 받을 수 있게 IO 클래스 얻기
			//이 코드로 접속시 IO 클래스가 생성된다. 서버를 먼저 만들고 클라이언트를 만들어야 한다. 
			InputStream is = null;
			try {
				is = clientSocket.getInputStream(); // 네트워크로 읽을 수 있게 하는 InputStream 
				br = new BufferedReader(new InputStreamReader(is)); //br로 읽는것
				pw = new PrintWriter(clientSocket.getOutputStream()); //pw 로 보내는것
				area.append("서버에 접속 성공\n");
				
				//서버에 "1|닉네임" 이런식으로 보낸다.
				pw.println("1|"+nickName+"\n");
				pw.flush();//네트워크로 실제 전송
				
				//서버가 언제 메세지를 보낼지 모르니 while 문을 열어두고 
				//메세지가 올 때 마다 실시간으로 출력한다.
				while(true)
				{
					String message = br.readLine();
					area.append(message+"\n");
					this.autoScroll();// 자동 스크롤추가. 화면 꽉차면 자동으로 아래로 내려감
				}
				
				
			} catch (IOException e) {
				//에러 많이 발생해서 삭제함.
			}

		} catch (IOException e) {
			area.append("서버에 접속 실패:"+e.getMessage()+"\n");
		}

	}

	private void setDesign() {
		// TODO Auto-generated method stub
		JPanel pTop = new JPanel();
		tfNickName = new JTextField("짱구는반건조",7);// 자기이름 초기값, 뒤 5는 field의 크기
		tfServerIp = new JTextField("192.168.0.46");// 각자 자기 ip를 초기값으로
		
		btnConnect = new JButton("서버접속");
		pTop.add(new JLabel("닉네임:"));
		pTop.add(tfNickName);
		pTop.add(tfServerIp);
		pTop.add(btnConnect);
		this.add("North",pTop);

		JPanel pBottom = new JPanel();
		tfMessage = new JTextField(25);
		btnSend = new JButton("전송");
		pBottom.add(tfMessage);
		pBottom.add(btnSend);
		this.add("South",pBottom);

		area = new JTextArea();
		this.add("Center",new JScrollPane(area)); // 이렇게 하면 스크롤이 생성된다.

		//접속 버튼
		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				// TODO Auto-generated method stub

				//닉네임을 읽어서 창제목으로 넣기
				nickName = tfNickName.getText();

				//창제목으로 넣기
				Ex04_ClientChat.this.setTitle(nickName+"님 채팅창");

				//run 메소드 호출
				Thread th = new Thread(Ex04_ClientChat.this);
				th.start();
				//익명 내부클래스의 this는 내부 클래스 자기 자신을 가르킨다.
			}
		});

		//메세지 입력후 엔터 또는 전송 버튼 누를때 이벤트 발생
		//둘다 같은 메서드 호출- 기능이 같으므로
		tfMessage.addActionListener(this);
		btnSend.addActionListener(this);
	}


	public void autoScroll()
	{
		int n = area.getDocument().getLength();//총 라인수
		area.setCaretPosition(n); // 마지막줄로 위치 변경
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex04_ClientChat client = new Ex04_ClientChat();
	}

	



}
