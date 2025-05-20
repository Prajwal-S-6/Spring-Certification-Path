package com.certification.spring.beans.scopes.web.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean2 {
}
