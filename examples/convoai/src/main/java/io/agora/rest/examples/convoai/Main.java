package io.agora.rest.examples.convoai;

import io.agora.rest.core.BasicAuthCredential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.examples.convoai.service.Service;
import io.agora.rest.services.convoai.ConvoAIServiceRegionEnum;
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

    private final DomainArea domainArea = DomainArea.CN;


    @Option(names = {"-t", "--ttsVendor"}, description = "bytedance,microsoft,tencent,minimax,elevenlabs")
    private String ttsVendor = "";

    @Option(names = {"-s", "--serviceRegion"}, description = "chineseMainland,global")
    private String serviceRegion;

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

        logger.info("appId: {}, username: {}, password: {}, region: {}, ttsVendor: {}, serviceRegion: {}",
                appId, username, password, domainArea, ttsVendor, serviceRegion);

        if (serviceRegion==null) {
            throw new IllegalArgumentException("serviceRegion is required");
        }

        ConvoAIServiceRegionEnum convoAIServiceRegionEnum;

        if(serviceRegion.equals("chineseMainland")){
            convoAIServiceRegionEnum = ConvoAIServiceRegionEnum.ChinaMainland;
        }
        else if(serviceRegion.equals("global")){
            convoAIServiceRegionEnum = ConvoAIServiceRegionEnum.Global;
        }
        else{
            throw new IllegalArgumentException("Invalid serviceRegion: " + serviceRegion);
        }

        Service svc =new Service(domainArea, appId, username, password, new BasicAuthCredential(username, password),  convoAIServiceRegionEnum);
        switch (ttsVendor) {
            case "bytedance":
                if(convoAIServiceRegionEnum!=ConvoAIServiceRegionEnum.ChinaMainland){
                    throw new IllegalArgumentException("Bytedance TTS is only available in China Mainland");
                }

                svc.runBytedanceTTS();
                break;
            case "microsoft":
                if (convoAIServiceRegionEnum != ConvoAIServiceRegionEnum.Global) {
                    throw new IllegalArgumentException("Microsoft TTS is only available in Global");
                }
                svc.runMicrosoftTTS();
                break;
            case "tencent":
                if (convoAIServiceRegionEnum != ConvoAIServiceRegionEnum.ChinaMainland) {
                    throw new IllegalArgumentException("Tencent TTS is only available in China Mainland");
                }
                svc.runTencentTTS();
                break;
            case "minimax":
                if (convoAIServiceRegionEnum != ConvoAIServiceRegionEnum.ChinaMainland) {
                    throw new IllegalArgumentException("Minimax TTS is only available in China Mainland");
                }
                svc.runMinimaxTTS();
                break;
            case "elevenlabs":
                if (convoAIServiceRegionEnum != ConvoAIServiceRegionEnum.Global) {
                    throw new IllegalArgumentException("Elevenlabs TTS is only available in Global");
                }
                svc.runElevenlabsTTS();
                break;
            default:
                throw new IllegalArgumentException("Invalid ttsVendor: " + ttsVendor);
        }

        return 0;
    }
}
