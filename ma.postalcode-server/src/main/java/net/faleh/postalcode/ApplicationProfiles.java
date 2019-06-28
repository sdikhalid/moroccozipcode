package net.faleh.postalcode;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.core.env.Environment;

public interface ApplicationProfiles {

    String PRODUCTION = "PRODUCTION";

    String NO_LIQUIBASE = "noLiquibase";

    String LIQUIBASE = "!" + NO_LIQUIBASE;

    static boolean isNotProduction(Environment environment) {
        return !isProduction(environment);
    }

    static boolean isProduction(Environment environment) {
        checkEnvironmentIsPresent(environment);
        return Arrays.asList(environment.getActiveProfiles()).contains(ApplicationProfiles.PRODUCTION);
    }

    static boolean isLiquibase(Environment environment) {
        checkEnvironmentIsPresent(environment);
        return !Arrays.asList(environment.getActiveProfiles()).contains(ApplicationProfiles.NO_LIQUIBASE);
    }


    static void checkEnvironmentIsPresent(Environment environment) {
        Objects.requireNonNull(environment, "cannot determine application profile given null environment");
    }
}
