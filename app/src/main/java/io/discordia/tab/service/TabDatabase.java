package io.discordia.tab.service;
import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import io.discordia.tab.model.dao.AccountDao;
import io.discordia.tab.model.dao.PaymentOptionDao;
import io.discordia.tab.model.dao.TransactionDao;
import io.discordia.tab.model.dao.UserDao;
import io.discordia.tab.model.entity.PaymentOption;
import io.discordia.tab.model.entity.Account;
import io.discordia.tab.model.entity.Transaction;
import io.discordia.tab.model.entity.User;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

@Database(
    entities = {PaymentOption.class, Account.class, Transaction.class, User.class},
    version = 1, exportSchema = true
)
@TypeConverters(TabDatabase.Converters.class)
public abstract class TabDatabase extends RoomDatabase {

  protected TabDatabase() {}

  private static Application applicationContext;

  public static void setApplicationContext(Application applicationContext) {
    BlackjackDatabase.applicationContext = applicationContext;
  }

  public static TabDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract AccountDao getAccountDao();

  public abstract PaymentOptionDao getPaymentOptionDao();

  public abstract TransactionDao getTransactionDao();

  public abstract UserDao getUserDao();


  private static class InstanceHolder {

    private static final TabDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, TabDatabase.class, "tab_db").build();
    }

  }

  public static class Converters {

    @TypeConverter
    public Long dateToLong(Date date) {
      return (date != null) ? date.getTime() : null;
    }

    @TypeConverter
    public Date longToDate(Long milliseconds) {
      return (milliseconds != null) ? new Date(milliseconds) : null;
    }

    @TypeConverter
    public String enumToString(Enum value) {
      return (value != null) ? value.toString() : null;
    }

    @TypeConverter
    public URL stringToURL(String name) throws MalformedURLException {
      URL returnVal = null;
      try {
        returnVal = (name != null) ? new URL(name) : null;
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      return returnVal;
    }
  }

}