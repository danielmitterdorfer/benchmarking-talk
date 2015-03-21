Benchmarking Talk
=================

This project contains a purposefully flawed hand-written microbenchmark and a corresponding microbenchmark using the Java Microbenchmarking Harness ([JMH](http://openjdk.java.net/projects/code-tools/jmh)).

It accompanies a short talk on microbenchmarking at the [Software Performance Meetup Group](http://www.meetup.com/Software-Performance-Meetup-Group/) in Munich ([Slides](http://daniel.mitterdorfer.name/talks/2014/jmh-microbenchmarking-munich/)).

# Getting Started

## Prerequisites

The project requires at least JDK 8 and Gradle 2.0 or Maven 3.0.

## Installation

If Gradle is not installed:

```
git clone https://github.com/danielmitterdorfer/benchmarking-talk.git
cd benchmarking-talk
./gradlew shadow
java -jar build/libs/benchmarking-talk-0.1.0-all.jar
```

Or alternatively, if Gradle > 2.1 is installed:

```
git clone https://github.com/danielmitterdorfer/benchmarking-talk.git
cd benchmarking-talk
gradle shadow
java -jar build/libs/benchmarking-talk-0.1.0-all.jar
```

or finally with Maven:

```
git clone https://github.com/danielmitterdorfer/benchmarking-talk.git
cd benchmarking-talk
mvn clean package
java -jar target/benchmarking-talk.jar
```

The Gradle build file supports also IntelliJ IDEA project setup. Just issue `gradle idea` to create the project files.

# License

This project is distributed under the terms of the [Apache Software Foundation license, version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).