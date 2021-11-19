package question2043_simple_bank_system;

public class Bank {

  private long[] balance;

  public Bank(long[] balance) {
    this.balance = balance;
  }

  public boolean transfer(int account1, int account2, long money) {
      if (!checkAccount(account1) || !checkAccount(account2)) {
          return false;
      }
      if (balance[account1 - 1] < money) {
          return false;
      }
      balance[account1 - 1] -= money;
      balance[account2 - 1] += money;
      return true;
  }

  private boolean checkAccount(int account) {
      account--;
      return account >= 0 && account < balance.length;
  }

  public boolean deposit(int account, long money) {
      if (!checkAccount(account)) {
          return false;
      }
      balance[account - 1] += money;
      return true;
  }

  public boolean withdraw(int account, long money) {
      if (!checkAccount(account)) {
          return false;
      }
      if (balance[account - 1] < money) {
          return false;
      }
      balance[account - 1] -= money;
      return true;
  }

}