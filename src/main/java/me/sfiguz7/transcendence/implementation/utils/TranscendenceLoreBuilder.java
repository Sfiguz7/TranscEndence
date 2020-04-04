package me.sfiguz7.transcendence.implementation.utils;

import me.sfiguz7.transcendence.implementation.core.attributes.Instability;

public final class TranscendenceLoreBuilder {

    private TranscendenceLoreBuilder() {}

    public static String unstable(Instability instability) {
        return instability.getLore();
    }

}
