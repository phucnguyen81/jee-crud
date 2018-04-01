package lou.beginjee.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import lou.beginjee.util.BaseIT;
import lou.jeecrud.ejb.UserEJB;
import lou.jeecrud.entity.User;
import lou.jeecrud.util.Util;

public class RepositoryIT extends BaseIT {

    @Test
    public void initialData() throws Exception {
        UserEJB repo = Util.lookupLocalBean(UserEJB.class);
        assertNotNull(repo);

        List<User> books = repo.getUsers();
        assertEquals("Wrong number of users", 0, books.size());
    }

}
