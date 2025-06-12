package com.spring.data.example18.service;

import com.spring.data.example18.exceptions.CustomCheckedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employee_service")
public class EmployeeService {

    @Transactional
    public void methodWithUncheckedExceptionCausingRollback() {
        throw new IllegalArgumentException("test unchecked exception that will cause rollback");
    }

    @Transactional
    public void methodWithCheckedExceptionNotCausingRollback() throws CustomCheckedException {
        throw new CustomCheckedException("test checked exception that will not cause rollback");
    }

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    // @Transactional(noRollbackForClassName = "IllegalArgumentException")
    public void methodWithUncheckedExceptionNotCausingRollback() {
        throw new IllegalArgumentException("test unchecked exception that will not cause rollback because of noRollbackFor field");
    }

    @Transactional(rollbackFor = CustomCheckedException.class)
    // @Transactional(rollbackForClassName = "CustomCheckedException")
    public void methodWithCheckedExceptionCausingRollback() throws CustomCheckedException {
        throw new CustomCheckedException("test checked exception that will cause rollback because of rollbackFor field");
    }
}
