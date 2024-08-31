package hello.hello_spring;

import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberSerivce;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//    private final EntityManager em;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
//        this.dataSource = dataSource;
//        this.em = em;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberSerivce memberSerivce() {
        return new MemberSerivce(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//    }
}