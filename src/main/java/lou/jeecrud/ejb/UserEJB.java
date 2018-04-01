package lou.jeecrud.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import lou.jeecrud.entity.User;

/**
 * An ejb that exposes a no-interface view (via @LocalBean annotation) and a
 * remote view (via the remote UserEJBRemote interface).
 */
@Stateless
@LocalBean
public class UserEJB implements UserEJBRemote {

    @Inject
    private EntityManager em;

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll",
            User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User addNewUser(User user) {
        user.setRegdate(new Date());
        em.persist(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.merge(user));
    }
}