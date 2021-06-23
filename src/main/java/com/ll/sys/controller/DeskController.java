package com.ll.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 20:12
 *
 * 工作台控制器
 */

@Controller
@RequestMapping("desk")
public class DeskController {
    @RequestMapping("toDeskManager")
    public String toDeskManager(){
        return "system/main/deskManger";
    }
}
