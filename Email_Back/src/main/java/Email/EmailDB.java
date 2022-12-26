package Email;

import java.util.HashMap;

public class EmailDB {

    private HashMap<String, Email> database;

    public void loadDatabase(){
        this.database = null; //load the data
    }
    public Email retrieveEmail(String id){
        return database.get(id);
    }
}
