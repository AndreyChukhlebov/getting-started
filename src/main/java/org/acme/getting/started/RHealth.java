package org.acme.getting.started;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Readiness
@ApplicationScoped
public class RHealth implements HealthCheck {

    private static final Logger logger = LoggerFactory.getLogger(RHealth.class);

    @Inject
    private Config config;


    @Override
    public HealthCheckResponse call() {
        if (config.healthReadiness()) {
            logger.error("R-UP");
            return HealthCheckResponse.up("I'm alive");
        } else {
            logger.error("R-DOWN");
            return HealthCheckResponse.down("I'm not alive");
        }
    }
}
