package io.agora.rest.services.convoai;

/**
 * @brief ServiceRegion represents the region of the Conversational AI engine service
 * @note The service in Chinese mainland and the global region are two different services
 * @since v0.3.0
 */
public enum ConvoAIServiceRegionEnum {
    /**
     * CHINESE_MAINLAND represents the Conversational AI engine service in Chinese mainland
     */
    CHINESE_MAINLAND,

    /**
     * GLOBAL represents the Conversational AI engine service in the global region, except Chinese mainland
     */
    GLOBAL,
}
