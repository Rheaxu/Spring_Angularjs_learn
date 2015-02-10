package firstapp.core.services;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;
import firstapp.core.services.util.AccountList;
import firstapp.core.services.util.BlogList;

/**
 * Created by Rhea on 1/24/15.
 */
public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}
