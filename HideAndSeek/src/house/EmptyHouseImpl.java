package house;

import java.util.Scanner;

import lombok.Builder;
@Builder //builder 사용
public class EmptyHouseImpl implements House {
	private String address;
	
	public String getAddress() {
		return address;
	}
	
	@Override
	public void matchPassword(Scanner sc) {
		System.out.println("[비어있는 방입니다.]");
		System.out.println("집주인: Oh, hi there! Did you come to see the house? You can move in right away :) ");
		String answer = sc.nextLine();
		if (answer == "yes") {
			//집주인과의 계약
		} else {
			System.out.println("[집주인이 당신을 침입자로 분류하였습니다.]");
			System.out.println("[경비원들이 뛰어옵니다. . .]");
		}
		
	}

}
