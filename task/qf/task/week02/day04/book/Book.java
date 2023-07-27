package qf.task.week02.day04.book;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day04.book
 * @company lpc
 * date 2023/7/27 16:58
 */

/**
 * 设计一个图书类Book，包括私有属性：编号、书名、价格。
 */
public class Book {
    private String id;
    private String bookName;
    private double bookPrince;

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

    public double getBookPrince() {
        return bookPrince;
    }

    public void setBookPrince(double bookPrince) {
        this.bookPrince = bookPrince;
    }

    public Book() {
    }

    public Book(String id, String bookName, double bookPrince) {
        this.id = id;
        this.bookName = bookName;
        this.bookPrince = bookPrince;
    }

    @Override
    public String toString() {
        return "Book{" +
                "编号是'" + id + '\'' +
                ", 书名是'" + bookName + '\'' +
                ", 价格是" + bookPrince +
                '}';
    }
}
