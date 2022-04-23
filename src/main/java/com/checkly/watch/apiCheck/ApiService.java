package com.checkly.watch.apiCheck;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Value("${middleware.base.url}")
    private String baseUrl;
    @Value("${middleware.get.banks.path}")
    private String getBankPath;
    @Value("${middleware.flutter.fee.path}")
    private String transactionFeePath;
    @Value("${query.parameter}")
    private String parameter;
    @Value("${middleware.apikey}")
    private String apikey;



//    private static String GET_TRANSACTION_FEE = "https://cv-lendqr-middleware.herokuapp.com/middleware/api/v1/banks/transactions/fee?amount=100000&currency=NGN";
//    private static String GET_ALL_BANKS = "https://cv-lendqr-middleware.herokuapp.com/middleware/api/v1/banks";
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    ObjectMapper objectMapper = new ObjectMapper();

    public ApiModel getAllBanks() throws JsonProcessingException {
        headers.set("apikey", apikey);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> data = restTemplate.exchange(baseUrl + getBankPath, HttpMethod.GET, httpEntity, String.class);
        ApiModel model = objectMapper.readValue(data.getBody(), ApiModel.class);
        return model;
    }


    public ApiModel getTransactionFee() throws JsonProcessingException {
        headers.set("apikey", apikey);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> data = restTemplate.exchange(baseUrl + transactionFeePath + parameter, HttpMethod.GET, httpEntity, String.class);
        ApiModel model = objectMapper.readValue(data.getBody(), ApiModel.class);
        return model;
    }

}
