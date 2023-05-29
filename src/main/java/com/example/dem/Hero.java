package com.example.dem;

import org.springframework.stereotype.Component;

@Component
public class Hero {

    int count=0;
    int health=100;

    public int getHealth()
    {
        count++;
        System.out.println(count);
        System.out.println(this.health);
        return health;
    }

    // this damage functionality should be in service is preferred
    public void damage()
    {
        count++;
        System.out.println(count);
        System.out.println(this.health);
        this.health=this.health-20;
        System.out.println(this.health);
        count++;
        System.out.println(count);
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

