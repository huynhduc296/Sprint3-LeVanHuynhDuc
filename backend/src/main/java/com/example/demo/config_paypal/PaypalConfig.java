//package com.example.demo.config_paypal;
//
//
//import com.paypal.base.rest.APIContext;
//import com.paypal.base.rest.OAuthTokenCredential;
//import com.paypal.base.rest.PayPalRESTException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Configuration
//public class PaypalConfig {
//    @Value("AV7Xl8E1mayjXjUysjpK-yrFXF2yMIFNw8Z85A1lUnukJLCfhrpY_aCdZungQ4evZEK5yvZ1va7TQeK1")
//    private String clientId;
//    @Value("EMq94Sm7fJnMS6GfXIFbSGnm0R-HeumRJaUJ5gKDFQ2Xeqjqc2t_gdF9XW3RpUKkP4dVYS7Es31sPHQF")
//    private String clientSecret;
//    @Value("${paypal.mode}")
//    private String mode;
//
//    @Bean
//    public Map<String, String> paypalSdkConfig() {
//        Map<String, String> sdkConfig = new HashMap<>();
//        sdkConfig.put("mode", mode);
//        return sdkConfig;
//    }
//
//    @Bean
//    public OAuthTokenCredential authTokenCredential() {
//        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
//    }
//
//    @Bean
//    public APIContext apiContext() throws PayPalRESTException {
//        APIContext apiContext = new APIContext(authTokenCredential().getAccessToken());
//        apiContext.setConfigurationMap(paypalSdkConfig());
//        return apiContext;
//    }
//}