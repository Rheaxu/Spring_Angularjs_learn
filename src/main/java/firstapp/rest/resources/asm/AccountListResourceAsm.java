package firstapp.rest.resources.asm;

import firstapp.core.services.util.AccountList;
import firstapp.rest.mvc.AccountController;
import firstapp.rest.resources.AccountListResource;
import firstapp.rest.resources.AccountResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by Rhea on 2/10/15.
 */
public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {
    public AccountListResourceAsm(){
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList){
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}
