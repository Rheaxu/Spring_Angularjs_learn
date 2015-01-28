package firstapp.core.repositories.jpa;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;
import firstapp.core.repositories.AccountRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by Rhea on 1/26/15.
 */
@Repository
public class JpaAccountRepo implements AccountRepo{
    @Override
    public Account findAccount(Long id) {
        return null;
    }

    @Override
    public Account createAccount(Account data) {
        return null;
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        return null;
    }
}
