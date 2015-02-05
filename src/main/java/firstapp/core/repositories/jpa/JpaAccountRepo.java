package firstapp.core.repositories.jpa;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;
import firstapp.core.repositories.AccountRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Rhea on 1/26/15.
 */
@Repository
public class JpaAccountRepo implements AccountRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Account findAccount(Long id) {
        return em.find(Account.class,id);
    }

    @Override
    public Account createAccount(Account data) {
        em.persist(data);
        return data;
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        return null;
    }
}
