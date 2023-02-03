package com.masai.junitTest;

import com.masai.junit.Contact;
import com.masai.junit.ContactManager;
import org.junit.jupiter.api.*;

public class ContactManagerTest {
    static ContactManager manager ;

    @BeforeAll
    public static void setUp(){
        manager=new ContactManager();

    }

	@Test
	@DisplayName("Should Create Contact")
    void createContact(){
        Contact contact = new Contact("Kanishka","Shrivastava","0912327018");
        manager.addContact(contact);

        Assertions.assertNotNull(manager.getAllContacts());

    }

    @Test
	@DisplayName("Should Not Create Contact When First Name is Null")
    void notNullFName(){
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{manager.addContact(new Contact("","Verma","7854356345"));});
    }

	@Test
    @DisplayName("Phone Number should start with 0")
    void checkNo(){
        Contact contact = new Contact("Aman","Sinha","366854577");
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{manager.addContact(contact);});


    }

	@AfterAll
    public static void setNull(){
        manager = null;
    }

}
