@Transactional Isolation level - @Transactional(isolation = Isolation.SERIALIZABLE)
* Isolation level determines how changes made in one transaction will be visible in other transaction
* Higher isolation level means changes made in one transaction are not visible in other
* Lower isolation level means changes made in one transaction may slip into select statements of other transaction

* Higher isolation level makes data appear in more consistent way
* Lower isolation level makes data appear more concurrently hence more throughput, but less consistent

---
* Some of the challenges that occur due to transaction isolation levels are
  * Phantom Read - Can be avoided using Range locks
  * Non Repeatable read - Can be avoided using Read-Write locks
  * Dirty Read - Can be avoided using isolation level such that changes are it prevents any uncommitted changes from other transactions visible
  
---
Relational DB supports 4 transaction isolation level:
1. SERIALIZABLE - solves Phantom read, Non Repeatable read, Dirty Read
   * High isolation level
   * Read-write locks until end of transaction
   * Range locks until end of transaction
2. REPEATABLE_READ - solves Non Repeatable read, Dirty Read
   * Read-write locks until end of transaction
3. READ_COMMITTED - Dirty Read
   * Read locks until end of select statement
   * Write locks until end of transaction
4. READ_UNCOMMITTED - Provides high concurrency and throughput
   * Lowest isolation level
   * Changes from one transaction will be visible, even if changes are not committed
  