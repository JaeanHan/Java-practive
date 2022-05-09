package j22_������;

import java.util.ArrayList;

public class ThreadTest {

	public static void main(String[] args) {
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new AutoSum2());
			t.start();
			threads.add(t);
		}
		
		for(int i=0; i< threads.size(); i++) {
			Thread t = threads.get(i);
			try {
				t.join(); // �ش� �����尡 ����� ������ ��ٷ���.
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
		
		System.out.println("���� �޼ҵ� ����");

	}

}
