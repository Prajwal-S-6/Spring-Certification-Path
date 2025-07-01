package com.spring.security.example2.controllers;

import com.spring.security.example2.dao.DepartmentDao;
import com.spring.security.example2.ds.Department;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.spring.security.example2.security.SecurityRoles.*;

@Controller
public class DepartmentsController {
    
    @Autowired
    private DepartmentDao departmentsDao;

    @PreAuthorize("hasAnyAuthority('DEPARTMENTS_READ', 'DEPARTMENTS_PAG_VIEW')")
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments1", "departments", departmentsDao.findAll());
    }

    @PreAuthorize("hasAuthority('DEPARTMENTS_CREATE')")
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create1", "department", new Department());
    }

    @PreAuthorize("hasAuthority('DEPARTMENTS_CREATE')")
    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create1";
        } else {
            departmentsDao.save(department);

            return "redirect:/departments";
        }
    }

    @PreAuthorize("hasAuthority('DEPARTMENTS_DELETE')")
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);

        return "redirect:/departments";
    }
}

