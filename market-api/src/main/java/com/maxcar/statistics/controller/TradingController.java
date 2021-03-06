package com.maxcar.statistics.controller;

import com.maxcar.BaseController;
import com.maxcar.base.pojo.InterfaceResult;
import com.maxcar.base.util.DateUtils;
import com.maxcar.statistics.model.entity.InventoryInvoiceMonthEntity;
import com.maxcar.statistics.model.request.TradingRequest;
import com.maxcar.statistics.model.response.TradingResponse;
import com.maxcar.statistics.service.InsertStockAndInvoice;
import com.maxcar.statistics.service.TradingService;
import com.maxcar.user.entity.User;
import com.maxcar.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TradingController extends BaseController {

    @Autowired
    private TradingService tradingService;

    @Autowired
    private UserService userService;

    /**
     * 交易总量与交易价值
     *
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    /*@PostMapping("/trading/trading")
    public InterfaceResult getPropertyContractAll(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
        getUserMarketAndSetTime(tradingRequest, request);

        List<TradingResponse> responses = tradingService.getVolumeAndValue(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(responses);
        return interfaceResult;
    }*/
    @PostMapping("/trading/trading")
    public InterfaceResult getPropertyContractAll(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
//        getUserMarketAndSetTime(tradingRequest, request);
        getUserMarketId(tradingRequest, request);

        List<InventoryInvoiceMonthEntity> responses = tradingService.getVolumeAndValue(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(responses);
        return interfaceResult;
    }

    private void getUserMarketId(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
            User currentUser = getCurrentUser(request);
            String marketId = currentUser.getMarketId();
            String userId = currentUser.getUserId();
            User user = userService.selectByPrimaryKey(userId);
            if (user.getManagerFlag() == 0) {
                tradingRequest.setMarketId(null);
            } else {
                tradingRequest.setMarketId(marketId);

        }
    }

    /**
     * 增长率统计
     *
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/increase")
    public InterfaceResult getIncreaseRate(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
//        getUserMarketAndSetTime(tradingRequest, request);
        getUserMarketId(tradingRequest, request);

        List<TradingResponse> increaseRate = tradingService.getIncreaseRate(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(increaseRate);
        return interfaceResult;
    }

    /**
     * 平均交易价格
     *
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/avgPrice")
    public InterfaceResult getAvgPrice(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
//        getUserMarketAndSetTime(tradingRequest, request);
        getUserMarketId(tradingRequest, request);

        Map<String, Object> avgPrice = tradingService.getAvgPrice(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(avgPrice);
        return interfaceResult;
    }

    /**
     * 平均交易价格增长率
     *
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/avgPriceRate")
    public InterfaceResult getAvgPriceRate(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
//        getUserMarketAndSetTime(tradingRequest, request);
        getUserMarketId(tradingRequest, request);

        List<TradingResponse> avgPriceRate = tradingService.getAvgPriceRate(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(avgPriceRate);
        return interfaceResult;
    }

    /**
     * 车商交易量分布
     *
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/tenantCount")
    public InterfaceResult getTenantCount(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
//        getUserMarketAndSetTime(tradingRequest, request);
        getUserMarketId(tradingRequest, request);

//        String timeStart = tradingRequest.getTimeStart();
//        Date date = DateUtils.parseDate(timeStart, DateUtils.DATE_FORMAT_DATEONLY);
//        Date dayEnd = DateUtils.getDayEnd(date);
//        timeStart = DateUtils.formatDate(dayEnd, DateUtils.DATE_FORMAT_DATEONLY);
//        tradingRequest.setTimeEnd(timeStart);

        Map<String, Double> tenantCount = tradingService.getTenantCount(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(tenantCount);
        return interfaceResult;
    }


    /**
     * 车商交易量发展趋势
     *
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/tenantDeal")
    public InterfaceResult getTenantDeal(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
//        getUserMarketAndSetTime(tradingRequest, request);
        getUserMarketId(tradingRequest, request);

        tradingRequest.setCarNumType(tradingRequest.getCountType());

        String timeStart = tradingRequest.getTimeStart();
        tradingRequest.setTimeStart(timeStart.substring(0,7));
        String timeEnd = tradingRequest.getTimeEnd();
        tradingRequest.setTimeEnd(timeEnd.substring(0,7));
        List<TradingResponse> tenantDeal = tradingService.getTenantDeal(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(tenantDeal);
        return interfaceResult;
    }

    /**
     * 按交易价格分布的车辆
     *
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/carPrice")
    public InterfaceResult getCarPrice(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
        getUserMarketId(tradingRequest, request);

        Map<String, Object> carPrice = tradingService.getCarPrice(tradingRequest);
        if(carPrice == null){
            HashMap<String, Integer> map = new HashMap<>();
            map.put("10万以下",0);
            map.put("10-20万",0);
            map.put("20-30万",0);
            map.put("30-40万",0);
            map.put("40-50万",0);
            map.put("50万以上",0);
            InterfaceResult interfaceResult = new InterfaceResult();
            interfaceResult.InterfaceResult200(map);
            return interfaceResult;
        }

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(carPrice);
        return interfaceResult;
    }

    /**
     *   交易层次发展趋势
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/transactionLevel")
    public InterfaceResult transactionLevel(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
        getUserMarketId(tradingRequest, request);

        String timeStart = tradingRequest.getTimeStart().substring(0, 7);
        String timeEnd = tradingRequest.getTimeEnd().substring(0, 7);

        tradingRequest.setTimeStart(timeStart);
        tradingRequest.setTimeEnd(timeEnd);

        List<TradingResponse> carpriceDayEntities = tradingService.transactionLevel(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(carpriceDayEntities);
        return interfaceResult;
    }

    /**
     * 按交易价格分布的平均库存天数
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/trading/stockAvgDay")
    public InterfaceResult stockAvgDay(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
        getUserMarketId(tradingRequest, request);

        Map<String, Object> map = tradingService.stockAvgDay(tradingRequest);

        InterfaceResult interfaceResult = new InterfaceResult();
        interfaceResult.InterfaceResult200(map);
        return interfaceResult;
    }



    @Autowired
    private InsertStockAndInvoice insertStockAndInvoice;

    /**
     * 导入数据测试
     * @param tradingRequest
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/test/test")
    public void test(@RequestBody TradingRequest tradingRequest, HttpServletRequest request) throws Exception {
        getUserMarketId(tradingRequest, request);
        insertStockAndInvoice.InsertCarpriceDay();
        insertStockAndInvoice.InsertCarstockDay();
        insertStockAndInvoice.InsertCarstockMonth();
        insertStockAndInvoice.InsertInventoryInvoiceDay();
        insertStockAndInvoice.InsertInventoryInvoiceMonth();
        insertStockAndInvoice.InsertStockAvgDay();
    }
}
