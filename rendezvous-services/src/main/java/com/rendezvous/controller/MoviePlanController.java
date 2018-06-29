package com.rendezvous.controller;

import com.rendezvous.entity.MoviePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class to hold APIs related to movie plans.
 *
 * @author Rupali Paunikar
 */
@CrossOrigin
@RestController
public class MoviePlanController {

    /**
     * API to create a dine out plan
     *
     * @param moviePlan the {@link MoviePlan}.
     * @return the {@link MoviePlan}.
     */
    @RequestMapping(value = "moviePlan", method = RequestMethod.POST)
    public MoviePlan createMoviePlan(@RequestBody final MoviePlan moviePlan) {
        return new MoviePlan("1", "1", "Plan 1", "SpiderMan", "desc", new Date());
    }

    /**
     * Method to get {@link MoviePlan} by user id.
     *
     * @param userId the userId.
     * @return the list of {@link MoviePlan}.
     */
    @RequestMapping(value = "moviePlan/search", method = RequestMethod.GET)
    public Iterable<MoviePlan> moviePlanSearch(@RequestParam("userId") final String userId) {
        List<MoviePlan> moviePlans = new ArrayList<>();
        moviePlans.add(new MoviePlan("1", "1", "SpiderMan", "SpiderMan", "desc", new Date()));
        moviePlans.add(new MoviePlan("2", "1", "Parmanu", "Parmanu", "desc", new Date()));
        moviePlans.add(new MoviePlan("3", "1", "Revenge", "Revenge", "desc", new Date()));
        moviePlans.add(new MoviePlan("4", "1", "BatMan", "BatMan",  "desc", new Date()));
        return moviePlans;
    }
}
