package com.mhj.utils;

import java.math.BigDecimal;

/**
 * @author mahuijian
 * @date 2019-09-11 16:57
 */
public class AmountUtils {

    /**金额为分的格式 */
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";
    /**
     * 将分为单位的转换为元 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(String amount) throws Exception{
        if(!amount.matches(CURRENCY_FEN_REGEX)) {
            throw new Exception("金额格式有误");
        }
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(changeF2Y(2+""));
    }
}
