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
    public String hello(@RequestParam String name, Model model) {
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
//    @GetMapping("hello/{name}")
//    public String hello(@PathVariable String name, Model model) {
//        String greetingTwo = "Hello " + name + "!!";
//        model.addAttribute("greeting", greetingTwo);
//        return "hello";
//    }

    @GetMapping()
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type = 'text' name = 'name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //Ch 10 exercises
    @GetMapping("form")
    @ResponseBody
    public String getLanguage() {
        return "<html>" +
                "<body>" +
                "<form action='createMessage' method='post'>" + //submit a request to /createMessage
                "<input type = 'text' name = 'name'>" +
                "<select name='language'>" +
                    "<option value='eng'>English</option>" +
                    "<option value='deu'>Deutsch</option>" +
                    "<option value='pig'>Pig Latin</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value = "createMessage", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language, Model model) {
        String langGreet = "";
        if (language.equals("eng")) {
            langGreet = "Hello, ";
        } else if (language.equals("deu")) {
            langGreet = "Guten Tag, ";
        } else if (language.equals("pig")) {
            langGreet = "Ello hay, ";
        }
        String languageGreeting = "";
        model.addAttribute("langGreeting", languageGreeting);
        return "<html>" +
                "<body>" +
                "<h1>" + langGreet + name + "</h1>" +
                "</body>" +
                "</html>";
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
