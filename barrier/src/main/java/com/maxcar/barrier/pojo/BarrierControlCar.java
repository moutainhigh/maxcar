package com.maxcar.barrier.pojo;

import com.maxcar.base.pojo.PageBean;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class BarrierControlCar extends PageBean implements Serializable {
    private String id;

    private String barrierId;// 道闸id

    private String marketId; // 市场id

    private Integer controlType; // 控制类型  1控制车辆  2控制商户

    private Integer listType; // 名单类型 1白名单   2黑名单

    @NotNull(message = "车辆id不能为空")
    private String carId; // 车辆id

    private String vin; // 车辆vin

    private String rfid; // 标签

    @NotNull(message = "商户id不能为空")
    private String tenantId; // 商户id

    private Integer isvalid;

    private String remark;

    private Date insertTime;

    private String insertOperator;

    private Date updateTime;

    private String updateOperator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBarrierId() {
        return barrierId;
    }

    public void setBarrierId(String barrierId) {
        this.barrierId = barrierId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId == null ? null : marketId.trim();
    }

    public Integer getControlType() {
        return controlType;
    }

    public void setControlType(Integer controlType) {
        this.controlType = controlType;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid == null ? null : rfid.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getInsertOperator() {
        return insertOperator;
    }

    public void setInsertOperator(String insertOperator) {
        this.insertOperator = insertOperator == null ? null : insertOperator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }
}