package firstapp.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rhea on 2/10/15.
 */
public class AccountListResource extends ResourceSupport {
    private List<AccountResource> accounts = new ArrayList<AccountResource>();

    public List<AccountResource> getAccounts(){
        return accounts;
    }

    public void setAccounts(List<AccountResource> accounts){
        this.accounts = accounts;
    }
}
