package com.crowdsourcing.config;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.crowdsourcing.dao.TaskDAO;
import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.User;
import com.crowdsourcing.model.Worker;
import com.crowdsourcing.service.ClientService;
import com.crowdsourcing.service.SystemService;
import com.crowdsourcing.service.UserService;
import com.crowdsourcing.service.WorkerService;

public class Executor {
	
	public static void main(String[] args) throws CoreException{
		//String [] ctx = new String[]{"app-context.xml"};
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//ApplicationContext context = new ClassPathXmlApplicationContext(ctx,context1);
		//ServiceClass bean = context.getBean();
		
		//MongoOperations mongoOperation = (MongoOperations) context.getBean("mongoTemplate");
		User user = new User();
		user.setFirstName("vishal");
		user.setLastName("Singh");
		user.setPassword("pass");
		user.setEmail("vishl@newgen.co.in");
		user.setPhoneNumber("123456789");
		user.setAbout("Automobile Domain Client");
		user.setUserCreationDate(new java.util.Date());
		user.setActive(true);
		
		Client client  = new Client();
		client.setDetails(user);				
				
		Worker worker = new Worker();
		worker.setDetails(user);
		worker.setSkills("Java, html, CSS");
		worker.setWorkerLocation("India");
		worker.setWorkExperience(10.0);
		ClientService clientService = (ClientService)context.getBean("clientService");
		WorkerService workerService = (WorkerService)context.getBean("workerService");
		SystemService systemService = (SystemService)context.getBean("systemService");
		
		//Client client1 = clientService.getById("56e44ea4fee2bc0ff49fa749");
		System.out.println(workerService.signUp(worker));
		//System.out.println(clientService.signIn("vishl@newgen.co.in", "pass1"));
		//System.out.println(clientService.updateClient(client1));
		
		/*Task task = new Task();
		task.setTaskDescription("Baby sitting");
		//clientService.createTask(task, client1.getClientId());
		
		String taskId = "56e45a4dfee2bc05045dc175";
		//clientService.submitRatings(0.5, taskId);
		
		
		Worker worker1= new Worker();
		worker1.setWorkerLocation("Delhi");
		worker1.setSkills("java,english,paint");
		worker1.setWorkCredibility(1.0);
		
		Worker worker2= new Worker();
		worker2.setWorkerLocation("Chandigarh");
		worker2.setSkills("java,cook,shoe");
		worker2.setWorkCredibility(0.7);
		
		Worker worker3= new Worker();
		worker3.setWorkerLocation("Lucknow");
		worker3.setSkills("english,teach,maths");
		worker3.setWorkCredibility(0.2);
		
		Task task1 = new Task();
		task1.setRequiredCredibiliy(0.5);
		task1.setRequiredSkills("english");
		task1.setRequiredSkills("abc");
		
		task1.setTaskLocation("delhi");
		
		clientService.createTask(task1, client1.getClientId());
		workerService.signUp(worker1);
		workerService.signUp(worker2);
		workerService.signUp(worker3);
		
		List<Worker> workers= systemService.getPotentialWorkers(task1);
		System.out.println(workers.size());
		for(Worker worker : workers){
			System.out.println(worker.getWorkerId() +" "+worker.getSkills()+" "+worker.getWorkCredibility());	
		}*/
		
	}

}
