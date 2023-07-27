package qf.task.week02.day04.book;

import qf.task.week02.day04.book.Book;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day04.book
 * @company lpc
 * date 2023/7/27 16:58
 */

/**
 * 设计一个工具类Tools，工具类中设计以下方法：
 */
public class Tools {

    /**
     * 1）在一个图书数组中按编号查找图书，并将图书信息输出，
     *     分析：
     *     返回值：可以不要返回值
     *     参数：需要两个，Book数组、编号
     * @param id
     * @param bookList
     */
    public void forEachBookOfId(String id, Book[] bookList ){

        for (int i = 0; i < bookList.length; i++) {
            if(bookList[i].getId().equals(id)){
                System.out.println(bookList[i].toString());
            }
        }
    }

    /**
     *     2）在一个图书数组中按价格查找图书，并将查找到的所有图书返回（注意考虑相同价格的图书，返回一个数组）
     *     分析：
     *     返回值：有，一个新数组（Book），是查询到指定价格的图书
     *     参数：需要两个，Book数组，价格
     * @param prince
     * @param bookList
     * @return
     */
    public Book[] forEachBookOfPrince(double prince, Book[] bookList) {

    int size = 0;
    Book[] res = new Book[bookList.length];
    for (int i = 0; i < bookList.length; i++) {
        if (bookList[i].getBookPrince() == prince) {
            res[size++] = bookList[i];
        }
    }
    return res;
}

}
