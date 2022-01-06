package leetCode.easy

/**
 * You are given an m x n integer grid accounts where accounts[i][j]
 * is the amount of money the ith customer has in the jth bank.
 * Return the wealth that the richest customer has.
 *
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */
class ReachestCustomerWealth {
    // More elegant
    fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.map { it.sum() }.maxOrNull() ?: 0
    }

    // Faster
    fun maximumWealthManualearch(accounts: Array<IntArray>): Int {
        var max = 0
        for (account in accounts){
            var accountSum = 0
            for (j in account.indices){
                accountSum += account[j]
            }
            if (accountSum>max){
                max = accountSum
            }
        }
        return max
    }
}