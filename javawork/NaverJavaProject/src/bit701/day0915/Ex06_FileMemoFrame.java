package bit701.day0915;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex06_FileMemoFrame extends JFrame{

	JTextArea memoArea;
	JButton btnSave,btnOpen,btnClear;
	
	public Ex06_FileMemoFrame(String title)
	{	//this로 호출했지만 JFrame 가지고 있던것, 그리고 JFrame도 물려받은 것들
		super(title);//JFrame의 문자열을 받는 생성자 호출 
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(500,600);//프레임의 너비, 높이
		this.getContentPane().setBackground(new Color(200,255,180)); // Background만 이렇게 변경한다. -> Color 상수를 이용해 변경
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		this.setVisible(true);//ture:프레임을 보이게 하기, false:프레임 숨기기 / 색 지정 이런건 visible 전에 줘야 적용된다.
		// x 누르면 속성이 false 인거지 닫히는게 아님. 종료는 아래의 콘솔에서 빨간색 정지하고 xx 버튼 눌러야함

		//윈도우 이벤트 발생
		//this.addWindowListener(new WindowLister()) // 이렇게 하면 메서드 8개 다 오버라이드 함. 필요한건 1개지만 



		//윈도우 이벤트 발생 - 익명내부클래스 형태로 이벤트 구현, 좀 길면 따로 클래스 구현해서 사용해도 괜찮다.
		this.addWindowListener(new WindowAdapter() { //이렇게 하면 필요한것 한개만 구현 가능 
			//여기서 클래스를 구현하면 된다. 
			@Override
			public void windowClosing(WindowEvent e) {//x 버튼 클릭시 호출되는 메서드
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다.");
				//실제종료
				System.exit(0);//정상종료
				super.windowClosing(e);
			}

		}); // Listener로 끝나면 거의 인터페이스를 구현하는것 
	}


	private void setDesign() {
		// TODO Auto-generated method stub
		btnSave=new JButton("파일저장");
		btnOpen=new JButton("파일열기");
		btnClear=new JButton("내용지우기");
		
		JPanel p=new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		p.add(btnClear);
		
		//Panel을 Norht 에 추가
		this.add(p,"North");
		
		memoArea=new JTextArea("내용을 입력해보세요.");
//		this.add(memoArea,"Center"); //data가 긴경우 스크롤바 생성 x 추가해야함. border layout ?은 위치를 지정해야 한다.
		
		this.add(new JScrollPane(memoArea),"Center"); //스크롤팬 생성자 안에 넣어주면 된다.
		
		//버튼: 내용지우기 -> 익명 내부클래스 구현 
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memoArea.setText("");
			}
		});
		
		//버튼 : 파일저장
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg=new FileDialog(Ex06_FileMemoFrame.this,"메모장저장",FileDialog.SAVE);
				dlg.setVisible(true);
				//System.out.println("디렉토리:"+dlg.getDirectory());
				//System.out.println("파일명:"+dlg.getFile());
				
				//취소시 메서드 종료
				if(dlg.getDirectory()==null) //취소시 널값 들어감
					return;
				
				String fileName=dlg.getDirectory()+dlg.getFile()+".txt";//불러오기는 .txt 빼고
				String memoText=memoArea.getText();//저장할 내용을 변수에 담는다.
				
				FileWriter fw=null;
				try {
					fw=new FileWriter(fileName);
					//내용저장하기
					fw.write(memoText);
					//메모장에 메세지 넣기
					memoArea.setText("저장되었습니다");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					System.out.println("메모장 저장하다가 오류가 났네요!"+e1.getMessage());
				}finally {
					try {
						fw.close();
					} catch (NullPointerException|IOException e1) {
						// close 시 나올만한 Exception 두개 나열
					}
				}//파이널리 끝
				
			}//메서드 끝
		});
		
		//버튼 : 파일열기
				btnOpen.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						FileDialog dlg=new FileDialog(Ex06_FileMemoFrame.this,"메모장열기",FileDialog.LOAD);
						dlg.setVisible(true);
						//System.out.println("디렉토리:"+dlg.getDirectory());
						//System.out.println("파일명:"+dlg.getFile());
						
						//취소시 메서드 종료
						if(dlg.getDirectory()==null)
							return;
						
						String fileName=dlg.getDirectory()+dlg.getFile();
						FileReader fr=null;
						BufferedReader br=null;
						try {
							fr=new FileReader(fileName);
							br=new BufferedReader(fr);
							//메모장에 기본내용 지우기
							memoArea.setText("");
							
							while(true)
							{
								String line=br.readLine();
								if(line==null)
									break;
								memoArea.append(line+"\n");
							}
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally {
							try {
								br.close();
								fr.close();
							} catch (NullPointerException|IOException e1) {
								e1.printStackTrace();
							}
						}//파이널리 끝
					}//메서드 끝
				});//끝		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex06_FileMemoFrame s=new Ex06_FileMemoFrame("간단한 메모장");
	}
}
