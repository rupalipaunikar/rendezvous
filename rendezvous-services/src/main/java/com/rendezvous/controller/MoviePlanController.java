package com.rendezvous.controller;

import com.rendezvous.entity.MoviePlan;
import com.rendezvous.repository.MoviePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class to hold APIs related to movie plans.
 *
 * @author Rupali Paunikar
 */
@CrossOrigin
@RestController
public class MoviePlanController {

    private MoviePlanRepository moviePlanRepository;

    public MoviePlanRepository getMoviePlanRepository() {
        return moviePlanRepository;
    }

    @Autowired
    public void setMoviePlanRepository(final MoviePlanRepository moviePlanRepository) {
        this.moviePlanRepository = moviePlanRepository;
    }

    /**
     * API to create a dine out plan
     *
     * @param moviePlan the {@link MoviePlan}.
     * @return the {@link MoviePlan}.
     */
    @RequestMapping(value = "moviePlan", method = RequestMethod.POST)
    public MoviePlan createMoviePlan(@RequestBody final MoviePlan moviePlan) {
        return moviePlanRepository.save(moviePlan);
    }

    /**
     * Method to get {@link MoviePlan} by user id.
     *
     * @param userId the userId.
     * @return the list of {@link MoviePlan}.
     */
    @RequestMapping(value = "moviePlan/search", method = RequestMethod.GET)
    public Iterable<MoviePlan> moviePlanSearch(@RequestParam("userId") final String userId) {
        return moviePlanRepository.findByUserId(userId);
    }
}
