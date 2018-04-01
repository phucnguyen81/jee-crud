package lou.jeecrud.ejb;

import java.util.List;
import javax.ejb.Remote;

import lou.jeecrud.entity.User;

@Remote
public interface UserEJBRemote {
    public List<User> getUsers();

    public User getUserById(int id);

    public User addNewUser(User user);

    public User updateUser(User user);

    public void deleteUser(User user);
}
