package com.progex.hris.user;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@Mock
	private RoleRepository roleRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1,"indunil","123","Indunil","Moremada","861481131v","Kandy","imoremada@gmaillcom", new Date(1986, 5, 27), true, new Role(), new ArrayList<Designation>(), new ArrayList<ContactNumber>()));
		userList.add(new User(2,"kamal","346","Kamal","Senarath","871481132v","Galle Rd, Colombo 5","ks@gmaillcom", new Date(1985, 8, 17), true, new Role(), new ArrayList<Designation>(), new ArrayList<ContactNumber>()));
		when(userRepository.findAll()).thenReturn(userList);
		
		List<User> result = userServiceImpl.getAllUsers();
		assertEquals(2, result.size());
	}
	
	@Test 
	public void testGetUser() {
		
		List<User> userList = new ArrayList<User>();
		User u1 = new User(1,"indunil","123","Indunil","Moremada","861481131v","Kandy","imoremada@gmaillcom", new Date(1986, 5, 27), true, new Role(), new ArrayList<Designation>(), new ArrayList<ContactNumber>());
		User u2 = new User(2,"kamal","346","Kamal","Senarath","871481132v","Galle Rd, Colombo 5","ks@gmaillcom", new Date(1985, 8, 17), true, new Role(), new ArrayList<Designation>(), new ArrayList<ContactNumber>());
		userList.add(u1);
		userList.add(u2);
		when(userRepository.findOne(1L)).thenReturn(u1);
		
		User user = userServiceImpl.getUser(1);
		assertEquals(user.getId(), u1.getId());
		assertEquals(user.getUserName(), u1.getUserName());
	}
	
	@Test
	public void testAddUser() {
		
		User u1 = new User(1,"indunil","123","Indunil","Moremada","861481131v","Kandy","imoremada@gmaillcom", new Date(1986, 5, 27), true, new Role(), new ArrayList<Designation>(), new ArrayList<ContactNumber>());
		when(userRepository.save(u1)).thenReturn(u1);
		
		User u = userServiceImpl.addUser(u1);
		assertEquals(1, u.getId());
		assertEquals("indunil", u.getUserName());
	}
	
	@Test
	public void testRemoveUser() {
		User u1 = new User(1,"indunil","123","Indunil","Moremada","861481131v","Kandy","imoremada@gmaillcom", new Date(1986, 5, 27), true, new Role(), new ArrayList<Designation>(), new ArrayList<ContactNumber>());
		userServiceImpl.deleteUser(1L);
		verify(userRepository, times(1)).delete(1L);		
	}
	
	@Test 
	public void testGetUserByUserName() {
		User u1 = new User(1,"indunil","123","Indunil","Moremada","861481131v","Kandy","imoremada@gmaillcom", new Date(1986, 5, 27), true, new Role(), new ArrayList<Designation>(), new ArrayList<ContactNumber>());
		when(userRepository.findByUserName("indunil")).thenReturn(u1);
		
		User user = userServiceImpl.getUserByUserName("indunil");
		assertEquals(1L, user.getId());
		assertEquals("indunil", user.getUserName());
	}
}
