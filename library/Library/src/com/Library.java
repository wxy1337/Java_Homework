package com;

import java.util.Scanner;

public class Library {
	
	Scanner sc = new Scanner(System.in);
	
	public void login() {
		int count = 0;
		Person p = null;
		while(count < 2) {
			System.out.println("**********��ӭ����ͼ���**********");
			System.out.println("��¼��1.�û� 2.����Ա 3.�˳�");
			
			int n = sc.nextInt();
			if(n == 3) {
				return;
			}
			switch(n) {
			case 1:
				System.out.println("�û�����");
                String Uname = sc.next();
                System.out.println("���룺");
                String Upassword = sc.next();
                
                p = new User(Uname,Upassword);
                
                System.out.println("��½�ɹ�");
                System.out.println("��ǰ�û�����  " + p.getName());
                
                while(true) {
                	System.out.println("1.��ѯ�鼮 2.�����鼮 3.�黹�鼮 4.��ʾ�鼮�б� 5.�˳�");
                	int i = sc.nextInt();
                	if(i == 5) {
                		System.out.println("�ɹ��˳�");
                		break;
                	}else {
                		p.operate();
                	}
                }
                break;
			case 2:
				System.out.println("����Ա�û�����");
				String Rname = sc.next();
				System.out.println("���룺");
				String Rpassword = sc.next();
				
				p = new Root(Rname,Rpassword);
				
				System.out.println("��¼�ɹ�");
                System.out.println("��ǰ����Ա�� " + p.getName());
                
                while(true) {
                	System.out.println("1.�����鼮 2.�����鼮 3.�����鼮 4.ɾ���鼮 5.��ʾ�鼮�б� 6.�˳�");
                	int j = sc.nextInt();
                	if(j == 6) {
                		System.out.println("�ɹ��˳�");
                		break;
                	}else {
                		p.operate();
                	}
                }
                break;
			}
		}
	}
}
