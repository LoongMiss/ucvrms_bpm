TIME MACHINE
=====================
![TIME MACHINE](/images/time-machine.png)

TIME MACHINE is a flexible framework for workflow and process automation. It's core is a native BPMN 2.0 process engine that runs inside the Java Virtual Machine. It can be embedded inside any Java application and any Runtime Container. It integrates with Java EE 6 and is a perfect match for the Spring Framework. On top of the process engine, you can choose from a stack of tools for human workflow management, operations & monitoring.
* Getting Started: https://github.com/LoongMiss/ucvrms_bpm
* Issue Tracker: https://github.com/LoongMiss/ucvrms_bpm/issues

Components
----------

camunda BPM platform provides a rich set of components centered around the BPM lifecycle.

#### Process Implementation and Execution
 * camunda engine - The core component responsible for executing BPMN 2.0 processes.
 * REST API - The REST API provides remote access to running processes.
 * Spring, CDI integration - Programming model integration that allows developers to write Java Applications that interact with running processes.

#### Process Design
 * camunda modeler - A [standalone desktop application](https://github.com/camunda/camunda-modeler) that allows business users and developers to design & configure processes.
 * camunda cycle - Enables BPMN 2.0 based Roundtrip between Business and IT parties involved in a project. Allows to use any BPMN 2.0 modeling tool with camunda BPM.

#### Process Operations
 * camunda engine - JMX and advanced Runtime Container Integration for process engine monitoring.
 * camunda cockpit - Web application tool for process operations.
 * camunda admin - Web application for managing users, groups, and their access permissions.

#### Human Task Management
 * camunda tasklist - Web application for managing and completing user tasks in the context of processes.

#### And there's more...

 * [bpmn.io](https://bpmn.io/) - Toolkits for BPMN, CMMN, and DMN in Java Script (rendering, modeling)
 * [Community Extensions](https://docs.camunda.org/manual/7.5/introduction/extensions/) - Extensions on top of Camunda BPM provided and maintained by our great open source community


A Framework
----------
In contrast to other vendor BPM platforms, camunda BPM strives to be highly integrable and embeddable. We seek to deliver a great experience to developers that want to use BPM technology in their projects.

### Highly Integrable
Out of the box, camunda BPM provides infrastructure-level integration with Java EE Application Servers and Servlet Containers.

### Embeddable
Most of the components that make up the platform can even be completely embedded inside an application. For instance, you can add the process engine and the REST Api as a library to your application and assemble your custom BPM platform configuration.
