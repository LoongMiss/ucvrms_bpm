package com.camunda.bpm.getstarted.ucvrms;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * <p>发起维修处理
 *
 * @author yulong.yang, yangyulong0108@gmail.com
 * @version 1.0
 * @since 2019-04-12
 **/
public class InitiateRepairDelegate implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) throws Exception {
    System.out.println("===============发起维修申请===================");
  }
}
