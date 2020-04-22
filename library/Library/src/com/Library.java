package com;

import java.util.Scanner;

public class Library {
	
	Scanner sc = new Scanner(System.in);
	
	public void login() {
		int count = 0;
		Person p = null;
		while(count < 2) {
			System.out.println("**********欢迎来到图书馆**********");
			System.out.println("登录：1.用户 2.管理员 3.退出");
			
			int n = sc.nextInt();
			if(n == 3) {
				return;
			}
			switch(n) {
			case 1:
				System.out.println("用户名：");
                String Uname = sc.next();
                System.out.println("密码：");
                String Upassword = sc.next();
                
                p = new User(Uname,Upassword);
                
                System.out.println("登陆成功");
                System.out.println("当前用户名：  " + p.getName());
                
                while(true) {
                	System.out.println("1.查询书籍 2.借阅书籍 3.归还书籍 4.显示书籍列表 5.退出");
                	int i = sc.nextInt();
                	if(i == 5) {
                		System.out.println("成功退出");
                		break;
                	}else {
                		p.operate();
                	}
                }
                break;
			case 2:
				System.out.println("管理员用户名：");
				String Rname = sc.next();
				System.out.println("密码：");
				String Rpassword = sc.next();
				
				p = new Root(Rname,Rpassword);
				
				System.out.println("登录成功");
                System.out.println("当前管理员： " + p.getName());
                
                while(true) {
                	System.out.println("1.整理书籍 2.查阅书籍 3.增加书籍 4.删除书籍 5.显示书籍列表 6.退出");
                	int j = sc.nextInt();
                	if(j == 6) {
                		System.out.println("成功退出");
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
