package com.revature.services;

import com.revature.models.AppUser;
import com.revature.repos.UserRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;


public class UserServiceTest {

    public UserService sut; //Sut stands for system under test
    public UserRepository mockUserRepo = mock(UserRepository.class);
    public AppUser fakeUser = new AppUser();

    @Before
    public void setupTests() {
        sut = new UserService(mockUserRepo);
    }

    @After
    public void teardownTests() {
        sut = null;
    }

    // Conventions vary for test method names
    // AAA pattern
    // Arrange, Act, Assert
    /**
     * Common test pattern: AAA (Arrange, Act, Assert)
     */
    @Test
    public void test_isUserValid_whenGiven_nullUser() {
        // Arrange
        AppUser nullUser = null;
        boolean expectedResult = false;

        // Act
        boolean actualResult = sut.isUserValid(nullUser);

        // Assert
        assertEquals(actualResult, expectedResult);
        assertFalse(actualResult);
    }

    // Use parameterized tests to reduce number of tests to write
    @Test
    public void test_isUserValid_whenGiven_userWithNullFirstName() {
        AppUser userWithNullFName = new AppUser(null, "last", "username", "password");

        boolean actualResult = sut.isUserValid(userWithNullFName);

        assertFalse(actualResult);
    }

    @Test
    public void test_isUserValid_whenGiven_validUser() {
        AppUser validUser = new AppUser("first", "last", "username", "password");

        boolean actualResult = sut.isUserValid(validUser);

        assertTrue(actualResult);
    }

    @Test
    public void test_authenticate_whenGiven_validCredentials() {
        String validUsername = "valid";
        String validPassword = "valid";
        AppUser expectedResult = fakeUser;
        when(mockUserRepo.findUserByCredentials(anyString(), anyString()))
            .thenReturn(Optional.of(fakeUser));
        
        AppUser actualResult = sut.login(validUsername, validPassword);

        assertEquals(actualResult, expectedResult);
        verify(mockUserRepo, atMost(1)).findUserByCredentials(validUsername, validPassword);
    }
}
