package io.discordia.tab.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_profile_id")
    private long id;

    @ColumnInfo(name="date_of_birth")
    private Date dateOfBirth;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="google_id")
    private String googleId;

    @ColumnInfo(name="current_credit_score")
    private int currentCreditScore;



    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGoogleId() {
    return googleId;
  }

  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  public int getCurrentCreditScore() {
    return currentCreditScore;
  }

  public void setCurrentCreditScore(int currentCreditScore) {
    this.currentCreditScore = currentCreditScore;
  }
}
