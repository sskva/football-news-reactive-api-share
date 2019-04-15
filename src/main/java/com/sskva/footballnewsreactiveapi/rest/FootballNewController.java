package com.sskva.footballnewsreactiveapi.rest;

import com.sskva.footballnewsreactiveapi.domain.FootballNew;
import com.sskva.footballnewsreactiveapi.repository.FootballNewRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class FootballNewController {

    private FootballNewRepository repository;
    private static final Logger logger = LogManager.getLogger("FootballNewController");

    public FootballNewController(FootballNewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/footballnewrussian")
    public Flux<FootballNew> footballNewRussian() {
        logger.info("footballnewrussian start");
        return repository.findByType("russian").takeLast(200).sort();
    }


    @GetMapping("/footballnewworld")
    public Flux<FootballNew> footballNewWorld() {
        logger.info("footballnewworld start");
        return repository.findByType("world").takeLast(200).sort();
    }

}
