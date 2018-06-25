package com.rendezvous.repository;

import java.util.List;

import com.rendezvous.entity.DineOutPlan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO interface for {@link DineOutPlan}.
 *
 * @author Rupali Paunikar
 */
public interface DineOutPlanRepository extends CrudRepository<DineOutPlan, String> {

    /**
     * Method to find list of {@link DineOutPlan} by user id.
     *
     * @param userId the userId
     * @return the list of {@link DineOutPlan}.
     */
    @EnableScan
    List<DineOutPlan> findByUserId(String userId);
}
