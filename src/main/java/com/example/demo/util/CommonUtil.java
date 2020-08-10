package com.example.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommonUtil {

    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

}
