package io.agora.rest.examples.convoai;

import io.agora.rest.core.DomainArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "Main", mixinStandardHelpOptions = true, version = "0.1.0",
        description = "Agora Conversational AI Service")
public class Main implements Callable<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private String appId;

    private String username;

    private String password;

    private final DomainArea region = DomainArea.CN;


    @Option(names = {"-t", "--ttsVendor"}, description = "bytedance,microsoft,tencent,minimax,elevenlabs")
    private String ttsVendor = "";

    public static void main(String[] args) {
        logger.info("Start conversational ai service");
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    private void loadEnv() {
        appId = System.getenv("APP_ID");
        username = System.getenv("BASIC_AUTH_USERNAME");
        password = System.getenv("BASIC_AUTH_PASSWORD");
    }


    @Override
    public Integer call() throws Exception {
        loadEnv();

        logger.info("appId: {}, username: {}, password: {}, region: {}, ttsVendor: {}",
                appId, username, password, region, ttsVendor);

        switch (ttsVendor) {
            case "bytedance":
                break;
            case "microsoft":
                break;
            case "tencent":
                break;
            case "minimax":
                break;
            case "elevenlabs":
                break;
            default:
                throw new IllegalArgumentException("Invalid ttsVendor: " + ttsVendor);
        }

        return 0;
    }
}
