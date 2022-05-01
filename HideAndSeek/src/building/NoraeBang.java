package building;

import java.util.Scanner;
import noraebang.NoraeMachineImpl;

/*
 * Karaoke는 손에 잘 안붙고
 * CoinKaraoke는 너무 길고
 * NoraeBang이 더 직관적
 */

public class NoraeBang { 
	private NoraeMachineImpl machine1;
	private NoraeMachineImpl machine2;
	private NoraeMachineImpl machine3;

	public NoraeBang() {
//		Di를 지향해야하지만 노래방 기계 3개를 main 클래스에서
//		선언하고 넘겨주는건 좀 번거로우니 여기서 생성
		machine1 = new NoraeMachineImpl("poknjui","podfnvifb" ,"spdovnsbuo", 1 );
		machine2 = new NoraeMachineImpl("qweudqowufn", "qowjbchak", "zmznsjso", 2);
		machine3 = new NoraeMachineImpl("zxcas", "aspdooi", "alskdus", 3);
	}
	
	public void useNoraeBang(Scanner sc) {
		System.out.println("[코인 노래연습장에 도착하였습니다.]");
		System.out.println("[1번방] [2번방] [3번방]");
		System.out.println("[어떤 방을 이용하시겠습니까? 숫자만 입력해 주세요.]");
		String ans = sc.nextLine();
		if (ans.equals("1")) {
			machine1.insertCoin(sc);
		} else if (ans.equals("2")) {
			machine2.insertCoin(sc);
		} else if (ans.equals("3")) {
			machine3.insertCoin(sc);
		} else {
			System.out.println("[??? 이해할 수 없는 행동입니다.]");
			System.out.println("[당신은 죽었습니다.]");
		}
	}
	
}
