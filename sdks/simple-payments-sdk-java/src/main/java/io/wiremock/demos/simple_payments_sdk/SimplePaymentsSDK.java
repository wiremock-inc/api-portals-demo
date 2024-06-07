/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package io.wiremock.demos.simple_payments_sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.wiremock.demos.simple_payments_sdk.models.errors.SDKError;
import io.wiremock.demos.simple_payments_sdk.models.operations.SDKMethodInterfaces.*;
import io.wiremock.demos.simple_payments_sdk.utils.HTTPClient;
import io.wiremock.demos.simple_payments_sdk.utils.HTTPRequest;
import io.wiremock.demos.simple_payments_sdk.utils.Hook.AfterErrorContextImpl;
import io.wiremock.demos.simple_payments_sdk.utils.Hook.AfterSuccessContextImpl;
import io.wiremock.demos.simple_payments_sdk.utils.Hook.BeforeRequestContextImpl;
import io.wiremock.demos.simple_payments_sdk.utils.JSON;
import io.wiremock.demos.simple_payments_sdk.utils.Retries.NonRetryableException;
import io.wiremock.demos.simple_payments_sdk.utils.RetryConfig;
import io.wiremock.demos.simple_payments_sdk.utils.SerializedBody;
import io.wiremock.demos.simple_payments_sdk.utils.SpeakeasyHTTPClient;
import io.wiremock.demos.simple_payments_sdk.utils.Utils;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.apache.http.NameValuePair;
import org.openapitools.jackson.nullable.JsonNullable;

public class SimplePaymentsSDK implements
            MethodCallGetCustomerById,
            MethodCallPutCustomersByCustomerId,
            MethodCallPostCharges,
            MethodCallGetChargesByChargeId {


    /**
     * SERVERS contains the list of server urls available to the SDK.
     */
    public static final String[] SERVERS = {
        "https://simple-payments.wiremockapi.cloud",
    };

    private final SDKConfiguration sdkConfiguration;

    /**
     * The Builder class allows the configuration of a new instance of the SDK.
     */
    public static class Builder {

        private final SDKConfiguration sdkConfiguration = new SDKConfiguration();

        private Builder() {
        }

        /**
         * Allows the default HTTP client to be overridden with a custom implementation.
         *
         * @param client The HTTP client to use for all requests.
         * @return The builder instance.
         */
        public Builder client(HTTPClient client) {
            this.sdkConfiguration.defaultClient = client;
            return this;
        }
        
        /**
         * Overrides the default server URL.
         *
         * @param serverUrl The server URL to use for all requests.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl) {
            this.sdkConfiguration.serverUrl = serverUrl;
            return this;
        }

        /**
         * Overrides the default server URL  with a templated URL populated with the provided parameters.
         *
         * @param serverUrl The server URL to use for all requests.
         * @param params The parameters to use when templating the URL.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl, java.util.Map<String, String> params) {
            this.sdkConfiguration.serverUrl = io.wiremock.demos.simple_payments_sdk.utils.Utils.templateUrl(serverUrl, params);
            return this;
        }
        
        /**
         * Overrides the default server by index.
         *
         * @param serverIdx The server to use for all requests.
         * @return The builder instance.
         */
        public Builder serverIndex(int serverIdx) {
            this.sdkConfiguration.serverIdx = serverIdx;
            this.sdkConfiguration.serverUrl = SERVERS[serverIdx];
            return this;
        }
        
        /**
         * Overrides the default configuration for retries
         *
         * @param retryConfig The retry configuration to use for all requests.
         * @return The builder instance.
         */
        public Builder retryConfig(RetryConfig retryConfig) {
            this.sdkConfiguration.retryConfig = Optional.of(retryConfig);
            return this;
        }
        /**
         * Builds a new instance of the SDK.
         * @return The SDK instance.
         */
        public SimplePaymentsSDK build() {
            if (sdkConfiguration.defaultClient == null) {
                sdkConfiguration.defaultClient = new SpeakeasyHTTPClient();
            }
            if (sdkConfiguration.serverUrl == null || sdkConfiguration.serverUrl.isBlank()) {
                sdkConfiguration.serverUrl = SERVERS[0];
                sdkConfiguration.serverIdx = 0;
            }
            if (sdkConfiguration.serverUrl.endsWith("/")) {
                sdkConfiguration.serverUrl = sdkConfiguration.serverUrl.substring(0, sdkConfiguration.serverUrl.length() - 1);
            }
            return new SimplePaymentsSDK(sdkConfiguration);
        }
    }
    
    /**
     * Get a new instance of the SDK builder to configure a new instance of the SDK.
     * @return The SDK builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    private SimplePaymentsSDK(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.sdkConfiguration.initialize();
    }
    /**
     * Gets a customer by ID.
     * @return The call builder
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdRequestBuilder getCustomerById() {
        return new io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdRequestBuilder(this);
    }

    /**
     * Gets a customer by ID.
     * @param customerId
     * @param detail
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdResponse getCustomerById(
            String customerId,
            io.wiremock.demos.simple_payments_sdk.models.operations.Detail detail) throws Exception {
        io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdRequest request =
            io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdRequest
                .builder()
                .customerId(customerId)
                .detail(detail)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdRequest.class,
                _baseUrl,
                "/customers/{customerId}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        _req.addQueryParams(Utils.getQueryParams(
                io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdRequest.class,
                request, 
                null));

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("getCustomerById", sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("getCustomerById", sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("getCustomerById", sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("getCustomerById", sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdResponse.Builder _resBuilder = 
            io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdResponseBody>() {});
                _res.withObject(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }

    /**
     * Updates a customer by customerId.
     * @return The call builder
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdRequestBuilder putCustomersByCustomerId() {
        return new io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdRequestBuilder(this);
    }

    /**
     * Updates a customer by customerId.
     * @param customerId
     * @param detail
     * @param requestBody
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdResponse putCustomersByCustomerId(
            String customerId,
            io.wiremock.demos.simple_payments_sdk.models.operations.QueryParamDetail detail,
            io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdRequestBody requestBody) throws Exception {
        io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdRequest request =
            io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdRequest
                .builder()
                .customerId(customerId)
                .detail(detail)
                .requestBody(requestBody)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdRequest.class,
                _baseUrl,
                "/customers/{customerId}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "PUT");
        Object _convertedRequest = Utils.convertToShape(request, Utils.JsonShape.DEFAULT,
            new TypeReference<java.lang.Object>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, "requestBody", "json", false);
        if (_serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
        _req.setBody(Optional.ofNullable(_serializedRequestBody));
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        _req.addQueryParams(Utils.getQueryParams(
                io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdRequest.class,
                request, 
                null));

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("putCustomersByCustomerId", sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("putCustomersByCustomerId", sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("putCustomersByCustomerId", sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("putCustomersByCustomerId", sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdResponse.Builder _resBuilder = 
            io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<io.wiremock.demos.simple_payments_sdk.models.operations.PutCustomersByCustomerIdResponseBody>() {});
                _res.withObject(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }

    /**
     * Create a new charge.
     * @return The call builder
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesRequestBuilder postCharges() {
        return new io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesRequestBuilder(this);
    }

    /**
     * Create a new charge.
     * @param request The request object containing all of the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesResponse postCharges(
            io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesRequestBody request) throws Exception {
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                _baseUrl,
                "/charges");
        
        HTTPRequest _req = new HTTPRequest(_url, "POST");
        Object _convertedRequest = Utils.convertToShape(request, Utils.JsonShape.DEFAULT,
            new TypeReference<io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesRequestBody>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, "request", "json", false);
        if (_serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
        _req.setBody(Optional.ofNullable(_serializedRequestBody));
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("postCharges", sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("postCharges", sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("postCharges", sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("postCharges", sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesResponse.Builder _resBuilder = 
            io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesResponseBody>() {});
                _res.withObject(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }

    /**
     * Get charges by chargeId.
     * @return The call builder
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdRequestBuilder getChargesByChargeId() {
        return new io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdRequestBuilder(this);
    }

    /**
     * Get charges by chargeId.
     * @param chargeId
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdResponse getChargesByChargeId(
            String chargeId) throws Exception {
        io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdRequest request =
            io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdRequest
                .builder()
                .chargeId(chargeId)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdRequest.class,
                _baseUrl,
                "/charges/{chargeId}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("getChargesByChargeId", sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("getChargesByChargeId", sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("getChargesByChargeId", sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("getChargesByChargeId", sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdResponse.Builder _resBuilder = 
            io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<io.wiremock.demos.simple_payments_sdk.models.operations.GetChargesByChargeIdResponseBody>() {});
                _res.withObject(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }
}
