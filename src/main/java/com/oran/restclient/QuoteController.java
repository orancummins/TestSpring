package com.oran.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Consuming JSON services
 */
@Controller
@RequestMapping("/restclient")
public class QuoteController {

    private static final Logger log = LoggerFactory.getLogger(com.oran.restclient.QuoteController.class);

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    Quote generate() {

        log.info("Quote Controller hit");

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());

        return quote;
    }
}
