package data;

import api.dto.responseDto.BookDto;
import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin", ConfigProvider.configHiddenProperties.login_default());
    public static String PASSWORD_DEFAULT = System.getProperty("defaultPassword", ConfigProvider.configHiddenProperties.password_default());
    public static String DENTIST = "Dentist";
    public static String DOC_MARK_SMITH = "Mark Smith";


    /**
     * Books for API testing
     */
    public static BookDto bookGitPocketGuide = BookDto.builder()
            .isbn("9781449325862")
            .title("Git Pocket Guide")
            .subTitle("A Working Introduction")
            .author("Richard E. Silverman")
            .publisher("O'Reilly Media")
            .pages(234)
            .description("This pocket guide is the perfect on-the-job companion to Git, the distributed " +
                    "version control system. It provides a compact, readable introduction to Git for " +
                    "new users, as well as a reference to common commands and procedures for " +
                    "those of you with Git exp")
            .build();

    public static BookDto bookDesigningEvolvableWebAPIs = BookDto.builder()
            .isbn("9781449337711")
            .title("Designing Evolvable Web APIs with ASP.NET")
            .subTitle("Harnessing the Power of the Web")
            .author("Glenn Block et al.")
            .publisher("O'Reilly Media")
            .pages(238)
            .description("Design and build Web APIs for a broad range of clients—including browsers and mobile " +
                    "devices—that can adapt to change over time. This practical, hands-on guide takes you through " +
                    "the theory and tools you need to build evolvable HTTP services with Microsoft")
            .build();

    public static BookDto bookLearningJavaScriptDesignPatterns = BookDto.builder()
            .isbn("9781449331818")
            .title("Learning JavaScript Design Patterns")
            .subTitle("A JavaScript and jQuery Developer's Guide")
            .author("Addy Osmani")
            .publisher("O'Reilly Media")
            .pages(254)
            .description("With Learning JavaScript Design Patterns, you'll learn how to write beautiful, " +
                    "structured, and maintainable JavaScript by applying classical and modern design patterns " +
                    "to the language. If you want to keep your code efficient, more manageable, and up-to-da")
            .build();
}
