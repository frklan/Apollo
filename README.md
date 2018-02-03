# Apollo
[![Java 8](https://img.shields.io/badge/Java-8-brightgreen.svg)](https://www.spigotmc.org/wiki/spigot/)
[![Build Status](https://travis-ci.org/frklan/Apollo.svg?branch=master)](https://travis-ci.org/frklan/Apollo)
[![GitHub release](https://img.shields.io/github/release/frklan/Apollo.svg)](https://github.com/frklan/Apollo/releases)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/frklan/Apollo/issues)
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](https://github.com/frklan/Apollo/blob/master/LICENSE)


Part of the Prometheus project.

This is a very simple command line interpreter, a minimal set of build in commands are available (at present 'help', 'version' and 'stop'; out of which 'stop' is of any real use). However, the functionally is easy expanded by a plugin system where stand alone java jar-packages are loaded at runtime.


## Compiling and running
Prerequisites

- Java 8 SDK
- Apached Maven

### Compiling

To compile issue the following commands

````
$ git clone git@github.com:frklan/Apollo.git
$ cd Apollo
$ mvn package
````

### Running

Download and compile the source code as outlined above, then:

````
$ cd launcher/target
$ java -jar Apollo-0.0.1-SNAPSHOT.jar
````

## Plugin

The basic functions of the launcher can be expanded with simple jar plugins, see [plugin template](https://github.com/PrometheusTemplatePlugin) for an up-to-date example.

## Contributing
Contributions are always welcome!

When contributing to this repository, please first discuss the change you wish to make via the issue tracker, email, or any other method with the owner of this repository before making a change.

Please note that we have a code of conduct, you are required to follow it in all your interactions with the project.

## Versioning
We use SemVer for versioning. For the versions available, see the tags on this repository.

## Authors
- Fredrik Andersson - Initial work - frklan

## License
This project is licensed under the MIT License - see the LICENSE file for details

## Acknowledgments
- The creators of BungeeCord and SpigotMC
- README based on PurpleBooth's template
