package com.dhf.handler;

import com.dhf.exception.MyException;
import com.dhf.exception.NoUSerException;
import com.dhf.exception.PassException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerMyException {

    @ExceptionHandler(value = MyException.class)
    public String error(Exception exception,Model model){

        if(exception instanceof PassException)
            model.addAttribute("error","密码输入不正确");
        if(exception instanceof NoUSerException)
            model.addAttribute("error","账户不存在");

        System.out.println(exception.getMessage());

        return "login";
    }

}
