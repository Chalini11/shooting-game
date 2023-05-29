package com.example.dem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShootingController {
    @Autowired
    public ShootingService shootingService;
    @GetMapping("/health")
    @ResponseBody  // why need this??
    public int getHealth(@RequestParam int who)
    {
        if(who==1)
            return shootingService.getHealth(1);
        else if(who==2)
            return shootingService.getHealth(2);
        else return 0;
    }
    @PostMapping("/shootDamage")
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public void postAfterShoot(@RequestParam String who)
    {
        if(who=="hero") // Do u think equals is better that ==
            shootingService.postShooting("hero");
        else if(who=="villain")
            shootingService.postShooting("villain");

    }

    @PostMapping("/armour")
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public void toggleArmour()
    {
        shootingService.toggleArmour();
    }


}
