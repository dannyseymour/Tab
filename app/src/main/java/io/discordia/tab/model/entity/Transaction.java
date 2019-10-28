package io.discordia.tab.model.entity;

import android.accounts.Account;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            childColumns = "payment_option_id",
            parentColumns = "payment_option_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity= Account.class,
            childColumns = "account_id",
            parentColumns = "account_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Transaction {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "transaction")
  private int id;

  @ColumnInfo(name="payment_option_id")
  private int paymentOptionId;

  @ColumnInfo(name="account_id")
  private int accountId;

  @ColumnInfo(name="date_due")
  private Date dateDue;

  @ColumnInfo(name="transaction_date")
  private Date transactionDate;

  @ColumnInfo(name="amount")
  private float amount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPaymentOptionId() {
    return paymentOptionId;
  }

  public void setPaymentOptionId(int paymentOptionId) {
    this.paymentOptionId = paymentOptionId;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public Date getDateDue() {
    return dateDue;
  }

  public void setDateDue(Date dateDue) {
    this.dateDue = dateDue;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }
}
