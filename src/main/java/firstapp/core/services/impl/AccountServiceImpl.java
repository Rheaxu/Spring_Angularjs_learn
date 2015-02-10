package firstapp.core.services.impl;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;
import firstapp.core.repositories.AccountRepo;
import firstapp.core.repositories.BlogRepo;
import firstapp.core.services.AccountService;
import firstapp.core.services.exceptions.AccountDoesNotExistException;
import firstapp.core.services.exceptions.AccountExistsException;
import firstapp.core.services.exceptions.BlogExistsException;
import firstapp.core.services.util.BlogList;
import firstapp.core.services.util.AccountList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rhea on 2/9/15.
 */

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Account findAccount(Long id){
        return accountRepo.findAccount(id);
    }

    @Override
    public Account createAccount(Account data){
        Account account = accountRepo.findAccountByName(data.getName());
        if(account != null){
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }

    @Override
    public Blog createBlog(Long accountId, Blog data){
        Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

        if(blogSameTitle!=null)
        {
            throw new BlogExistsException();
        }

        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }

        Blog createBlog = blogRepo.createBlog(data);

        createBlog.setOwner(account);

        return createBlog;
    }

    @Override
    public BlogList findBlogsByAccount(Long accountId){
        Account account = accountRepo.findAccount(accountId);
        if(account==null)
        {
            throw new AccountDoesNotExistException();
        }
        return new BlogList(blogRepo.findBlogsByAccount(accountId));
    }

    @Override
    public AccountList findAllAccounts(){
        return new AccountList(accountRepo.findAllAccounts());
    }

    @Override
    public Account findByAccountName(String name){
        return accountRepo.findAccountByName(name);
    }
}
