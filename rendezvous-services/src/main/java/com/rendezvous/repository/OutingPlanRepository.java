package com.rendezvous.repository;

import java.util.List;

import com.rendezvous.entity.OutingPlan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO interface for {@link OutingPlan}.
 *
 * @author Rupali Paunikar
 */
public interface OutingPlanRepository extends CrudRepository<OutingPlan, String> {

    /**
     * Method to find list of {@link OutingPlan} by user id.
     *
     * @param userId the userId
     * @return the list of {@link OutingPlan}.
     */
    @EnableScan
    List<OutingPlan> findByUserId(String userId);
}
