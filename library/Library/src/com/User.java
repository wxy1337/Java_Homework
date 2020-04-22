package com;

import java.util.Scanner;

class User extends Person implements operate {   //user类继承了人的类，  实现operate接口
   private String Uname;
   private String Upassword;


   public User(String name, String password) {
       super(name, password); //调用人基类的构造函数（派生类不继承基类的构造函数）
   }

   Scanner sc = new Scanner(System.in);

   public void operate() {  //普通用户的操作

       System.out.print("再次输入以确认操作:\n");
       int i = sc.nextInt();
       switch (i) {
           case 1://查
               select(books);
               break;
           case 2: //借
               delete(books);
               break;
           case 3: //还
               add(books);
               break;
           case 4://书列表
               list(books);
               break;
           default:
               System.out.println("输入有误！");
               break;
       }
   }

   public void select(Book[] books) {
       System.out.println("请输入书名进行查询：");
       String name = sc.next();
       if(name != null) {

           for (int i = 0; i < books.length; i++) {
               if (books[i].getName().equals(name)) {
                   System.out.println("有此书籍！");
                   System.out.println("书籍信息为：（书名-作者-价格-分类-状态）");
                   System.out.println(books[i].getName() + "   "+books[i].getAuthor() + "   "+books[i].getPrice() + "   "+books[i].getCategory() + "   "+books[i].isState());
                   break;
               }
               System.out.println("暂时没有此书！");
               break;
           }
       }
   }
   
   public void delete(Book[] books) {
       System.out.println("请输入要借阅的书名:");
       String name = sc.next();
       if (name != null) {
           for (int i = 0; i < books.length-1; i++) {
               if (books[i].getName().equals(name)) {  //借走书时设置状态为false
                   books[i].setState(false);
                   System.out.println("借阅成功！");
                   break;
               } else {               //没书
                   System.out.println("没有此书！");
                   break;
               }
           }
       }
   }

   public void add(Book[] books) {

       System.out.println("请输入要还的书名：");
       String name = sc.next();

       if (name != null) {
           for (int j = 0; j < books.length-1; j++)
               if (books[j].getName().equals(name)) {
                   books[j].setState(true);
                   System.out.println("还书成功！");
                   break;
               }
       }
   }


   public void list(Book[] books) {
       System.out.println("图书列表如下：（书名-作者-价格-分类-状态）");  //打印Book数组
       for (int i = 0; i < books.length; i++) {
           if (books[i] != null) {
               System.out.println(books[i].getName() + "   " + books[i].getAuthor() + "   " + books[i].getPrice() + "   " + books[i].getCategory() + "   " + books[i].isState());
            }
       }
   }
}
