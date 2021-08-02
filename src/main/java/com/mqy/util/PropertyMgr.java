package com.mqy.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author TF014268
 * @description 读取配置文件
 * @since 2021/8/2 0002 9:45
 */
public class PropertyMgr {
    private static final PropertyMgr propertyMgr = new PropertyMgr();

    static Properties properties = null;
    
    private PropertyMgr(){}

    public static PropertyMgr getInsatace(){
        return propertyMgr;
    }

    static{
        try {
            //先初始化
            properties = new Properties();
            properties.load(PropertyMgr.class.getResourceAsStream("/config/application.properties"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    //获取配置
    public Object get(String key) throws Exception {
        if(properties==null){
            return null;
        }

        if(null==properties.get(key)){
            throw new Exception("缺少配置" + key);
        }
        return properties.get(key);
    }
}
