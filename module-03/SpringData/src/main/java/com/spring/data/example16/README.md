Transaction propagation type: @Transactional(propagation = Propagation.REQUIRED)
* Transaction propagation defines how existing transaction can be reused, when method annotated with @Transactional is called with another transaction already running

---
Transaction propagation can be defined in @Transactional annotation with one of the following options:
1. REQUIRED - supports/uses existing transaction; creates new one if none exists.
2. SUPPORT - supports/uses existing transaction; else run non transactionally if none exists.
3. MANDATORY - supports/uses existing transaction; throws exception if none exists.
4. REQUIRES_NEW - creates new transaction; suspends any existing transaction
5. NOT_SUPPORTED - executes non transactionally; suspends any existing transaction.
6. NEVER - executes non transactionally; throws exception if any transaction exists.
7. NESTED - execute within nested transaction if current transaction exists; else creates new one

* Suspension of existing transaction in case of REQUIRES_NEW, NOT_SUPPORTED only works if Transaction manager is **JtaTransactionManager**.
* Nesting of existing transactions happens only with JDBC Data**SourceTransactionManager**