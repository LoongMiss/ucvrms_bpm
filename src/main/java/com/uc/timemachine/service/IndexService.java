package com.uc.timemachine.service;

import com.uc.timemachine.vo.ProcessDataNumVo;

import java.util.List;

/**
 * <p>首页服务
 *
 * @author 杨玉龙, yulong.yang@ucarinc.com
 * @version 1.0
 * @since 2019/4/13
 */
public interface IndexService {

  List<ProcessDataNumVo> getProcessDataNum();
}
