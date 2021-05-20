package cn.goodrock.p2.bean;

/**
 * @program: project2
 * @description: 实体对象，封装客户信息
 * @author: Mr.Yan
 * @create: 2021-05-18 15:25
 **/
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public Customer(){};


    /**
     * description:
     * @param  name 姓名
     * @param  gender 性别
     * @param  age 年龄
     * @param  phone 手机号
     * @param  email 邮箱
     * @return
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }
    public char getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
}
