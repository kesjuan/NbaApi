package com.NbaStats2.Api.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableScheduling
@Component
public class ScheduledService {
    //private Logger log = LoggerFactory.getLogger(ScheduledService.class);

    @Autowired
    private DbGameService dbGameService;

    @Autowired
    private DbPlayerService dbPlayerService;

    @Autowired
    private DbStatService dbStatService;





    @Scheduled(fixedRate = 2000000) public void scheduledTask(){
        System.out.println("Scheduling");
    }

}
