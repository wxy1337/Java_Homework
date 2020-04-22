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
		System.out.print("�ٴ�������ȷ�ϲ���:\n");
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
			System.out.println("�������");
			break;
		}
	}
	
	public void sort(Book[] books) {
		System.out.println("�鰴�۸���������: ");
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
		System.out.println("�������");
	}	
	
	public void select(Book[] books) {
	    System.out.println("�����������в�ѯ��");
	    String name = sc.next();
	    if(name != null) {
	        for(int i = 0; i < books.length; i++) {
	            if (books[i].getName().equals(name)) {
	                System.out.println("�ҵ����£�");
	                System.out.println("�鼮��Ϣ: ");
	                System.out.println(books[i].getName() + "\t"
	                		+ books[i].getAuthor() + "\t"
	                		+ books[i].getPrice() + "\t"
	                		+ books[i].getCategory() + "\t"
	                		+ books[i].isState());
	                break;
	            }
	         System.out.println("û�д���");
	         break;
	         }
	     }
	 }
	
	public void delete(Book[] books) {
        System.out.println("������Ҫɾ��������:");
        String str = sc.next();
        if(str != null) {
            for(int i = 0;i<books.length;i++) {
                if(books[i].getName().equals(str)) {
                    books[i] = null;
                    System.out.println("ɾ���ɹ���");
                  break;
                }
            }
        }
    }

    public void add(Book[] books) {
        System.out.println("������������");
        String name = sc.next();
        System.out.println("���������ߣ�");
        String author = sc.next();
        System.out.println("������۸�");
        double price = sc.nextDouble();
        System.out.println("��������ࣺ");
        String category = sc.next();

            for (int i = 0; i < books.length; i++) {
                if (books[i].getName() == null) {
                    books[i].setName(name);
                    books[i].setAuthor(author);
                    books[i].setPrice(price);
                    books[i].setCategory(category);
                    books[i].setState(true);
                    System.out.println("��ӳɹ�");
                    break;
                }
            }
        }

    public void list (Book[]books){
        System.out.println("ͼ���б����£�������-����-�۸�-����-״̬��");  //��ӡBook����
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

	
	
	
	
	
	
	
	
	
	
	