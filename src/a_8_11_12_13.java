public class a_8_11_12_13
{
    /*Suppose the following BankAccount class has been created:
        1 // Each BankAccount object represents one user's account
        2 // information including name and balance of money.
        3 public class BankAccount {
        4 String name;
        5 double balance;
        6
        7 public void deposit(double amount) {
        8 balance = balance + amount;
        9 }
        10
        11 public void withdraw(double amount) {
        12 balance = balance - amount;
        13 }
        14 }
    Add a field to the BankAccount class named transactionFee for a real number representing an amount of money
    to deduct every time the user withdraws money. The default value is $0.00, but the client can change the value.
    Deduct the transaction fee money during every withdraw call (but not from deposits). Make sure that the balance
    cannot go negative during a withdrawal. If the withdrawal (amount plus transaction fee) would cause it to become
    negative, don’t modify the balance at all.*/

    /*Add a toString method to the BankAccount class from the previous exercise. Your method should return a string that
    contains the account's name and balance separated by a comma and space. For example, if an account object named yana
    has the name "Yana" and a balance of 3.03, the call yana.toString() should return the string "Yana, $3.03".*/

    /*Add a transfer method to the BankAccount class from the previous exercises. Your method should move money
    from the current bank account to another account. The method accepts two parameters: a second BankAccount to
    accept the money, and a real number for the amount of money to transfer. There is a $5.00 fee for transferring
    money, so this much must be deducted from the current account’s balance before any transfer. The method should
    modify the two BankAccount objects such that “this” current object has its balance decreased by the given amount
    plus the $5 fee, and the other account's balance is increased by the given amount. If this account object does not have
    enough money to make the full transfer, transfer whatever money is left after the $5 fee is deducted. If this account
    has under $5 or the amount is 0 or less, no transfer should occur and neither account's state should be modified. The
    following are some example calls to the method:
    BankAccount ben = new BankAccount();
    ben.deposit(80.00);
    BankAccount hal = new BankAccount();
    hal.deposit(20.00);
    ben.transfer(hal, 20.00); // ben $55, hal $40 (ben -$25, hal +$20)
    ben.transfer(hal, 10.00); // ben $40, hal $50 (ben -$15, hal +$10)
    hal.transfer(ben, 60.00); // ben $85, hal $ 0 (ben +$45, hal -$50)*/

    // Each BankAccount object represents one user's account
    // information including name and balance of money.
    public class BankAccount
    {
        double transactionFee = 0.00;
        String name;
        double balance;

        public void transfer(BankAccount secAccount, double money)
        {
            double fee = 5.0;

            if (balance >= money+fee)
            {
                //calls the deposit from sec account and withdraw from current account!
                secAccount.deposit(money);
                withdraw(money,fee);
            }

        }

        public void deposit(double amount)
        {
          balance = balance + amount;
        }

        public void withdraw(double amount, double setTransactionFee)
        {
            if (balance >= (amount+transactionFee) && amount >= 0.0 && transactionFee >= 0.0)
            {
                transactionFee = setTransactionFee;
                balance = (balance - amount) - transactionFee;
                System.out.println("successful withdraw");
            }
            else
            {
                System.out.println("Your withdraw met a mistake, try again");
            }
        }

        public String toString()
        {
            return name+ ", $" + balance;
        }
    }
}
