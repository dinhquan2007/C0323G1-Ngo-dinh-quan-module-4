package com.codegym.ss6_player_soccer.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private int count = 0;

    @After("execution(* com.codegym.ss6_player_soccer.controller.PlayerSoccerController.transitionStatusReady(..))")
    public void loggingReadyPlayer() {
        count++;
        if (count>11){

        }
        System.out.println("có "+count +" cầu thủ đá chính");
    }
    @After("execution(* com.codegym.ss6_player_soccer.controller.PlayerSoccerController.transitionStatusReserve(..))")
    public void loggingUnReadyPlayer() {
        count--;
        System.out.println("có "+count +" cầu thủ đá chính");
    }

}
