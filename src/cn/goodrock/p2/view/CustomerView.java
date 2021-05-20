package cn.goodrock.p2.view;

import cn.goodrock.p2.bean.Customer;
import cn.goodrock.p2.service.CustomerList;
import cn.goodrock.p2.util.CMUtility;
import com.sun.corba.se.impl.oa.toa.TOA;

/**
 * @program: project2
 * @description: 主模块，负责菜单的显示和处理用户操作
 * @author: Mr.Yan
 * @create: 2021-05-18 15:52
 **/
public class CustomerView {
    //创建最大包含10个客户对象的CustomerList对象
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer cust = new Customer("李刚", '男', 18, "13976548723", "qifei@163.com");
        customerList.addCustomer(cust);
    }

    /**
     * description: 显示《客户信息管理软件》界面
     * @param
     * @return  void
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public void enterMainMenu(){
        boolean isFlag = true;
        while(isFlag){
            System.out.println("\n-------------------客户信息管理软件--------------------\n");
            System.out.println("                    1 添加客户");
            System.out.println("                    2 修改客户");
            System.out.println("                    3 删除客户");
            System.out.println("                    4 客户列表");
            System.out.println("                    5  退  出\n");
            System.out.print("                   请选择（1-5）：");
            char menu = CMUtility.readMenuSelection();

            switch(menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出（Y/N）：");
                    char temp = CMUtility.readConfirmSelection();
                    if(temp == 'Y'){
                        isFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * description: 添加客户
     * @param
     * @return  void
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    private void addNewCustomer(){
        System.out.println("-----------------------添加客户-----------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

        //将上述数据封装到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("-----------------------添加成功-----------------------");
        }else{
            System.out.println("-------------------客户已满，添加失败-------------------");
        }
    }

    /**
     * description: 修改客户
     * @param
     * @return  void
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    private void modifyCustomer(){
        System.out.println("-----------------------修改客户-----------------------");
        boolean isFlag = true;
        Customer cust = null;
        int number = 0;
        while(isFlag){
            System.out.print("请选择待修改客户编号（-1退出）：");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }else{
                cust = customerList.getCustomer(number - 1);
                if(cust == null){
                    System.out.println("无法找到指定客户！");
                }else{
                    break;
                }
            }
        }

        //修改客户信息
        System.out.print("姓名（" + cust.getName() + "）：");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别（" + cust.getGender() + "）：");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄（" + cust.getAge() + "）：");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话（" + cust.getPhone() + "）：");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("邮箱（" + cust.getName() + "）：");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number-1, newCust);
        if(isReplaced){
            System.out.println("-----------------------修改完成-----------------------");
        }else{
            System.out.println("-----------------------修改失败-----------------------");
        }
    }


    /**
     * description: 删除客户
     * @param
     * @return  void
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    private void deleteCustomer(){
        System.out.println("-----------------------修改完成-----------------------");
        int number = 0;
        Customer customer;
        for(;;){
            System.out.print("请选择删除客户编号（-1退出）：");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }else{
                customer = customerList.getCustomer(number-1);
                if(customer == null){
                    System.out.println("无法找到指定客户！");
                }else{
                    break;
                }
            }
        }
        System.out.print("确认是否删除（Y/N）：");
        char confirmSelection = CMUtility.readConfirmSelection();
        if(confirmSelection == 'Y'){
            boolean isDeleted = customerList.deleteCustomer(number-1);
            if(isDeleted){
                System.out.println("-----------------------删除完成-----------------------");
            }else{
                System.out.println("-----------------------删除失败-----------------------");
            }
        }

    }

    /**
     * description: 显示客户列表
     * @param  
     * @return  void
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    private void listAllCustomer(){
        System.out.println("-----------------------客户列表----------------------");
        if(customerList.getTotal() == 0){
            System.out.println("没有客户记录！");
        }else{
            System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t\t\t邮箱");
            Customer[] customers = customerList.getAllCustomers();
            for(int i = 0; i < customerList.getTotal(); i++){
                Customer customer = customers[i];
                System.out.println((i+1) + "\t\t" + customer.getName() + "\t\t" + customer.getGender() + "\t\t" + customer.getAge() + "\t\t" + customer.getPhone() + "\t\t" + customer.getEmail());
            }
        }
        System.out.println("---------------------客户列表结束---------------------");
    }

    public static void main(String[] args){
        CustomerView view = new CustomerView();

        view.enterMainMenu();
    }
}
