package com;

public abstract class Person {
	public String name;
	public String password;
	
	public static Book[] books = new Book[] {
			new Book("���μ�","��ж�",10,"����",true),
            new Book("��¥��","��ѩ��",20,"����",true),
            new Book("��������","�޹���",15,"����",true),
            new Book("С��ͬѧ","С��",5,"��־",true),
			new Book()
	};
	public Person(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public abstract void operate();
}
