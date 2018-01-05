package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }


    @Bean
    public TollProcessingTask tollProcessingTask() {
        return new TollProcessingTask();
    }

    public class TollProcessingTask implements CommandLineRunner {
        @Override
        public void run(String... strings) throws Exception {

            //parameters stationid, license plate, timestamp
            if (null != strings) {
                System.out.println("parameter lenght is " + strings.length);

                String stationId = strings[1];
                String licensePlate = strings[2];
                String timestamp = strings[3];

                System.out.println("Station ID is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timestamp);
            }
        }
    }
}
