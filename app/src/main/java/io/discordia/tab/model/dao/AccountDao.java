package io.discordia.tab.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.discordia.tab.model.entity.Account;
import java.util.Collection;
import java.util.List;

@Dao
public interface AccountDao {
  @Query("SELECT * FROM Account ORDER BY account_id ASC")
  LiveData<List<Account>> getAll();

  @Query("SELECT * FROM Account WHERE account_id= :accountId")
  LiveData<Account> getById(int accountId);

  @Query("SELECT amount_due FROM Account WHERE account_id= :accountId")
  int getAmountDueByAccount(int accountId);

  @Insert
  List<Long> insert(Collection<Account> accounts);

  @Update
  int update(Account account);

  @Update
  int update(Account...acccounts);
}
