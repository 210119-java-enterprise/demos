package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.models.Batch;
import com.revature.models.User;

public class funWithCollectionsDriver {
    public static void main(String[] args) {
        User nate = new User("Nate", 22);
        User jay = new User("Jay", 45);
        User kalyb = new User("Kalyb", 22);
        User gabby = new User("Gabby", 24);
        User nate2 = new User("Nate", 21);

        Batch javaAngular = new Batch("210119-java-enterprise", Batch.TechStack.JAVA_ANGULAR);
        Batch cSharpReact = new Batch("10892-net-react", Batch.TechStack.C_SHARP_REACT);
        Batch thirdBatch = new Batch("10723-null", Batch.TechStack.PYTHON);

        Map<Batch, List<User>> batchMapping = new HashMap<>();
        // If there, don't replace. If not there, add
        // batchMapping.putIfAbsent(cSharpReact, new ArrayList<>());
        // batchMapping.get(cSharpReact).add(nate2);
        
        // If key not in map, associate it with value of lambda expression
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(jay);
        // Does not execute lambda because javaAngular key exists
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(gabby);

        System.out.println("Associates in .NET batch: " + batchMapping.getOrDefault(cSharpReact, Collections.EMPTY_LIST));
        System.out.println("Associates in Java Angular batch: " + batchMapping.getOrDefault(javaAngular, Collections.EMPTY_LIST));
        System.out.println("Associates in Python batch: " + batchMapping.getOrDefault(thirdBatch, Collections.EMPTY_LIST));

        // Merging maps
        Map<Batch, List<User>> batchMapping2 = new HashMap<>();
        batchMapping2.computeIfAbsent(cSharpReact, batch -> new ArrayList<>()).add(nate2);
        // Does not execute lambda because javaAngular key exists
        batchMapping2.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(nate);
        batchMapping2.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(kalyb);

        // Merges users in each batch in batchMapping2 into batches in batchMapping
        batchMapping2.forEach((batch, users) -> {
            batchMapping.merge(batch, users, (batch1Users, batch2Users) -> {
                batch1Users.addAll(batch2Users);
                return batch1Users;
            });
        });

        System.out.println("--------------------------");
        batchMapping.forEach((batch, users) -> {
            System.out.println(batch + " :: " + users);
        });

    }
}
