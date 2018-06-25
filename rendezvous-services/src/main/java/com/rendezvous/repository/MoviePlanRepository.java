package com.rendezvous.repository;

import java.util.List;

import com.rendezvous.entity.MoviePlan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO interface for {@link MoviePlan}.
 *
 * @author Rupali Paunikar
 */
public interface MoviePlanRepository extends CrudRepository<MoviePlan, String> {

    /**
     * Method to find list of {@link MoviePlan} by user id.
     *
     * @param userId the userId
     * @return the list of {@link MoviePlan}.
     */
    @EnableScan
    List<MoviePlan> findByUserId(String userId);
}
