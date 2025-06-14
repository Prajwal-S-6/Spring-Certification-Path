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

---
Global Transaction:
* Is a type of transaction that spans across multiple transaction resources. Those resources can be multiple database transactions or database transactions and queues.
* JTA is used for managing global transactions

Local Transaction:
* Are resource specific transaction, they dont span across multiple transactions, they dont treat series of tasks like multiple database transactions or database transaction and queues as single unit of work
* Hence any exception in one of the resource/transaction will not rollback other transaction