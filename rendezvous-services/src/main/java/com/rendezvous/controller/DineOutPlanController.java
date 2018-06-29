package com.rendezvous.controller;

import com.rendezvous.entity.DineOutPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class to hold APIs related to dine out plans.
 *
 * @author Rupali Paunikar
 */
@CrossOrigin
@RestController
public class DineOutPlanController {

    /**
     * API to create a dine out plan
     *
     * @param dineOutPlan the {@link DineOutPlan}.
     * @return the {@link DineOutPlan}.
     */
    @RequestMapping(value = "dineOutPlan", method = RequestMethod.POST)
    public DineOutPlan createDineOutPlan(@RequestBody final DineOutPlan dineOutPlan) {
        return new DineOutPlan("1", "1", "Plan 1", "Lunch", "BBQ", "desc", new Date());
    }

    /**
     * Method to get {@link DineOutPlan} by user id.
     *
     * @param userId the userId.
     * @return the list of {@link DineOutPlan}.
     */
    @RequestMapping(value = "dineOutPlan/search", method = RequestMethod.GET)
    public Iterable<DineOutPlan> dineOutPlanSearch(@RequestParam("userId") final String userId) {
        List<DineOutPlan> dineOutPlans = new ArrayList<>();
        dineOutPlans.add(new DineOutPlan("1", "1", "BBQ", "Lunch", "BBQ", "desc", new Date()));
        dineOutPlans.add(new DineOutPlan("2", "1", "Pizza hut", "Dinner", "Pizza hut", "desc", new Date()));
        dineOutPlans.add(new DineOutPlan("3", "1", "Faasos", "Breakfast", "Faasos", "desc", new Date()));
        dineOutPlans.add(new DineOutPlan("4", "1", "Cream Stone", "Brunch", "Cream Stone", "desc", new Date()));
        return dineOutPlans;
    }
}
