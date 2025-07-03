package com.spring.security.example4.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

import static java.lang.Thread.sleep;

@Controller
public class AccountsController {

    @GetMapping("/account")
    public String accounts(Model model) throws InterruptedException {

        sleep(5000);
        model.addAttribute("securityContextHolderStrategy", SecurityContextHolder.getContextHolderStrategy().getClass().getName());

        storeSecurityContextDataInModelMainThread(model);
        storeSecurityContextDataInModelChildThread(model);
        return "account4";
    }

    private void storeSecurityContextDataInModelMainThread(Model model) {
        storeSecurityContextDataInModel("main", model);
    }

    private void storeSecurityContextDataInModelChildThread(Model model) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                storeSecurityContextDataInModel("child", model);
            }
        });
        thread.start();
        thread.join();
    }

    private void storeSecurityContextDataInModel(String threadName, Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        User user  = (User) Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .orElse(null);

        model.addAttribute(threadName + "HashCode", Integer.toHexString(securityContext.hashCode()));

        model.addAttribute(
                threadName + "Name",
                Optional.ofNullable(authentication)
                        .map(Authentication::getName)
                        .orElse("N/A")
        );

        model.addAttribute(
                threadName + "Username",
                Optional.ofNullable(user)
                        .map(User::getUsername)
                        .orElse("N/A")
        );

        model.addAttribute(
                threadName + "Authorities",
                Optional.ofNullable(authentication)
                        .map(Authentication::getAuthorities)
                        .orElse(null)
        );

    }
}
