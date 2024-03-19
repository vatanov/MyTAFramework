package libs;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import java.sql.*;

import static libs.ConfigProvider.configProperties;

public class DbUtils {
    Logger logger = Logger.getLogger(getClass());
    private Connection connection = null;

    public DbUtils() {
        try {
            String DB_URL = configProperties.db_url();
            String DB_USER = configProperties.db_user();
            String DB_PASSWORD = configProperties.db_password();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Connection to DB is successful");
        } catch (SQLException e) {
            logger.error("Connection to DB failed " + e.getMessage());
        }
    }

    /**
     * This method is used to execute SELECT query and other queries that return ResultSet
     */
    public ResultSet executeQueryAndGetResult(String query) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.close();
            statement.close();
            this.connection.close();
            logger.info("Query executed successfully");
            return resultSet;
        } catch (SQLException e) {
            logger.error("Query execution failed " + e.getMessage());
            return null;
        }
    }

    /**
    * This method is used to execute DELETE or CREATE query
     */
    public void executeQueryWithoutResult(String query) {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(query);
            statement.close();
            this.connection.close();
            logger.info("Query executed successfully");
        } catch (SQLException e) {
            logger.error("Query execution failed " + e.getMessage());
        }
    }
}
