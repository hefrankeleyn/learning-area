package com.hef.design11.simulators;

import com.hef.design11.Quackable;
import com.hef.design11.adapters.GooseAdapter;
import com.hef.design11.component.Flock;
import com.hef.design11.dacks.DuckCall;
import com.hef.design11.dacks.MallardDuck;
import com.hef.design11.dacks.RedheadDuck;
import com.hef.design11.dacks.RubberDuck;
import com.hef.design11.decorators.QuackCounter;
import com.hef.design11.factory.AbstractDuckFactory;
import com.hef.design11.factory.CountingDuckFactory;
import com.hef.design11.gooses.Goose;
import com.hef.design11.observer.Quackologist;

/**
 * @Date 2019-06-14
 * @Author lifei
 */
public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }


    private void simulate(AbstractDuckFactory duckFactory) {
        // 装饰模式
        // 工厂模式
        Quackable mallardDuck = duckFactory.createMallardDuck();//new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = duckFactory.createRedheadDuck();//new QuackCounter(new RedheadDuck());
        Quackable duckCall = duckFactory.createDuckCall();//new QuackCounter(new DuckCall());
        Quackable rubberDuck = duckFactory.createRubberDuck();//new QuackCounter(new RubberDuck());

        // 适配器模式
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator: With Composite - Flocks");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);


        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);


        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);


        simulate(flockOfDucks);

//        System.out.println("\nDuck Simulator");
//
//        simulate(mallardDuck);
//        simulate(redHeadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times.");

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
