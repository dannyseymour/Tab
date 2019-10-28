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
public class Account {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "account_id")
  private int id;

  @ColumnInfo(name="user_profile_id")
  private int userProfileId;

  @ColumnInfo(name="account_type")
  private AccountType accountType;

  @ColumnInfo(name="amount_due")
  private float amountDue;

  @ColumnInfo(name="provider_name")
  private String providerName;

  @ColumnInfo(name = "date_due")
  private Date dateDue= new Date();

  @ColumnInfo(name = "date_opened")
  private Date dateOpened= new Date();

  @ColumnInfo(name="past_due_days")
  private int pastDueDays;

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

  public float getAmountDue() {
    return amountDue;
  }

  public void setAmountDue(float amountDue) {
    this.amountDue = amountDue;
  }

  public String getProviderName() {
    return providerName;
  }

  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  public Date getDateDue() {
    return dateDue;
  }

  public void setDateDue(Date dateDue) {
    this.dateDue = dateDue;
  }

  public Date getDateOpened() {
    return dateOpened;
  }

  public void setDateOpened(Date dateOpened) {
    this.dateOpened = dateOpened;
  }

  public int getPastDueDays() {
    return pastDueDays;
  }

  public void setPastDueDays(int pastDueDays) {
    this.pastDueDays = pastDueDays;
  }

  public String getAccountType() {
    return accountType.toString();
  }

  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  public enum AccountType {

    UTILITY,
    PHONE,
    RENT,
    INTEREST,
    LOAN,
    MORTGAGE,
    OTHER;


    @Override
    public String toString() {
      return AccountType.valueOf(this);
    }
  }



}
