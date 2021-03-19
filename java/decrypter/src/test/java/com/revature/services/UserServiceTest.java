package com.revature.services;

import com.revature.models.AppUser;
import com.revature.repos.UserRepository;
import com.revature.stubs.UserRepositoryStub;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    UserService sut;
    UserRepository mockUserRepo = mock(UserRepository.class);
    AppUser fakeUser = new AppUser();


    @Before
    public void setUpTest() {
        sut = new UserService(mockUserRepo);
    }

    @After
    public void tearDownTest() {
        sut = null;
    }

    /*
        Common Test Pattern: AAA Pattern
            - Arrange
            - Act
            - Assert
     */
    @Test
    public void test_isUserValid_whenGiven_nullUser() {

        // Arrange
        AppUser nullUser = null;

        // Act
        boolean actualResult = sut.isUserValid(nullUser);

        // Assert
        assertFalse(actualResult);

    }

    @Test
    public void test_isUserValid_whenGiven_userWithNullFirstName() {

        // Arrange
        AppUser userWithNullFn = new AppUser(null, "last", "username", "pw");

        // Act
        boolean actualResult = sut.isUserValid(userWithNullFn);

        // Assert
        assertFalse(actualResult);

    }

    @Test
    public void test_isUserValid_whenGiven_validUser() {

        // Arrange
        AppUser validUser = new AppUser("first", "last", "un", "pw");

        // Act
        boolean actualResult = sut.isUserValid(validUser);

        // Assert
        assertTrue(actualResult);

    }

    @Test
    public void test_authenticate_whenGiven_validCredentials() {

        // Arrange
        String validUsername = "valid";
        String validPassword = "valid";
        AppUser expectedResult = fakeUser;
        when(mockUserRepo.findUserByUsernameAndPassword(anyString(), anyString()))
                .thenReturn(Optional.ofNullable(expectedResult));

        // Act
        AppUser actualResult = sut.authenticate_example(validUsername, validPassword);

        // Assert
        assertEquals(actualResult, expectedResult);
        verify(mockUserRepo, atMost(1)).findUserByUsernameAndPassword(anyString(), anyString());

    }
}
