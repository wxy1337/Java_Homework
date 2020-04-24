package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
 
 
public class BookManager {
	
    private Map<Book, Integer> books = new HashMap<>();
 
    {
        books.put(new Book("java核心技术"), 5);
        books.put(new Book("三国演义"), 5);
        books.put(new Book("c++程序设计"), 5);
        books.put(new Book("数据结构基础"), 5);
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
 
    //图书馆菜单

    public void start(User u) {
 
        // 开始菜单
        while (true) {
 
            MenuUtils.book();
            int choose = InputUtils.getInt("请输入你的选择:(输入数字)");
 
            switch (choose) {
            case 1:
 
                showBooks();
 
                break;
            case 2:
 
                HashMap<Book, Integer> map = borrowBooks();
 
                // 把 借阅的书籍 放到 具体的用户中
                if (map != null) {
                    u.saveBook(map);
                } else {
                    System.out.println("借阅失败");
                }
 
                break;
            case 3:
 
                Map<Book, Integer> uMap = u.returnBook();
 
                if (uMap != null) {
 
                    returnBookManager(uMap);
 
                } else {
                    System.out.println("还书失败");
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
 
    //还书
    private void returnBookManager(Map<Book, Integer> uMap) {
 
        Set<Entry<Book, Integer>> entrySet = uMap.entrySet();
 
        for (Entry<Book, Integer> entry : entrySet) {
 
            Integer count = entry.getValue();
            Book book = entry.getKey();
 
            // 拿到 图书馆书架上的书籍
            Integer num = books.get(book);
 
            // 书包中的 书要放到书架上去
            books.put(book, num == null ? count : num + count);
 
        }
 
        System.out.println("还书成功");
 
    }
 
    //借书
    private HashMap<Book, Integer> borrowBooks() {
        while (true) {
 
            String bname = InputUtils.getStr("请输入书名:");
 
            Book book = new Book(bname);
            // 判断 书名是否存在
            boolean containsKey = books.containsKey(book);
 
            if (!containsKey) {
                System.out.println("书架上没有这本书,请重新输入：");
                continue;
            }
 
            int num = InputUtils.getInt("请输入你要借阅的数量:");
 
            // 图书馆书架上的数量
            Integer count = books.get(book);
 
            if (num > count) {
                System.out.println("书架上没有那么多书");
                return null;
            }
 
            // 总数 - 借阅的数量
            books.put(book, count - num);
 
            // 借阅的书籍 装到自己仓库 返回书包
 
            HashMap<Book, Integer> map = new HashMap<>();
 
            map.put(book, num);
 
            return map;
        }
    }
 
    private void showBooks() {
        Set<Entry<Book, Integer>> entrySet = books.entrySet();
 
        System.out.println("图书\t数量");
        for (Entry<Book, Integer> entry : entrySet) {
 
            System.out.println(entry.getKey().getBookName() + "\t" + entry.getValue());
        }
 
    }
 
}