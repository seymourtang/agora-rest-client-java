package io.agora.rest.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @brief DomainArea represents the global regions where the Open API gateway endpoint is located
 * @note Choose the appropriate area based on your service deployment region.
 * @since v0.3.0
 */
public enum DomainArea {
    /**
     * US represents the western and eastern regions of the United States
     */
    US(
            Arrays.asList("api-us-west-1", "api-us-east-1"),
            Arrays.asList("agora.io", "sd-rtn.com")),

    /**
     * EU represents the western and central regions of Europe
     */
    EU(
            Arrays.asList("api-eu-west-1", "api-eu-central-1"),
            Arrays.asList("agora.io", "sd-rtn.com")),

    /**
     * AP represents the southeastern and northeastern regions of Asia-Pacific
     */
    AP(
            Arrays.asList("api-ap-southeast-1", "api-ap-northeast-1"),
            Arrays.asList("agora.io", "sd-rtn.com")),

    /**
     * CN represents the eastern and northern regions of Chinese mainland
     */
    CN(
            Arrays.asList("api-cn-east-1", "api-cn-north-1"),
            Arrays.asList("sd-rtn.com", "agora.io"));

    private final List<String> regionDomainPrefixes;

    private final List<String> majorDomainSuffixes;

    DomainArea(List<String> regionDomainPrefixes, List<String> majorDomainSuffixes) {
        this.regionDomainPrefixes = Collections.unmodifiableList(regionDomainPrefixes);
        this.majorDomainSuffixes = Collections.unmodifiableList(majorDomainSuffixes);
    }

    public List<String> getRegionDomainPrefixes() {
        return regionDomainPrefixes;
    }

    public List<String> getMajorDomainSuffixes() {
        return majorDomainSuffixes;
    }
}
