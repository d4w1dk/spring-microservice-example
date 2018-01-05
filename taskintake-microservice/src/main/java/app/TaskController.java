package app;

import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
class TaskController {

    @Inject
    private TaskProcessor t;

    @RequestMapping(path = "/tasks", method = RequestMethod.POST)
    public @ResponseBody
    String launchTask(@RequestBody String s) {

        t.publishRequest(s);

        System.out.println("request mode");

        return "success";
    }

}
