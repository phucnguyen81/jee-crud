package lou.jeecrud;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import lou.jeecrud.ejb.UserEJB;
import lou.jeecrud.entity.User;

/**
 * Run some tests on initial state of the application. Exceptions at this stage
 * will stop the application from being deployed.
 */
@Startup
@Singleton
public class RunAtStartup {

    @Inject
    Logger log;

    @Inject
    UserEJB repo;

    @PostConstruct
    public void testRepository() {
        List<User> users = repo.getUsers();
        log.info("Number of users: " + users.size());
    }

}
