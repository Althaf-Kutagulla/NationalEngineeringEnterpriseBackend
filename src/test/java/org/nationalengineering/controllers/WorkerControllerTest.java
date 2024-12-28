package org.nationalengineering.controllers;

import org.junit.jupiter.api.Test;
import org.nationalengineering.constants.WorkingStatus;
import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.records.WorkerResponse;
import org.nationalengineering.security.SecurityConfig;
import org.nationalengineering.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = { WorkerController.class })
@Import(SecurityConfig.class)
@ImportAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class})
public class WorkerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WorkerService workerService;


    @Test
    public void createWorkerTest() throws Exception {

        when(workerService.createWorker(any(WorkerRequest.class))).thenReturn(12);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/workers/create")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())
                .content("{\n" +
                        "    \"firstName\": \"Ravi\",\n" +
                        "    \"lastName\": \"Charan\",\n" +
                        "    \"phoneNumber\": \"4567890123\",\n" +
                        "    \"alterPhoneNumber\": \"3987654321\",\n" +
                        "    \"town\": \"Anantapur\",\n" +
                        "    \"village\": \"Akam Palle\",\n" +
                        "    \"address\": \"321 Pine Rd\",\n" +
                        "    \"workingStatus\": \"WORKING\"\n" +
                        "}");

        mockMvc.perform(request)
                .andExpect(content().string("12"))
                .andExpect(status().isCreated())
                .andReturn();
    }


    @Test
    public void getWorkerTest() throws Exception {
        WorkerResponse worker = new WorkerResponse(
                2,
                "Priya",
                "Sharma",
                "8765432198",
                "7654321987",
                "Chennai",
                "Tambaram",
                "456 Anna Nagar",
                WorkingStatus.WORKING, // Assuming WorkingStatus is an enum
                LocalDateTime.of(2023, 12, 1, 9, 0),
                null // leftDate is null
        );
        when(workerService.getWorkerById(anyInt())).thenReturn(worker);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/workers/{id}",2)
                        .accept(MediaType.APPLICATION_JSON)
                .with(csrf());
        mockMvc.perform(request)
                .andExpect(content().json("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"firstName\": \"Priya\",\n" +
                        "    \"lastName\": \"Sharma\",\n" +
                        "    \"phoneNumber\": \"8765432198\",\n" +
                        "    \"alterPhoneNumber\": \"7654321987\",\n" +
                        "    \"town\": \"Chennai\",\n" +
                        "    \"village\": \"Tambaram\",\n" +
                        "    \"address\": \"456 Anna Nagar\",\n" +
                        "    \"workingStatus\": \"WORKING\",\n" +
                        "    \"joinedDate\": \"2023-12-01T09:00:00\",\n" +
                        "    \"leftDate\": null\n" +
                        "}"))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void getAllWorkerTest() throws Exception {
        List<WorkerResponse> workerResponses = List.of(
                new WorkerResponse(1, "Rajesh", "Kumar", "9876543210", "8765432109", "Bangalore", "Kumbalgodu", "123 MG Road", WorkingStatus.WORKING, LocalDateTime.of(2024, 1, 15, 10, 0), null),
                new WorkerResponse(2, "Priya", "Sharma", "8765432198", "7654321987", "Chennai", "Tambaram", "456 Anna Nagar", WorkingStatus.WORKING, LocalDateTime.of(2023, 12, 1, 9, 0), null),
                new WorkerResponse(3, "Amit", "Patel", "7654321098", "6543210987", "Ahmedabad", "Bopal", "789 CG Road", WorkingStatus.NOT_WORKING, LocalDateTime.of(2023, 11, 20, 10, 0), LocalDateTime.of(2024, 5, 30, 17, 0)),
                new WorkerResponse(4, "Sneha", "Reddy", "6543210987", "5432109876", "Hyderabad", "Shamirpet", "101 Jubilee Hills", WorkingStatus.WORKING, LocalDateTime.of(2024, 2, 5, 10, 30), null),
                new WorkerResponse(5, "Vikram", "Singh", "5432109876", "4321098765", "Jaipur", "Amer", "202 Pink City Road", WorkingStatus.NOT_WORKING, LocalDateTime.of(2023, 8, 10, 9, 45), LocalDateTime.of(2024, 3, 25, 18, 0)),
                new WorkerResponse(6, "Anjali", "Verma", "4321098765", "3210987654", "Delhi", "Dwarka", "303 Connaught Place", WorkingStatus.WORKING, LocalDateTime.of(2024, 3, 1, 11, 0), null),
                new WorkerResponse(7, "Rohit", "Mehta", "3210987654", "2109876543", "Mumbai", "Andheri", "404 Marine Drive", WorkingStatus.NOT_WORKING, LocalDateTime.of(2023, 10, 15, 8, 30), LocalDateTime.of(2024, 6, 20, 19, 0)),
                new WorkerResponse(8, "Deepika", "Gupta", "2109876543", "1098765432", "Kolkata", "Salt Lake", "505 Park Street", WorkingStatus.WORKING, LocalDateTime.of(2024, 4, 10, 9, 15), null),
                new WorkerResponse(9, "Karan", "Joshi", "1098765432", "1987654321", "Pune", "Hinjewadi", "606 FC Road", WorkingStatus.WORKING, LocalDateTime.of(2023, 11, 1, 10, 45), null),
                new WorkerResponse(10, "Meera", "Iyer", "1987654321", "9876543210", "Coimbatore", "Peelamedu", "707 Race Course Road", WorkingStatus.NOT_WORKING, LocalDateTime.of(2023, 12, 20, 9, 30), LocalDateTime.of(2024, 7, 10, 17, 30)),
                new WorkerResponse(11, "Ravi", "Charan", "4567890123", "3987654321", "Anantapur", "Akam Palle", "321 Pine Rd", WorkingStatus.WORKING, LocalDateTime.of(2024, 12, 26, 8, 50, 50, 176281000), null),
                new WorkerResponse(12, "Ravi", "Charan", "4567890123", "3987654321", "Anantapur", "Akam Palle", "321 Pine Rd", WorkingStatus.WORKING, LocalDateTime.of(2024, 12, 26, 9, 25, 26, 621217000), null)
        );
        when(workerService.getAllWorkers()).thenReturn(workerResponses);

        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/workers")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"firstName\": \"Rajesh\",\n" +
                        "        \"lastName\": \"Kumar\",\n" +
                        "        \"phoneNumber\": \"9876543210\",\n" +
                        "        \"alterPhoneNumber\": \"8765432109\",\n" +
                        "        \"town\": \"Bangalore\",\n" +
                        "        \"village\": \"Kumbalgodu\",\n" +
                        "        \"address\": \"123 MG Road\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2024-01-15T10:00:00\",\n" +
                        "        \"leftDate\": null\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"firstName\": \"Priya\",\n" +
                        "        \"lastName\": \"Sharma\",\n" +
                        "        \"phoneNumber\": \"8765432198\",\n" +
                        "        \"alterPhoneNumber\": \"7654321987\",\n" +
                        "        \"town\": \"Chennai\",\n" +
                        "        \"village\": \"Tambaram\",\n" +
                        "        \"address\": \"456 Anna Nagar\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2023-12-01T09:00:00\",\n" +
                        "        \"leftDate\": null\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"firstName\": \"Amit\",\n" +
                        "        \"lastName\": \"Patel\",\n" +
                        "        \"phoneNumber\": \"7654321098\",\n" +
                        "        \"alterPhoneNumber\": \"6543210987\",\n" +
                        "        \"town\": \"Ahmedabad\",\n" +
                        "        \"village\": \"Bopal\",\n" +
                        "        \"address\": \"789 CG Road\",\n" +
                        "        \"workingStatus\": \"NOT_WORKING\",\n" +
                        "        \"joinedDate\": \"2023-11-20T10:00:00\",\n" +
                        "        \"leftDate\": \"2024-05-30T17:00:00\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 4,\n" +
                        "        \"firstName\": \"Sneha\",\n" +
                        "        \"lastName\": \"Reddy\",\n" +
                        "        \"phoneNumber\": \"6543210987\",\n" +
                        "        \"alterPhoneNumber\": \"5432109876\",\n" +
                        "        \"town\": \"Hyderabad\",\n" +
                        "        \"village\": \"Shamirpet\",\n" +
                        "        \"address\": \"101 Jubilee Hills\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2024-02-05T10:30:00\",\n" +
                        "        \"leftDate\": null\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 5,\n" +
                        "        \"firstName\": \"Vikram\",\n" +
                        "        \"lastName\": \"Singh\",\n" +
                        "        \"phoneNumber\": \"5432109876\",\n" +
                        "        \"alterPhoneNumber\": \"4321098765\",\n" +
                        "        \"town\": \"Jaipur\",\n" +
                        "        \"village\": \"Amer\",\n" +
                        "        \"address\": \"202 Pink City Road\",\n" +
                        "        \"workingStatus\": \"NOT_WORKING\",\n" +
                        "        \"joinedDate\": \"2023-08-10T09:45:00\",\n" +
                        "        \"leftDate\": \"2024-03-25T18:00:00\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 6,\n" +
                        "        \"firstName\": \"Anjali\",\n" +
                        "        \"lastName\": \"Verma\",\n" +
                        "        \"phoneNumber\": \"4321098765\",\n" +
                        "        \"alterPhoneNumber\": \"3210987654\",\n" +
                        "        \"town\": \"Delhi\",\n" +
                        "        \"village\": \"Dwarka\",\n" +
                        "        \"address\": \"303 Connaught Place\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2024-03-01T11:00:00\",\n" +
                        "        \"leftDate\": null\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 7,\n" +
                        "        \"firstName\": \"Rohit\",\n" +
                        "        \"lastName\": \"Mehta\",\n" +
                        "        \"phoneNumber\": \"3210987654\",\n" +
                        "        \"alterPhoneNumber\": \"2109876543\",\n" +
                        "        \"town\": \"Mumbai\",\n" +
                        "        \"village\": \"Andheri\",\n" +
                        "        \"address\": \"404 Marine Drive\",\n" +
                        "        \"workingStatus\": \"NOT_WORKING\",\n" +
                        "        \"joinedDate\": \"2023-10-15T08:30:00\",\n" +
                        "        \"leftDate\": \"2024-06-20T19:00:00\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 8,\n" +
                        "        \"firstName\": \"Deepika\",\n" +
                        "        \"lastName\": \"Gupta\",\n" +
                        "        \"phoneNumber\": \"2109876543\",\n" +
                        "        \"alterPhoneNumber\": \"1098765432\",\n" +
                        "        \"town\": \"Kolkata\",\n" +
                        "        \"village\": \"Salt Lake\",\n" +
                        "        \"address\": \"505 Park Street\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2024-04-10T09:15:00\",\n" +
                        "        \"leftDate\": null\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 9,\n" +
                        "        \"firstName\": \"Karan\",\n" +
                        "        \"lastName\": \"Joshi\",\n" +
                        "        \"phoneNumber\": \"1098765432\",\n" +
                        "        \"alterPhoneNumber\": \"1987654321\",\n" +
                        "        \"town\": \"Pune\",\n" +
                        "        \"village\": \"Hinjewadi\",\n" +
                        "        \"address\": \"606 FC Road\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2023-11-01T10:45:00\",\n" +
                        "        \"leftDate\": null\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 10,\n" +
                        "        \"firstName\": \"Meera\",\n" +
                        "        \"lastName\": \"Iyer\",\n" +
                        "        \"phoneNumber\": \"1987654321\",\n" +
                        "        \"alterPhoneNumber\": \"9876543210\",\n" +
                        "        \"town\": \"Coimbatore\",\n" +
                        "        \"village\": \"Peelamedu\",\n" +
                        "        \"address\": \"707 Race Course Road\",\n" +
                        "        \"workingStatus\": \"NOT_WORKING\",\n" +
                        "        \"joinedDate\": \"2023-12-20T09:30:00\",\n" +
                        "        \"leftDate\": \"2024-07-10T17:30:00\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 11,\n" +
                        "        \"firstName\": \"Ravi\",\n" +
                        "        \"lastName\": \"Charan\",\n" +
                        "        \"phoneNumber\": \"4567890123\",\n" +
                        "        \"alterPhoneNumber\": \"3987654321\",\n" +
                        "        \"town\": \"Anantapur\",\n" +
                        "        \"village\": \"Akam Palle\",\n" +
                        "        \"address\": \"321 Pine Rd\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2024-12-26T08:50:50.176281\",\n" +
                        "        \"leftDate\": null\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 12,\n" +
                        "        \"firstName\": \"Ravi\",\n" +
                        "        \"lastName\": \"Charan\",\n" +
                        "        \"phoneNumber\": \"4567890123\",\n" +
                        "        \"alterPhoneNumber\": \"3987654321\",\n" +
                        "        \"town\": \"Anantapur\",\n" +
                        "        \"village\": \"Akam Palle\",\n" +
                        "        \"address\": \"321 Pine Rd\",\n" +
                        "        \"workingStatus\": \"WORKING\",\n" +
                        "        \"joinedDate\": \"2024-12-26T09:25:26.621217\",\n" +
                        "        \"leftDate\": null\n" +
                        "    }\n" +
                        "]"))
                .andReturn();
    }


    @Test
    public void updateWorkerTest() throws Exception {
        String workerRequest = "{\n" +
                "        \"id\": 12,\n" +
                "        \"firstName\": \"Ravi\",\n" +
                "        \"lastName\": \"Charan\",\n" +
                "        \"phoneNumber\": \"4567890123\",\n" +
                "        \"alterPhoneNumber\": \"3987654321\",\n" +
                "        \"town\": \"Anantapur\",\n" +
                "        \"village\": \"Akam Palle\",\n" +
                "        \"address\": \"321 Pine Rd\",\n" +
                "        \"workingStatus\": \"WORKING\",\n" +
                "        \"joinedDate\": \"2024-12-26T09:25:26.621217\",\n" +
                "        \"leftDate\": null\n" +
                "    }";

        when(workerService.updateWorker(any(WorkerRequest.class))).thenReturn(true);

        RequestBuilder request = MockMvcRequestBuilders.put("/api/v1/workers/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(workerRequest);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andReturn();
    }


    @Test
    public void deleteWorkerTest() throws Exception {
        Integer workerId = 12;
        when(workerService.deleteWorker(anyInt())).thenReturn(true);
        RequestBuilder request = MockMvcRequestBuilders.delete("/api/v1/workers/delete/{id}",workerId);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andReturn();
    }

}
