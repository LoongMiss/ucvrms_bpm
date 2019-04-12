package com.camunda.bpm.getstarted.ucvrms;

import org.springframework.stereotype.Service;

/**
 * <p>发送消息服务类
 *
 * @author yulong.yang, yangyulong0108@gmail.com
 * @version 1.0
 * @since 2019-04-12
 **/
@Service
public class SendMessageDelegate {

  public void rejectBill(){
    System.out.println("=========维修单驳回============");
  }

  public void rejectAudit(){
    System.out.println("===========审核退回============");
  }

}
