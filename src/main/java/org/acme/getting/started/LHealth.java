package org.acme.getting.started;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Liveness
@ApplicationScoped
public class LHealth implements HealthCheck {

    private static final Logger logger = LoggerFactory.getLogger(LHealth.class);

    @Inject
    private Config config;

    @Override
    public HealthCheckResponse call() {
        if (config.healthLiveness()) {
            logger.error("L-UP");
            return HealthCheckResponse.up("I'm alive");
        } else {
            logger.error("L-DOWN");
            return HealthCheckResponse.down("I'm not alive");
        }
    }
}
