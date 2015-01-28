package firstapp.core.services;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;

/**
 * Created by Rhea on 1/24/15.
 */
public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
}
