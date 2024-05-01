package com.petpals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petpals.application.dto.AddFirstPal;
import com.petpals.application.dto.NewOwner;
import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.ports.in.CreateOwnerIn;
import com.petpals.shared.enums.Species;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class CreateOwnerResourceTest {
	@InjectMock
	CreateOwnerIn createOwnerIn;
	ArgumentCaptor<Owners> ownerCaptor = ArgumentCaptor.forClass(Owners.class);
	@Test
	void testHelloEndpoint() throws JsonProcessingException {
		Mockito.when(createOwnerIn.createOwnerWithFirstPal(Mockito.any(Owners.class))).thenReturn(1L);
		ObjectMapper mapper = new ObjectMapper();
		var owner = new NewOwner("sa.bennaceur@gmail.com","OPPO C9","19819189189189119818919181981981", "FRANCE",
								 List.of(
										 new AddFirstPal(true, "1234567656755765656757655657", "Ashe", "Ashe", new Date()
												 , true, Species.DOG,"Husky","250229090909090", true, false, 29.0,
														 53.0)
								 ));
		var json = mapper.writeValueAsString(owner);
		given()
				.headers("API-KEY","pals-0.1.0")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.body(json)
				.when().post("/owners")
				.then()
				.statusCode(200)
				.body(is("1"));
		Mockito.verify(createOwnerIn, Mockito.times(1)).createOwnerWithFirstPal(ownerCaptor.capture());
		Assertions.assertEquals(owner.reference(),ownerCaptor.getValue().getReference());
		Assertions.assertEquals(owner.pals().get(0).name(),ownerCaptor.getValue().getPalsList().get(0).getName());
		
	}
}
