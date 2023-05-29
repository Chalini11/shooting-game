package com.example.dem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShootingService {

    @Autowired
    Hero hero;
    @Autowired
    Villain villain;

    public int getHealth(int character)
    {
        if(character==1)
            return hero.getHealth();
        else if(character==2)
            return villain.getHealth();
        return 0;
    }


    public void postShooting(String whoWasShot) // 'who' is who is being shot and is losing health
    {
        System.out.println("hi party");
        if(whoWasShot.equals("hero"))
           {
               hero.damage();
           }
        else if(whoWasShot.equals("villain"))
           {
               villain.damage();
           }

    }

    public void toggleArmour()
    {
        villain.setArmour(true);
    }
}
