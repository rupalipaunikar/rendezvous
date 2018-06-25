package com.rendezvous.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rendezvous.common.JsonDateSerializer;

import java.util.Date;

/**
 * Data entity for movie_plan.
 *
 * @author Rupali Paunikar
 */
@DynamoDBTable(tableName = "movie_plan")
public class MoviePlan {

    @JsonIgnore
    private String planId;
    private String userId;
    private String planName;
    private String movie;
    private String description;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date date;

    @DynamoDBAttribute
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "userIdIndex")
    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(final String planName) {
        this.planName = planName;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(final String planId) {
        this.planId = planId;
    }

    @DynamoDBAttribute
    public String getMovie() {
        return movie;
    }

    public void setMovie(final String movie) {
        this.movie = movie;
    }

    @DynamoDBAttribute
    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MoviePlan{" +
                "planId='" + planId + '\'' +
                ", userId='" + userId + '\'' +
                ", planName='" + planName + '\'' +
                ", movie='" + movie + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}