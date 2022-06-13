package org.kie.example;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.kie.api.task.TaskEvent;
import org.kie.api.task.TaskLifeCycleEventListener;

public class ExampleTaskLifeCycleEventListener implements TaskLifeCycleEventListener {

    public static final String ENV_KEY_KAFKA_BOOTSTRAP_SERVERS = "KAFKA_BOOTSTRAP_SERVERS";
    public static final String ENV_KEY_KAFKA_TASKS_TOPIC = "KAFKA_TASKS_TOPIC";
    public String kafka_bootstrap_servers = "localhost:9092";
    public String kafka_tasks_topic = "tasks";
    private KafkaProducer<String, String> producer;

    public ExampleTaskLifeCycleEventListener() {
        System.out.println("====> example task event listener constructor called");
        String kbs = System.getenv(ENV_KEY_KAFKA_BOOTSTRAP_SERVERS);
        if (kbs != null) {
            kafka_bootstrap_servers = kbs;
        }
        System.out.println("====> kafka bootstrap servers: " + kafka_bootstrap_servers);
        String topic = System.getenv(ENV_KEY_KAFKA_TASKS_TOPIC);
        if (topic != null) {
            kafka_tasks_topic = topic;
        }
        System.out.println("====> kafka tasks topic: " + kafka_tasks_topic);

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka_bootstrap_servers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<String, String>(properties);
    }

    private void pushTaskToKafka(long taskId, long processInstanceId, String deploymentId, String taskName) {
        String key = "" + taskId;
        String value = "" + deploymentId + ":" + processInstanceId + ":" + taskId + ":" + taskName;
        System.out.println("====> pushing to kafka topic: " + kafka_tasks_topic);
        System.out.println("====> key: " + key);
        System.out.println("====> value: " + value);
        Future<RecordMetadata> future = producer.send(new ProducerRecord<String, String>(kafka_tasks_topic, key,
                value));
    }

    @Override
    public void beforeTaskActivatedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskClaimedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskSkippedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskStartedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskStoppedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskCompletedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskFailedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskAddedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskExitedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskReleasedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskResumedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskSuspendedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskForwardedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskDelegatedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void beforeTaskNominatedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskActivatedEvent(TaskEvent event) {
        String taskName = event.getTask().getName();
        System.out.println("====> task name: " + taskName);
        long taskId = event.getTask().getId();
        System.out.println("====> task id: " + taskId);
        long processInstanceId = event.getTask().getTaskData().getProcessInstanceId();
        System.out.println("====> process instance id: " + processInstanceId);
        String deploymentId = event.getTask().getTaskData().getDeploymentId();
        System.out.println("====> deployment id: " + deploymentId);
        Map<String, Object> inputVars = event.getTask().getTaskData().getTaskInputVariables();
        System.out.println("====> input variables: " + inputVars.keySet());

        pushTaskToKafka(taskId, processInstanceId, deploymentId, taskName);
    }

    @Override
    public void afterTaskClaimedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskSkippedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskStartedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskStoppedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskCompletedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskFailedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskAddedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskExitedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskReleasedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskResumedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskSuspendedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskForwardedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskDelegatedEvent(TaskEvent event) {
        // nothing here

    }

    @Override
    public void afterTaskNominatedEvent(TaskEvent event) {
        // nothing here

    }
}