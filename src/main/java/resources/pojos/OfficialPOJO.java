package resources.pojos;

public class OfficialPOJO {

    private Integer bookId;
    private String title;
    private String isbn;
    private Integer authorId;

    public OfficialPOJO() {
    }

    public OfficialPOJO(Integer bookId, String title, String isbn, Integer authorId) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
