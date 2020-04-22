package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Root extends Person implements operate{

	private String Rname;
	private String Rpassword;
	
	public Root(String name, String password) {
		super(name, password);
	}	
	
	Scanner sc = new Scanner(System.in);
	
	public void operate() {
		System.out.print("再次输入以确认操作:\n");
		int i = sc.nextInt();
		switch(i) {
		case 1:
			sort(books);
			break;
		case 2:
			select(books);
			break;
		case 3:
			add(books);
			break;
		case 4:
			delete(books);
			break;
		case 5:
			list(books);
			break;
		default :
			System.out.println("输入错误");
			break;
		}
	}
	
	public void sort(Book[] books) {
		System.out.println("书按价格整理如下: ");
		Arrays.sort(books, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return (int)(o1.getPrice()-o2.getPrice());
			}
	});
	
		for(int i = 0; i < books.length; i++) {
			System.out.println(books[i].getName() + "\t" 
					+ books[i].getAuthor() + "\t"
					+ books[i].getPrice() + "\t"
					+ books[i].getCategory() + "\t"
					+ books[i].isState());
		}
		System.out.println("整理完成");
	}	
	
	public void select(Book[] books) {
	    System.out.println("输入书名进行查询：");
	    String name = sc.next();
	    if(name != null) {
	        for(int i = 0; i < books.length; i++) {
	            if (books[i].getName().equals(name)) {
	                System.out.println("找到如下：");
	                System.out.println("书籍信息: ");
	                System.out.println(books[i].getName() + "\t"
	                		+ books[i].getAuthor() + "\t"
	                		+ books[i].getPrice() + "\t"
	                		+ books[i].getCategory() + "\t"
	                		+ books[i].isState());
	                break;
	            }
	         System.out.println("没有此书");
	         break;
	         }
	     }
	 }
	
	public void delete(Book[] books) {
        System.out.println("请输入要删除的书名:");
        String str = sc.next();
        if(str != null) {
            for(int i = 0;i<books.length;i++) {
                if(books[i].getName().equals(str)) {
                    books[i] = null;
                    System.out.println("删除成功！");
                  break;
                }
            }
        }
    }

    public void add(Book[] books) {
        System.out.println("请输入书名：");
        String name = sc.next();
        System.out.println("请输入作者：");
        String author = sc.next();
        System.out.println("请输入价格：");
        double price = sc.nextDouble();
        System.out.println("请输入分类：");
        String category = sc.next();

            for (int i = 0; i < books.length; i++) {
                if (books[i].getName() == null) {
                    books[i].setName(name);
                    books[i].setAuthor(author);
                    books[i].setPrice(price);
                    books[i].setCategory(category);
                    books[i].setState(true);
                    System.out.println("添加成功");
                    break;
                }
            }
        }

    public void list (Book[]books){
        System.out.println("图书列表如下：（书名-作者-价格-分类-状态）");  //打印Book数组
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i].getName() + "\t" 
                		+ books[i].getAuthor() + "\t" 
                		+ books[i].getPrice() + "\t" 
                		+ books[i].getCategory() + "\t" 
                		+ books[i].isState());
            }
        }
    }
    
}

	
	
	
	
	
	
	
	
	
	
	