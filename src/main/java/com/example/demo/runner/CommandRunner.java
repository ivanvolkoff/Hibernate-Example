package com.example.demo.runner;

import com.example.demo.entity.Adress;
import com.example.demo.entity.User;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Ivan");
        user.setLast_Name("Volkov");
        Adress adress = new Adress();
        adress.setDescription("Primary Adress");
        userRepository.save(user);
        adress.setUser(user);
        adressRepository.save(adress);

        User user2 = new User();
        user.setFirstName("Petar");
        user.setLast_Name("Nikolov");
        Adress adress2 = new Adress();
        adress2.setDescription("Primary Adress");
        userRepository.save(user2);
        adress.setUser(user2);
        adressRepository.save(adress2);

        lazyExample();
    }

    public void lazyExample(){
        User user =  userRepository.findById(1L).orElse(null);
        System.out.println(user);
        for (Adress addres: user.getAdress()) {
            System.out.println(addres.getId()+ addres.getDescription());
        }
        System.out.println("==============================");
    }
}
