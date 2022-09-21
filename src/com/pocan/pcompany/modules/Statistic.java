
package com.pocan.pcompany.modules;


public class Statistic {
    private String date;
    private int customer,order,earn;

    public Statistic(String date, int customer, int order, int earn) {
        this.date = date;
        this.customer = customer;
        this.order = order;
        this.earn = earn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getEarn() {
        return earn;
    }

    public void setEarn(int earn) {
        this.earn = earn;
    }
    
}
