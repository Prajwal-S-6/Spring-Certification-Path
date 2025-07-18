package other.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    public void print() {
        System.out.println("This is service from other package");
    }
}
