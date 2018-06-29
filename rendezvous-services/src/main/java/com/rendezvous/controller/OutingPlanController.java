package com.rendezvous.controller;

import com.rendezvous.entity.OutingPlan;
import com.rendezvous.repository.OutingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class to hold APIs related to outing plans.
 *
 * @author Rupali Paunikar
 */
@CrossOrigin
@RestController
public class OutingPlanController {

    private OutingPlanRepository outingPlanRepository;

    public OutingPlanRepository getOutingPlanRepository() {
        return outingPlanRepository;
    }

    @Autowired
    public void setOutingPlanRepository(final OutingPlanRepository outingPlanRepository) {
        this.outingPlanRepository = outingPlanRepository;
    }

    /**
     * API to create a dine out plan
     *
     * @param outingPlan the {@link OutingPlan}.
     * @return the {@link OutingPlan}.
     */
    @RequestMapping(value = "outingPlan", method = RequestMethod.POST)
    public OutingPlan createOutingPlan(@RequestBody OutingPlan outingPlan) {
        return new OutingPlan("1", "1", "Plan 1", "Mahabaleshwar", "desc", new Date());
    }

    /**
     * Method to get {@link OutingPlan} by user id.
     *
     * @param userId the userId.
     * @return the list of {@link OutingPlan}.
     */
    @RequestMapping(value = "outingPlan/search", method = RequestMethod.GET)
    public Iterable<OutingPlan> outingPlanSearch(@RequestParam("userId") final String userId) {
        List<OutingPlan> outingPlans = new ArrayList<>();
        outingPlans.add(new OutingPlan("1", "1", "Plan 1", "Mahabaleshwar", "desc", new Date()));
        outingPlans.add(new OutingPlan("2", "1", "Plan 2", "Matheran", "desc", new Date()));
        outingPlans.add(new OutingPlan("3", "1", "Plan 3", "Mulshi", "desc", new Date()));
        outingPlans.add(new OutingPlan("4", "1", "Plan 4", "Rupali",  "desc", new Date()));
        return outingPlans;
    }
}
