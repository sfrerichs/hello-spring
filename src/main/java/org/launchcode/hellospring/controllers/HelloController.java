package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //handles request of the form /hello?name=LaunchCode
    //static
//    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
    //dynamic
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String thisGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", thisGreeting);
        return "hello";
    }

    //handles request of the form /hello/LaunchCode
    //static
//    @GetMapping("hello/{name}")
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!!";
//    }
    //dynamic
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greetingTwo = "Hello " + name + "!!";
        model.addAttribute("greeting", greetingTwo);
        return "hello";
    }

//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" + //submit a request to /hello
//                "<input type = 'text' name = 'name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    //Ch 10 exercises
//    @GetMapping("form")
//    public String createMessage() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" + //submit a request to /hello
//                "<input type = 'text' name = 'name'>" +
////                "<input type='" +
//                "<select name='language'>" +
//                    "<option value='English'>English</option>" +
//                    "<option value='Deutsch'>Deutsch</option>" +
//                "</select>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Sarah");
        names.add("Sis");
        names.add("Sally");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
