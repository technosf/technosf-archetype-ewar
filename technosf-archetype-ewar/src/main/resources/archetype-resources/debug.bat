mvn -Dorg.slf4j.simpleLogger.defaultLogLevel=debug -DXrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n jetty:run-exploded