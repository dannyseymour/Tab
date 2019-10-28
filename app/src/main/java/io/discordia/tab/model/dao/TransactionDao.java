package io.discordia.tab.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.discordia.tab.model.entity.Transaction;
import java.util.Collection;
import java.util.List;

@Dao
public interface TransactionDao {

    @Query("SELECT * FROM Transaction WHERE transaction_id = :transactionId")
    LiveData<Transaction> getAllById(int transactionId);


    @Insert
    List<Long> insert(Collection<Transaction> transactions);

    @Update
    int update(Transaction transaction);

    @Update
    int update(Transaction...transactions);
  }

}

