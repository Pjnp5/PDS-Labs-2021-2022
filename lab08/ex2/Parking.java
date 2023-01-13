package lab08.ex2;

import java.util.*;

public class Parking {

    private List<Person> persons_parking_list;
    

    public Parking() {
        this.persons_parking_list = new ArrayList<>();
    }

    public void allow(Person person){
        persons_parking_list.add(person);
    }
    
}
