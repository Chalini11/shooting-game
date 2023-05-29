package com.example.dem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class) // in order to use inject mocks..find out why later
public class ShootingServiceTest
{
   //inject mock --> will mock your methods . we mock the dependencies and not the functionality.

    @InjectMocks
    private ShootingService shootingService;

    @Mock
    private Hero hero;
    @Mock
    private Villain villain;

     // if I call getHealth() of service will it return a value
    @Test
    public void shouldReturnHealthValueForHero()
    {
        // 100 can be stored in a variable called "your mocked data"
        // can be defined using beforeEach                          22a
        Mockito.when(hero.getHealth()).thenReturn(100);
        int value = shootingService.getHealth(1);
        assertThat(value,is(equalTo(100)));

    }
    @Test
    public void shouldReturnHealthValueForVillain()
    {
        Mockito.when(villain.getHealth()).thenReturn(100);
        int value = shootingService.getHealth(2);
        assertThat(value,is(equalTo(100)));

    }

    @Test
    public void shouldInvokeDamageForVillain()
    {
        Mockito.doNothing().when(villain).damage();
        shootingService.postShooting("villain");
        verify(villain).damage();
    }

    @Test
    public void shouldInvokeDamageForHero()
    {
        Mockito.doNothing().when(hero).damage();
        shootingService.postShooting("hero");
        verify(hero).damage();

    }

    @Test
    void shouldInvokeToggle()
    {
        Mockito.doNothing().when(villain).setArmour(true); // this doNothing how is the inner mocking happening
        shootingService.toggleArmour();
        verify(villain).setArmour(true);
    }



}
