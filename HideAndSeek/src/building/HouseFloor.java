package building;

import java.util.Scanner;

import house.HouseImpl;

//아 interface로 틀만 짜놓을 껄
//원래는 거주층은 하나만 만들 생각이었는데
//설계의 중요성.
public class HouseFloor {
	private HouseImpl house1; //이사갈 수도 있으니까 final x
	private HouseImpl house2; // 집 안에 사람이 숨어있다고 할지 없다고 할지 고민중 
//									만약 있다면 HouseImpl 상속받아서 matchPassword() override

	public HouseFloor(String floorNumber) { //DI를 사용할 순 있지만 main에서 생성하기엔 너무 복잡해져서 감당안될듯
		house1 = new HouseImpl(floorNumber +"01" , "한재안", "1234"); //그리고 비밀번호 때문에 메인에서 보여주기 싫음
		house2 = new HouseImpl(floorNumber +"02", "안재한", "4321");
	}
	
	public void whichRoom(Scanner sc) {
		System.out.println("[외부인은 접근할 수 없습니다.\n]");
		System.out.println("[방문하실 호수를 입력해주세요.]");
		System.out.println("[" + house1.getAddress() + "] [" + house2.getAddress() + "]\n");
		
		String house = sc.nextLine();
		
		if (house.equals(house1.getAddress())) {
			house1.matchPassword(sc);
		} else if (house.equals(house2.getAddress())) {
			house2.matchPassword(sc);
		}
		else {
			System.out.println("[존재하지 않는 호수를 입력하셨습니다.]");
			System.out.println("[침입자로 의심되어 경비원을 호출합니다.]\n");
		}
	}
}
