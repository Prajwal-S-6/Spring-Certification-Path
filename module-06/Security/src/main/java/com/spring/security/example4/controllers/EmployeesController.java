package com.spring.security.example4.controllers;

import com.spring.security.example4.dao.EmployeeDao;
import com.spring.security.example4.ds.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.spring.security.example4.security.SecurityRoles.*;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeDao employeesDao;

    @Secured(ROLE_PREFIX + EMPLOYEES_READ)
    @GetMapping("/employees")
    public ModelAndView index() {
        return new ModelAndView("employees1", "employees", employeesDao.findAll());
    }

    @Secured(ROLE_PREFIX + EMPLOYEES_CREATE)
    @GetMapping("/employees/create")
    public ModelAndView create() {
        return new ModelAndView("employee-create", "employee", new Employee());
    }

    @Secured(ROLE_PREFIX + EMPLOYEES_CREATE)
    @PostMapping("/employees/create")
    public String create(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-create";
        } else {
            employeesDao.save(employee);

            return "redirect:/employees";
        }
    }

    @Secured(ROLE_PREFIX + EMPLOYEES_DELETE)
    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeesDao.deleteById(id);

        return "redirect:/employees";
    }
}
