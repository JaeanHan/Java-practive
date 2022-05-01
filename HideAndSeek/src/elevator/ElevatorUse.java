package elevator;

import java.util.Scanner;

import quest.Quest;

public class ElevatorUse {
	Elevator elevator; //건물 단 하나의 엘레베이터
	
	public ElevatorUse(Elevator elevator) { //엘레베이터를 싱글톤으로 생성했으니 getInstance()로 주소값 전달
		this.elevator = elevator; //DI??
	}
	
	public void checkElevatorFloor(Scanner sc) { // 다른클래스에서는 얘만 접근가능
		int selectedFloor = Integer.parseInt(sc.nextLine());

		if (selectedFloor == elevator.getCurrentFloorElevator()) {
			System.out.println("[안재한을 찾았습니다!]"); //여기에 숨어 있었다
			Quest.getInstance().setTargetThree(); //true로 바꿈
			return;
		}
		
		elevator.setFloorToGo(selectedFloor);
		displayCurrentProcess();
	}
	
	private void displayCurrentProcess() { //엘레베이터 올라가는지 내려가는지
			if (elevator.getCurrentFloorElevator() < elevator.getFloorToGo() ) {
				UpElevator();
			} else {
				DownElevator();
			}
	}
	
	private void UpElevator() {
		System.out.println("[엘레베이터에 탑승하셨습니다.]");
		System.out.println("[" + elevator.getCurrentFloorElevator() + "층]");
		
		int z = elevator.getFloorToGo()-elevator.getCurrentFloorElevator(); //일단은 보기편하게
		
		for(int i = 0; i < z; i++) {
			System.out.println("["+ (elevator.getCurrentFloorElevator() + (i+1)) + "층]");
		}
		
		Bye();
	}
	
	private void DownElevator() {
		System.out.println("[엘레베이터에 탑승하셨습니다.]");
		System.out.println("[" + elevator.getCurrentFloorElevator() + "층. . .]");
		
		int z = elevator.getCurrentFloorElevator() - elevator.getFloorToGo();
		
		for(int i = 0; i<z; i++) {
			System.out.println("[" + (elevator.getCurrentFloorElevator() - (i+1)) + "층]");
		}
		
		Bye();
	}
	
	private void Bye() {
		elevator.setCurrentFloorElevator(elevator.getFloorToGo());
		System.out.println("[" + elevator.getCurrentFloorElevator() + "층에 도착했습니다!]\n");
		
		if(elevator.getCurrentFloorElevator() > elevator.getMaxFloor() 
				|| elevator.getCurrentFloorElevator() < elevator.getMinFloor()) {
			
			System.out.println("[마법의 엘레베이터로 인해 공간을 초월하였습니다.]");
			System.out.println("[당신은 사망하였습니다.]"); //visitor class에서 get이름
			System.out.println("[사유: " + 
					(elevator.getCurrentFloorElevator() > elevator.getMaxFloor() ?
							"낙사" : "압사") + "]\n");
			//여기서 종료****
			//별찍기 활용해서 이때 별 좌라라라라락 나오게 해볼지 고민중
			//아니면 여기서 바로 프로그램 종료 시킬지
		}
	}
	
	
	
}
