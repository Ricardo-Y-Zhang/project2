package cn.goodrock.p2.util;

import java.util.*;

/**
 * @program: project2
 * @description: 将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，无需考虑具体的功能实现细节
 * @author: Mr.Yan
 * @create: 2021-05-18 16:19
 **/
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * description: 键盘读取一个字符，如果是‘1’~‘5’，则作为方法的返回值
     * @param  
     * @return  char
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public static char readMenuSelection(){
        char c;
        for(;;){
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4' && c != '5'){
                System.out.print("选择错误，请重新输入：");
            }else{
                break;
            }
        }
        return c;
    }

    /**
     * description: 键盘读取一个字符，作为方法的返回值；若不输入字符直接回车，以defaultValue作为返回值
     * @param  defaultValue 默认返回值
     * @return  char
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public static char readChar(char defaultValue){
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }


    public static char readChar(){
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * description: 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
     * @param  
     * @return  int
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public static int readInt(){
        int n;
        for(;;){
            String str = readKeyBoard(2, false);
            try{
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * description: 从键盘读取一个长度不超过2位的整数，将其作为方法的返回值；如果用户不输入字符直接回车，以defaultValue作为返回值
     * @param  defaultValue 默认返回值
     * @return  int
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public static int readInt(int defaultValue){
        int n;
        for(;;){
            String str = readKeyBoard(2, true);
            if(str.equals("")){
                return defaultValue;
            }
            try{
                n = Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * description: 从键盘读取一个长度不超过limit的字符串，作为方法的返回值
     * @param  limit 字符串长度限制
     * @return  java.lang.String
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public static String readString(int limit){
        return readKeyBoard(limit, false);
    }

    /**
     * description: 从键盘读取一个长度不超过limit的字符串，作为返回值；无输入，返回默认值
     * @param  limit 字符串长度限制
 * @param  defaultValue 默认值
     * @return  java.lang.String
     * @author: Mr.Yan
     * @date: 2021/5/20
     **/
    public static String readString(int limit, String defaultValue){
        String str = readKeyBoard(limit, true);
        if(str.equals("")){
            return defaultValue;
        }else{
            return str;
        }
    }
    
    /**
     * description: 用于确认选择的输入，该方法从键盘读取'Y'或'N'，作为方法的返回值
     * @param  
     * @return  char
     * @author: Mr.Yan
     * @date: 2021/5/19
     **/
    public static char readConfirmSelection(){
        char c;
        for(;;){
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else{
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn){
        String line = "";

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length() == 0){
                if(blankReturn){
                    return line;
                }else{
                    continue;
                }
            }

            if(line.length() < 1 || line.length() > limit){
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }

}
