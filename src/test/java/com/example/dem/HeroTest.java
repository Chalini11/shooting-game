package com.example.dem;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


@SpringBootTest(classes = Hero.class)
public class HeroTest
{
    @BeforeEach
    void initBeforeEach()
    {
        hero.setHealth(100);
    }
    @Autowired
    Hero hero;

    //why autowire here it can be dependent right???

    @Test
    void shouldChangeHealth()
    {
        int reducedHealth = 80;
        hero.damage();
        assertThat(hero.getHealth(),is(equalTo(reducedHealth)));
    }

    @Test
    void shouldTestForGetHealth()
    {
        // why is this happening after the other testcase
        int beginHealth = 100;
        assertThat(hero.getHealth(),is(equalTo(beginHealth)));
    }

}
