package com.uc.timemachine.controller;

import com.uc.timemachine.service.IndexService;
import com.uc.timemachine.vo.ProcessDataNumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>首页控制器
 *
 * @author 杨玉龙, yulong.yang@ucarinc.com
 * @version 1.0
 * @since 2019/4/13
 */
@RestController
@RequestMapping("/api/index")
public class IndexController {

  @Autowired
  IndexService indexService;
  /**
   * 获取流程实例数目信息
   *
   * @author 杨玉龙, yulong.yang@ucarinc.com
   * @since 2019/4/13
   * @return ['startDate','processDataSum','bpmnNum','dmnNum','cmmnNum']
   * @see ProcessDataNumVo
   */

  @RequestMapping(value = "/getDataNum", method = RequestMethod.GET)
  public List<ProcessDataNumVo> getProcessDataNum(){
    return indexService.getProcessDataNum();
  }
}
