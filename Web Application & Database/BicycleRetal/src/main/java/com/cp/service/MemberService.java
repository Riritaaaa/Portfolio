package com.cp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.entity.Bicycle;
import com.cp.entity.Member;
import com.cp.repository.MemberRepository;


@Service
public class MemberService {
	@Autowired
	private MemberRepository memRepo;
	
	public boolean isExistByMemberId(String memId) {
		Optional mem = memRepo.findById(memId);
		return mem.isEmpty();
	}
	
	public List<Member> findAllMember(){
		return (List<Member>) memRepo.findAll();
	}

	public Member findMemberById(String memId) {
		return (Member) memRepo.findById(memId).get();
	}
	
	public void saveMember(Member mem) {
		memRepo.save(mem);
	}
	
	public void deleteMember(String memId) {
		Member mem = memRepo.findById(memId).get();
		memRepo.delete(mem);
	}
	public String getNextId() {
		String nextId;
		List<Member> memList = this.findAllMember();
		if (memList.size() > 0) {
			String lId = memList.get(memList.size() - 1).getId();
			int lastId = Integer.parseInt(lId.substring(1));
			nextId = String.format("M%03d", lastId + 1);
		} else {
			System.out.println("New");
			nextId = "M001";
		}
		return nextId;
	}
}
