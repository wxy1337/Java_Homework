package com;

public abstract class Person {
	public String name;
	public String password;
	
	public static Book[] books = new Book[] {
			new Book("西游记","吴承恩",10,"名著",true),
            new Book("红楼梦","曹雪芹",20,"名著",true),
            new Book("三国演义","罗贯中",15,"名著",true),
            new Book("小茗同学","小明",5,"杂志",true),
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
