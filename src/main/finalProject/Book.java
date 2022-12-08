package main.finalProject;

public class Book {
	public String id;
	public String bookName;
	public String author;
	public String brief;
	public String state;
	public String type;
	public String browser;
	public String dateOn;
	public int hot;
	public Book(){}

	public Book(String string, String string1, String string2, String string3, String string4, String string5, String string6, String string7,int num) {
	}

	public int getHot() {
		return this.hot;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getDateOn() {
		return dateOn;
	}

	public void setDateOn(String dateOn) {
		this.dateOn = dateOn;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}
}
