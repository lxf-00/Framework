package com.springlearning.proxy;

/**
 * 对生产厂家的要求的接口
 */
public interface Iproducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(Float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(Float money);
}
