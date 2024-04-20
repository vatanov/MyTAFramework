package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:./src/main/resources/hiddenConfig.properties")
public interface ConfigHiddenProperties extends Config {
    String login_default();
    String password_default();
    String login_api_default();
    String password_api_default();
    String user_id();
}
