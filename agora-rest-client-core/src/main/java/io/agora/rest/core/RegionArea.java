package io.agora.rest.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum RegionArea {
    /**
     * Unknown region area
     */
    UnkonwnRegionArea(Collections.emptyList(), Collections.emptyList()),

    /**
     * US region area
     */
    USRegionArea(
            Arrays.asList("api-us-west-1", "api-us-east-1"),
            Arrays.asList("agora.io", "sd-rtn.com")),

    /**
     * EU region area
     */
    EURegionArea(
            Arrays.asList("api-eu-west-1", "api-eu-central-1"),
            Arrays.asList("agora.io", "sd-rtn.com")),

    /**
     * AP region area
     */
    APRegionArea(
            Arrays.asList("api-ap-southeast-1", "api-ap-northeast-1"),
            Arrays.asList("agora.io", "sd-rtn.com")),

    /**
     * CN region area
     */
    CNRegionArea(
            Arrays.asList("api-cn-east-1", "api-cn-north-1"),
            Arrays.asList("sd-rtn.com", "agora.io"));

    private final List<String> regionDomainPrefixes;

    private final List<String> majorDomainSuffixes;

    RegionArea(List<String> regionDomainPrefixes, List<String> majorDomainSuffixes) {
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
