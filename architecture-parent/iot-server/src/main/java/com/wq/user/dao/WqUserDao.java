package com.wq.user.dao;

import java.util.List;
import java.util.Map;

public interface WqUserDao
{
    
    List<Map<String, Object>> queryOne(Map<String, Object> param);
    
    List<Map<String, Object>> getUserList(Map<String, Object> param);
}
