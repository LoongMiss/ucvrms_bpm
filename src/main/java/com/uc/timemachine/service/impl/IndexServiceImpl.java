package com.uc.timemachine.service.impl;

import com.uc.timemachine.service.IndexService;
import com.uc.timemachine.vo.ProcessDataNumVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>首页服务实现类
 *
 * @author 杨玉龙, yulong.yang@ucarinc.com
 * @version 1.0
 * @since 2019/4/13
 */

@Service
public class IndexServiceImpl implements IndexService {
  @Override
  public List<ProcessDataNumVo> getProcessDataNum() {
    List<ProcessDataNumVo> processDataNumVoList = new ArrayList<ProcessDataNumVo>(8);
    ProcessDataNumVo processDataNumVo = ProcessDataNumVo.builder().processDataSum(110).bpmnNum(50).cmmnNum(30).dmnNum(30).startDate( "2019-04-15").build();
    ProcessDataNumVo processDataNumVo1 = ProcessDataNumVo.builder().processDataSum(120).bpmnNum(60).cmmnNum(40).dmnNum(20).startDate( "2019-04-14").build();
    ProcessDataNumVo processDataNumVo2 = ProcessDataNumVo.builder().processDataSum(130).bpmnNum(50).cmmnNum(40).dmnNum(40).startDate( "2019-04-13").build();
    ProcessDataNumVo processDataNumVo3 = ProcessDataNumVo.builder().processDataSum(100).bpmnNum(80).cmmnNum(10).dmnNum(10).startDate( "2019-04-12").build();
    ProcessDataNumVo processDataNumVo4 = ProcessDataNumVo.builder().processDataSum(170).bpmnNum(150).cmmnNum(15).dmnNum(5).startDate( "2019-04-11").build();
    processDataNumVoList.add(processDataNumVo);
    processDataNumVoList.add(processDataNumVo1);
    processDataNumVoList.add(processDataNumVo2);
    processDataNumVoList.add(processDataNumVo3);
    processDataNumVoList.add(processDataNumVo4);
    return processDataNumVoList;
  }
}
