/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package io.wiremock.demos.simple_payments_sdk;

import io.wiremock.demos.simple_payments_sdk.models.components.Security;

public interface SecuritySource {

    Security getSecurity();
    
    public static SecuritySource of(Security security) {
        return new DefaultSecuritySource(security);
    }

    public static class DefaultSecuritySource implements SecuritySource {
        private Security security;

        public DefaultSecuritySource(Security security) {
            this.security = security;
        }

        public Security getSecurity() {
            return security;
        }
    }
}
