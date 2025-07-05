package com.spring.security.example8.controllers;

import com.spring.security.example7.dao.EmployeeDao;
import com.spring.security.example7.ds.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeDao employeesDao;

//    @PreAuthorize("hasRole('ROLE_EMPLOYEES_PAG_VIEW')")
    @GetMapping("/employees")
    public ModelAndView index() {
        return new ModelAndView("employees1", "employees", employeesDao.findAll());
    }

//    @PreAuthorize("hasRole('ROLE_EMPLOYEES_CREATE')")
    @GetMapping("/employees/create")
    public ModelAndView create() {
        return new ModelAndView("employee-create1", "employee", new Employee());
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYEES_CREATE') || 'TEST'.equals(#employee.getFirstName())")
    @PostMapping("/employees/create")
    public String create(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-create1";
        } else {
            employeesDao.save(employee);

            return "redirect:/employees";
        }
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYEES_DELETE') || #id == 3")
    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeesDao.deleteById(id);

        return "redirect:/employees";
    }
}
