package com.spring.security.example5.controllers;

import com.spring.security.example5.dao.DepartmentDao;
import com.spring.security.example5.ds.Department;
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

import static com.spring.security.example5.security.SecurityRoles.*;

@Controller
public class DepartmentsController {
    
    @Autowired
    private DepartmentDao departmentsDao;

    @Secured(ROLE_PREFIX + DEPARTMENTS_READ)
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments1", "departments", departmentsDao.findAll());
    }

    @Secured(ROLE_PREFIX + DEPARTMENTS_CREATE)
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create1", "department", new Department());
    }

    @Secured(ROLE_PREFIX + DEPARTMENTS_CREATE)
    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create1";
        } else {
            departmentsDao.save(department);

            return "redirect:/departments";
        }
    }

    @Secured(ROLE_PREFIX + DEPARTMENTS_DELETE)
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);

        return "redirect:/departments";
    }
}

