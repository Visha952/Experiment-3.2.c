package com.example.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.bank.service.BankService;
import com.example.bank.config.AppConfig;

public class MainApp {
 public static void main(String[] args){
     AnnotationConfigApplicationContext ctx =
         new AnnotationConfigApplicationContext(AppConfig.class);
     BankService service = ctx.getBean(BankService.class);
     service.transfer(101, 102, 500);
     ctx.close();
 }
}
