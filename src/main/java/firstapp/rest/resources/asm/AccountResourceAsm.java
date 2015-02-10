package firstapp.rest.resources.asm;

import firstapp.core.models.entities.Account;
import firstapp.rest.mvc.AccountController;
import firstapp.rest.resources.AccountResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by Rhea on 1/24/15.
 */
public class AccountResourceAsm extends ResourceAssemblerSupport<Account,AccountResource> {
    public AccountResourceAsm(){
        super(AccountController.class,AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account)
    {
        AccountResource res = new AccountResource();
        res.setName(account.getName());
        res.setPassword(account.getPassword());
        res.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
        res.add(linkTo(methodOn(AccountController.class).findAllBlogs(account.getId())).withRel("blogs"));
        return res;
    }
}
