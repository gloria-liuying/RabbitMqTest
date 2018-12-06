import org.apache.coyote.http2.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class listTest {

    public static void main(String[] args) {
        List<String> jdks = asList("JDK6","JDK8");
//        jdks.add("dd");
        System.out.println(jdks);
        List<String> numbers = new ArrayList<String>(Arrays.asList("1","2","3"));
        numbers.add("4");
        System.out.println(numbers);
        List<String> apples = Collections.nCopies(3,"apple");
        System.out.println(apples);
        List<String> dogs = new ArrayList<String>(Collections.nCopies(2,"dogs"));
        dogs.add("dogs");
        System.out.println(dogs);
//        List<String> colors = Stream.of("blue","red","white").collect(toList());
    }

}
