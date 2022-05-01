package building;

import java.util.Scanner;

import house.EmptyHouseImpl;
import house.HouseImpl;

public class HouseFloorForSale {
	private EmptyHouseImpl emptyHouse1;
	private EmptyHouseImpl emptyHouse2;
	
	public HouseFloorForSale(String floorNumber) { 
		emptyHouse1 = EmptyHouseImpl.builder().address(floorNumber +"01").build();
		emptyHouse2 = EmptyHouseImpl.builder().address(floorNumber +"02").build();
	}
	
	public void whichRoom(Scanner sc) {
		System.out.println("[외부인은 접근할 수 없습니다.\n]");
		System.out.println("[방문하실 호수를 입력해주세요.]");
		System.out.println("[" + emptyHouse1.getAddress() + "] [" + emptyHouse2.getAddress() + "]\n");
		
		String house = sc.nextLine();
		
		if (house.equals(emptyHouse1.getAddress())) {
			emptyHouse1.matchPassword(sc);
		} else if (house.equals(emptyHouse2.getAddress())) {
			emptyHouse2.matchPassword(sc);
		}
		else {
			System.out.println("[존재하지 않는 호수를 입력하셨습니다.]");
			System.out.println("[침입자로 의심되어 경비원을 호출합니다.]\n");
		}
	}
}
