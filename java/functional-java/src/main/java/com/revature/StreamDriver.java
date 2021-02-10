package com.revature;

import com.revature.models.State;
import com.revature.models.User;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDriver {

    public static void main(String[] args) {

        User cole = new User("Cole", 22);
        User kalyb = new User("Kalyb", 22);
        User daniel = new User("Daniel", 23);
        User wezley = new User("Wezley", 30);
        User jay = new User("Jay", 50);
        User greg = new User("Greg", 45);
        User nobody = new User("", 34);

        List<User> users = new ArrayList<>(Arrays.asList(cole, kalyb, daniel, wezley, jay, greg, nobody));

        long numberOfEmptyNames = users.stream() // Stream of Users
                                        .map(u -> u.getName()) // Stream of Strings
                                        .filter(uname -> uname.isEmpty()) // Stream of Strings (filtered)
                                        .count(); // return a long which represents the number of Strings in the above Stream

        System.out.println(numberOfEmptyNames);


        Stream<User> userStream = users.stream();
        Stream<String> nameStream = userStream.map(User::getName);
        Stream<String> nonEmptyNamesStream = nameStream.filter(name -> !name.isEmpty());
        long countNonEmptyNames = nonEmptyNamesStream.count();

        System.out.println(countNonEmptyNames);

        //--------------------

        /// ALL ABOUT THE FLATMAP

        State florida = new State("Florida", wezley);
        State missouri = new State("Missouri", jay);
        State texas = new State("Texas", cole, kalyb);
        State pennsylvania = new State("Pennsylvania", nobody, daniel, greg);

        List<State> states = new ArrayList<>(Arrays.asList(florida, missouri, texas, pennsylvania));

        // counts the number of states in our stream, not the number of people across all states
        long stateCount = states.stream()
                .map(state -> state.getStateUsers())
                .count();

        // Gives us a Stream<Object>, which is not super useful.
        Stream<Object> streamStream = states.stream()
                                            .map(place -> place.getStateUsers().stream()); // <- returns a stream of a stream of a list of users
                                            // casting doesn't want to play nicely

        long peopleCount = states.stream()
                            .flatMap(place -> place.getStateUsers().stream())
                            .count();

        System.out.println(peopleCount);

        states.stream()
                .flatMap(place -> place.getStateUsers().stream())
                .map(User::getName)
                .forEach(System.out::println);

        //--------------

        int ageSum = users.stream()
                            .map(User::getAge)
                            .reduce(0, (age1, age2) -> age1 + age2);

        System.out.println(ageSum);

    }
}
