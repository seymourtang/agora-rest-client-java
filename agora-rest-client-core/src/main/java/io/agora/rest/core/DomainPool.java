package io.agora.rest.core;

import io.agora.rest.exception.AgoraInvalidArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class DomainPool {

    private String currentDomain;

    private Instant lastUpdate;

    private final List<String> currentRegionPrefixes;

    private final List<String> domainSuffixes;

    private final List<String> regionPrefixes;

    private static final Duration updateDuration = Duration.ofSeconds(30);

    private final ReentrantLock locker = new ReentrantLock(true);

    private final DomainDNSResolver resolver;

    private final Logger logger = LoggerFactory.getLogger(DomainPool.class);

    public DomainPool(DomainArea domainArea) {
        if (domainArea == null || domainArea == DomainArea.Unknown) {
            throw new AgoraInvalidArgumentException("invalid domain area");
        }

        this.domainSuffixes = new ArrayList<>(domainArea.getMajorDomainSuffixes());
        this.resolver = new DefaultDomainDNSResolver();
        this.regionPrefixes = new ArrayList<>(domainArea.getRegionDomainPrefixes());
        this.currentRegionPrefixes = new ArrayList<>(domainArea.getRegionDomainPrefixes());
        this.currentDomain = domainArea.getMajorDomainSuffixes().get(0);

        this.lastUpdate = Instant.now();
    }

    private boolean domainNeedUpdate() {
        return Duration.between(lastUpdate, Instant.now()).compareTo(updateDuration) > 0;
    }

    public void selectBestDomain() {
        //  提前判断domain是否需要更新，避免多线程情况下重复获取锁
        if (!domainNeedUpdate()) {
            return;
        }
        if (!locker.tryLock()) {
            return;
        }

        try {
            if (domainNeedUpdate()) {
                logger.debug("Need to update domainPool");
                String bestDomain = resolver.resolve(domainSuffixes, currentRegionPrefixes.get(0)).block();
                if (bestDomain != null) {
                    logger.debug("Selected best domain: {}", bestDomain);
                    selectDomain(bestDomain);
                } else {
                    logger.warn("No suitable domain found, using current domain: {}", currentDomain);
                }
            }
        } finally {
            locker.unlock();
        }
    }

    public void nextRegion() {
        locker.lock();
        try {
            currentRegionPrefixes.remove(0);
            if (currentRegionPrefixes.isEmpty()) {
                currentRegionPrefixes.addAll(regionPrefixes);
            }
        } finally {
            locker.unlock();
        }
    }

    private void selectDomain(String domain) {
        if (domainSuffixes.contains(domain)) {
            currentDomain = domain;
            lastUpdate = Instant.now();
        }
    }

    public String getCurrentUrl() {
        locker.lock();
        try {
            return "https://" + currentRegionPrefixes.get(0) + "." + currentDomain;
        } finally {
            locker.unlock();
        }
    }

}
