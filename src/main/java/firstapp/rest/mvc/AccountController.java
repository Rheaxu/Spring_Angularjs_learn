package firstapp.rest.mvc;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;
import firstapp.core.services.AccountService;
import firstapp.core.services.exceptions.AccountDoesNotExistException;
import firstapp.core.services.exceptions.AccountExistsException;
import firstapp.core.services.exceptions.BlogExistsException;
import firstapp.core.services.util.AccountList;
import firstapp.core.services.util.BlogList;
import firstapp.rest.exceptions.BadRequestException;
import firstapp.rest.exceptions.ConflictException;
import firstapp.rest.exceptions.NotFoundException;
import firstapp.rest.resources.AccountResource;
import firstapp.rest.resources.AccountListResource;
import firstapp.rest.resources.BlogListResource;
import firstapp.rest.resources.BlogResource;
import firstapp.rest.resources.asm.AccountListResourceAsm;
import firstapp.rest.resources.asm.AccountResourceAsm;
import firstapp.rest.resources.asm.BlogListResourceAsm;
import firstapp.rest.resources.asm.BlogResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rhea on 1/24/15.
 */
@Controller
@RequestMapping("/rest/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired      //Inject real service to controller
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<AccountListResource> findAllAccounts(@RequestParam(value="name",required=false) String name){
        AccountList list = null;
        if(name == null){
            list = accountService.findAllAccounts();
        } else{
            Account account = accountService.findByAccountName(name);
            if(account == null){
                list = new AccountList(new ArrayList<Account>());
            }else{
                list  = new AccountList(Arrays.asList(account));
            }
        }
        AccountListResource res = new AccountListResourceAsm().toResource(list);
        return new ResponseEntity<AccountListResource>(res,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountResource> createAccount(
            @RequestBody AccountResource sentAccount
    ) {
        try {
            Account createdAccount = accountService.createAccount(sentAccount.toAccount());
            AccountResource res = new AccountResourceAsm().toResource(createdAccount);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);
        } catch(AccountExistsException exception) {
            throw new ConflictException(exception);
        }
    }

    @RequestMapping( value="/{accountId}",
            method = RequestMethod.GET)
    public ResponseEntity<AccountResource> getAccount(
            @PathVariable Long accountId
    ) {
        Account account = accountService.findAccount(accountId);
        if(account != null)
        {
            AccountResource res = new AccountResourceAsm().toResource(account);
            return new ResponseEntity<AccountResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{accountId}/blogs",
            method = RequestMethod.POST)
    public ResponseEntity<BlogResource> createBlog(
            @PathVariable Long accountId,
            @RequestBody BlogResource res)
    {
        try {
            Blog createdBlog = accountService.createBlog(accountId, res.toBlog());
            BlogResource createdBlogRes = new BlogResourceAsm().toResource(createdBlog);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdBlogRes.getLink("self").getHref()));
            return new ResponseEntity<BlogResource>(createdBlogRes, headers, HttpStatus.CREATED);
        } catch(AccountDoesNotExistException exception)
        {
            throw new BadRequestException(exception);
        } catch (BlogExistsException exception)
        {
            throw new ConflictException(exception);
        }
    }

    @RequestMapping(value="/{accountId}/blogs",
            method = RequestMethod.GET)
    public ResponseEntity<BlogListResource> findAllBlogs(@PathVariable Long accountId){
        try{
            BlogList blogList = accountService.findBlogsByAccount(accountId);
            BlogListResource blogListRes = new BlogListResourceAsm().toResource(blogList);
            return new ResponseEntity<BlogListResource>(blogListRes,HttpStatus.OK);
        }catch(AccountDoesNotExistException exception)
        {
            throw new NotFoundException(exception);
        }
    }

}
