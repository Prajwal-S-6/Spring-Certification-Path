package com.spring.security.example6.controllers;


import com.spring.security.example6.dao.EmployeesDao;
import com.spring.security.example6.ds.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    private EmployeesDao employeesDao;

    @GetMapping("/employees")
    public ModelAndView index() {
        return new ModelAndView("employees6", "employees", employeesDao.findAll());
    }

    @GetMapping("/employees/create")
    public ModelAndView create() {
        return new ModelAndView("employee-create6", "employee", new Employee());
    }

    @PostMapping("/employees/create")
    public String create(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-create6";
        } else {
            employeesDao.save(employee);

            return "redirect:/employees";
        }
    }

    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeesDao.deleteById(id);

        return "redirect:/employees";
    }
}
