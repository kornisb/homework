package hu.kornis.personservice;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import hu.kornis.personservice.config.TestDatabaseConfig;
//import hu.kornis.personservice.model.Address;
//import hu.kornis.personservice.model.Contact;
//import hu.kornis.personservice.model.Person;
//
//@SpringBootTest(classes = {TestDatabaseConfig.class})
//@AutoConfigureMockMvc(print = MockMvcPrint.SYSTEM_OUT)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
public class PersonControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testGetAllPersons() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/persons/get/all"))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$").isArray());
//    }
//    
//    @Test
//    public void testGetPersonByIdNonExistingId() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/persons/get/999999"))
//               .andExpect(status().isNotFound());
//    }
//
//
//    @Test
//    public void testGetPersonByIdExistingId() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/persons/get/1"))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$").isNotEmpty());
//    }
//    
//    @Test
//    public void testAddPerson() throws Exception {
//        Person person = new Person();
//        person.setFirstName("Andras");
//        person.setLastName("Kovacs");
//        Address address = new Address();
//        address.setAddress("1111 Budapest, Fo ut 1");
//        address.setAddressType("Permanent");
//        List<Address> addresses = Arrays.asList(address);
//        Contact contact = new Contact();
//        contact.setContact("+36301234567");
//        contact.setContactType("Phone");
//        List<Contact> contacts = Arrays.asList(contact);
//        person.setAddresses(addresses);
//        person.setContacts(contacts);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/persons/add")
//                                              .contentType(MediaType.APPLICATION_JSON)
//                                              .content(objectMapper.writeValueAsString(person)))
//               .andExpect(status().isCreated())
//               .andExpect(jsonPath("$").isNotEmpty());
//    }
//
//    @Test
//    public void testUpdatePersonByIdExistingId() throws Exception {
//    	Person person = new Person();
//        person.setFirstName("Andras");
//        person.setLastName("Kovacs");
//        Address address = new Address();
//        address.setAddress("1111 Budapest, Fo ut 1");
//        address.setAddressType("Permanent");
//        List<Address> addresses = Arrays.asList(address);
//        Contact contact = new Contact();
//        contact.setContact("+36301234567");
//        contact.setContactType("Phone");
//        List<Contact> contacts = Arrays.asList(contact);
//        person.setAddresses(addresses);
//        person.setContacts(contacts);
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/persons/update/1")
//                                              .contentType(MediaType.APPLICATION_JSON)
//                                              .content(objectMapper.writeValueAsString(person)))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$").isNotEmpty());
//    }
//
//    @Test
//    public void testUpdatePersonByIdNonExistingId() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.put("/persons/update/999999")
//                                              .contentType(MediaType.APPLICATION_JSON)
//                                              .content(objectMapper.writeValueAsString(new Person())))
//               .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void testDeletePersonByIdExistingId() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/persons/delete/1"))
//               .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void testDeletePersonByIdNonExistingId() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/persons/delete/999999"))
//               .andExpect(status().isNotFound());
//    }
}
