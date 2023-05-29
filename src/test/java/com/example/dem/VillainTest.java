package com.example.dem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@SpringBootTest(classes = Villain.class)
public class VillainTest
{
    @Autowired
    Villain villain;

    @BeforeEach
    void initBeforeEach()
    {
        villain.setHealth(100);
        villain.setArmour(false);

    }

    @Test
    void shouldTestForGetHealth()
    {
        // why is this happening after the other testcase
        int beginHealth = 100;
        assertThat(villain.getHealth(),is(equalTo(beginHealth)));
    }

    @Test
    void shouldTestForChangeHealth()
    {
        int reducedHealth = 80;
        villain.damage();
        assertThat(villain.getHealth(),is(equalTo(reducedHealth)));
    }

    @Test
    void shouldTestForChangeHealthWhenArmourIsTrue()
    {
        int reducedHealth = 90;
        villain.setArmour(true);
        villain.damage();
        assertThat(villain.getHealth(),is(equalTo(reducedHealth)));
    }
}
