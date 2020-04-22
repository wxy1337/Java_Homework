package com;

import java.util.Scanner;

class User extends Person implements operate {   //user��̳����˵��࣬  ʵ��operate�ӿ�
   private String Uname;
   private String Upassword;


   public User(String name, String password) {
       super(name, password); //�����˻���Ĺ��캯���������಻�̳л���Ĺ��캯����
   }

   Scanner sc = new Scanner(System.in);

   public void operate() {  //��ͨ�û��Ĳ���

       System.out.print("�ٴ�������ȷ�ϲ���:\n");
       int i = sc.nextInt();
       switch (i) {
           case 1://��
               select(books);
               break;
           case 2: //��
               delete(books);
               break;
           case 3: //��
               add(books);
               break;
           case 4://���б�
               list(books);
               break;
           default:
               System.out.println("��������");
               break;
       }
   }

   public void select(Book[] books) {
       System.out.println("�������������в�ѯ��");
       String name = sc.next();
       if(name != null) {

           for (int i = 0; i < books.length; i++) {
               if (books[i].getName().equals(name)) {
                   System.out.println("�д��鼮��");
                   System.out.println("�鼮��ϢΪ��������-����-�۸�-����-״̬��");
                   System.out.println(books[i].getName() + "   "+books[i].getAuthor() + "   "+books[i].getPrice() + "   "+books[i].getCategory() + "   "+books[i].isState());
                   break;
               }
               System.out.println("��ʱû�д��飡");
               break;
           }
       }
   }
   
   public void delete(Book[] books) {
       System.out.println("������Ҫ���ĵ�����:");
       String name = sc.next();
       if (name != null) {
           for (int i = 0; i < books.length-1; i++) {
               if (books[i].getName().equals(name)) {  //������ʱ����״̬Ϊfalse
                   books[i].setState(false);
                   System.out.println("���ĳɹ���");
                   break;
               } else {               //û��
                   System.out.println("û�д��飡");
                   break;
               }
           }
       }
   }

   public void add(Book[] books) {

       System.out.println("������Ҫ����������");
       String name = sc.next();

       if (name != null) {
           for (int j = 0; j < books.length-1; j++)
               if (books[j].getName().equals(name)) {
                   books[j].setState(true);
                   System.out.println("����ɹ���");
                   break;
               }
       }
   }


   public void list(Book[] books) {
       System.out.println("ͼ���б����£�������-����-�۸�-����-״̬��");  //��ӡBook����
       for (int i = 0; i < books.length; i++) {
           if (books[i] != null) {
               System.out.println(books[i].getName() + "   " + books[i].getAuthor() + "   " + books[i].getPrice() + "   " + books[i].getCategory() + "   " + books[i].isState());
            }
       }
   }
}
