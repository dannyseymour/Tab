package io.discordia.tab.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            childColumns = "user_profile_id",
            parentColumns = "user_profile_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class PaymentOption {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "payment_option_id")
  private int id;


  @NonNull
  @ColumnInfo(name="user_profile_id")
  private int userProfileId;

  @ColumnInfo(name="last_four_digits")
  private int lastFourDigits;

  @ColumnInfo(name = "date_added")
  private Date dateAdded = new Date();

  @ColumnInfo(name="account_type")
  private AccountType accountType;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserProfileId() {
    return userProfileId;
  }

  public void setUserProfileId(int userProfileId) {
    this.userProfileId = userProfileId;
  }

  public int getLastFourDigits() {
    return lastFourDigits;
  }

  public void setLastFourDigits(int lastFourDigits) {
    this.lastFourDigits = lastFourDigits;
  }

  public Date getDateAdded() {
    return dateAdded;
  }

  public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
  }

  public String getAccountType() {
    return accountType.toString();
  }

  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  public enum AccountType {

    BANK_ACCOUNT,
    CREDIT_CARD,
    GOOGLE_PAY,
    OTHER;


    @Override
    public String toString() {
      return AccountType.valueOf(this);
    }
  }



}
