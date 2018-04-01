package lou.jeecrud.jpa;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

import lou.jeecrud.util.C;

/**
 * Main properties for creating a data source. These properties are
 * complementary to persistence.xml and are unlikely to change.
 */
@ApplicationScoped
@DataSourceDefinition(
    name = C.DS_JNDI,
    className = C.DS_EMBEDDED_DRIVER,
    url = C.DS_URL,
    user = "app",
    password = "app",
    properties = {
        "create=true"
    })
public class MainDataSource {}