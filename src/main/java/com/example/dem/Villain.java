package com.example.dem;

import org.springframework.stereotype.Component;

@Component
public class Villain extends Hero {

    boolean armour=false;


    public boolean getArmour()
    {
        return armour;
    }
    public void setArmour(boolean value) {
        armour=value;

    }
    @Override
    public void damage()
    {
        if(armour)
            health=health-10;
        else
            health=health-20;

    }


}
