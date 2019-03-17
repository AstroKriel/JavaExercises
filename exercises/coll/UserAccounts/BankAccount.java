package coll.UserAccounts;

/**
 * A bank account with an associated owner and available funds.
 */
public class BankAccount {

    /**
     * Constructs a bank object with $0.0 funds and assigns the owner as the given User.
     *
     * @param owner-  the owner.
     */
    public BankAccount(User owner) {

    }

    /**
     * Gets the total funds in the account.
     *
     * @return the total funds.
     */
    public double getFunds() {

    }

    /**
     * Deposits money into the account.
     *
     * @param deposit - the sum of money to be deposited.
     */
    public void deposit(double deposit) {

    }

    /**
     * Withdraws money from the account. Only the owner can withdraw funds.
     *
     * @param user - the user requesting to withdraw funds.
     * @param withdrawal - the amount requested to be withdrawn.
     * @throws UserException if anyone but the owner is attempting to withdraw funds.
     * @throws FundsException if there are insufficient funds in the account.
     */
    public void withdraw(User user, double withdrawal) throws UserException, FundsException {

    }
}