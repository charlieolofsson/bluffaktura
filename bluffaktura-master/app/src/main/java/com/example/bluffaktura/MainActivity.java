package com.example.bluffaktura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        database.companyDao().removeAllCompanies();
        // add some data
        List<Company> companies = database.companyDao().getAllCompany();
        if (companies.size()==0) {
            database.companyDao().addCompany(new Company(1, "Test 1", 1));
            company = database.companyDao().getAllCompanies().get(0);
            Toast.makeText(this, String.valueOf(company.id), Toast.LENGTH_SHORT).show();

            database.companyDao().addUser(new Company(2, "Test 2", 2));
            database.companyDao().addUser(new Company(3, "Test 3", 3));
        }

        updateFirstCompanyData();

    }


    private void updateFirstCompanyData() {
        List<Company> user = database.companyDao().getAllCompany();
        TextView textView = findViewById(R.id.result);
        if (company.size()>0){
            textView.setText(company.get(0).name + " Skill points " + company.get(0).skillPoints    );
        }
    }

    public void onClick(View view){
        if (view.getId()==R.id.addtrophybutton) {
            // TODO add trophy
            // TODO call updatefirstUserData
            Toast.makeText(this,String.valueOf(company.id), Toast.LENGTH_SHORT).show();
        }
        if (view.getId()==R.id.increaseskills ){
            company.skillPoints++;
            database.companyDao().updateCompany(company);
            // TODO to skillpoints

        }
        // TODO call updatefirstUserData
        updateFirstUserData();

    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

        public class ReadNSearchFile {

            private static Scanner x;

            public static void main(String[] args) {
                String filepath = "tutorial.txt";
                String searchTerm = "search";
            }

            public static void readRecord(String searchTerm, String filepath) {

                try {

                } catch (Exception e) {

                }


            }
        }
    }
}
