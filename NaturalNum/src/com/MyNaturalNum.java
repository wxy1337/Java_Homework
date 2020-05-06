package com;

import java.util.Scanner;

public class MyNaturalNum {
	
	MyNaturalNum() throws SelfException {
		String x = getInstance();
		int num = Verify(x);
		System.out.println("�յ�����: " + num);
	}
	
	private int Verify(String in) throws SelfException{
		int length = in.length();
		int num = 0;
		char[] charArray = in.toCharArray();
		if(charArray[0] == '-'){ //����ʱ�Ķ�Ӧ����
			for(int i = 1; i < length; i++) {
				if(charArray[i] > '9' || charArray[i] < '0') { //��λ����Ƿ�����Ƿ��ַ�
					//System.out.println("�����Ƿ��ַ�");
					throw new SelfException("�����Ƿ��ַ�");
				}
			}
			//System.out.println("���ݹ�С");
			throw new SelfException("���ݹ�С");//�������λ������Ϊ���֣������Ǹ��������ݹ�С
		}
		else { //����ʱ�Ķ�Ӧ����
			for(int i = 0; i < length; i++) {
				if(charArray[i] > '9' || charArray[i] < '0') {//��λ����Ƿ�����Ƿ��ַ�
					//System.out.println("�����Ƿ��ַ�");
					throw new SelfException("�����Ƿ��ַ�");
				}else {
					num = 10 * num + charArray[i] - '0';//���ַ�ת��Ϊ����
					if(num > 100) {
						//System.out.println("���ݹ���");//�������λ������Ϊ���֣�����������100�����ݹ���
						throw new SelfException("���ݹ���");
					}
				}
			}
		}
		return num;
	}
	
	public static String getInstance() {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		return in;
	}
	
	
}
