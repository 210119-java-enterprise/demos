package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.revature.models.State;
import com.revature.models.User;

public class StreamDriver {
    public static void main(String[] args) {
        User nate = new User("Nate", 22);
        User jay = new User("Jay", 45);
        User kalyb = new User("Kalyb", 22);
        User cole = new User("Cole", 22);
        User gabby = new User("Gabby", 24);
        User nobody = new User("", 69);

        List<User> users = new ArrayList<>(Arrays.asList(nate, jay, kalyb, gabby, nobody));

        long numberOfEmptyNames = users.stream()    // Stream of users
                                        .map(u -> u.getName())  // Stream of Strings
                                        .filter(uname -> uname.isEmpty())   // Stream of Strings (filtered)
                                        .count();   // long that represents num of Strings in above stream
        System.out.println(numberOfEmptyNames);

        // Explicit/multi-line example
        Stream<User> userStream = users.stream();
        // Stream<String> nameStream = userStream.map(user -> user.getName());
        Stream<String> nameStream = userStream.map(User::getName);
        Stream<String> nonEmptyNames = nameStream.filter(name -> !name.isEmpty());
        long countNonEmptyNames = nonEmptyNames.count();
        System.out.println(countNonEmptyNames);



        // --------------------------
        // Flat map demonstration
        State michigan = new State("Michigan", nate);
        State missouri = new State("Missouri", jay);
        State texas = new State("Texas", kalyb, cole);
        State california = new State("California", gabby, nobody);

        List<State> states = new ArrayList<>(Arrays.asList(michigan, missouri, texas, california));

        // takes States in a stream, replaces state object with List<User> of the stateUsers
        // then counts items in stream, not very helpful
        long countStates = states.stream()
                            .map(place -> place.getStateUsers())
                            .count();

        // Count how many people across all states
        long countPeople = states.stream()
                            .flatMap(place -> place.getStateUsers().stream())
                            .count();

        System.out.println("Num states: " + countStates);
        System.out.println("Num people: " + countPeople);


        states.stream()
                .flatMap(place -> place.getStateUsers().stream())
                .map(u -> u.getName())
                .forEach(System.out::println);
        // ---------------------
        int ageSum = users.stream()
                            .map(User::getAge)
                            // .reduce(0, Integer::sum);
                            // 0 is start value
                            .reduce(0, (age1, age2) -> age1 + age2);  
        System.out.println(ageSum); 
    }
}
