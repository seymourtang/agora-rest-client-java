package io.agora.rest.services.convoai;

/**
 * @brief ServiceRegion represents the region of the Conversational AI engine service
 *
 * @note The service in mainland China and the global region are two different services
 *
 * @since 0.3.0
 */
public enum ConvoAIServiceRegionEnum {
    /**
     * The service region is in China Mainland
     */
    ChinaMainland,

    /**
     * The service region is in Global,except China Mainland
     */
    Global,
}
