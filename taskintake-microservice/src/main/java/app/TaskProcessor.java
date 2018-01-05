package app;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@EnableBinding(Source.class)
class TaskProcessor {

    @Inject
    private Source source;

    public void publishRequest(String payload) {

        String url = "maven://com.sandpit:task-microservice:jar:0.0.1-SNAPSHOT";

        List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));

        TaskLaunchRequest request = new TaskLaunchRequest(url, input, null,
                null, null);

        System.out.println("created task launch request ...");

        GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
        this.source.output().send(message);
    }
}
