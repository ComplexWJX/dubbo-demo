package com.wq.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wq.user.dao.WqUserDao;

@Repository
public class WqUserDaoImpl implements WqUserDao
{
    
    @Autowired
    private SqlSessionTemplate sessionTemplate;
    
    public List<Map<String, Object>> queryOne(Map<String, Object> param)
    {
        List<Map<String, Object>> list = sessionTemplate.selectList("login", param);
        return list;
    }

    public List<Map<String, Object>> getUserList(Map<String, Object> param)
    {
        return sessionTemplate.selectList("getUserList",param);
    }
    
}
