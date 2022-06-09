package dao;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public static List<Person> personList=new ArrayList<>();
    public static List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person){
        for (int i = 0; i <personList.size() ; i++) {
            if (personList.get(i).equals(person)) {
                System.out.println("такой пользователь уже существует");
                break;
            }
                personList.add(person);
            }
        }

    public void deletePerson(int id){
        for (Person z :
                personList) {
            if(z.getUserId()==id){
                personList.remove(z);
            }

       else
            System.out.println("Такого пользователя не существует!");
        }
    }
    public void update (Person person){
        for (int i = 0; i <personList.size() ; i++) {
            if (personList.get(i).equals(person)) {
                Person newPerson=personList.get(i);
                deletePerson(newPerson.getUserId());
                addPerson(person);
            }
        }
    }
    public Person getPersonById(int id){
        for (Person z :
                personList) {
            if(z.getUserId()==id){
                return z;
            }
        }
        System.out.println("такого пользователя не существует");
        return null;
    }
    public Object getAllPersons() {
        return personList;
    }
}


