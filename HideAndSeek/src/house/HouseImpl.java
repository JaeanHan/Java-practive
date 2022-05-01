package house;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import quest.Quest;

@RequiredArgsConstructor //final 때문에 필수
public class HouseImpl implements House{
	final private String address;
	final private String Resident;
	final private String password; //나중에 final 빼고 방에 들어간 상태에서 
									//password 바꿀 수 있게 해봐야겠음

	public String getAddress() { //나중에 호수 선택할 때 사용
		return address;
	}

	@Override
	public void matchPassword(Scanner sc) {
		System.out.println("[" + address + "호]\n");
		System.out.println("거주인 이름을 입력해주세요: ");
		String tmpResident = sc.nextLine();
		System.out.println("비밀번호를 입력해 주세요: ");
		String tmpPassword = sc.nextLine();
		
		if (tmpResident.equals(Resident) && tmpPassword.equals(password) ) {
			showState();
			return;
		}
		System.out.println("비밀번호 또는 거주인명이 틀렸습니다.");
		System.out.println("[침입자로 의심되어 경비원을 호출합니다.]");
		
	}
	
	private void showState() {
		System.out.println("시스템: " + Resident + "님 어서오세요!\n");
		if(address.equals("401")) {
			Quest.getInstance().setTargetOne();
			System.out.println("[한재안을 찾았습니다!]");
		} else {
			System.out.println("[하지만 집은 비어져있다.]");
		}
	}

}
