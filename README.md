# technosf-archetype-ewar #

**Executable Web Archive** (*.war*) files are incredibly handy - deploy your web application via them to Java Web Application servers, or just execute them directly as you would a **Java Archive** (*.jar*) file:
	
	java -jar myapplication.war
	
This project builds _Maven Archetypes_ that generate **executable war files** with a sample application that you can build off. Generating a Maven Project from a _technosf-archetype-ewar_ archetype will deliver a dynamic web application combined with an embedded _Eclipse Jetty_ web application server.


## Table of Contents ##

- [How Does An Executable Web Archive Work](#how-does-an-executable-web-archive-work)
- [Installation ](#installation)
- [Components ](#components)
- [License](#license)


## How Does An Executable Web Archive Work? ##

**.jar** files can be execute directly with the _java -jar_ command. This is achieved by following a standard archive layout and by including a manifest that specifies a _main_ class to execute.

**.war** files are deployed for execution within web application servers that expect the archive to follow a standard layout and to including specific deployment descriptors.

An **executable .war** file is a _.war_ file which has had an _embedded web application server_ included in it using the *executable .jar* layout. By executing the *.war* file with the _java -jar_ command, the embedded web application server starts up, explodes the _.war_ it is contained in and runs the contained web application.


## Installation ##

Download the _archetype_ for the version of Jetty you wish to use. Generate a project with the command:
	
	mvn install:install-file technosf-archetype-ewar-9.3_8.5.jar


## Components ##

  * **technosf-archetype-ewar** archetypes are built utilizing the **Eclipse Jetty** web application server
  * _JSP_'s are compiled with **Apache Tomcat Jasper**
  * _JSTL standard libraries_ are included
  * _JQuery_ core, cookies and template are included 



## License ##

technosf-archetype-ewar - Copyright 2016 technosf [https://github.com/technosf]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
