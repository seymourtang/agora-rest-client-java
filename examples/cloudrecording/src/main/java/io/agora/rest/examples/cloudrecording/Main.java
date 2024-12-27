package io.agora.rest.examples.cloudrecording;

import io.agora.rest.core.BasicAuthCredential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.examples.cloudrecording.scenario.IndividualRecordingScenario;
import io.agora.rest.examples.cloudrecording.scenario.MixRecordingScenario;
import io.agora.rest.examples.cloudrecording.scenario.WebRecordingScenario;
import io.agora.rest.services.cloudrecording.api.req.StartResourceReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "Main", mixinStandardHelpOptions = true, version = "0.1.0",
        description = "Agora Recording Service")
public class Main implements Callable<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private String appId;

    private String cname;

    private String uid;

    private String username;

    private String password;

    private String token;

    private final DomainArea region = DomainArea.CN;

    private StartResourceReq.StorageConfig storageConfig;

    @Option(names = {"-m", "--mode"}, description = "mix, web, individual")
    private String mode = "";

    @Option(names = {"-ms", "--mix_scene"}, description = "hls, hls_and_mp4")
    private String mixScene = "";

    @Option(names = {"-is", "--individual_scene"}, description = "recording, snapshot, recording_and_snapshot, recording_and_postpone_transcoding, recording_and_audio_mix")
    private String individualScene = "";

    @Option(names = {"-ws", "--web_scene"}, description = "web_recorder, web_recorder_and_rtmp_publish")
    private String webScene = "";

    public static void main(String[] args) {
        logger.info("Start cloud recording service");
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    private void loadEnv() {
        appId = System.getenv("APP_ID");
        cname = System.getenv("CNAME");
        uid = System.getenv("USER_ID");
        username = System.getenv("BASIC_AUTH_USERNAME");
        password = System.getenv("BASIC_AUTH_PASSWORD");
        token = System.getenv("TOKEN");
        storageConfig = StartResourceReq.StorageConfig.builder()
                .vendor(Integer.parseInt(System.getenv("STORAGE_CONFIG_VENDOR")))
                .region(Integer.parseInt(System.getenv("STORAGE_CONFIG_REGION")))
                .bucket(System.getenv("STORAGE_CONFIG_BUCKET"))
                .accessKey(System.getenv("STORAGE_CONFIG_ACCESS_KEY"))
                .secretKey(System.getenv("STORAGE_CONFIG_SECRET_KEY"))
                .build();
    }

    private void handleMixMode() {
        MixRecordingScenario mixScenario = new MixRecordingScenario(region, appId, cname, uid, new BasicAuthCredential(username, password));

        switch (mixScene) {
            case "hls":
                mixScenario.runHLS(token, storageConfig);
                break;
            case "hls_and_mp4":
                mixScenario.runHLSAndMP4(token, storageConfig);
                break;
            default:
                throw new IllegalArgumentException("invalid mix_scene:" + mixScene);
        }
    }

    private void handleIndividualMode() {
        IndividualRecordingScenario individualScenario = new IndividualRecordingScenario(region, appId, cname, uid, new BasicAuthCredential(username, password));

        switch (individualScene) {
            case "recording":
                individualScenario.runRecording(token, storageConfig);
                break;
            case "snapshot":
                individualScenario.runSnapshot(token, storageConfig);
                break;
            case "recording_and_snapshot":
                individualScenario.runRecordingAndSnapshot(token, storageConfig);
                break;
            case "recording_and_postpone_transcoding":
                individualScenario.runRecordingAndPostponeTranscoding(token, storageConfig);
                break;
            case "recording_and_audio_mix":
                individualScenario.runRecordingAndAudioMix(token, storageConfig);
                break;
            default:
                throw new IllegalArgumentException("invalid individual_scene: " + individualScene);
        }
    }

    private void handleWebMode() {
        WebRecordingScenario webScenario = new WebRecordingScenario(region, appId, cname, uid, new BasicAuthCredential(username, password));

        switch (webScene) {
            case "web_recorder":
                webScenario.runWebRecorder(storageConfig);
                break;
            case "web_recorder_and_rtmp_publish":
                webScenario.runWebRecorderAndRtmpPublish(storageConfig);
                break;
            default:
                throw new IllegalArgumentException("invalid web_scene: " + webScene);
        }
    }

    @Override
    public Integer call() throws Exception {
        loadEnv();

        logger.info("appId: {}, cname: {}, uid: {}, username: {}, password: {}, token: {}, region: {}, storageConfig: {}",
                appId, cname, uid, username, password, token, region, storageConfig);

        switch (mode) {
            case "mix":
                handleMixMode();
                break;
            case "individual":
                handleIndividualMode();
                break;
            case "web":
                handleWebMode();
                break;
            default:
                throw new IllegalArgumentException("Invalid mode: " + mode);
        }

        return 0;
    }
}
