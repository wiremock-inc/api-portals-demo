# openapi

<div align="left">
    <a href="https://speakeasyapi.dev/"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://opensource.org/licenses/MIT">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>


## 🏗 **Welcome to your new SDK!** 🏗

It has been generated successfully based on your OpenAPI spec. However, it is not yet ready for production use. Here are some next steps:
- [ ] 🛠 Make your SDK feel handcrafted by [customizing it](https://www.speakeasyapi.dev/docs/customize-sdks)
- [ ] ♻️ Refine your SDK quickly by iterating locally with the [Speakeasy CLI](https://github.com/speakeasy-api/speakeasy)
- [ ] 🎁 Publish your SDK to package managers by [configuring automatic publishing](https://www.speakeasyapi.dev/docs/advanced-setup/publish-sdks)
- [ ] ✨ When ready to productionize, delete this section from the README

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'io.wiremock.demos.simple_payments_sdk:openapi:0.0.2'
```

Maven:
```xml
<dependency>
    <groupId>io.wiremock.demos.simple_payments_sdk</groupId>
    <artifactId>openapi</artifactId>
    <version>0.0.2</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import io.wiremock.demos.simple_payments_sdk.SimplePaymentsSDK;
import io.wiremock.demos.simple_payments_sdk.models.components.*;
import io.wiremock.demos.simple_payments_sdk.models.operations.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            SimplePaymentsSDK sdk = SimplePaymentsSDK.builder()
                .build();

            GetCustomerByIdResponse res = sdk.getCustomerById()
                .customerId("881b07a4-f7e9-4d74-b643-05479128a5b6")
                .detail(Detail.SUMMARY)
                .call();

            if (res.object().isPresent()) {
                // handle response
            }
        } catch (io.wiremock.demos.simple_payments_sdk.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

### [SimplePaymentsSDK](docs/sdks/simplepaymentssdk/README.md)

* [getCustomerById](docs/sdks/simplepaymentssdk/README.md#getcustomerbyid) - Gets a customer by ID.
* [putCustomersByCustomerId](docs/sdks/simplepaymentssdk/README.md#putcustomersbycustomerid) - Put customers by customerId.
* [postCharges](docs/sdks/simplepaymentssdk/README.md#postcharges) - Create a new charge.
* [getChargesByChargeId](docs/sdks/simplepaymentssdk/README.md#getchargesbychargeid) - Get charges by chargeId.
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations.  All operations return a response object or raise an error.  If Error objects are specified in your OpenAPI Spec, the SDK will throw the appropriate Exception type.

| Error Object           | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4xx-5xx                | */*                    |

### Example

```java
package hello.world;

import io.wiremock.demos.simple_payments_sdk.SimplePaymentsSDK;
import io.wiremock.demos.simple_payments_sdk.models.components.*;
import io.wiremock.demos.simple_payments_sdk.models.operations.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            SimplePaymentsSDK sdk = SimplePaymentsSDK.builder()
                .build();

            GetCustomerByIdResponse res = sdk.getCustomerById()
                .customerId("881b07a4-f7e9-4d74-b643-05479128a5b6")
                .detail(Detail.SUMMARY)
                .call();

            if (res.object().isPresent()) {
                // handle response
            }
        } catch (io.wiremock.demos.simple_payments_sdk.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Select Server by Index

You can override the default server globally by passing a server index to the `serverIndex` builder method when initializing the SDK client instance. The selected server will then be used as the default on the operations that use it. This table lists the indexes associated with the available servers:

| # | Server | Variables |
| - | ------ | --------- |
| 0 | `https://simple-payments.wiremockapi.cloud` | None |

#### Example

```java
package hello.world;

import io.wiremock.demos.simple_payments_sdk.SimplePaymentsSDK;
import io.wiremock.demos.simple_payments_sdk.models.components.*;
import io.wiremock.demos.simple_payments_sdk.models.operations.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            SimplePaymentsSDK sdk = SimplePaymentsSDK.builder()
                .serverIndex(0)
                .build();

            GetCustomerByIdResponse res = sdk.getCustomerById()
                .customerId("881b07a4-f7e9-4d74-b643-05479128a5b6")
                .detail(Detail.SUMMARY)
                .call();

            if (res.object().isPresent()) {
                // handle response
            }
        } catch (io.wiremock.demos.simple_payments_sdk.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```


### Override Server URL Per-Client

The default server can also be overridden globally by passing a URL to the `serverURL` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import io.wiremock.demos.simple_payments_sdk.SimplePaymentsSDK;
import io.wiremock.demos.simple_payments_sdk.models.components.*;
import io.wiremock.demos.simple_payments_sdk.models.operations.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            SimplePaymentsSDK sdk = SimplePaymentsSDK.builder()
                .serverURL("https://simple-payments.wiremockapi.cloud")
                .build();

            GetCustomerByIdResponse res = sdk.getCustomerById()
                .customerId("881b07a4-f7e9-4d74-b643-05479128a5b6")
                .detail(Detail.SUMMARY)
                .call();

            if (res.object().isPresent()) {
                // handle response
            }
        } catch (io.wiremock.demos.simple_payments_sdk.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically.
Feel free to open a PR or a Github issue as a proof of concept and we'll do our best to include it in a future release!

### SDK Created by [Speakeasy](https://docs.speakeasyapi.dev/docs/using-speakeasy/client-sdks)
