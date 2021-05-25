package com.cg.App.Tata;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.App.Tata.Module.Account;
import com.cg.App.Tata.Module.Pack;
import com.cg.App.Tata.Module.Recharge;
import com.cg.App.Tata.Module.ServiceRequest;
import com.cg.App.Tata.Module.User;
import com.cg.App.Tata.Repository.IAccountRepository;
import com.cg.App.Tata.Repository.IRechargeRepository;
import com.cg.App.Tata.Repository.IServiceRequestRepository;
import com.cg.App.Tata.Repository.IUserRepository;
import com.cg.App.Tata.Repository.IPackRepository;


@SpringBootApplication
public class AppTataApplication implements CommandLineRunner {
	
	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRechargeRepository rechargeRepository;
	
	@Autowired
	private IServiceRequestRepository serviceRepository;
	
	@Autowired
	private  IPackRepository packRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(AppTataApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside run");
		
	//insert	
		//Account object
				Account a=new Account();
				a.setAccountId(12345);
				a.setRegisteredDate(LocalDate.of(2021,05,22));
				
		//User object
				User u=new User();
				u.setId(12345678);
				u.setFirstName("syugf");
				u.setLastName("reddyy");
				u.setUsername("project");
				u.setRole("intern");
				
	 //Recharge Object
				Recharge r1 = new Recharge();
				r1.setId(156);
				r1.setAmount(10000);
				r1.setDaysValidity(30);
				r1.setPlanDescription("nothing much");
				r1.setPlanName("project");
				r1.setPurchasedDate(LocalDate.of(2021, 05, 22));
				
				
				Recharge r2 = new Recharge();
				r2.setId(157);
				r2.setAmount(20000);
				r2.setDaysValidity(30);
				r2.setPlanDescription("nothing more");
				r2.setPlanName("project1");
				r2.setPurchasedDate(LocalDate.of(2021, 05, 22));
				
				
				Recharge r3 = new Recharge();
				r3.setId(158);
				r3.setAmount(30000);
				r3.setDaysValidity(30);
				r3.setPlanDescription("nothing");
				r3.setPlanName("project2");
				r3.setPurchasedDate(LocalDate.of(2021, 05, 22));
				
				
				
				List<Recharge> l1 = new ArrayList<Recharge>();
				l1.add(r1);
				l1.add(r2);
				l1.add(r3);
				
				
	  //Service-Request object
				ServiceRequest s1=new ServiceRequest();
				s1.setId(9874);
				s1.setMessage("error1");
				s1.setRequestedDate(LocalDate.of(2021, 05, 22));
				s1.setStatusOpened(false);
				
				
				ServiceRequest s2=new ServiceRequest();
				s2.setId(98746);
				s2.setMessage("error2");
				s2.setRequestedDate(LocalDate.of(2021, 05, 22));
				s2.setStatusOpened(false);
				
				 List<ServiceRequest> l2= new ArrayList<ServiceRequest>();
				 l2.add(s1);
				 l2.add(s2);
				
				
				
				
	//pack object			
				Pack p=new Pack();
				p.setCost(10001);
				p.setDaysValidity(31);
				p.setDescription("Plan has activated");
				p.setId(33);
				p.setPlanName("internship");
				
								
				Account a1=new Account();
				a1.setAccountId(987459);
				a1.setRegisteredDate(LocalDate.of(2021,05,22));
	
				List<Account> la1=new ArrayList<Account>();
				la1.add(a);
				la1.add(a1);
				
				
				a.setRecharges(l1);
			    a.setUser(u);
			    a.setRequests(l2);
			    
				u.setAccount(a);
				
				r1.setAccount(a);
				r2.setAccount(a);
				r3.setAccount(a);
				
				s1.setAccount(a);
				s2.setAccount(a);
				
				a.setCurrentPack(p);
				a1.setCurrentPack(p);
				
				p.setAccount(la1);
				
			    a.setCurrentPack(p);
				a1.setCurrentPack(p);
				
				accountRepository.save(a);
				userRepository.save(u);
				rechargeRepository.saveAll(l1);
				serviceRepository.saveAll(l2);
				
				packRepository.save(p);
				accountRepository.saveAll(la1);
		
	
				Account a2=accountRepository.findById((long) 12345).get();
				//update			
							a2.getUser().setFirstName("client");
				
							accountRepository.save(a2);
				//retrieve			
							System.out.println(a2);
							System.out.println(a2.getUser());				
							System.out.println(a2.getRecharges());
							System.out.println(a2.getRequests());
							System.out.println(a2.getCurrentPack());
				
				accountRepository.deleteById((long) 12345);
				userRepository.deleteById((long) 12345678);
				User u2=userRepository.findById((long) 12345678).get();
				System.out.println(u2);
				
				rechargeRepository.deleteById((long) 156);
				serviceRepository.deleteById((long) 9874);
				packRepository.deleteById((long) 33);
				
				
				
				
	
	}
}
	

