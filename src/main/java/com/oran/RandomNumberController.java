package com.oran;


import java.util.List;

import org.h2.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * This is the main controller
 * Spring Boot starts up on a given port (see application.properties) and listens to HTTP requests
 * This creates basic web services
 *
 * Look at the @Autowired annotation which gives quick db access to entities
 *
 * E.g. /hello-world?name=Oran will be interpreted (see below annotation)
 */
@Controller
@RequestMapping("/random")
public class RandomNumberController {

    @Autowired
    private RandomNumberRepository randomNumberRepository;// + setter

    private static final Logger log = LoggerFactory.getLogger(RandomNumberController.class);

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody RandomNumber generate(@RequestParam(value="name", required=false, defaultValue="Stranger") String name,
                                           @RequestHeader(value="User-Agent") String userAgent) {

        log.info("Controller hit");

        if (!StringUtils.isNullOrEmpty(name)) {

            log.info("Trying to find by name: " + name);
            List<RandomNumber> randomNumbers = randomNumberRepository.findByName(name);

            if (randomNumbers.size() > 0) {
                log.info("Found name: " + name);
                return randomNumbers.get(0);
            }
        }
        log.info("Unrecognized name!");
        return new RandomNumber(null, "Not Found!", "", 0);
    }
}
