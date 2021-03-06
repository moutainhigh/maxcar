package com.maxcar.stock.entity.Request;

import com.maxcar.base.pojo.PageBean;

import java.util.Date;

public class SearchCarRequest extends PageBean {

    /**
     * 车型名称
     */
    private String modelName;

    /**
     * 品牌code
     */
    private String brandCode;

    /**
     * 车系code
     */
    private String seriesCode;

    /**
     * 售价起始价
     */
    private Integer priceStart;

    /**
     * 售价截止价
     */
    private Integer priceEnd;

    /**
     * 起始里程
     */
    private Integer mileageStart;

    /**
     * 截止里程
     */
    private Integer mileageEnd;

    /**
     * 变速箱
     */
    private String gearBox;

    /**
     * 车体类型
     */
    private String level;

    /**
     * 排放标准
     */
    private String environmentalStandards;

    /**
     * 车颜色
     */
    private String color;

    /**
     * 起始车龄
     */
    private Integer autoAgeStart;

    /**
     * 截止车龄
     */
    private Integer autoAgeEnd;

    private String marketId;

    private Date initialLicenceStartTime;

    private Date initialLicenceEndTime;

    private Integer engineNo;//是否维珍验车过 1验过  0 or null 未验过

    public Integer getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(Integer engineNo) {
        this.engineNo = engineNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public Integer getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(Integer priceStart) {
        this.priceStart = priceStart;
    }

    public Integer getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Integer priceEnd) {
        this.priceEnd = priceEnd;
    }

    public Integer getMileageStart() {
        return mileageStart;
    }

    public void setMileageStart(Integer mileageStart) {
        if (mileageStart != null) {
            this.mileageStart = mileageStart * 10000;
        }
    }

    public Integer getMileageEnd() {
        return mileageEnd;
    }

    public void setMileageEnd(Integer mileageEnd) {
        if (mileageEnd != null) {
            this.mileageEnd = mileageEnd * 10000;
        }
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        if ("不限".equals(gearBox)) {
            return;
        }
        this.gearBox = gearBox;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        if ("不限".equals(level)) {
            return;
        }
        this.level = level;
    }

    public String getEnvironmentalStandards() {
        return environmentalStandards;
    }

    public void setEnvironmentalStandards(String environmentalStandards) {
        if ("不限".equals(environmentalStandards)) {
            return;
        }
        this.environmentalStandards = environmentalStandards;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if ("不限".equals(color)) {
            return;
        }
        this.color = color;
    }

    public Integer getAutoAgeStart() {
        return autoAgeStart;
    }

    public void setAutoAgeStart(Integer autoAgeStart) {
        this.autoAgeStart = autoAgeStart;
    }

    public Integer getAutoAgeEnd() {
        return autoAgeEnd;
    }

    public void setAutoAgeEnd(Integer autoAgeEnd) {
        this.autoAgeEnd = autoAgeEnd;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public Date getInitialLicenceStartTime() {
        return initialLicenceStartTime;
    }

    public void setInitialLicenceStartTime(Date initialLicenceStartTime) {
        this.initialLicenceStartTime = initialLicenceStartTime;
    }

    public Date getInitialLicenceEndTime() {
        return initialLicenceEndTime;
    }

    public void setInitialLicenceEndTime(Date initialLicenceEndTime) {
        this.initialLicenceEndTime = initialLicenceEndTime;
    }
}