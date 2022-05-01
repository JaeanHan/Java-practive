package quest;

/*
 * 이거도 약간 굳이?
 * 지만 배웠으니까 써봄
 */
public class Quest {
	public static Quest instance;
	private static Boolean targetOne = false;; 
	private static Boolean targetTwo = false;
	private static Boolean targetThree = false;
	private static int money = 100; //나중에 Visitor로 옮길 예정 여기서 쓰는게 더 편함
	public static boolean flag=true;
	
	private Quest() {
	}
	
	public static Quest getInstance() {
		if (instance == null) {
			instance = new Quest();
		}
		return instance;
	}

	public void setTargetOne() {
		targetOne = true;
	}
	
	public void setTargetTwo() {
		targetTwo = true;
	}
	
	public void setTargetThree() {
		targetThree = true;
	}
	
	public void spendMoney() { //돈 사용시 지출 단위 고정 setMoney() 
		money -= 100; 				  //X 이거 한번만 사용하는데 static을 꼭 붙여야하는지
									  //사용하는 곳에서 객체 만들고 getInstance()로 받아와서 그걸로 spaneMoney() 실행할지
	}								  //그냥 static으로 만들어서 spendMoney() 사용할지
	
	public int getMoney() {
		return money;
	}

	public void showProgress() { //true false 하니까 버그뜨네
		System.out.println("[진행 상황]"); //ifelse로 바꾸면 될거같긴함
		System.out.println("한재안 : " + (targetOne==true ? "찾았습니다!" : "아직 못찾았습니다."));
		System.out.println("재안안 : " + (targetTwo==true ? "찾았습니다!" : "아직 못찾았습니다."));
		System.out.println("안재한 : " + (targetThree==true ? "찾았습니다!" : "아직 못찾았습니다."));
		
		updateProgress(); //이거 왜 static으로 해야하는지 *****
	}

	private void updateProgress() {
		if (targetOne == true && targetTwo == true && targetThree == true) {
			System.out.println("[축하드립니다. 숨어있던 세명 모두를 찾으셨습니다!]");
			flag=false;
		}
	}
	
	
	
	
}
