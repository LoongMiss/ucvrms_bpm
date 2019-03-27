package com.camunda.bpm.getstarted.ucvrms;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

/**
 * <p>对流程分配进行监听处理
 *
 * @author yulong.yang, yangyulong0108@gmail.com
 * @version 1.0
 * @since 2019-03-27
 **/
public class MyAssignmentHandler implements TaskListener {
  @Override
  public void notify(DelegateTask delegateTask) {
    delegateTask.setAssignee("yulong");
    delegateTask.addCandidateUser("kermit");
    delegateTask.addCandidateGroup("management");
  }
}
