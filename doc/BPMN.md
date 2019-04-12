#BPMN2.0

##Tasks
BPMN 中的任务有：
- Service Task        服务任务
- Send Task           发送任务
- User Task           用户任务
- Business Rule Task  业务规则任务
- Script Task         脚本任务
- Receive Task        接受任务
- Manual Task         手动任务
- Task Markers        任务标记
###Service Task
服务任务用于调用服务，在Camunda中，这个任务是用来调用Java代码或者为外部工作者提供工作项以异步完成

####Calling Java Code
有四种方式可以实现对Java代码的调用:
- Specifying a class that implements a JavaDelegate or ActivityBehavior
- Evaluating an expression that resolves to a delegation object
- Invoking a method expression
- Evaluating a value expression

也就是实现JavaDelegate 或者 ActivityBehavior的类
```xml
<serviceTask id="javaService" name="My Java Service Task" camunda:class="com.camunda.bpm.getstarted.ucvrms.MyController" />
```
而解析表达式的写法，前提是要实现JavaDelegate 或者 ActivityBehavior的类
```xml
<serviceTask id="beanService" name="My Bean Service Task" camunda:delegateExpression="${myDelegateBean}"></serviceTask>
```
或者可以实现调用一个Java方法
```xml
<serviceTask id="expressionService" name="My Expression Service Tash" camunda:expression="${myBean.doWork()}"></serviceTask>
```

#### Service Task Results
可以为服务任务添加一个返回值，在xml中配置 camunda:resultVariable 属性就可以将返回值接收到流程变量中。
如果没有配置此属性，即使方法有返回值也会丢弃掉。
```xml
<serviceTask id="aMethodExpressionServiceTask" camunda:expression="#{myService.doSomething()}" 
             camunda:resultVariable="myVar"></serviceTask>
```

###External Tasks
当服务任务声明为外部任务时，引擎会生产任务给外部操作人员，这就将任务实现和流程引擎进行了分离，并且提供Rest Api实现跨域系统和技术边界

当在xml中配置 camunda:type=external 和 camunda:topic 后即是指定了外部任务主题。
```xml
<serviceTask id="anExternalServiceTask" camunda:type="external" camunda:topic="ShipmentProcessing"></serviceTask>
```

### Send Task
发送任务用来发送消息，其实现和Service Task一样，都是调用Java代码
```xml
<sendTask id="sendTask" camunda:class="com.camunda.bpm.getstarted.ucvrms.MyController"></sendTask>
```

### User Task
用户任务用来模拟一个人类需要完成的事情，当流程执行到用户任务时，会给对应的人员或者组生成一个任务单
```xml
<userTask id="theTask" name="Important task"></userTask>
```
任何一个BPMN2.0的元素都是可以添加描述的，可以通过添加文档元素实现
```xml
<userTask id="theTask" name="Schedule meeting"></userTask>
<documentation> Schedule an engineering meeting </documentation>
```
通过Java代码可以取到这个描述
```java
task.getDescription();
```
#### Properties
##### Due Date
每个用户任务都一个截止时间，可以在xml或者TaskListeners中指定截止时间
```xml
<userTask id="theTask" name="Important task" camunda:dueDate="${dataVariable}"></userTask>
```
该表达式始终解析为：java.util.Date,java.util.String(ISO8601 formatted) or null
##### Follow Up Date
跟进时间和截止时间类似
```xml
<userTask id="theTask" name="Important task" camunda:followUpDate="${dataVariable}"></userTask>
```
#### User Assignment
##### Human Performer
用户任务可以通过子节点 humanPerformer 可以指定当前任务的执行人
```xml
<userTask id="theTask" name="important task">
  <humanPerformer>
    <resourceAssignmentExpression>
      <formalExpression>kermit</formalExpression>
    </resourceAssignmentExpression>
  </humanPerformer>
</userTask>
```
还可以使用camunda的assignee属性实现
```xml
<userTask id="theTask" name="my task" camunda:assignee="kermit"></userTask>
```

在Java代码中查询某个指定人的任务
```java
List<Task> tasks = taskService.createTaskQuery().taskAssignee("kermit").list();
```

##### Potential Owner
总有一些任务是不一定要被操作的，那么这些候选任务怎么实现呢？
```xml
<userTask id="theTask" name="important task">
  <potentialOwner>
    <resourceAssignmentExpression>
      <formalExpression>user(kermit), group(management)</formalExpression>
    </resourceAssignmentExpression>
  </potentialOwner>
</userTask>
```
如果表达式中没有指出值是人员还是组，那么引擎会默认为组

使用camunda的candidateUsers属性实现
```xml
<userTask id="theTask" name="my task" camunda:candidateUsers="kermit, fonzo"></userTask>
<userTask id="theTask" name="my task" camunda:candidateGroups="management, accountancy"></userTask>
```

代码获取候选任务
```xml
List<Task> tasks = taskService.createTaskQuery().taskCandidataUser("kermit").list();
```


