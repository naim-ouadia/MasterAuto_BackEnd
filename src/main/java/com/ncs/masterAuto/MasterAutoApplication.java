package com.ncs.masterAuto;

import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MasterAutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterAutoApplication.class, args);

    }

//    @Bean
//    CommandLineRunner start(AccountService accountService) {
//        return args -> {
//            accountService.saveRole(new RoleUser("USER", null));
//            accountService.saveRole(new RoleUser("Admin", null));
//            Stream.of("user1", "user2", "user3", "admin").forEach(un -> {
//                accountService.saveUser(un, "1234", "1234");
//            });
//
//        };
//    }

    @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

}
