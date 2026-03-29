package ro.ase.csie;

import java.util.Arrays;
import java.util.Objects;

public class Book implements Comparable<Book>, Cloneable{
    private String title;
    private String authorName;
    private int noPages;
    private int[] pagesPerChapter;
    //sum < total no of pages

    public Book(String title, String authorName, int noPages, int[] pagesPerChapter) {
        this.title = title;
        this.authorName = authorName;
        this.noPages = noPages;
        this.pagesPerChapter = pagesPerChapter;
    }

    public int[] getPagesPerChapter() {
        int[] dummy = new int[this.pagesPerChapter.length];
        for(int i=0; i<this.pagesPerChapter.length; i++){
            this.pagesPerChapter[i] = pagesPerChapter[i];
        }
        return dummy;
    }

    public void setPagesPerChapter(int[] pagesPerChapter) {
        int sum = 0;
        for (int i=0; i<pagesPerChapter.length; i++) {
            sum += pagesPerChapter[i];
        }

        if (this.noPages < sum) throw new UnsupportedOperationException("Sum too big.");
//        if (this.noPages < sum) try {
//            throw new Exception();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        this.pagesPerChapter = new int[pagesPerChapter.length];
        for (int i=0; i<pagesPerChapter.length; i++){
            this.pagesPerChapter[i] = pagesPerChapter[i];
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {

        Book copy = (Book) super.clone();
        copy.pagesPerChapter = new int[this.pagesPerChapter.length];
        System.arraycopy(this.pagesPerChapter, 0, copy.pagesPerChapter, 0, this.pagesPerChapter.length);
        return copy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", authorName='").append(authorName).append('\'');
        sb.append(", noPages=").append(noPages);
        sb.append(", pagesPerChapter=").append(Arrays.toString(pagesPerChapter));
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(Book b) {
        if (this.noPages > b.noPages)
            return 1;
        else if (this.noPages < b.noPages)
            return -1;
        else {
            return 0;
        }
    }

    //hash code takes an object and transforms it into a numerical value

//    @Override
//    public int hashCode() {
//        return this.title.hashCode() + this.authorName.hashCode() + noPages;
//    }

//    @Override
//    public boolean equals(Object obj) {
//
//        //same title + same author = same book
//        Book other = (Book)obj;
//        if(!this.authorName.equals(other.authorName)){
//            return false;
//        }
//
//        if(!this.title.equals(other.title)){
//            return false;
//        }
//
//        if(this.noPages != other.noPages){
//            return false;
//        }
//
//        return true;
//    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return noPages == book.noPages && Objects.equals(title, book.title) && Objects.equals(authorName, book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName, noPages);
    }
}

