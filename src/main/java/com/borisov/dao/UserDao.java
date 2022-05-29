package com.borisov.dao;

import com.borisov.hero.EnableProfiling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@EnableProfiling
public class UserDao {

    @Autowired
    public UserDao() {
    }

    public void findAll() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
