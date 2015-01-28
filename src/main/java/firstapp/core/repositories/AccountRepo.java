package firstapp.core.repositories;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;

/**
 * Created by Rhea on 1/26/15.
 */
public interface AccountRepo {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
}
