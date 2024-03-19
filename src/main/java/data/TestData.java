package data;

import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin", ConfigProvider.configHiddenProperties.login_default());
    public static String PASSWORD_DEFAULT = System.getProperty("defaultPassword", ConfigProvider.configHiddenProperties.password_default());
    public static String DENTIST = "Dentist";
    public static String DOC_MARK_SMITH = "Mark Smith";
}
