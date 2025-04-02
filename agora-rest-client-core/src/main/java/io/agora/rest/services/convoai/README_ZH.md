# 对话式 AI 引擎服务

 [English](./README.md) | 简体中文

## 服务概述

声网对话式 AI 引擎重新定义了人机交互界面，突破了传统文字交互，实现了高拟真、自然流畅的实时语音对话，让 AI 真正“开口说话”。适用于智能助手、情感陪伴、口语陪练、智能客服、智能硬件、沉浸式游戏 NPC 等创新场景。

## 环境准备

- 获取声网App ID -------- [声网Agora - 文档中心 - 如何获取 App ID](https://docs.agora.io/cn/Agora%20Platform/get_appid_token?platform=All%20Platforms#%E8%8E%B7%E5%8F%96-app-id)

  > - 点击创建应用
  >
  >   ![](../../../../../../../../../assets/imges/CN/create_app_1.png)
  >
  > - 选择你要创建的应用类型
  >
  >   ![](../../../../../../../../../assets/imges/CN/create_app_2.png)

- 获取App 证书 ----- [声网Agora - 文档中心 - 获取 App 证书](https://docs.agora.io/cn/Agora%20Platform/get_appid_token?platform=All%20Platforms#%E8%8E%B7%E5%8F%96-app-%E8%AF%81%E4%B9%A6)

  > 在声网控制台的项目管理页面，找到你的项目，点击配置。
  > ![](../../../../../../../../../assets/imges/CN/config_app.png)
  > 点击主要证书下面的复制图标，即可获取项目的 App 证书。
  > ![](../../../../../../../../../assets/imges/CN/copy_app_cert.png)

- 启用会话式AI引擎服务 ----- [启用服务](https://doc.shengwang.cn/doc/convoai/restful/get-started/enable-service)
  > ![](../../../../../../../../../assets/imges/CN/open_convo_ai.png)

## API定义

更多API详情，请参考 [API文档](https://doc.shengwang.cn/api-ref/convoai/java/java-api/overview)

## API调用示例

### 初始化会话式AI引擎客户端

```java
    public static final String APP_ID = "<your appId>";
    public static final String CNAME = "<your cname>";
    public static final String USERNAME = "<the username of basic auth credential>";
    public static final String PASSWORD = "<the password of basic auth credential>";

	Credential credential = new BasicAuthCredential(USERNAME, PASSWORD);
        ConvoAIConfig config = ConvoAIConfig.builder().
                appId(APP_ID).
                credential(credential).
                // Specify the region where the server is located. Options include CN, EU, AP, US.
                // The client will automatically switch to use the best domain based on the configured region.
                domainArea(DomainArea.CN).
                // Specify the service region. Options include ChineseMainlandServiceRegion, GlobalServiceRegion.
                // ChineseMainlandServiceRegion and GlobalServiceRegion are two different services.
                serverRegion(ConvoAIServiceRegionEnum.CHINESE_MAINLAND).
                build();

    ConvoAIClient convoAIClient = ConvoAIClient.create(config);
```

### 创建对话式智能体
>
> 创建对话式 AI 智能体实例并加入RTC频道。

需要设置的参数：LLM、TTS和代理相关参数。

调用`join`方法创建会话代理，以使用字节跳动TTS为例：

```java
    public static final String AGENT_RTC_UID = "<your agent rtc uid>";
    public static final String AGENT_RTC_TOKEN = "<your agent rtc token>";

    public static final String LLM_URL = "<your llm url>";
    public static final String LLM_API_KEY = "<your llm api key>";
    public static final String LLM_MODEL = "<your llm model>";

    public static final String TTS_BYTEDANCE_TOKEN = "<your bytedance tts token>";
    public static final String TTS_BYTEDANCE_APP_ID = "<your bytedance tts app id>";
    public static final String TTS_BYTEDANCE_CLUSTER = "<your bytedance tts cluster>";
    public static final String TTS_BYTEDANCE_VOICE_TYPE = "<your bytedance tts voice type>";

	// Start agent
    String name = APP_ID + ":" + CNAME;

    JoinConvoAIRes joinConvoAIRes;
    try {
        joinConvoAIRes = convoAIClient.join(JoinConvoAIReq.builder()
                    .name(name)
                    .properties(JoinConvoAIReq.Properties.builder()
                            .token(AGENT_RTC_TOKEN)
                            .channel(CNAME)
                            .agentRtcUId(AGENT_RTC_UID)
                            .remoteRtcUIds(new ArrayList<String>() {
                                {
                                    add("*");
                                }
                            })
                            .enableStringUId(false)
                            .idleTimeout(120)
                            .advancedFeatures(JoinConvoAIReq.AdvancedFeatures.builder()
                                    .enableAIVad(true)
                                    .build())
                            .llmPayload(JoinConvoAIReq.LLMPayload.builder()
                                    .url(LLM_URL)
                                    .apiKey(LLM_API_KEY)
                                    .params(new HashMap<String, Object>() {
                                        {
                                            put("model", LLM_MODEL);
                                            put("max_tokens", 1024);
                                            put("username", "Jack");
                                        }
                                    })
                                    .systemMessages(new ArrayList<Map<String, Object>>() {
                                        {
                                            add(new HashMap<String, Object>() {
                                                {
                                                    put("content", "You are a helpful chatbot。");
                                                    put("role", "system");
                                                }
                                            });
                                        }
                                    })
                                    .maxHistory(30)
                                    .greetingMessage("Hello,how can I help you?")
                                    .build())
                            .ttsPayload(JoinConvoAIReq.TTSPayload.builder()
                                    .vendor(JoinConvoAIReq.TTSVendorEnum.BYTEDANCE)
                                    .params(JoinConvoAIReq.BytedanceTTSVendorParams.builder().
                                            token(TTS_BYTEDANCE_TOKEN).
                                            cluster(TTS_BYTEDANCE_CLUSTER).
                                            voiceType(TTS_BYTEDANCE_VOICE_TYPE).
                                            appId(TTS_BYTEDANCE_APP_ID).
                                            speedRatio(1.0F).
                                            volumeRatio(1.0F).
                                            pitchRatio(1.0F).
                                            emotion("happy").
                                            build())
                                    .build())
                            .vadPayload(JoinConvoAIReq.VADPayload.builder()
                                    .interruptDurationMs(160)
                                    .prefixPaddingMs(300)
                                    .silenceDurationMs(480)
                                    .threshold(0.5F)
                                    .build())
                            .asrPayload(JoinConvoAIReq.ASRPayload.builder()
                                    .language("zh-CN")
                                    .build())
                            .build())
                    .build()).block();
        } catch (AgoraException e) {
            logger.error("Failed to start the agent,err:{}", e.getMessage());
            return;
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
            return;
        }

    if (joinConvoAIRes == null) {
        System.out.println("Failed to start the agent");
        return;
    }

    logger.info("Start the agent successfully, joinConvoAIRes:{}", joinConvoAIRes);

```

### 停止对话式智能体

> 停止对话式智能体并离开RTC频道。

需要设置的参数：
- `join`接口返回的AgentId

```java
 // Stop the agent
    try {
        convoAIClient.leave(agentId).block();
        logger.info("Leave the agent successfully, agentId:{}", agentId);
    } catch (AgoraException e) {
        logger.error("Failed to leave the agent,err:{}", e.getMessage());
    } catch (Exception e) {
        logger.error("Unknown exception,err:{}", e.getMessage());
    }
```

### 更新智能体配置

> 目前只能更新正在运行的智能体的Token信息。

需要设置的参数：
- `join`接口返回的AgentId
- 要更新的Token

```java
    // Update agent
    UpdateConvoAIRes updateConvoAIRes;

    try {
        updateConvoAIRes = this.convoAIClient.update(agentId, UpdateConvoAIReq.builder()
                .token(updateToken).build()).block();
    } catch (AgoraException e) {
        logger.error("Failed to update the agent,err:{}", e.getMessage());
        return;
    } catch (Exception e) {
        logger.error("Unknown exception,err:{}", e.getMessage());
        return;
    }

    logger.info("Update the agent successfully, updateConvoAIRes:{}", updateConvoAIRes);
```

### 查询智能体状态

> 查询智能体的状态。

需要设置的参数：
- `join`接口返回的AgentId

```java
    // Query agent
    QueryConvoAIRes queryConvoAIRes;
    try {
        queryConvoAIRes = this.convoAIClient.query(agentId).block();
    } catch (AgoraException e) {
        logger.error("Failed to query the agent,err:{}", e.getMessage());
        return;
    } catch (Exception e) {
        logger.error("Unknown exception,err:{}", e.getMessage());
        return;
    }

    if (queryConvoAIRes == null) {
        logger.error("Failed to query the agent");
        return;
    }

    logger.info("Query the agent successfully, queryConvoAIRes:{}", queryConvoAIRes);
```


## 检索智能体列表
> 按照条件检索智能体列表。

需要设置的参数：
- `join`接口返回的AgentId

```java
     // List agent
    ListConvoAIRes listConvoAIRes;
     try {
         listConvoAIRes = this.convoAIClient.list(ListConvoAIReq.builder()
                 .channel(channel)
                 .state(2)
                 .build()).block();
     } catch (AgoraException e) {
         logger.error("Failed to list the agent,err:{}", e.getMessage());
         return;
     } catch (Exception e) {
         logger.error("Unknown exception,err:{}", e.getMessage());
         return;
     }

     if (listConvoAIRes == null) {
         logger.error("Failed to list the agent");
         return;
     }

     logger.info("List the agent successfully, listConvoAIRes:{}", listConvoAIRes);
```

## 错误代码和响应状态代码处理
有关具体的业务响应代码，请参考 [业务响应代码](https://doc.shengwang.cn/doc/convoai/restful/api/response-code) 文档。
