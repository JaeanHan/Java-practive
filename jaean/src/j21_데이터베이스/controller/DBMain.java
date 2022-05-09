package j21_데이터베이스.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import db.DBConnectionMgr;
import j21_데이터베이스.dao.UserDao;
import j21_데이터베이스.dto.User;
import j21_데이터베이스.dto.UserDtl;
import j21_데이터베이스.dto.UserMst;

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
		 * 로그인을 만들어오기
		 * DAO -> User signin(String username, String password)
		 * 
		 * 
		 * 
		 */
		
		//회원 가입
		int cnt = 0;
		Scanner sc = new  Scanner(System.in);
//		System.out.print("가입 할 회원 수를 입력하세요: ");
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
//			System.out.println((i+1)+"번째 회원");
//			System.out.print("이메일: ");
//			email = sc.nextLine();
//			System.out.print("이름: ");
//			name = sc.nextLine();
//			System.out.print("아이디: ");
//			username = sc.nextLine();
//			System.out.print("비밀번호: ");
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
//		System.out.println(result + "명의 회원을 등록하였습니다.");
		

		System.out.println("[회원정보 수정]");
		System.out.println("아이디: ");
		String username = sc.nextLine();
		
		System.out.print("주소");
		String address = sc.nextLine();
		System.out.print("전화번호: ");
		String phone = sc.nextLine();
		System.out.print("성별");
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
			System.out.println(username + "회원의 정보를 수정하였습니다.");
		} else {
			System.out.println("데이버베이스오류!");
		}
	}
	
	

}
