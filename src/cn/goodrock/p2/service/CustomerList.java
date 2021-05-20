package cn.goodrock.p2.service;

import cn.goodrock.p2.bean.Customer;

/**
 * @program: project2
 * @description: customer对象的管理模块，用数组管理一组对象
 * @author: Mr.Yan
 * @create: 2021-05-18 15:32
 **/
public class CustomerList {
    private Customer[] customers;
    private int total = 0;//记录已保存客户对象的数量

    /**
     * description: 用于初始化customers数组的构造器
     * @param  totalCustomer 指定数组的长度
     * @return
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * description: 将指定的客户添加到数组中，成功返回true，失败返回false
     * @param  customer 客户
     * @return  boolean
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public boolean addCustomer(Customer customer){
        if(total == customers.length){
            return false;
        }else{
            customers[total] = customer;
            total++;
            return true;
        }
    }
    
    /**
     * description: 修改指定索引位置的客户信息
     * @param  index 需要修改客户的索引位置
     * @param  cust 替换客户
     * @return  boolean
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >= total){
            return false;
        }else{
            customers[index] = cust;
            return true;
        }
    }

    /**
     * description: 删除指定索引位置的客户，修改成功返回true，修改失败返回false
     * @param  index 删除客户索引
     * @return  boolean
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }else{
            for(int i = index; i < total-1; i++){
                customers[i] = customers[i+1];
            }
            customers[total - 1] = null;
            total--;
            return true;
        }
    }

    /**
     * description: 获取所有的客户信息，只返回含有客户信息的数组
     * @param  
     * @return  cn.goodrock.p2.bean.Customer[]
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for(int i = 0; i < total; i++){
            custs[i] = customers[i];
        }
        return custs;
    }


    /**
     * description: 获取指定索引位置上的客户
     * @param  index 指定索引位置
     * @return  cn.goodrock.p2.bean.Customer
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }else{
            return customers[index];
        }
    }

    /**
     * description: 获取存储的客户数量
     * @param  
     * @return  int
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public int getTotal() {
        return total;
    }
}
