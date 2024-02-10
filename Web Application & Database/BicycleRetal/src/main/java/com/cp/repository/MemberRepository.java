package com.cp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cp.entity.Member;


public interface MemberRepository extends CrudRepository<Member, String> {

}
