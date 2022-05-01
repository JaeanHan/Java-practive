package visitor;

import java.util.Scanner;

import quest.Quest;

/*
 * visitor는 무조건 한명
 * 그런데 꼭 singleton으로 생성하야하는지
 */

public class Visitor {
	private String name;
//	private int money;
//	Quest quest; //quest 확인하려고 넣어놨는데 필요없을지도? ****
	
	public Visitor(Scanner sc) {
		System.out.println("이름을 입력해 주세요: ");
		name = sc.nextLine();
//		quest = Quest.getInstance();
	}
	
	public String getName() {
		return name;
	}
	
//	public void showProgress() {
//		quest.showProgress();
//	}
}
