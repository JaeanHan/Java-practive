package elevator;

//건물에 엘레베이터는 하나만 있다고 가정하고 singleton으로 생성

public class Elevator {
	private final int maxFloor; //최고층은 생성시 fix
	private final int minFloor; //최저층은 생성시 fix
	private int currentFloorElevator;
	private int floorToGo;
	
	public static Elevator instance;
//	private int currentFloorYou;
	
	private Elevator(int maxFloor, int minFloor) { // 인자가 너무 많은거 같아서
		this.maxFloor = maxFloor;
		this.minFloor = minFloor;
		this.currentFloorElevator = 1; // 엘레베이터는 1층에서 시작
	}
	
	public static Elevator getInstance() { // 진짜 주소 받아가기
		return instance;
	}
	//생성 두개 해도 되는지 ****
	public static Elevator getInstance(int maxFloor, int minFloor) {
		if(instance == null) {
			instance = new Elevator(maxFloor, minFloor);
		}
		return instance;
	}
	
	public int getCurrentFloorElevator() {
		return currentFloorElevator;
	}
	
	public void setCurrentFloorElevator(int currentFloorElevator) {
		this.currentFloorElevator = currentFloorElevator;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public int getFloorToGo() {
		return floorToGo;
	}

	public void setFloorToGo(int floorToGo) {
		this.floorToGo = floorToGo;
	}
	
}
