package com.mchz.downloadaspdfdemo.demo.Util;

import com.mchz.downloadaspdfdemo.demo.entity.TableBase;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造导出数据
 *
 */


public class data {
    public Map<String,Object> getData(TableBase tableBase){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("tableBase",tableBase);
        return dataMap;
    }
}
