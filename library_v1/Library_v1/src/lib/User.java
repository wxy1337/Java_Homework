package lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//�û���
public class User {
 
    private String username;
    private String password;
 
    public String getUsername() {
            return username;
    }
 
    public void setUsername(String username) {
            this.username = username;
    }
 
    public String getPassword() {
            return password;
    }
 
    public void setPassword(String password) {
            this.password = password;
    }
 
    public User() {
    }
 
    public User(String username, String password) {
            this.username = username;
            this.password = password;
    }
 
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((password == null) ? 0 : password.hashCode());
            result = prime * result + ((username == null) ? 0 : username.hashCode());
            return result;
    }
 
    @Override
    //��дequals
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            User other = (User) obj;
            if (password == null) {
                    if (other.password != null)
                            return false;
            } else if (!password.equals(other.password))
                    return false;
            if (username == null) {
                    if (other.username != null)
                            return false;
            } else if (!username.equals(other.username))
                    return false;
            return true;
    }
 
    // ��������
 
    private HashMap<Book, Integer> hashMap = new HashMap<>();
 
 
    //�����鼮

    public void saveBook(HashMap<Book, Integer> map) {
 
            Set<Entry<Book, Integer>> entrySet = map.entrySet();
 
            for (Entry<Book, Integer> entry : entrySet) {
                   
                    Book book = entry.getKey();
                    Integer count = entry.getValue();
 
                    Integer num = hashMap.get(book);
 
                    // װ�� �û��������
                    hashMap.put(book, num == null ? count : num + count);
 
            }
 
            System.out.println("���� �ɹ�");
 
    }
 
    // ����    
    public Map<Book, Integer> returnBook() {
 
            while (true) {
 
                    String bname = InputUtils.getStr("�������鼮������:");
                    Book book = new Book(bname);
 
                    boolean containsKey = hashMap.containsKey(book);
 
                    if (!containsKey) {
                            System.out.println("û���������,����������");
                            continue;
                    }
 
                    int num = InputUtils.getInt("�����뻹�������:");
 
                    // ������������
                    Integer count = hashMap.get(book);
 
                    if (num > count) {
                            System.out.println("�����û����ô����");
                            return null;
                    }
 
                    
                    hashMap.put(book, count - num);
 
                    Map<Book, Integer> map = new HashMap<>();
                    map.put(book, num);
                    return map;
            }
    }
 
    //��ʾ�鼮
    public void showBook() {
 
            Set<Entry<Book, Integer>> entrySet = hashMap.entrySet();
 
            System.out.println("ͼ��\t����");
            for (Entry<Book, Integer> entry : entrySet) {
 
                    System.out.println(entry.getKey().getBookName() + "\t" + entry.getValue());
            }
 
    }
}