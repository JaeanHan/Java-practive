package noraebang;

import java.util.Random;
import java.util.Scanner;

import quest.Quest;

public class NoraeMachineImpl implements NoraeMachine{
	private String[] song;
	private Random random = new Random();
	private int roomNumber;
	
	public NoraeMachineImpl(String lyric1, String lyric2, String lyric3, int num) {
		song = new String[] {lyric1, lyric2, lyric3 }; // 엄청 길게
		roomNumber = num;
	}
	
	private void singASong(Scanner sc) {
		Boolean ifShow = true;
		System.out.println("[같이 불러요]");
		
		for (int i=0; i<3; i++) {
			String tempLyric = song[random.nextInt(song.length)];
			System.out.println("lyrics: " + tempLyric);
			String inputLyric = sc.nextLine();
			if (!(tempLyric.equals(inputLyric))) {
				System.out.println("[가사가 틀렸습니다.]");
				System.out.println("[당신은 죽었습니다.]");
				ifShow = true;
				break;
			} //for-else
		}
		if (ifShow) {
			showResult(); 
		}
	}
	private void showResult() { //2에서 이거 override 안됨
		System.out.println("[노래를 잘하시는 군요!]");
		if(roomNumber == 3) {
			Quest.getInstance().setTargetTwo();
			System.out.println("재안안을 찾았습니다!");
		} else {
		System.out.println("[당신은 죽었습니다.]");
		}
	}
	
	@Override
	public void insertCoin(Scanner sc) {
		System.out.println("[코인을 넣으시겠습니까?]");
		System.out.println("[입력: yes or no]");
		String answer = sc.nextLine();
		if (answer.equals("yes")) {
			Quest.getInstance().spendMoney();
			singASong(sc);
		} else {
			System.out.println("[이용안할거면 NAGA");
			System.out.println("[당신은 NAGA가 되었습니다.]");
			System.out.println("[바다로 돌아갑니다. . .]");
		}
		
	}
}