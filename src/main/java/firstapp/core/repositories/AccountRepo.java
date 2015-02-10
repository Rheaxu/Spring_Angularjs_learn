package firstapp.core.repositories;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;

import java.util.List;

/**
 * Created by Rhea on 1/26/15.
 */
public interface AccountRepo {
    public List<Account> findAllAccounts();
    public Account findAccount(Long id);
    public Account findAccountByName(String name);
    public Account createAccount(Account data);
}
