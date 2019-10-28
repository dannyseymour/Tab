package io.discordia.tab.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.discordia.tab.model.entity.Account;
import io.discordia.tab.model.entity.PaymentOption;
import java.util.Collection;
import java.util.List;

@Dao
public interface PaymentOptionDao {
  @Insert
  List<Long> insert(Collection<PaymentOption> paymentOptions);

  @Query("SELECT * FROM PaymentOption ORDER BY payment_option_id")
  LiveData<PaymentOption> getAllById();

  @Query("SELECT * FROM PaymentOption ORDER BY payment_option_id ASC")
  LiveData<List<Account>> getAll();

  @Query("SELECT * FROM PaymentOption WHERE payment_option_id= :paymentOptionId")
  LiveData<Account> getById(int paymentOptionId);

  @Query("SELECT account_type FROM PaymentOption WHERE payment_option_id :paymentOptionId")
  int getTypeOfOptionById(int paymentOptionId);


  @Update
  int update(PaymentOption paymentOption);

  @Update
  int update(PaymentOption... paymentOptions);

}
