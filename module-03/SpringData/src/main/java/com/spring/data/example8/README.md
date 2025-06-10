Transaction
* Transaction is a operation with series of tasks in which all those tasks should be performed successfully, then only the transaction is said to be completed, all those tasks are treated as single unit of work
* If all the tasks are successful then those changes are preserved
* If any of the task fails then all the completed tasks changes are rolled back
* Any pending tasks are not executed

ACID - Transactions should follow ACID principles
* Atomicity - All changes are applied or none changes are applied
* Consistency - System should go from one valid state to another, any constraint on data should never leave system in invalid state
* Isolation - One transaction should not affect another. Concurrent execution of transaction should leave system in same state as if it was executed sequentially
* Durability - Once transaction is committed, then data should be preserved even in case of system or power failure