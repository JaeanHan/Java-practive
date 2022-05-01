package main;

import java.util.Scanner;

import building.HouseFloor;
import building.HouseFloorForSale;
import building.NoraeBang;
import elevator.Elevator;
import elevator.ElevatorControl;
import house.EmptyHouseImpl;
import quest.Quest;
import visitor.Visitor;

public class MainApplication {
	public static void main(String[] args) {
		Elevator elevator = Elevator.getInstance(4, 1); //건물에 엘레베이터는 하나라고 가정
		ElevatorControl elevatorControl = new ElevatorControl(); //이것도 하나만 있으면 되는데 singleton으로 만들어야할지 ****
		
		HouseFloor fourthFloor = new HouseFloor("4"); //4층은 거주공간
		HouseFloorForSale thirdFloor = new HouseFloorForSale("3"); // 3층은 거주공간
		NoraeBang secondFloor = new NoraeBang(); //2층은 코노

		Scanner sc = new Scanner(System.in);
		Visitor player = new Visitor(sc);
		
//		boolean repeat = true; //static은 안됨
		
		System.out.println("[어서오세요."+ player.getName() +"님]\n");
		System.out.println("[Hide-and-Seek을 시작하겠습니다!]");
		System.out.println("[건물안에 숨어있는 3명을 찾아주세요!]\n");
		System.out.println("[1. 한재안 (힌트: 요즘 집돌이임)]");
		System.out.println("[2. 재안안 (힌트: 요즘 노래 연습중임)]");
		System.out.println("[3. 안재한: (힌트: 시공간을 초월함)]\n");
		
		while (Quest.flag) {
			System.out.println("\n[엘레베이터를 호출하시려면 \"call\"을 입력해주세요.]");
			System.out.println("[각 층의 설명이 필요하다면\"info\"를 입력해 주세요.]");
			System.out.println("[게임 진행 상황을 보시려면 \"progress\"를 입력해주세요.]");
			System.out.println("[엘레베이터를 이용하지 않으실 땐 \"bye\"를 입력해 주세요.]\n");
			System.out.print("입력: ");
			
			String input = sc.nextLine();
			
			if (input.equals("call")) {
				elevatorControl.elevatorON(sc);
				if (elevator.getCurrentFloorElevator()==4) {
					fourthFloor.whichRoom(sc);
				} else if (elevator.getCurrentFloorElevator()==3) {
					thirdFloor.whichRoom(sc);
				} else if (elevator.getCurrentFloorElevator()==2) {
					secondFloor.useNoraeBang(sc);
				}
					
			} else if (input.equals("info")) {
				System.out.println("[4층: 거주공간]\n[3층: 거주공간]\n[2층: 노래연습장]\n[1층: 현관]");
			} else if (input.equals("progress")) {
				Quest.getInstance().showProgress();
			} else if (input.equals("bye")) {
				break;
			}
			else {
				System.out.println("[존재하지 않는 명령어 입니다.]");
		
			}
			
		}
	}
}
