**@Transactional**

* Is used on top of class/method to indicate that the @Test method has to run  in a transaction that can alter the state of transactional resources like db
* Also indicates that @Transactional annotated method has o rollback all changes done by test ad next @Test should start from clear state
* By default all @Test will rollback which was executed within transaction
* We can change this behavior using @Rollback(false)


* @Rollback
* @Commit
* @BeforeTransaction - annotated method is executed before transaction is started
* @AfterTransaction - annotated method is executed after transaction is completed