package com.example.Email_Back.Filter;

import com.example.Email_Back.Model.Email.Email;

import java.util.ArrayList;

public class CriteriaDate implements ICriteria {

    private int SpecifiedDate;
    private boolean Larger;

    public CriteriaDate(int SpecifiedDate, boolean Larger) {
        this.SpecifiedDate = SpecifiedDate;
        this.Larger = Larger;
    }


    public ArrayList<Email> meetCriteria(ArrayList<Email> emails) {
        ArrayList<Email> met = new ArrayList<>();
        if(Larger) {
            for (Email email : emails)
                if (email.getDate() >= SpecifiedDate)
                    met.add(email);
        }
        else {
            for (Email email : emails)
                if (email.getDate() < SpecifiedDate)
                    met.add(email);
        }

        return met;
    }



}
