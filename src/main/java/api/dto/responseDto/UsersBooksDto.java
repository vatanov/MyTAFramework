package api.dto.responseDto;

import java.util.Arrays;

public class UsersBooksDto {
    String userId;
    String username;
    BookDto[] books;

    public UsersBooksDto(String userId, String username, BookDto[] books) {
        this.userId = userId;
        this.username = username;
        this.books = books;
    }

    public UsersBooksDto() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BookDto[] getBooks() {
        return books;
    }

    public void setBooks(BookDto[] books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "UsersBooksDto{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
