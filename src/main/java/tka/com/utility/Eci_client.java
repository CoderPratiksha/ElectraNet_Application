package tka.com.utility;

import java.util.List;

import tka.com.controller.Eci_controller;
import tka.com.entity.Candidate;

public class Eci_client {

	public static void main(String[] args) {
		
		Eci_controller c1 = new Eci_controller();
		List<Candidate> allcandidate = c1.getAllCandidate();
	}
}
