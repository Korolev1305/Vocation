package com.example.ewigkeit.vacantion10;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ewigkeit.vacantion10.AddData.AddDataAddressActivity;
import com.example.ewigkeit.vacantion10.AddData.AddDataCompanyActivity;
import com.example.ewigkeit.vacantion10.AddData.AddDataEmploymentTypeActivity;
import com.example.ewigkeit.vacantion10.AddData.AddDataSkillsActivity;
import com.example.ewigkeit.vacantion10.AddData.AddDataVacancyActivity;
import com.example.ewigkeit.vacantion10.AddData.AddDataVacancySkillsJoinActivity;
import com.example.ewigkeit.vacantion10.AddData.AddDataVacancyTypeActivity;
import com.example.ewigkeit.vacantion10.Adapters.PageAdapter;
import com.example.ewigkeit.vacantion10.Tables.Vacancy;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VacancyListActivity extends AppCompatActivity implements PageAdapter.OnDeleteListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancylist);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        databaseHelper = App.getDatabaseInstance();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.menu_add_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_address: {
                startActivity(new Intent(this, AddDataAddressActivity.class));
                break;
            }
            case R.id.action_add_company: {
                startActivity(new Intent(this, AddDataCompanyActivity.class));
                break;
            }
            case R.id.action_add_skills: {
                startActivity(new Intent(this, AddDataSkillsActivity.class));
                break;
            }
            case R.id.action_add_vacancy: {
                startActivity(new Intent(this, AddDataVacancyActivity.class));
                break;
            }
            case R.id.action_add_vacancyskillsjoin: {
                startActivity(new Intent(this, AddDataVacancySkillsJoinActivity.class));
                break;
            }
            case R.id.action_add_vacancytype: {
                startActivity(new Intent(this, AddDataVacancyTypeActivity.class));
                break;
            }
            case R.id.action_add_employmenttype: {
                startActivity(new Intent(this, AddDataEmploymentTypeActivity.class));
                break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        PageAdapter recyclerAdapter = new PageAdapter(this, databaseHelper.getVacancyDao().getAllData());
        recyclerAdapter.setOnDeleteListener(this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onDelete(Vacancy dataModel) {
        databaseHelper.getVacancyDao().delete(dataModel);
    }
}
