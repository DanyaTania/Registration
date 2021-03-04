package by.gourianova.binocularvision.dao;

import by.gourianova.binocularvision.entity.User;

import java.util.ArrayList;


public class PersonalFactory
{
  private User person;

    public User getPerson() {       return person;    }
    public void setPerson(String email,String password){

    this.person = new User(email, password);
    }


    public User create(String groupName, ArrayList<String> parameters)
    {
        switch (groupName)
        {
            case "user":
            {
                person = new User(parameters.get(0), parameters.get(1));
                break;
            }

        }

          return     person;
    }
}
