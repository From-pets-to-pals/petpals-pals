package com.petpals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petpals.application.dto.AddPalRequest;
import com.petpals.application.dto.NewOwnerRequest;
import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.ports.in.CreateOwnerIn;
import com.petpals.shared.entities.uuid.UUIDFormatter;
import com.petpals.shared.entities.uuid.UUIDGenerator;
import com.petpals.shared.model.enums.SpeciesEnum;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

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
		var owner = new NewOwnerRequest("sa.bennaceur@gmail.com", "Sidou", "OPPO C9",
										UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(), true, ""),
										 "FRANCE",
										List.of(
										 new AddPalRequest("Ashe", "Ashe", "250221212121212", "2022-04-28",
														   SpeciesEnum.DOG, "Husky",
														   true
												 , true, false, true, null, null, null,
														   UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,""),
														   29.0,
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
		Assertions.assertEquals(owner.email(),ownerCaptor.getValue().getEmail());
		Assertions.assertEquals(owner.username(),ownerCaptor.getValue().getUsername());
		Assertions.assertEquals(owner.location(),ownerCaptor.getValue().getLocation());
		Assertions.assertEquals(owner.deviceId(),ownerCaptor.getValue().getDeviceId());
		Assertions.assertEquals(owner.pals().get(0).name(),ownerCaptor.getValue().getPals().get(0).getName());
		Assertions.assertEquals(owner.pals().get(0).shortname(),ownerCaptor.getValue().getPals().get(0).getShortname());
		Assertions.assertEquals(owner.pals().get(0).reference(),ownerCaptor.getValue().getPals().get(0).getReference());
		Assertions.assertEquals(owner.pals().get(0).breed(),ownerCaptor.getValue().getPals().get(0).getBreed().getName());
		Assertions.assertEquals(owner.pals().get(0).birthDate(),
								ownerCaptor.getValue().getPals().get(0).getBirthDate().toString());
		Assertions.assertEquals(owner.pals().get(0).icadIdentifier(),ownerCaptor.getValue().getPals().get(0).getIcadIdentifier());
		Assertions.assertEquals(owner.pals().get(0).isMale(),ownerCaptor.getValue().getPals().get(0).isMale());
		Assertions.assertEquals(owner.pals().get(0).hasPassport(),ownerCaptor.getValue().getPals().get(0).isHasPassport());
		Assertions.assertEquals(owner.pals().get(0).isVaccinated(),ownerCaptor.getValue().getPals().get(0).isVaccinated());
		Assertions.assertEquals(owner.pals().get(0).isSterilized(),ownerCaptor.getValue().getPals().get(0).isSterilized());
		Assertions.assertNull(owner.pals().get(0).nextVaccine());
		Assertions.assertNull(ownerCaptor.getValue().getPals().get(0).getNextVaccine());
		Assertions.assertNull(owner.pals().get(0).nextPlannedVetApp());
		Assertions.assertNull(ownerCaptor.getValue().getPals().get(0).getNextPlannedVetApp());
		Assertions.assertEquals(owner.pals().get(0).weight(),ownerCaptor.getValue().getPals().get(0).getWeight());
		Assertions.assertEquals(owner.pals().get(0).height(),ownerCaptor.getValue().getPals().get(0).getHeight());
		Mockito.verifyNoMoreInteractions(createOwnerIn);
	}
}
