package io.agora.rest.services.convoai;

/**
 * @brief ServiceRegion represents the region of the Conversational AI engine service
 * @note The service in Chinese mainland and the global region are two different services
 * @since 0.3.0
 */
public enum ConvoAIServiceRegionEnum {
    /**
     * The service region is in Chinese Mainland
     */
    CHINESE_MAINLAND,

    /**
     * The service region is in Global,except China Mainland
     */
    GLOBAL,
}
