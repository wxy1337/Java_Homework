package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
 
 
public class BookManager {
	
    private Map<Book, Integer> books = new HashMap<>();
 
    {
        books.put(new Book("java���ļ���"), 5);
        books.put(new Book("��������"), 5);
        books.put(new Book("c++�������"), 5);
        books.put(new Book("���ݽṹ����"), 5);
        books.put(new Book("jvm"), 5);
    }
 
    private BookManager() {
 
    }
 
    private static BookManager instance = new BookManager();
 
    public static BookManager getInstance() {
 
        if (instance == null) {
 
            instance = new BookManager();
 
        }
 
        return instance;
 
    }
 
    //ͼ��ݲ˵�

    public void start(User u) {
 
        // ��ʼ�˵�
        while (true) {
 
            MenuUtils.book();
            int choose = InputUtils.getInt("���������ѡ��:(��������)");
 
            switch (choose) {
            case 1:
 
                showBooks();
 
                break;
            case 2:
 
                HashMap<Book, Integer> map = borrowBooks();
 
                // �� ���ĵ��鼮 �ŵ� ������û���
                if (map != null) {
                    u.saveBook(map);
                } else {
                    System.out.println("����ʧ��");
                }
 
                break;
            case 3:
 
                Map<Book, Integer> uMap = u.returnBook();
 
                if (uMap != null) {
 
                    returnBookManager(uMap);
 
                } else {
                    System.out.println("����ʧ��");
                }
 
                break;
            case 4:
 
                u.showBook();
 
                break;
            case 5:
                return;
            }
        }
    }
 
    //����
    private void returnBookManager(Map<Book, Integer> uMap) {
 
        Set<Entry<Book, Integer>> entrySet = uMap.entrySet();
 
        for (Entry<Book, Integer> entry : entrySet) {
 
            Integer count = entry.getValue();
            Book book = entry.getKey();
 
            // �õ� ͼ�������ϵ��鼮
            Integer num = books.get(book);
 
            // ����е� ��Ҫ�ŵ������ȥ
            books.put(book, num == null ? count : num + count);
 
        }
 
        System.out.println("����ɹ�");
 
    }
 
    //����
    private HashMap<Book, Integer> borrowBooks() {
        while (true) {
 
            String bname = InputUtils.getStr("����������:");
 
            Book book = new Book(bname);
            // �ж� �����Ƿ����
            boolean containsKey = books.containsKey(book);
 
            if (!containsKey) {
                System.out.println("�����û���Ȿ��,���������룺");
                continue;
            }
 
            int num = InputUtils.getInt("��������Ҫ���ĵ�����:");
 
            // ͼ�������ϵ�����
            Integer count = books.get(book);
 
            if (num > count) {
                System.out.println("�����û����ô����");
                return null;
            }
 
            // ���� - ���ĵ�����
            books.put(book, count - num);
 
            // ���ĵ��鼮 װ���Լ��ֿ� �������
 
            HashMap<Book, Integer> map = new HashMap<>();
 
            map.put(book, num);
 
            return map;
        }
    }
 
    private void showBooks() {
        Set<Entry<Book, Integer>> entrySet = books.entrySet();
 
        System.out.println("ͼ��\t����");
        for (Entry<Book, Integer> entry : entrySet) {
 
            System.out.println(entry.getKey().getBookName() + "\t" + entry.getValue());
        }
 
    }
 
}