package lou.jeecrud.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lou.jeecrud.ejb.UserEJBRemote;
import lou.jeecrud.entity.User;

@Named(value = "uc")
@RequestScoped
public class UserManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private UserEJBRemote userEJB;
    private User user = new User();
    private List<User> list = new ArrayList<>();
    private boolean edit;

    public UserManagedBean() {}

    @PostConstruct
    public void init() {
        list = userEJB.getUsers();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void addUser() {
        userEJB.addNewUser(user);
        list = userEJB.getUsers();
    }

    public void editUser(User usr) {
        user = usr;
        edit = true;
    }

    public void deleteUser(User usr) {
        userEJB.deleteUser(usr);
        list.remove(usr);
    }

    public void saveUser() {
        userEJB.updateUser(user);
        edit = false;
    }
}