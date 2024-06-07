<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import io.wiremock.demos.simple_payments_sdk.SimplePaymentsSDK;
import io.wiremock.demos.simple_payments_sdk.models.components.*;
import io.wiremock.demos.simple_payments_sdk.models.operations.*;
import io.wiremock.demos.simple_payments_sdk.utils.EventStream;
import java.math.BigDecimal;
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