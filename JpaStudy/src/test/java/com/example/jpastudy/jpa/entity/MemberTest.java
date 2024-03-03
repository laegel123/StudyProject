package com.example.jpastudy.jpa.entity;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    EntityManager em;

    @Test
    public void primaryKeyTest() {
        MemberPK memberPK = new MemberPK();
        memberPK.setMemberId(1);
        memberPK.setPhone(01011112222);

        Member member = new Member();
        member.setMemberId(1);
        member.setPhone(01011112222);
        member.setName("laegel");

        em.persist(member);
        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, memberPK);

        assertEquals(member, findMember);

    }
}
