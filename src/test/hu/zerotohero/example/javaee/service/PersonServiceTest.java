package hu.zerotohero.example.javaee.service;

import hu.zerotohero.example.javaee.dao.BaseDao;
import hu.zerotohero.example.javaee.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) class PersonServiceUnitTest {

	@Mock BaseDao mockedBaseDao;

	@InjectMocks PersonService personService;

	@Test void addPersonUnitTest() {
		//Given

		String trimmedName = "Gyula";
		Date date = new Date(1975 - 01 - 05);
		Person person = new Person(trimmedName, date);
		//when(mockedBaseDao.queryWithNameParameter(Person.class, Person.NQ_FIND_PERSON_BY_NAME, "Gyula")).thenReturn(person);

		//When
		String name = "   Gyula   ";
		personService.addPerson(name, date);

		//Assert
		ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
		verify(mockedBaseDao).save(personArgumentCaptor.capture());

		assertEquals("Gyula", personArgumentCaptor.getValue().getName());
		assertEquals(date, personArgumentCaptor.getValue().getBirthday());
	}
}