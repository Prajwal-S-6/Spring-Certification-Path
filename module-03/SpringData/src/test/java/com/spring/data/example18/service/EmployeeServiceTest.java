package com.spring.data.example18.service;

import com.spring.data.example18.configuration.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({OutputCaptureExtension.class, SpringExtension.class})
@ContextConfiguration(classes = DataSourceConfig.class)
class EmployeeServiceTest {

    @Autowired
    //@Qualifier("employee_service")
    private EmployeeService employeeService;

    @Test
    public void shouldCauseRollbackForUncheckedException(CapturedOutput capturedOutput) {
        try {
            employeeService.methodWithUncheckedExceptionCausingRollback();
        } catch (Exception e) {

        }
        finally {
            assertThat(capturedOutput.getOut()).contains("rollback");
        }
    }

    @Test
    public void shouldNotCauseRollbackForCheckedException(CapturedOutput capturedOutput) {
        try {
            employeeService.methodWithCheckedExceptionNotCausingRollback();
        } catch (Exception e) {

        }
        finally {
            assertThat(capturedOutput.getOut()).doesNotContain("rollback");
        }
    }

    @Test
    public void shouldNotCauseRollbackForUnCheckedExceptionForMethodWithTranactionalNoRollback(CapturedOutput capturedOutput) {
        try {
            employeeService.methodWithUncheckedExceptionNotCausingRollback();
        } catch (Exception e) {

        } finally {
            assertThat(capturedOutput.getOut()).doesNotContain("rollback");
        }
    }

        @Test
    public void shouldCauseRollbackForCheckedExceptionForMethodWithTranactionalRollbackFor(CapturedOutput capturedOutput) {
        try {
            employeeService.methodWithCheckedExceptionCausingRollback();
        } catch (Exception e) {

        }
        finally {
            assertThat(capturedOutput.getOut()).contains("rollback");
        }


    }

}