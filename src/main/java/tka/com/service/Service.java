package tka.com.service;

import java.util.ArrayList;
import java.util.List;

import tka.com.dao.Dao;
import tka.com.entity.Candidate;

public class Service {
    private Dao d = new Dao();
    
    // Add candidate
    public String addCandidate(int cid, String name, String gender, String party, String state, String assembly, int age) {
        return d.addCandidate(cid, name, gender, party, state, assembly);
    }

    // Get all candidates
    public List<Candidate> getAllCandidate() {
        return d.getAllCandidate();
    }

    // Filter candidates by party
    public List<Candidate> getCandidateByParty(String party) {
        List<Candidate> candidatesByParty = new ArrayList<>();
        for (Candidate candidate : d.getAllCandidate()) {
            if (candidate.getParty().equalsIgnoreCase(party)) {
                candidatesByParty.add(candidate);
            }
        }
        return candidatesByParty;
    }

    // Filter candidates by gender
    public List<Candidate> getCandidateByGender(String gender) {
        List<Candidate> candidatesByGender = new ArrayList<>();
        for (Candidate candidate : d.getAllCandidate()) {
            if (candidate.getGender().equalsIgnoreCase(gender)) {
                candidatesByGender.add(candidate);
            }
        }
        return candidatesByGender;
    }

    // Filter candidates by assembly
    public List<Candidate> getCandidateByAssembly(String assembly) {
        List<Candidate> candidatesByAssembly = new ArrayList<>();
        for (Candidate candidate : d.getAllCandidate()) {
            if (candidate.getAssembly().equalsIgnoreCase(assembly)) {
                candidatesByAssembly.add(candidate);
            }
        }
        return candidatesByAssembly;
    }

    // Update candidate data
    public String updateCandidateData(int oldCid, int updatedCid, String name, String party, String assembly, int age) {
        String res = null;
        boolean found = false;
        for (Candidate candidate : d.getAllCandidate()) {
            if (oldCid == candidate.getCid()) {  // Ensure `getCid()` matches the Candidate class
                found = true;
                res = d.updateCandidateData(oldCid, updatedCid, name, party, assembly);
                break;
            }
        }
        if (!found) {
            res = "This candidate ID does not exist";
        }
        return res;
    }

    // Delete a candidate
    public String deleteCandidate(int id) {
        return d.deleteCandidate(id);
    }
}
