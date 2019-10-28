package com.wq.task;


import com.base.common.IotServerProviderService;
import com.wq.user.model.WqUser;
import com.wq.util.SpringContextUtil;

public class TimerJob extends WqUser
{ 
    private IotServerProviderService iotServerProviderService;
    
     void schedule()
    {
         System.out.println("TimerJob.schedule()");
    }

    //@Override
    public void run()
    {
        iotServerProviderService = SpringContextUtil.getBean(IotServerProviderService.class);
        schedule();
    }
}
