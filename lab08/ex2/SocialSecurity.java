package lab08.ex2;

import java.util.*;

public class SocialSecurity {

    private List<Person> persons_social_security_list;
    

    public SocialSecurity() {
        this.persons_social_security_list = new ArrayList<>();
    }

    public void regist(Person person){
        persons_social_security_list.add(person);
    }
    
}
