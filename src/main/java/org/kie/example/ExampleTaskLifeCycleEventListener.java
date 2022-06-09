package org.kie.example;

import java.util.Map;

import org.kie.api.task.TaskEvent;
import org.kie.api.task.TaskLifeCycleEventListener;

public class ExampleTaskLifeCycleEventListener implements TaskLifeCycleEventListener {

    public ExampleTaskLifeCycleEventListener () {
        System.out.println("====> example task event listener constructor called");
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
        Map<String,Object> inputVars = event.getTask().getTaskData().getTaskInputVariables();
        System.out.println("====> input variables: " + inputVars.keySet());
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