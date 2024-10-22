package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	TaskRepo taskRepo;

	@RequestMapping("delete{taskid}")
	public int delete(@PathVariable int taskid)
	{
		try {
			taskRepo.deleteById(taskid);
			return 1;
			
		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		}
	}
	
	@RequestMapping("read{id}")
	public List<Task> read(@PathVariable int id) {
		try {

			return taskRepo.findByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("login{username}")
	public int login(@RequestBody String password, @PathVariable String username) {
		try {

			int cnt = userRepo.countByUsername(username);
			if (cnt == 0) {
				return -2;
			}
			if (cnt > 1) {
				return -3;

			}
			User user = userRepo.findByUsername(username);
			if (user.getPassword().equals(password)) {
				return user.getId();

			} else {
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;

		}
	}

	@RequestMapping("add{id}")
	public Task add(@PathVariable int id, @RequestBody String details) {
		try {
			Task task = new Task();
			User user = userRepo.findById(id).get();

			task.setDetails(details);
			task.setUser(user);
			return taskRepo.save(task);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
