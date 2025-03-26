# 对话式 AI 引擎服务

 [English](./README.md) |  简体中文

> 这是一个对话式 AI 引擎的示例项目，利用对话式 AI 引擎 API 实现对话式 AI 功能。

## 前提条件

设置环境变量。基本环境变量包括：

```bash
export APP_ID=<Your App ID>
export BASIC_AUTH_USERNAME=<您的基本认证用户名>
export BASIC_AUTH_PASSWORD=<您的基本认证密码>
export CONVOAI_TOKEN=<您的代理令牌>
export CONVOAI_CHANNEL=<您的频道名称>
export CONVOAI_AGENT_RTC_UID=<您的代理 RTC UID>
```

您可以在 [对话式 AI 服务文档](../../agora-rest-client-core/src/main/java/io/agora/rest/services/convoai/README_ZH.md) 中找到相关参数。

选择不同的 TTS 提供商时，需要配置额外的环境变量。目前支持的 TTS 提供商有：

### bytedance

```bash
export CONVOAI_TTS_BYTEDANCE_TOKEN=<Your ttsPayload bytedance token>
export CONVOAI_TTS_BYTEDANCE_APP_ID=<Your ttsPayload bytedance app id>
export CONVOAI_TTS_BYTEDANCE_CLUSTER=<Your ttsPayload bytedance cluster>
export CONVOAI_TTS_BYTEDANCE_VOICE_TYPE=<Your ttsPayload bytedance voice type>
```

### tencent

```bash
export CONVOAI_TTS_TENCENT_APP_ID=<Your ttsPayload tencent app id>
export CONVOAI_TTS_TENCENT_SECRET_ID=<Your ttsPayload tencent secret id>
export CONVOAI_TTS_TENCENT_SECRET_KEY=<Your ttsPayload tencent secret key>
```

### minimax

```bash
export CONVOAI_TTS_MINIMAX_GROUP_ID=<Your ttsPayload minimax group id>
export CONVOAI_TTS_MINIMAX_GROUP_KEY=<Your ttsPayload minimax group key>
export CONVOAI_TTS_MINIMAX_GROUP_MODEL=<Your ttsPayload minimax group model>
```

### microsoft

```bash
export CONVOAI_TTS_MICROSOFT_KEY=<Your ttsPayload microsoft key>
export CONVOAI_TTS_MICROSOFT_REGION=<Your ttsPayload microsoft region>
export CONVOAI_TTS_MICROSOFT_VOICE_NAME=<Your ttsPayload microsoft voice name>
```

### elevenLabs

```bash
export CONVOAI_TTS_ELEVENLABS_API_KEY=<Your ttsPayload elevenLabs api key>
export CONVOAI_TTS_ELEVENLABS_MODEL_ID=<Your ttsPayload elevenLabs model id>
export CONVOAI_TTS_ELEVENLABS_VOICE_ID=<Your ttsPayload elevenLabs voice id>
```

## 执行

请确保在主模块目录已经执行了模块安装操作：

```bash
make install
```

接着，在当前模块下，通过分别执行下面的命令来体验不同场景的`Convo AI`示例：

```bash
mvn exec:java -Dexec.mainClass="io.agora.rest.examples.convoai.Main" -Dexec.args="--ttsVendor=<ttsVendor> --serviceRegion=<serviceRegion>"
```

`ttsVendor` 代表不同的 TTS 提供商。根据您的需求选择合适的 TTS 提供商。
`serviceRegion` 代表选择的服务区域。目前支持的服务区域有：
* `chineseMainland`
* `global`

