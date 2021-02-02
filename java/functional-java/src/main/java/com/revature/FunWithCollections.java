package com.revature;

import com.revature.models.Batch;
import com.revature.models.TechStack;
import com.revature.models.User;

import java.util.*;

public class FunWithCollections {

    public static void main(String[] args) {

        // We've got some associates (including Cole's doppleganger)
        User cole = new User("Cole", 22);
        User cole2 = new User("Cole", 21);
        User kalyb = new User("Kalyb", 22);
        User daniel = new User("Daniel", 23);
        User wezley = new User("Wezley", 30);
        User jay = new User("Jay", 50);
        User greg = new User("Greg", 45);

        // We have two batches we can assign these associates to
        Batch javaAngular = new Batch("210119-java-enterprise", TechStack.JAVA_ANGULAR);
        Batch cSharpReact = new Batch("201225-net-react", TechStack.C_SHARP_REACT);

        // Create a Map that maps a Batch to a List of Users
        Map<Batch, List<User>> batchMapping = new HashMap<>();

        // putIfAbsent allows us to put in a key and value only if the key does not already exist
        // remember: put will simply overwrite the previously associated value (not always what we want)
        batchMapping.putIfAbsent(cSharpReact, new ArrayList<>());

        // add doppleganger cole to the .NET batch
        batchMapping.get(cSharpReact).add(cole2);

        // computeIfAbsent is similar to putIfAbsent, but allows for us to specify a default value if the key
        // does not already exist in the map
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(cole); // this creates a new ArrayList
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(kalyb); // this does not execute the provided lambda
        batchMapping.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(daniel); // neither does this

        // print out our associates
        System.out.println("Associates in the Python batch = " + batchMapping.getOrDefault(new Batch("python", TechStack.PYTHON), Collections.EMPTY_LIST));
        System.out.println("Associates in the .NET/React December batch = " + batchMapping.getOrDefault(cSharpReact, Collections.EMPTY_LIST));
        System.out.println("Associates in the Java/Angular January batch = " + batchMapping.getOrDefault(javaAngular, Collections.EMPTY_LIST));

        // Say that we have another batch mapping construct
        Map<Batch, List<User>> batchMapping2 = new HashMap<>();

        // add some new associates to the Java/Angular batch (same batch, new map!)
        batchMapping2.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(jay);
        batchMapping2.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(greg);
        batchMapping2.computeIfAbsent(javaAngular, batch -> new ArrayList<>()).add(wezley);

        // how to go about merging our two maps? :thinking_face:

        // For each entry (batch, users) in our second batch mapping
        batchMapping2.forEach((batch, users) -> {

            // each iteration we will attempt to merge the batch and its users (params 1 & 2) into our
            // first batch mapping. how we perform this merge is defined by the third param which is a lambda
            batchMapping.merge(batch, users, (batch1Users, batch2Users) -> {

                // add all of the users in batch 2 to batch 1
                batch1Users.addAll(batch2Users);

                // return batch 1 users
                return batch1Users; // I'm not actually catching this, but we need a return because .merge requires it
            });
        });

        // print out our original batch mapping which now is merged with batch mapping 2
        batchMapping.forEach((batch, users) -> System.out.println(batch + " :: " + users));



    }

}
