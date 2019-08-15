package managementOfBooks;

import java.io.*;

public class Book implements Serializable {
   private int bookNum;
   private String title_author;
   
 
   public Book(int n, String title) {
      bookNum = n;
      this.title_author = title;
   }
 
   public void setBookNum(int n) {
      bookNum = n;
   }
   public void setTitleAuthor(String titleauthor) {
      this.title_author = titleauthor;
   }
   
   public int getBookNum() {
      return bookNum;
   }
   public String getTitleAuthor() {
      return title_author;
   }
   
   public String toString() {
      return " (( BookNumber: " + bookNum + ", Title__Author : " + title_author ;
   }


}