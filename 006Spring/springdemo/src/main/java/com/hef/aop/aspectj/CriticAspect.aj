package com.hef.aop.aspectj;

/**
 *  需要使用 Ajc编译器
 *  参考： https://mritd.me/2016/06/19/AspectJ-Hello-World/
 */
public aspect CriticAspect {
    public CriticAspect(){}

    pointcut performance() : execution(* com.hef.aop.Performance.perform(..));

    before():performance(){
        System.out.println(criticismEngine.getCriticism());
    }
    after():performance() {
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
