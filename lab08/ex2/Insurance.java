package lab08.ex2;

import java.util.*;

public class Insurance {

    private List<Person> persons_insurance_list;
    

    public Insurance() {
        this.persons_insurance_list = new ArrayList<>();
    }

    public void regist(Person person){
        persons_insurance_list.add(person);
    }
    
    
}
