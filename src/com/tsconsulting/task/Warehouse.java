package com.tsconsulting.task;

public final class Warehouse {
    private static Warehouse warehouse;
    private int totalGoodsNum;

    private Warehouse(int goodsNum) {
        this.totalGoodsNum = goodsNum;
    }

    public synchronized int sell(int countOfGoods) {
        if(countOfGoods>totalGoodsNum){
            countOfGoods = totalGoodsNum;
            totalGoodsNum = 0;
            return countOfGoods;
        }
        else{
            totalGoodsNum -= countOfGoods;
            return countOfGoods;
        }
    }

    public static synchronized Warehouse getInstance(){
        if(warehouse==null){
            warehouse = new Warehouse(1000);
            return warehouse;
        }
        else return warehouse;
    }



    public void fill(int goodsNum){
        totalGoodsNum=goodsNum;
    }
}
