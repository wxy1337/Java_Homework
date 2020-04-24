package lib;


import java.util.Scanner;
 
public class InputUtils {
 
    private static Scanner scanner = new Scanner(System.in);
 
    // ��ȡintֵ
    public static int getInt(String msg) {
 
        System.out.println(msg);
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("�������,����������:");
            }
        }
 
    }
 
    // ��ȡString		
    public static String getStr(String string) {
        System.out.println(string);
        return scanner.next();
    }
 
}