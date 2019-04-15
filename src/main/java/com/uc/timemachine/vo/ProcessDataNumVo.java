package com.uc.timemachine.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>流程实例数VO
 *
 * @author 杨玉龙, yulong.yang@ucarinc.com
 * @version 1.0
 * @since 2019/4/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessDataNumVo implements Serializable {

  private static final long serialVersionUID = 3849118417256709274L;

  /** 创建时间 **/
  private String startDate;

  /** 当前运行总数 **/
  private Integer processDataSum;

  /** 运行中BPMN类型任务数 **/
  private Integer bpmnNum;

  /** 运行中DMN类型任务数 **/
  private Integer dmnNum;

  /** 运行中cmmn类型任务数 **/
  private Integer cmmnNum;
}
