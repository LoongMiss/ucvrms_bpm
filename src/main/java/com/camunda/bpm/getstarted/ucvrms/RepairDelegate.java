package com.camunda.bpm.getstarted.ucvrms;

import org.springframework.stereotype.Service;

/**
 * <p>维修方式处理
 *
 * @author yulong.yang, yangyulong0108@gmail.com
 * @version 1.0
 * @since 2019-04-12
 **/
@Service
public class RepairDelegate {

  public void repair(){
    System.out.println("========进场维修============");
  }


  public void maintain(){
    System.out.println("===========预约保养==========");
  }
}
