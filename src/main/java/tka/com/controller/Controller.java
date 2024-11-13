package tka.com.controller;

import java.util.ArrayList;
import java.util.List;

import tka.com.entity.*;

import tka.com.service.*;

public class Controller {
	static Service s = null;
	List<Candidate> candidate = null;

	
	public String addCandidate(int cid, String name, String gender, String party, String state, String assembly,
			int age) {
		s = new Service();
		String res = s.addCandidate(cid, name, gender, party, state, assembly, age);

		return res;
	}

	public List<Candidate> getAllCandidate() {
		
		candidate = new ArrayList<Candidate>();
		s = new Service();
		candidate = s.getAllCandidate();
		return candidate;

	}

	public List<Candidate> getCandidateByParty(String party) {
		s = new Service();
		candidate = new ArrayList<Candidate>();
		candidate = s.getCandidateByParty(party);

		return candidate;
	}

	public List<Candidate> getCandidateByGender(String gender) {
		s = new Service();
		candidate = new ArrayList<Candidate>();
		candidate = s.getCandidateByGender(gender);

		return candidate;
	}

	public List<Candidate> getCandidateByAssembly(String assembly) {
		s = new Service();
		candidate = new ArrayList<Candidate>();
		candidate = s.getCandidateByAssembly(assembly);

		return candidate;
	}

	
	public static String updateCandidateData(int oldcid, int updatedcid, String name, String party, String assembly) {
		s = new Service();
		String res = s.updateCandidateData(oldcid, updatedcid, name, party, assembly, updatedcid);
		return res;
	}

	
	public static String deleteCadidate(int id) {
		s = new Service();
		String res = s.deleteCandidate(id);

		return res;
	}

}