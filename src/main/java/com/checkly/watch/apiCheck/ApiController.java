package com.checkly.watch.apiCheck;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApiController {

        @Autowired
        ApiService apiService;
        boolean data = true;


        @RequestMapping(value = "/banks", method = RequestMethod.GET)
        public ResponseEntity allBanks() throws JsonProcessingException {
            ApiModel bankData = apiService.getAllBanks();
            if (bankData.getStatus().equals("SUCCESS")){
                return new ResponseEntity(HttpStatus.OK);
            }
            else{
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        @RequestMapping(value = "/fee", method = RequestMethod.GET)
        public ResponseEntity transactionFee() throws JsonProcessingException {
            ApiModel feeData = apiService.getTransactionFee();
            if (feeData.getStatus().equals("SUCCESS")){
                return new ResponseEntity(HttpStatus.OK);
            }
            else{
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
