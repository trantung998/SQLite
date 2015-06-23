package sqlite.example.tung.sqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteHandle db = new SQLiteHandle(this);

        //insert
        db.addContact(new Contact("Tung","01632449974"));
        db.addContact(new Contact("Hai", "01561545182"));
        db.addContact(new Contact("Luan", "01561545182"));
        db.addContact(new Contact("Hung", "01561545182"));
        db.addContact(new Contact("Giang", "01561545182"));
        db.addContact(new Contact("Thao", "01561545182"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhone_number();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        //delete contact
        Log.d("Delete: ", "Delete contact..");
        db.deleteContact(contacts.get(0));
        Log.d("Reading: ", "Reading all contacts..");
        contacts = db.getAllContacts();
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhone_number();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

    }
}
