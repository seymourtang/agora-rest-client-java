# Agora REST Client for Java

<p>
<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/io.agora/agora-rest-client-core?colorB=brightgreen">
<img alt="GitHub License" src="https://img.shields.io/github/license/AgoraIO-Community/agora-rest-client-java">
<a href="https://github.com/AgoraIO-Community/agora-rest-client-java/actions/workflows/maven.yml"><img alt="Java CI with Maven" src="https://github.com/AgoraIO-Community/agora-rest-client-java/actions/workflows/maven.yml/badge.svg"></a>
<a href="https://github.com/AgoraIO-Community/agora-rest-client-java/actions/workflows/gitee-sync.yml"><img alt="gitee-sync" src="https://github.com/AgoraIO-Community/agora-rest-client-java/actions/workflows/gitee-sync.yml/badge.svg?branch=main"></a>
<img alt="GitHub" src="https://img.shields.io/github/v/release/AgoraIO-Community/agora-rest-client-java">
<img alt="GitHub Issues or Pull Requests" src="https://img.shields.io/github/issues-pr/AgoraIO-Community/agora-rest-client-java">
</p>

`agora-rest-client-java`is an open-source project written in Java, specifically designed for the Agora REST API. It includes wrappers and internal implementations of the official Agora REST API interfaces, making it easier for developers to integrate the server-side Agora REST API.

English | [简体中文](./README_ZH.md)

> [!IMPORTANT]
This SDK has undergone some testing to ensure its basic functionality works correctly. However, due to the complexity of software development, we cannot guarantee it is completely free of defects. We encourage community developers and users to actively participate and help improve this project.

## Features

* Encapsulates the request and response handling of the Agora REST API, simplifying the communication process with the Agora REST API.
* Provides automatic switching to the best domain in case of DNS resolution failure, network errors, or request timeouts, ensuring the availability of the REST API service.
* Offers easy-to-use APIs to easily implement common functions of the Agora REST API, such as starting and stopping cloud recording.
* Based on Java language, it is efficient, concurrent, and scalable.

## Supported Services

* [Cloud Recording](./agora-rest-client-core/src/main/java/io/agora/rest/services/cloudrecording/README.md)
* [Conversational AI Engine](./agora-rest-client-core/src/main/java/io/agora/rest/services/convoai/README.md)
  
## Environment Setup

* [Java 1.8 or later](https://www.java.com)
* App ID and App Certificate obtained from the [Agora Console](https://console.agora.io/v2)
* Basic Auth credentials from the [Agora Console](https://console.agora.io/v2)
* Enable the relevant service capabilities on the [Agora Console](https://console.agora.io/v2)

## Installation

First, add the REST Client dependency in the `pom.xml` file:

```xml
<dependency>
    <groupId>io.agora</groupId>
    <artifactId>agora-rest-client-core</artifactId>
    <version>0.3.0</version>
</dependency>
```

## Usage Example

Here is an example of calling the cloud recording service:

```java
package com.company.example;

import io.agora.rest.AgoraException;
import io.agora.rest.core.AgoraConfig;
import io.agora.rest.core.BasicAuthCredential;
import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.services.cloudrecording.api.req.StartResourceReq;
import io.agora.rest.services.cloudrecording.api.res.AcquireResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StartResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StopResourceRes;
import io.agora.rest.services.cloudrecording.CloudRecordingClient;
import io.agora.rest.services.cloudrecording.scenario.mix.req.AcquireMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.req.StartMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.res.QueryMixHLSAndMP4RecordingResourceRes;

import java.util.Arrays;
import java.util.Collections;

public class Main {
  private static String appId = "<your appId>";

  private static String cname = "<your cname>";

  private static String uid = "<your uid>";

  private static String username = "<the username of basic auth credential>";

  private static String password = "<the password of basic auth credential>";

  private static String token = "<your token>";

  private static String accessKey = "<your accessKey>";

  private static String secretKey = "<your secretKey>";

  private static Integer region = 0; // <your region>

  private static String bucket = "<your bucket>";

  private static Integer vendor = 0; // <your vendor>

  public static void main(String[] args) throws Exception {

    Credential credential = new BasicAuthCredential(username, password);

    // Initialize AgoraConfig
    AgoraConfig agoraConfig = AgoraConfig.builder()
            .appId(appId)
            .credential(credential)
            // Specify the region where the server is located.
            // Optional values are CN, US, EU, AP, and the client will automatically
            // switch to use the best domain name according to the configured region
            .domainArea(DomainArea.CN)
            .build();

    // Initialize CloudRecordingClient

    CloudRecordingClient cloudRecordingClient = CloudRecordingClient.create(agoraConfig);


    AcquireResourceRes acquireResourceRes;

    // Acquire resource
    try {
      acquireResourceRes = cloudRecordingClient
              .mixScenario()
              .acquire(cname, uid, AcquireMixRecordingResourceClientReq.builder()
                      .build())
              .block();
    } catch (AgoraException e) {
      System.out.printf("agora error:%s", e.getMessage());
      return;
    } catch (Exception e) {
      System.out.printf("unknown error:%s", e.getMessage());
      return;
    }

    // Check if the response is null
    if (acquireResourceRes == null || acquireResourceRes.getResourceId() == null) {
      System.out.println("failed to get resource");
      return;
    }


    System.out.printf("resourceId:%s", acquireResourceRes.getResourceId());

    System.out.println("acquire resource success");

    // Define storage config
    StartResourceReq.StorageConfig storageConfig = StartResourceReq.StorageConfig.builder()
            .accessKey(accessKey)
            .secretKey(secretKey)
            .bucket(bucket)
            .vendor(vendor)
            .region(region)
            .build();

    // Define start resource request
    StartMixRecordingResourceClientReq startResourceReq = StartMixRecordingResourceClientReq.builder()
            .token(token)
            .recordingConfig(StartResourceReq.RecordingConfig.builder()
                    .channelType(1)
                    .streamTypes(2)
                    .maxIdleTime(30)
                    .audioProfile(2)
                    .transcodingConfig(StartResourceReq.TranscodingConfig.builder()
                            .width(640)
                            .height(480)
                            .fps(15)
                            .bitrate(800)
                            .mixedVideoLayout(0)
                            .backgroundColor("#000000")
                            .build())
                    .subscribeAudioUIDs(Collections.singletonList("#allstream#"))
                    .subscribeVideoUIDs(Collections.singletonList("#allstream#"))
                    .build())
            .recordingFileConfig(StartResourceReq.RecordingFileConfig.builder()
                    .avFileType(Arrays.asList("hls", "mp4"))
                    .build())
            .storageConfig(storageConfig)
            .build();


    StartResourceRes startResourceRes;

    // Start resource
    try {
      startResourceRes = cloudRecordingClient
              .mixScenario()
              .start(cname, uid,
                      acquireResourceRes.getResourceId(),
                      startResourceReq)
              .block();

    } catch (AgoraException e) {
      System.out.printf("agora error:%s", e.getMessage());
      return;
    } catch (Exception e) {
      System.out.printf("unknown error:%s", e.getMessage());
      return;
    }

    // Check if the response is null
    if (startResourceRes == null || startResourceRes.getSid() == null) {
      System.out.println("failed to start resource");
      return;
    }

    System.out.printf("sid:%s", startResourceRes.getSid());

    System.out.println("start resource success");

    Thread.sleep(3000);

    QueryMixHLSAndMP4RecordingResourceRes queryResourceRes;

    // Query resource
    try {
      queryResourceRes = cloudRecordingClient
              .mixScenario()
              .queryHLSAndMP4(startResourceRes.getResourceId(), startResourceRes.getSid())
              .block();

    } catch (AgoraException e) {
      System.out.printf("agora error:%s", e.getMessage());
      return;
    } catch (Exception e) {
      System.out.printf("unknown error:%s", e.getMessage());
      return;
    }

    if (queryResourceRes == null || queryResourceRes.getServerResponse() == null) {
      System.out.println("failed to query resource");
      return;
    }

    System.out.println("query resource success");

    Thread.sleep(3000);

    StopResourceRes stopResourceRes;

    // Stop resource
    try {
      stopResourceRes = cloudRecordingClient
              .mixScenario()
              .stop(cname, uid, startResourceRes.getResourceId(), startResourceRes.getSid(),
                      true)
              .block();
    } catch (AgoraException e) {
      System.out.printf("agora error:%s", e.getMessage());
      return;
    } catch (Exception e) {
      System.out.printf("unknown error:%s", e.getMessage());
      return;
    }

    // Check if the response is null
    if (stopResourceRes == null || stopResourceRes.getSid() == null) {
      System.out.println("failed to stop resource");
    } else {
      System.out.println("stop resource success");
    }

  }
}

```

For more examples, see [Example](./examples).

## Contribution

This project welcomes and accepts contributions. If you encounter any issues or have suggestions for improvements, please open an issue or submit a Pull Request.

# SemVer Versioning

This project uses Semantic Versioning (SemVer) to manage versions. The format is MAJOR.MINOR.PATCH.

* MAJOR version indicates incompatible changes.
* MINOR version indicates backward-compatible new features or enhancements.
* PATCH version indicates backward-compatible bug fixes and maintenance.
For more details, please refer to the [Semantic Versioning](https://semver.org) specification.

## References

* [Agora API Documentation](https://docs.agora.io/en/)

## License

This project is licensed under the MIT License. For more details, please refer to the LICENSE file.
