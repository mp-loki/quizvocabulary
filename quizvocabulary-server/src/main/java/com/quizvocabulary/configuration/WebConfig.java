package com.quizvocabulary.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebConfig {

    @RequestMapping(value = "/{path:^(?!api$)(?!static$)(?!webjars$)(?!images$)(?!app/view/css$)[^\\.]*}/**")
    public String redirect() {
        return "forward:/index.html";
    }

}
