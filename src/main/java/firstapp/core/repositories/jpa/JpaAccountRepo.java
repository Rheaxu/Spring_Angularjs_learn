package firstapp.core.repositories.jpa;

import firstapp.core.models.entities.Account;
import firstapp.core.models.entities.Blog;
import firstapp.core.repositories.AccountRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rhea on 1/26/15.
 * The jpa repository is the interface to database for service layer
 */
@Repository
public class JpaAccountRepo implements AccountRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Account> findAllAccounts(){
        Query query = em.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }

    @Override
    public Account findAccount(Long id) {
        return em.find(Account.class,id);
    }

    @Override
    public Account findAccountByName(String name){
        Query query = em.createQuery("SELECT a FROM Account a WHERE a.name=?1");
        query.setParameter(1,name);
        List<Account> accounts = query.getResultList();
        if(accounts.size()==0){
            return null;
        }else{
            return accounts.get(0);
        }
    }

    @Override
    public Account createAccount(Account data) {
        em.persist(data);
        return data;
    }

}
