**SpringBoot Actuator**

* Provides features like Metrics, Audit, Health-check, Monitoring events. We can use tese features without having to code them.
* We just have to include spring-boot-starter-actuator dependency


---

* Some of the endpoints provided out of the box are:
   auditevents, info, health, metrics, loggers, env, sessions, threaddump, shutdown etc
* All are enabled by default except shutdown.
* We can change the default enabled endpoint using:
   **management.endpoints.enabled-by-default**=false

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
* It provides non sensitive information about the application  like app name, description, version
* These can be added via properties: info.app.name, info.app.version, info.app.description
* Also these can be added implementing InfoContributor bean

---
* /loggers will list all the currently configured loggers at package level and their levels
* /loggers/${logger-name} - to get the log level at the package(logger-name is package name/Class name)