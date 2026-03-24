package ro.ase.csie;

import java.util.Arrays;

public class Book implements Comparable<Book>{
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
}

