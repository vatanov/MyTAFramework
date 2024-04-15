package api.dto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDto {
    String isbn;
    String title;
    String subTitle;
    String author;
    String publish_date;
    String publisher;
    int pages;
    String description;
    String website;

//    public BookDto(String isbn, String title, String subTitle, String author, String publisher, int pages, String description) {
//        this.isbn = isbn;
//        this.title = title;
//        this.subTitle = subTitle;
//        this.author = author;
//        this.publisher = publisher;
//        this.pages = pages;
//        this.description = description;
//    }

//    public BookDto(){
//
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getSubTitle() {
//        return subTitle;
//    }
//
//    public void setSubTitle(String subTitle) {
//        this.subTitle = subTitle;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getPublish_date() {
//        return publish_date;
//    }
//
//    public void setPublish_date(String publish_date) {
//        this.publish_date = publish_date;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }
//
//    public int getPages() {
//        return pages;
//    }
//
//    public void setPages(int pages) {
//        this.pages = pages;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getWebsite() {
//        return website;
//    }
//
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    @Override
//    public String toString() {
//        return "BookDto{" +
//                "isbn='" + isbn + '\'' +
//                ", title='" + title + '\'' +
//                ", subTitle='" + subTitle + '\'' +
//                ", author='" + author + '\'' +
//                ", publish_date='" + publish_date + '\'' +
//                ", publisher='" + publisher + '\'' +
//                ", pages=" + pages +
//                ", description='" + description + '\'' +
//                ", website='" + website + '\'' +
//                '}';
//    }
}
