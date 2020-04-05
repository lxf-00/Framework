package com.springlearning.proxy;

public class Producer implements Iproducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(Float money){
        System.out.println("销售产品，拿到钱：" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(Float money){
        System.out.println("售后服务，并拿到钱：" + money );
    }
}
