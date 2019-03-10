package com.hef.aop;

import com.hef.aop.Performance;

public class FailPerformance implements Performance {
    @Override
    public void perform() {
        int i=1/0;
    }
}
