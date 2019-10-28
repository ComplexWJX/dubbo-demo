package com.base.common;

import java.util.Map;

public interface IotServerProviderService
{
    Object process(String method,Map<String, String> param);
}
