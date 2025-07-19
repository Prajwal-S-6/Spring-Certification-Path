**SpringBoot Actuator**

* Provides features like Metrics, Audit, Health-check, Monitoring events. We can use tese features without having to code them.
* We just have to include spring-boot-starter-actuator dependency


---

* Some of the endpoints provided out of the box are:
   auditevents, info, health, metrics, loggers, env, sessions, threaddump, shutdown etc

---
 * Actuator endpoints can be accessed via Http(Web) or JMX.
 * All the endpoints are enabled by default expect shutdown endpoint
 * Only /health endpoint is exposed via web, to expose other endpoints via web:
   **management.endpoints.web.exposure.include**=info,health,metrics,loggers  --- * for all endpoints
 * We can also exclude some of the endpoints from being exposed
   **management.endpoints.jmx.exposure.exclude**=health
 * We can enable non enabled endpoints by:
   **management.endpoint.shutdown.enabled**=true

---
* /info endpoint need to be exposed via web, and also need to be enabled using:
   management.info.env.enabled=true
* It provides non sensitive information about the application