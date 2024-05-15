# SimplePaymentsSDK


## Overview

### Available Operations

* [getCustomerById](#getcustomerbyid) - Gets a customer by ID.
* [postCharges](#postcharges) - Create a new charge.

## getCustomerById

Gets a customer by ID.

### Example Usage

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
                .id(531540L)
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

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `id`                                                                                                | *long*                                                                                              | :heavy_check_mark:                                                                                  | N/A                                                                                                 |
| `detail`                                                                                            | [io.wiremock.demos.simple_payments_sdk.models.operations.Detail](../../models/operations/Detail.md) | :heavy_check_mark:                                                                                  | N/A                                                                                                 |


### Response

**[Optional<? extends io.wiremock.demos.simple_payments_sdk.models.operations.GetCustomerByIdResponse>](../../models/operations/GetCustomerByIdResponse.md)**
### Errors

| Error Object           | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4xx-5xx                | */*                    |

## postCharges

Create a new charge.

### Example Usage

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

            PostChargesRequestBody req = PostChargesRequestBody.builder()
                .amount(350)
                .currency("gbp")
                .customerId("5931ed73-dcd4-4e24-ad24-975ac288fa7f")
                .build();

            PostChargesResponse res = sdk.postCharges()
                .request(req)
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

### Parameters

| Parameter                                                                                                                           | Type                                                                                                                                | Required                                                                                                                            | Description                                                                                                                         |
| ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                           | [io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesRequestBody](../../models/operations/PostChargesRequestBody.md) | :heavy_check_mark:                                                                                                                  | The request object to use for the request.                                                                                          |


### Response

**[Optional<? extends io.wiremock.demos.simple_payments_sdk.models.operations.PostChargesResponse>](../../models/operations/PostChargesResponse.md)**
### Errors

| Error Object           | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4xx-5xx                | */*                    |
