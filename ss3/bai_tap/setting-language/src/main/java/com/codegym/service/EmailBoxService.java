package com.codegym.service;

import com.codegym.model.EmailBox;
import com.codegym.repository.IEmailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailBoxService implements IEmailBoxService{
    @Autowired
   private IEmailBoxRepository emailBoxRepository;

   public EmailBox showSetting(){
       return emailBoxRepository.showSetting();
   }
}
