package com.spring.boot.data.transfer;


import com.spring.boot.data.layer.FtpDataLayer;
import com.spring.boot.data.layer.HttpDataLayer;
import com.spring.boot.ds.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataTransferAction {

    @Autowired
    FtpDataLayer ftpDataLayer;
    @Autowired
    HttpDataLayer httpDataLayer;

    public void transfer() {
        List<Person> personData = ftpDataLayer.getData();

        httpDataLayer.saveData(personData);
    }
}
