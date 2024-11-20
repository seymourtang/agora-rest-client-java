package io.agora.rest.core;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DomainDNSResolverTest {

    private static final Logger logger = LoggerFactory.getLogger(DomainDNSResolverTest.class);

    @Test
    public void testDomainDNSResolver() {
        DomainDNSResolver resolver = new DefaultDomainDNSResolver();
        assertNotNull(resolver);

        String domain = resolver.resolve(Arrays.asList("agora.io", "sd-rtn.com"),
                RegionArea.CNRegionArea.getRegionDomainPrefixes().get(0)).block();

        logger.info("Domain: {}", domain);
        assertNotNull(domain);
    }
}