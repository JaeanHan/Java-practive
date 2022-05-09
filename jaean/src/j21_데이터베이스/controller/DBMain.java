package j21_�����ͺ��̽�.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import db.DBConnectionMgr;
import j21_�����ͺ��̽�.dao.UserDao;
import j21_�����ͺ��̽�.dto.User;
import j21_�����ͺ��̽�.dto.UserDtl;
import j21_�����ͺ��̽�.dto.UserMst;

public class DBMain {
	public static void main(String[] args) {
		UserDao userDao = new UserDao(DBConnectionMgr.getInstance());
		
		ArrayList<UserMst> userMstList = userDao.getUserMstAll();
		for(UserMst um : userMstList) {
			System.out.println(um);
		}
		
		ArrayList<UserDtl> userDtlList = userDao.getUserDtlAll();
		for(UserDtl ud : userDtlList) {
			System.out.println(ud);
		}
		
		System.out.println(userDao.getUserByUsername("jaeano"));
		
		HashMap<String, User> userMap = userDao.getUserByUsername("jaeano");
		UserMst userMst = (UserMst)userMap.get("um");
		System.out.println(userMst.getName());
		
		/*
		 * 
		 * �α����� ��������
		 * DAO -> User signin(String username, String password)
		 * 
		 * 
		 * 
		 */
		
		//ȸ�� ����
		int cnt = 0;
		Scanner sc = new  Scanner(System.in);
//		System.out.print("���� �� ȸ�� ���� �Է��ϼ���: ");
//		cnt = sc.nextInt();
//		sc.nextLine();
//		
//		ArrayList<UserMst> userList = new ArrayList<UserMst>();
//		
//		for(int i=0; i<cnt; i++) {
//			String email = null;
//			String name = null;
//			String username = null;
//			String password = null;
//			
//			System.out.println((i+1)+"��° ȸ��");
//			System.out.print("�̸���: ");
//			email = sc.nextLine();
//			System.out.print("�̸�: ");
//			name = sc.nextLine();
//			System.out.print("���̵�: ");
//			username = sc.nextLine();
//			System.out.print("��й�ȣ: ");
//			password = sc.nextLine();
//			
//			userList.add(UserMst.builder()
//						.email(email)
//						.name(username)
//						.username(username)
//						.password(password)
//						.build()
//			);
//		}
//		
//		int result = userDao.insertUserMst(userList);
//		System.out.println(result + "���� ȸ���� ����Ͽ����ϴ�.");
		

		System.out.println("[ȸ������ ����]");
		System.out.println("���̵�: ");
		String username = sc.nextLine();
		
		System.out.print("�ּ�");
		String address = sc.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String phone = sc.nextLine();
		System.out.print("����");
		int gender = sc.nextInt();
		int result = 0;
		sc.nextLine();
		
		UserDtl userDtl = UserDtl.builder()
				.address(address)
				.phone(phone)
				.gender(gender)
				.build();
		
		result = userDao.updateUserDtl(username, userDtl);
		if(result > 0) {
			System.out.println(username + "ȸ���� ������ �����Ͽ����ϴ�.");
		} else {
			System.out.println("���̹����̽�����!");
		}
	}
	
	

}
