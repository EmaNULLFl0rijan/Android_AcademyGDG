class TransactionLogger(){

    fun Log(message: String){
        println("Transaction log: $message")
    }

}

class BankAccount(val accountNumber: String){
    private var balance: Double = 0.0
    val logger = TransactionLogger()

    init {
        numberOfAccounts++
        logger.Log("Created account $accountNumber. Total accounts: $numberOfAccounts")
    }

    fun deposit(amount: Double){
        balance += amount
        logger.Log("Deposited $amount. New balance: $balance")
    }

    fun withdraw(amount: Double){
        if(amount > balance){
            logger.Log("account number $accountNumber: Withdrawal of $amount failed. Insufficient funds.")
        } else {
            balance -= amount
            logger.Log("account number $accountNumber: Withdrew $amount. New balance: $balance")
        }
    }

    companion object {
        var numberOfAccounts: Int = 0
    }

}

fun main() {
    BankAccount("123").deposit(100.0)
    BankAccount("456").withdraw(50.0)
}