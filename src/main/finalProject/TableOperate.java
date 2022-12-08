package main.finalProject;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class TableOperate {

    //数据库查询连接模板
    public TableOperate() {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");

            String sql = "select * from user";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("编号" + "\t" + "姓名" + "\t" + "年龄");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //是否存在该用户,此处跟下面的管理员验证为或者关系
    public static boolean isExist_user(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from user";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isExist_Customer(String user) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from user";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }

    //是否存在该管理员
    public static boolean isExist_Manager(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Manager");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Manager");

            String sql = "select * from Manager";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isExist_Manager(String user) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from Manager";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }

    //注册新用户，这里注册逻辑为用户名必须为唯一的，如果用户名已经存在则注册失败，其次用户名需要符合规范，规范含非你自己定一下，
    // 我在这个文件夹中定义了一个PwdCheck类，里面有一个方法，可以判断账号密码是否符合规范，如果不符合规范则注册失败
    public static void register_User(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-register_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-register_Customer");

            String sql = "insert into lib.user values('" + user + "','" + password + "','0');";

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.execute();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //注册新管理员，此原理与上同
    public static void register_Manager(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-register_Manager");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-register_Manager");

            String sql = "insert into Manager values('" + user + "','" + password + "');";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //改变用户的密码，此处也需要符合规范
    public static void changePassword_User(String user, String password, String newPassword) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update user set user.password = '" + newPassword + "' where user.userName = '" + user + "';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changePassword_User(String user, String newPassword) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update user set user.password = '" + newPassword + "' where user.userName = '" + user + "';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //改变管理员的密码，原理同上
    public static void changePassword_Manager(String user, String password, String newPassword) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update Manager set manager.Password = '" + newPassword + "' where manager.Name = '" + user + "';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changePassword_Manager(String user, String newPassword) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update Manager set manager.Password = '" + newPassword + "' where manager.Name = '" + user + "';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //是否存在该用户名，如果存在则返回true，否则返回false
    public static boolean isExist_Customer_user(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from user";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //是否存在该管理员名称，原理同上
    public static boolean isExist_Manager_user(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Manager");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Manager");

            String sql = "select * from Manager";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //插入新书
    public static void insertBook(String id, String bookName,
                                  String author, String brief, String state, String type) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-insertBook");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-insertBook");

            String sql = "insert into " + "book" + " values('" + id + "','" + bookName +
                    "','" + author + "','" + brief + "','" + state + "','" + type + "','null','000-00-00 00:00:00','0');";   //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.execute();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //删除书籍信息
    public static void deleteBook(String id) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-deleteBook");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-deleteBook");

            String sql = "delete from " + "book" + " where id = '" + id + "';";  //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询某类图书信息
    public static void search_certainTypeBook(String type) {
        Information.bookArray.clear();
        try {

            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_classname");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_classname");

            String sql = "select * from " + "lib.book" + " where id = '" + type + "';"; //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                Book book = new Book();
                book.id = rs.getString(1);
                book.bookName = rs.getString(2);
                book.author = rs.getString(3);
                book.brief = rs.getString(4);
                book.state = rs.getString(5);
                book.type = rs.getString(6);
                book.browser = rs.getString(7);
                book.dateOn = rs.getString(8);
                Information.bookArray.add(book);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //借书注射到用户信息
    public static void borrowBook_Insert(String ID, String userName, java.sql.Date date) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-borrowBook_Insert");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-borrowBook_Insert");

            String sql = "insert into " + "record values('" + userName + "','" + ID + "','" + date + "');";
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.execute();
            stmts.close();

            sql = "insert into " + "history values('" + userName + "','" + ID + "','" + date + "');";
            PreparedStatement stmts_history = conn.prepareStatement(sql);
            stmts_history.execute();
            stmts_history.close();

            sql = "update " + "book" + " set state = '1' where id = '" + ID + "';";
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.execute();
            stmts_state.close();

            sql = "update " + "book" + " set dateOn = '" + date + "' where id = '" + ID + "';";
            PreparedStatement stmts_date = conn.prepareStatement(sql);
            stmts_date.execute();
            stmts_date.close();

            sql = "update " + "book" + " set browser = '" + userName + "' where id = '" + ID + "';";
            PreparedStatement stmts_browser = conn.prepareStatement(sql);
            stmts_browser.execute();
            stmts_browser.close();

            sql = "update " + "user" + " set BookNums +=1" + " where userName = '" + userName + "';";
            PreparedStatement stmts_personalBook = conn.prepareStatement(sql);
            stmts_personalBook.execute();
            stmts_personalBook.close();


            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //还书更新书籍数据库信息
    public static void returnBook_Update(String ID, String userName) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-returnBook_Update");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-returnBook_Update");

            String sql = "DELETE from " + "record where userName = '" + userName + "' and ID = '" + ID + "';";
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();
            stmts.close();

            sql = "update " + "book" + " set state = '0' where id = '" + ID + "';";
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.executeUpdate();
            stmts_state.close();

            sql = "update " + "book" + " set dateOn = '" + null + "' where id = '" + ID + "';";
            PreparedStatement stmts_date = conn.prepareStatement(sql);
            stmts_date.executeUpdate();
            stmts_date.close();

            sql = "update " + "book" + " set browser = '" + null + "' where id = '" + ID + "';";
            PreparedStatement stmts_browser = conn.prepareStatement(sql);
            stmts_browser.executeUpdate();
            stmts_browser.close();

            sql = "update " + "user" + " set personalBook -=1" + " where userName = '" + userName + "';";
            PreparedStatement stmts_personalBook = conn.prepareStatement(sql);
            stmts_personalBook.executeUpdate();
            stmts_personalBook.close();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询个人图书信息
    public static void search_personal(String userName) {
        Information.bookArray.clear();
        try {

            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_personal");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_personal");

            String sql = "select * from record where userName='" + userName + "';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                System.out.println(rs.getString("ID"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查找书名
    public static String search_bookNameWithID(String id) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookName");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_bookName");

            String sql = "select * from lib.book where id like ='" + id + "';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                return rs.getString(3);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "null";
    }

    public static String search_bookNameWithAuthor(String author) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookName");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_bookName");

            String sql = "select * from lib.book where author='" + author + "';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                return rs.getString(3);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "null";
    }

    //查询多条数据从数据库中
    public static ArrayList search_bookWithBookName(String bookName) {
        Information.bookArray.clear();
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_book");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_book");

            String sql = "select * from lib.book where bookName like ='" + bookName + "';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                Information.bookArray.add(new Book(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getInt(9)));
            }
            //热点值加1
            String sql2 = "update lib.book set hot=hot+1 where bookName like ='" + bookName + "';";    //要执行的SQL
            stmt.executeUpdate(sql2);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Information.bookArray;
    }

    public static ArrayList search_bookWithAuthor(String author) {
        Information.bookArray.clear();
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_book");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_book");

            String sql = "select * from lib.book where author like ='" + author + "';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                Information.bookArray.add(new Book(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Information.bookArray;
    }

    public static ArrayList search_bookWithType(String type) {
        Information.bookArray.clear();
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_book");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_book");

            String sql = "select * from lib.book where type='" + type + "';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                Information.bookArray.add(new Book(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Information.bookArray.sort((o1, o2) -> o2.getHot() - o1.getHot());
        return Information.bookArray;
    }

    //导出用户所有信息
    public static LinkedList outputUserData() {
        Information.userlist.clear();
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_book");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_book");

            String sql = "select  *from lib.user ;";   //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()) {
                Information.userlist.add(new User(rs.getString(1), rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Information.userlist;
    }

    public static Map<Book, User> record() throws Exception {
        Map<Book, User> map = new HashMap<>();
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_book");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_book");

            String sql = "select  *from lib.record ;";   //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            PreparedStatement stmts_record = conn.prepareStatement(sql);
            stmts_record.execute();

            while (rs.next()) {
                String userName = rs.getString(1);
                String bookID = rs.getString(2);

                String sql1 = "select * from lib.user where username='" + userName + "';";
                ResultSet rs1 = stmt.executeQuery(sql1);//创建数据对象
                PreparedStatement stmts_user = conn.prepareStatement(sql1);
                stmts_user.execute();
                String sql2;

                //建立一个数组储存用户的信息
                User[] user = new User[100];
                int i = 0;
                while (rs1.next()) {
                    user[i] = new User(rs1.getString(1), rs1.getString(2), rs1.getInt(3));
                    i++;
                }
                sql2 = "select * from lib.book where ID='" + bookID + "';";
                ResultSet rs2 = stmt.executeQuery(sql2);//创建数据对象
                PreparedStatement stmts_book = conn.prepareStatement(sql2);
                stmts_book.execute();
                while (rs2.next()) {
                    int j = 0;
                    Book book = new Book(rs2.getString(1), rs2.getString(2),
                            rs2.getString(3), rs2.getString(4),
                            rs2.getString(5), rs2.getString(6), rs2.getString(7),
                            rs2.getString(8), rs2.getInt(9));
                    map.put(book, user[j]);
                }

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
