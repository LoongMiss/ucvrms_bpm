package com.camunda.bpm.getstarted.ucvrms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>测试
 *
 * @author 杨玉龙, yulong.yang@ucarinc.com
 * @version 1.0
 * @since 2019/4/9
 */
@Controller
@RequestMapping("/api")
@Slf4j
public class MyController {

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public ResponseEntity getTest() {
    log.info("test");
    return new ResponseEntity(HttpStatus.OK);
  }

  @RequestMapping(value = "/getMap", method = RequestMethod.GET)
  @ResponseBody
  public Map getMap(){
    Map<String, String> result = new HashMap<String, String>(4);
    result.put("1111","1111");
    return result;
  }
}
