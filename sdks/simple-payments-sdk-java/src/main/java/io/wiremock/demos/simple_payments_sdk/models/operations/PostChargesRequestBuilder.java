/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package io.wiremock.demos.simple_payments_sdk.models.operations;

import com.fasterxml.jackson.core.type.TypeReference;
import io.wiremock.demos.simple_payments_sdk.models.errors.SDKError;
import io.wiremock.demos.simple_payments_sdk.utils.LazySingletonValue;
import io.wiremock.demos.simple_payments_sdk.utils.Utils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Stream;
import org.openapitools.jackson.nullable.JsonNullable;


public class PostChargesRequestBuilder {

    private PostChargesRequestBody request;
    private final SDKMethodInterfaces.MethodCallPostCharges sdk;

    public PostChargesRequestBuilder(SDKMethodInterfaces.MethodCallPostCharges sdk) {
        this.sdk = sdk;
    }

    public PostChargesRequestBuilder request(PostChargesRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public PostChargesResponse call() throws Exception {

        return sdk.postCharges(
            request);
    }
}
