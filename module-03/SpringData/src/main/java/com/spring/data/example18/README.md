Rollback policy:
* Default rollback policy is automatic when an unchecked/runtime exception is thrown from method annotated with @Transactional
* When checked exception is thrown from method annotated with @Transactional then transaction is not rolled back

---
However, this policy can be changed by using in @Transactional annotation
1. rollbackFor/rollbackForClassName
2. noRollbackFor/noRollbackForClassName