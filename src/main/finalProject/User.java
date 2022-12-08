package main.finalProject;

public class User {
    private String userName;
    private String password;
    private int bookNums;

    public User(){}

    public User(String userName, String password, int bookNums) {
        this.userName = userName;
        this.password = password;
        this.bookNums = bookNums;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getBookNums() {
        return bookNums;
    }
}
