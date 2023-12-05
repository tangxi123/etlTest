package testcase.base.tool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadProperties {
    @Value("${ods.datasource.driver-class-name}")
    private String odsDatasourceDriverClassName;

    @Value("${ods.datasource.jdbc-url}")
    private String odsDatasourceJdbcUrl;

    @Value("${ods.datasource.username}")
    private String odsDatasourceUsername;

    @Value("${ods.datasource.password}")
    private String odsDatasourcePassword;

    public String getOdsDatasourceDriverClassName() {
        return odsDatasourceDriverClassName;
    }

    public String getOdsDatasourceJdbcUrl() {
        return odsDatasourceJdbcUrl;
    }

    public String getOdsDatasourceUsername() {
        return odsDatasourceUsername;
    }

    public String getOdsDatasourcePassword() {
        return odsDatasourcePassword;
    }
}
