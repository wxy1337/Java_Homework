package com;

import java.util.Scanner;

public class MyNaturalNum {
	
	MyNaturalNum() throws SelfException {
		String x = getInstance();
		int num = Verify(x);
		System.out.println("收到数字: " + num);
	}
	
	private int Verify(String in) throws SelfException{
		int length = in.length();
		int num = 0;
		char[] charArray = in.toCharArray();
		if(charArray[0] == '-'){ //负数时的对应处理
			for(int i = 1; i < length; i++) {
				if(charArray[i] > '9' || charArray[i] < '0') { //逐位检查是否包含非法字符
					//System.out.println("包含非法字符");
					throw new SelfException("包含非法字符");
				}
			}
			//System.out.println("数据过小");
			throw new SelfException("数据过小");//如果所有位的数均为数字，由于是负数，数据过小
		}
		else { //正数时的对应处理
			for(int i = 0; i < length; i++) {
				if(charArray[i] > '9' || charArray[i] < '0') {//逐位检查是否包含非法字符
					//System.out.println("包含非法字符");
					throw new SelfException("包含非法字符");
				}else {
					num = 10 * num + charArray[i] - '0';//将字符转化为数字
					if(num > 100) {
						//System.out.println("数据过大");//如果所有位的数均为数字，但正数大于100，数据过大
						throw new SelfException("数据过大");
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
