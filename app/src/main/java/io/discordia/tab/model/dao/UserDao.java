package io.discordia.tab.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.discordia.tab.model.entity.User;
import java.util.Collection;
import java.util.List;
@Dao
public interface UserDao {


  @Insert
  List<Long> insert(Collection<User> users);


  @Update
  int update(User user);

  @Update
  int update(User... users);
}
