package com.revature.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDriver {

    public static void main(String[] args) {
        User cole = new User("Cole", 22);
        User cole2 = new User("Cole", 21);
        User kalyb = new User("Kalyb", 22);
        User daniel = new User("Daniel", 23);
        User wezley = new User("Wezley", 30);
        User jay = new User("Jay", 50);
        User greg = new User("Greg", 45);
        User nobody = new User ("", 34);

        List<User> users = new ArrayList<>(Arrays.asList(cole, cole2, kalyb, daniel, wezley, jay, greg, nobody));

        long numberOfEmptyNames = users.stream() //Stream of users
                                        .map(u -> u.getName()) // stream of strings
                                        .filter(uname -> uname.isEmpty()) // stream of strings (filtered)
                                        .count(); // return a long which represents the number of Strings in the above Stream
        System.out.println(numberOfEmptyNames);


        Stream<User> userStream = users.stream();
        Stream<String> nameStream = userStream.map(user -> user.getName());
        Stream<String> nonEmptyNamesStream = nameStream.filter(name -> name.isEmpty());
        long countNonEmptyNames = nonEmptyNamesStream.count();
        System.out.println(countNonEmptyNames);

        // ------------------------------------

        // Gives us a Stream<Object>, which is not very useful
//        Stream<Object> StreamStream = states.stream()
//                .map(place -> place.getStateUsers()); // <- returns a stream of a stream of a list of users
        // Casting doesnt want to play nicely


        /// ALL ABOUT THE FLATMAP
        State florida = new State("Florida", wezley);
        State missouri = new State("Missouri", jay);
        State texas = new State("Texas", cole, kalyb);
        State pennsylvania = new State("Pennsylvania", nobody, daniel, greg);

        List<State> states = new ArrayList<>(Arrays.asList(florida, missouri, texas, pennsylvania));

        long peopleCount = states.stream()
                            .flatMap(place -> place.getStateUsers().stream())
                            .count();

        System.out.println(peopleCount);

        states.stream()
                .flatMap(place -> place.getStateUsers().stream())
                .map(User::getName)
                .forEach(System.out::println);


        //-------------

        int ageSum = users.stream()
                            .map(User::getAge)
                            .reduce(0,(age1, age2) -> age1+age2);
        System.out.println(ageSum);
    }
}
