package firstapp.core.services.util;

import firstapp.core.models.entities.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rhea on 2/9/15.
 */
public class AccountList {

    private List<Account> accounts = new ArrayList<Account>();

    public AccountList(List<Account> list){
        this.accounts = list;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }
}
