package com.spring.security.example5.controllers;

import com.spring.security.example3.dao.DepartmentDao;
import com.spring.security.example3.ds.Department;
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
public class DepartmentsController {
    
    @Autowired
    private DepartmentDao departmentsDao;

    @PreAuthorize("hasAnyAuthority('DEPARTMENTS_READ', 'DEPARTMENTS_PAG_VIEW') || hasRole('SUPER_ADMIN')")
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments1", "departments", departmentsDao.findAll());
    }

    @PreAuthorize("hasAuthority('DEPARTMENTS_CREATE') || hasRole('SUPER_ADMIN')")
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create1", "department", new Department());
    }

    @PreAuthorize("hasAuthority('DEPARTMENTS_CREATE') || hasRole('SUPER_ADMIN')")
    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create1";
        } else {
            departmentsDao.save(department);

            return "redirect:/departments";
        }
    }

    @PreAuthorize("hasAuthority('DEPARTMENTS_DELETE') || hasRole('SUPER_ADMIN')")
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);

        return "redirect:/departments";
    }
}

