package com.maxcar.stock.pojo;

import java.io.Serializable;

public class ReviewDetail implements Serializable {
    private Integer id;

    private Integer reviewId;

    private String reviewPersonId;

    private Integer reviewResult;

    private String reviewDesc;

    private String marketId;

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewPersonId() {
        return reviewPersonId;
    }

    public void setReviewPersonId(String reviewPersonId) {
        this.reviewPersonId = reviewPersonId == null ? null : reviewPersonId.trim();
    }

    public Integer getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(Integer reviewResult) {
        this.reviewResult = reviewResult;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc == null ? null : reviewDesc.trim();
    }
}