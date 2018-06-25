package com.rendezvous.controller;

import com.rendezvous.entity.OutingPlan;
import com.rendezvous.repository.OutingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return outingPlanRepository.save(outingPlan);
    }

    /**
     * Method to get {@link OutingPlan} by user id.
     *
     * @param userId the userId.
     * @return the list of {@link OutingPlan}.
     */
    @RequestMapping(value = "outingPlan/search", method = RequestMethod.GET)
    public Iterable<OutingPlan> outingPlanSearch(@RequestParam("userId") final String userId) {
        return outingPlanRepository.findByUserId(userId);
    }
}
