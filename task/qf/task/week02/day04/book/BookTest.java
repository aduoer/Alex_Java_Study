package qf.task.week02.day04.book;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day04.book
 * @company lpc
 * date 2023/7/27 17:06
 */

public class BookTest {
    /**
     * 功能要求:
     * 在主方法中创建一个图书数组，调用工具类中的按编号查找图书，再调用按价格查找图书，再将所有查找到的图书信息输出
     *
     * @param args
     */
        public static void main(String[] args) {

        Book[] bookList = new Book[4];
        bookList[0] = new Book("1","三体1",99.0);
        bookList[1] = new Book("2","三体2",99.0);
        bookList[2] = new Book("3","三体3",99.0);
        bookList[3] = new Book("4","活着",99.0);

        Tools tools = new Tools();
        tools.forEachBookOfId("1",bookList);
        System.out.println("========================");
        Book[] res = tools.forEachBookOfPrince(99.0, bookList);
        for (Book book : res) {
            System.out.println(book.toString());
        }
    }
}
