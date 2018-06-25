package com.rendezvous.controller;

import com.rendezvous.entity.DineOutPlan;
import com.rendezvous.repository.DineOutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class to hold APIs related to dine out plans.
 *
 * @author Rupali Paunikar
 */
@CrossOrigin
@RestController
public class DineOutPlanController {

    private DineOutPlanRepository dineOutPlanRepository;

    public DineOutPlanRepository getDineOutPlanRepository() {
        return dineOutPlanRepository;
    }

    @Autowired
    public void setDineOutPlanRepository(final DineOutPlanRepository dineOutPlanRepository) {
        this.dineOutPlanRepository = dineOutPlanRepository;
    }

    /**
     * API to create a dine out plan
     *
     * @param dineOutPlan the {@link DineOutPlan}.
     * @return the {@link DineOutPlan}.
     */
    @RequestMapping(value = "dineOutPlan", method = RequestMethod.POST)
    public DineOutPlan createDineOutPlan(@RequestBody final DineOutPlan dineOutPlan) {
        return dineOutPlanRepository.save(dineOutPlan);
    }

    /**
     * Method to get {@link DineOutPlan} by user id.
     *
     * @param userId the userId.
     * @return the list of {@link DineOutPlan}.
     */
    @RequestMapping(value = "dineOutPlan/search", method = RequestMethod.GET)
    public Iterable<DineOutPlan> dineOutPlanSearch(@RequestParam("userId") final String userId) {
        return dineOutPlanRepository.findByUserId(userId);
    }
}
