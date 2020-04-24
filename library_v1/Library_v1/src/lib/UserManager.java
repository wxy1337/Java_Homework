package lib;

import java.util.HashSet;
 
import java.util.Set;
 
public class UserManager {
 
    private Set<User> users = new HashSet<>();
 
    public UserManager() {
 
        users.add(new User("admin", "root"));
    }
 
    //��ʼ�˵�
    public void start() {
        while (true) {
 
            MenuUtils.welcome();
            int choose = InputUtils.getInt(("����������ѡ��"));
            switch (choose) {
            case 1:
                User lUser = login();
                if (lUser != null) {
                    BookManager.getInstance().start(lUser);
                } else {
                    System.out.println("��¼ʧ��");
                }
                break;
 
            case 2:
                boolean reg = register();
                System.out.println(reg ? "ע��ɹ�" : "ע��ʧ��");
                break;
 
            case 3:
                System.out.println("�˳�����");
                System.exit(0);
                break;
 
            default:
                break;
            }
        }
 
    }
 
    //��¼����
    private User login() {
 
        while (true) {
            String username = InputUtils.getStr(("�������û�����(exit�˳�)"));
            if (username.equals("exit")) {
                start();
            }
            
            boolean checkUserName = checkUserName(username);
            
            if (!checkUserName) {
                System.out.println("�û���������,����������:");
                continue;
            }
            
            String password = InputUtils.getStr(("�������������룺"));
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
 
                    // �����û�
                    return user;
                }
 
            }
 
            return null;
        }
 
    }
    /***
     * ע��**
     * 
     * @author ˮԽ��
     * @date 2018��11��20�� ����12:09:04
     */
 
    private boolean register() {
        while (true) {
            String username = InputUtils.getStr("����������û���:(exit�˳�)");
            if (username.equals("exit")) {
                return false;
            }
 
            boolean isCheck = checkUserName(username);
            if (isCheck) {
                System.out.println("�û�����,����������:");
                continue;
            }
 
            String password = InputUtils.getStr("�������������:");
 
            // ��ӵ� �û�����ļ�����
            return users.add(new User(username, password));
        }
    }
 
    /***
     * ��֤�û��Ƿ����**
     * 
     * @author ˮԽ��
     * @date 2018��11��20�� ����12:05:01
     */
 
    private boolean checkUserName(String username) {
 
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
 
        return false;
 
    }
}