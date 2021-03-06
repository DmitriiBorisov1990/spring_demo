package com.borisov.hero.ano;

import com.borisov.hero.Weapon;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component
public class SwordAno implements Weapon {

    @Autowired()
    private String name;

    public SwordAno(){}

    @Override
    public int getDamage() {
        return 7;
    }
}
