package main.finalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Information {

    //数据库用户名
    public static String username = "root";
    //数据库密码
    public static String password = "15168055471";
    //数据库URL地址
    public static String JDBC_URL = "jdbc:mysql://localhost:3306/lib";
    //查询数据库图书类别名称
    public static String search_classname = "";
    //查询数据库图书列表
    public static ArrayList<Book> bookArray = new ArrayList<Book>();
    //当前管理员
    public static String manager = "";
    //当前用户
    public static String user = "";
    //查询Table列表
    public static ArrayList<String> tablearray = new ArrayList<String>();

    //查询Table链表
    public static LinkedList<User> userlist = new LinkedList<>();

    Map<Book,User> map = new HashMap<Book,User>();


}
