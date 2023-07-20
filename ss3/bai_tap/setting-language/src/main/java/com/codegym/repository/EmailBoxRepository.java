package com.codegym.repository;

import com.codegym.model.EmailBox;
import org.springframework.stereotype.Repository;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository{
    static EmailBox emailBox=new EmailBox("english",25,true,"một hai ba");
  public EmailBox showSetting(){
        return emailBox;
    }
}
