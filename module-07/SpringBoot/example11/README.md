**SpringBoot Actuator**

* Provides features like Metrics, Audit, Health-check, Monitoring events. We can use tese features without having to code them.
* We just have to include spring-boot-starter-actuator dependency

---
 * Actuator endpoints can be accessed via Http(Web) or JMX.
 * All the endpoints are enabled by default expect shutdown endpoint
 * Only /health endpoint is exposed via web, to expose other endpoints via web:
   **management.endpoints.web.exposure.include**=info,health,metrics,loggers  --- * for all endpoints
 * We can also exclude some of the endpoints from being exposed
   **management.endpoints.jmx.exposure.exclude**=health
 * We can enable non enabled endpoints by:
   **management.endpoint.shutdown.enabled**=true