package com.poc.aim.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.aim.exception.ResourceNotFoundException;
import com.poc.aim.model.Bovine;
import com.poc.aim.repository.BovineRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BovineController {
	@Autowired
	private BovineRepository bovineRepository;

	@GetMapping("/bovine")
	public List<Bovine> getAllBovine() {
		return bovineRepository.findAll();
	}

	
	@GetMapping("/bovine/{id}")
	public ResponseEntity<Bovine> getBovineById(@PathVariable(value = "id") Long bovineId)
			throws ResourceNotFoundException {
		Bovine bovine = bovineRepository.findById(bovineId)
				.orElseThrow(() -> new ResourceNotFoundException("Bovine not found for this id :: " + bovineId));
		return ResponseEntity.ok().body(bovine);
	}

	@PostMapping("/bovine")
	public Bovine createBovine(@Valid @RequestBody Bovine bovine) {
		return bovineRepository.save(bovine);
	}

	@PutMapping("/bovine/{id}")
	public ResponseEntity<Bovine> updateBovine(@PathVariable(value = "id") Long bovineId,
			@Valid @RequestBody Bovine bovineDetails) throws ResourceNotFoundException {
		Bovine bovine = bovineRepository.findById(bovineId)
				.orElseThrow(() -> new ResourceNotFoundException("Bovine not found for this id :: " + bovineId));

		bovine.setThirdParty(bovineDetails.getThirdParty());
		bovine.setMovedTo(bovineDetails.getMovedTo());
		bovine.setMovedFrom(bovineDetails.getMovedFrom());
		final Bovine updatedBovine = bovineRepository.save(bovine);
		return ResponseEntity.ok(updatedBovine);
	}

	@DeleteMapping("/bovine/{id}")
	public Map<String, Boolean> deleteBovine(@PathVariable(value = "id") Long bovineId)
			throws ResourceNotFoundException {
		Bovine bovine = bovineRepository.findById(bovineId)
				.orElseThrow(() -> new ResourceNotFoundException("Bovine not found for this id :: " + bovineId));

		bovineRepository.delete(bovine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
