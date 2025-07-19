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
* /loggers/${logger-name} - to get the log level at the package(logger-name is package name.Class name)
* It provides the effective log level.
* We can change the effective log level for package.className by doing POST request with body
   {"configuredLevel": "DEBUG"} to /loggers/${logger-name}

---
* We can access specific metric endpoint using TAG=KEY:VALUE
* Example: /metrics/http.server.requests?tag=status:200&tag=method:GET
* It is used to filter the query results, mainly used with /metrics endpoint
  http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/hello1&tag=status:200


* Metrics are used to examine the metrics of application at runtime like: request count, Cpu usage,memory usage, thread info.
* We can create a custom metrics with/without tag using MeterRegistry from Micrometer Application Metrics Facade
* We can use the primitives provided by MeterRegistry like: Counter, Gauge,Timer etc
* By injecting MeterRegistry at application start in constructor
   meterRegistry.counter("metric-name", "tagKey", "tagValue")