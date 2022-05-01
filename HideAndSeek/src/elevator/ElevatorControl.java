package elevator;

import java.util.Scanner;

public class ElevatorControl {
	private Elevator elevator;
	private ElevatorUse elevatorUse;
	
	public ElevatorControl() {
		elevator = Elevator.getInstance();
		elevatorUse = new ElevatorUse(elevator);
	}
	
	public void elevatorON(Scanner sc) {
		System.out.println("[층을 선택해주세요.]");
		System.out.println("[" + elevator.getMinFloor() + " ~ " + elevator.getMaxFloor() + "]");
		elevatorUse.checkElevatorFloor(sc);
	}
	
	
	

}
