Rollback policy in Junit Tests
* The default rollback policy in a junit test methods are always.
* Meaning the method annotated with @Test and @Transactional are rolled back after each test execution.
* Reason is since tests are repeatable hence changes made after each tests have to be reverted.

---
However, this rollback behavior in @Test methods can be changed by adding @Rollback(false) on test methods