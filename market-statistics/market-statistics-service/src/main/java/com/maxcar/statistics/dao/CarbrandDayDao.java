package com.maxcar.statistics.dao;

import com.maxcar.statistics.dao.base.BaseDao;
import com.maxcar.statistics.dao.provider.CarbrandDayProvider;
import com.maxcar.statistics.model.request.*;
import com.maxcar.statistics.model.response.*;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface CarbrandDayDao extends BaseDao {

    /**
     * param:
     * describe: 统计当前的车辆品牌日表交易集合
     * create_date:  lxy   2018/11/26  11:46
     **/
    @SelectProvider(type = CarbrandDayProvider.class, method = "groupCarbrandInvoiceDay")
    List<GroupCarbrandInvoiceDayResponse> groupCarbrandInvoiceDay(GroupCarbrandInvoiceDayRequest parameter);

    /**
     * param:
     * describe: 日表交易排名
     * create_date:  lxy   2018/12/11  11:22
     **/
    @SelectProvider(type = CarbrandDayProvider.class, method = "groupCarbrandInvoiceDayRanking")
    List<GetInvoiceRankingResponse> groupCarbrandInvoiceDayRanking(GetInvoiceRankingByConditionRequest parameter);

    /**
     * param:
     * describe: 日表库存排名
     * create_date:  lxy   2018/12/11  13:58
     **/
    @SelectProvider(type = CarbrandDayProvider.class, method = "groupCarbrandInventoryDayRanking")
    List<GetInventoryRankingResponse>  groupCarbrandInventoryDayRanking(GetInventoryRankingByConditionRequest parameter);

    /**
     * param:
     * describe: 统计当前的车辆品牌日表库存集合
     * create_date:  lxy   2018/11/26  14:50
     **/
    @SelectProvider(type = CarbrandDayProvider.class, method = "groupCarbrandInventoryDay")
    List<GroupCarbrandInventoryDayResponse> groupCarbrandInventoryDay(GroupCarbrandInventoryDayRequest parameter);

    /**
     * param:
     * describe: 查询市场 或者 商户 车辆品牌集合
     * create_date:  lxy   2018/12/1  11:15
     **/
    @SelectProvider(type = CarbrandDayProvider.class, method = "getAllBrandName")
    List<String> getAllBrandName(GetAllBrandNameRequest request);


    /**
     * param:
     * describe: 统计当前月的车辆品牌日表集合  交易
     * create_date:  lxy   2018/11/23  11:34
     **/
    @SelectProvider(type = CarbrandDayProvider.class, method = "groupCarbrandInvoiceDayByMonth")
    List<GroupCarbrandDayByMonthResponse> groupCarbrandInvoiceDayByMonth(String timeByMonth);

    /**
     * param:
     * describe: 统计当前月的车辆品牌日表集合  库存
     * create_date:  lxy   2018/11/23  11:34
     **/
    @SelectProvider(type = CarbrandDayProvider.class, method = "groupCarbrandInventoryDayByMonth")
    List<GroupCarbrandDayByMonthResponse> groupCarbrandInventoryDayByMonth(String timeByMonth);

}
