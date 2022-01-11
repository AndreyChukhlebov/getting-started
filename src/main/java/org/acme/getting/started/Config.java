package org.acme.getting.started;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "app")
public interface Config {
    String param1();
    String param2();
    boolean healthLiveness();
    boolean healthReadiness();
}
