# CloudRecording Example

English | [简体中文](./README_ZH.md)

> This is a sample project for Agora Cloud Recording that utilizes the Agora Cloud Recording RESTful API to implement channel recording functionality. This example supports three recording modes: composite recording, individual recording, and web recording.

## Run

### Prerequisites

Configure the environment variables with the following parameters:

```bash
export APP_ID=<Your App ID>
export CNAME=<Your Channel Name>
export USER_ID=<Your User ID>
export BASIC_AUTH_USERNAME=<Your Basic Auth Username>
export BASIC_AUTH_PASSWORD=<Your Basic Auth Password>
export TOKEN=<Your Token>
export STORAGE_CONFIG_VENDOR=<Your Storage Vendor>
export STORAGE_CONFIG_REGION=<Your Storage Region>
export STORAGE_CONFIG_BUCKET=<Your Storage Bucket>
export STORAGE_CONFIG_ACCESS_KEY=<Your Storage Access Key>
export STORAGE_CONFIG_SECRET_KEY=<Your Storage Secret Key>
```

Relevant parameters can be found in the [CloudRecording Service Documentation](../../agora-rest-client-core/src/main/java/io/agora/rest/services/cloudrecording/README.md)

### Execution

Please ensure that you have installed the module in the main module directory:

```bash
make install
```

Next, in the current module, execute the following commands to experience different scenarios of the `CloudRecording` example:

```bash
mvn exec:java -Dexec.mainClass="io.agora.rest.examples.cloudrecording.Main" -Dexec.args="--mode=mix --mix_scene=<scene>"
mvn exec:java -Dexec.mainClass="io.agora.rest.examples.cloudrecording.Main" -Dexec.args="--mode=individual --individual_scene=<scene>"
mvn exec:java -Dexec.mainClass="io.agora.rest.examples.cloudrecording.Main" -Dexec.args="--mode=web --web_scene=<scene>"
```

Where `mode` represents the cloud recording mode:

* mix: Composite recording
* individual: Individual recording
* web: Web page recording

Where `mix_scene` represents the composite recording scenario:

* hls: Record in HLS format
* hls_and_mp4: Record in both HLS and MP4 formats

Where `individual_scene` represents the individual recording scenario:

* recording: Recording only
* snapshot: Snapshot only
* recording_and_snapshot: Recording and snapshot
* recording_and_postpone_transcoding: Recording with delayed transcoding
* recording_and_audio_mix: Recording with delayed audio mixing

Where `web_scene` represents the web page recording scenario:

* web_recorder: Web page recording
* web_recorder_and_rtmp_publish: Web page recording and pushing to CDN
