package com.growth.awsv1.domain.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
//  RestController 어노테이션을 사용 시 해당 컨트롤러에서 return 하는 값을 그대로 클라이언트에게 전달해준다.
//  즉, 페이지가 아닌 데이터 자체를 반환할 때 사용하는 어노테이션

@RequestMapping(value = "/aws")
public class HelloController {


    @GetMapping("/v1")
    public ModelAndView hello(Model model, @RequestParam(defaultValue = "1") Integer number){

        String str = "";

        // RestController view 호출 방법
        ModelAndView modelAndView = new ModelAndView("main/main");

        if(number == 1){ // info 로그
            log.info("/aws/v1 이 호출되었어요. info 로그 #####################################");
            str = "info 로그";
        }else if(number == -1){ // error 로그
            log.error("/aws/v1 이 호출되었어요. error 로그 #####################################");
            str = "error 로그";
        }else if(number == 0){ // warn 로그
            log.warn("/aws/v1 이 호출되었어요. warn 로그 #####################################");
            str = "warn 로그";
        }
        model.addAttribute("str", str);
        return modelAndView;
    }
}
