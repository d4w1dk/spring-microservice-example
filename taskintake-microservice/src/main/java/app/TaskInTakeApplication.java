package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
public class TaskInTakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskInTakeApplication.class, args);
    }


}
