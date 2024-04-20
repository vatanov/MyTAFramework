package api;

public interface EndPoints {
    final String BASE_URL = "https://demoqa.com";
    final String BOOKS_BY_USER = BASE_URL + "/Account/v1/User/{0}";
    final String GENERATE_TOKEN = BASE_URL + "/Account/v1/GenerateToken";
    final String ADD_BOOKS = BASE_URL + "/BookStore/v1/Books";
    final String DELETE_BOOK = BASE_URL + "/BookStore/v1/Book";
}
