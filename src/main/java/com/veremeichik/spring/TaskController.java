package com.veremeichik.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/alltasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/")
    public String index() {
        return "Hello World! :3";
    }

    @GetMapping("/hello")
    public String hello() {
        return "gooner_ena";
    }

    @GetMapping("/{code}")
    public String print_code(@PathVariable String code) {
        return "There is code: " + code;
    }

    @GetMapping("/{a}/{b}")
    public int count_function(@PathVariable int a, @PathVariable int b) {
        return a*b;
    }

    @GetMapping("/{a}/{b}/{c}")
    public int sum_function(@PathVariable int a, @PathVariable int b, @PathVariable int c) {
        return a+b+c;
    }

    @GetMapping("/elseif/{c}/{d}")
    public String elseif(@PathVariable int c, @PathVariable int d) {
        if (c>d) {
            return "C is greater than D";
        } else  {
            return "C is lesser than D";
        }
    }

    @GetMapping("/cases/{c}")
    public String cases(@PathVariable int c) {
        return switch (c) {
            case 1 -> "C is 1";
            case 2 -> "C is 2";
            default -> "C is not 1 or 2";
        };
    }

    @GetMapping("/for/{z}")
    public String for_z(@PathVariable int z) {
        Assault ass = new Assault(13,17,33);
        String str = "The value you inserted is here";
        for (int i : ass.d) {
            if (i == z) {
                return str;
            }
        }
        return str + " (NOT)";
    }

}
