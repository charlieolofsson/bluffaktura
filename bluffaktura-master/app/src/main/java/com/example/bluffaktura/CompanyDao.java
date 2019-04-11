package com.example.bluffaktura;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CompanyDao {
    // Fundera på strategy
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCompany(Company company);

    @Query("select * from company")
    List<Company> getAllCompanies();

    @Query("select * from company where id = :companyId")
    List<Company> getCompany(int companyId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCompany(Company company);

    @Query("delete from company")
    void removeAllCompanies();

}
