package com.revature;

import com.revature.models.Batch;
import com.revature.models.User;

import java.util.*;

public class FunWithCollections {

    public static void main(String[] args) {
        User cole = new User("Cole", 22);
        User cole2 = new User("Cole", 21);
        User kalyb = new User("Kalyb", 22);
        User daniel = new User("Daniel", 23);
        User wezley = new User("Wezley", 30);
        User jay = new User("Jay", 50);
        User greg = new User("Greg", 45);

        Batch javaAngular = new Batch("210119-java-enterprise", Batch.TechStack.JAVA_ANGULAR);
        Batch cSharpReact = new Batch("201225-net-react", Batch.TechStack.C_SHARP_REACT);

        Map<Batch, List<User>> batchMapping = new HashMap<>();
        batchMapping.putIfAbsent(cSharpReact, new ArrayList<>());
        batchMapping.get(cSharpReact).add(cole2);

        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(cole);
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(kalyb);
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(daniel);
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(jay);
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(greg);
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(wezley);

        // print out associates
        System.out.println("Associates in the .NET December batch = " + batchMapping.getOrDefault(cSharpReact, Collections.EMPTY_LIST));
        System.out.println("Associates in the Java/Angular January batch = "+ batchMapping.getOrDefault(javaAngular, Collections.EMPTY_LIST));


        Map<Batch, List<User>> batchMapping2 = new HashMap<>();

        batchMapping2.computeIfAbsent(cSharpReact, batch -> new ArrayList<>()).add(jay);
        batchMapping2.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(greg);
        batchMapping2.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(wezley);

        // how to merge the two maps?

        // For each entry (batch, users) in our second batch mapping
        batchMapping2.forEach((batch, users) -> {

            // each iteration we will attempt to merge the batch and its users (params 1 & 2)  into our
            // first batch mapping
            batchMapping.merge(batch, users, (batch1Users, batch2Users) -> {
                batch1Users.addAll(batch2Users);
                return batch1Users;
            });
        });

        batchMapping.forEach((batch, users) -> System.out.println(batch + " :: "+ users));
    }
}
