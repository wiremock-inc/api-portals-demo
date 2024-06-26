/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package io.wiremock.demos.simple_payments_sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import io.wiremock.demos.simple_payments_sdk.utils.Utils;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Detail
 */
public enum Detail {
    FULL("full"),
    SUMMARY("summary");

    @JsonValue
    private final String value;

    private Detail(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
}
