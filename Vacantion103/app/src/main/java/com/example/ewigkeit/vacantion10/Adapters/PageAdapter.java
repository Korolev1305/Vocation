package com.example.ewigkeit.vacantion10.Adapters;

/**
 * Created by ewigkeit on 19/11/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ewigkeit.vacantion10.App;
import com.example.ewigkeit.vacantion10.DatabaseHelper;
import com.example.ewigkeit.vacantion10.R;
import com.example.ewigkeit.vacantion10.Tables.Address;
import com.example.ewigkeit.vacantion10.Tables.Vacancy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Vacancy> vacancies = new ArrayList<>();
    private OnDeleteListener onDeleteListener;
    private Context context;
    private DatabaseHelper databaseHelper;

    public PageAdapter(Context context, List<Vacancy> vacancies) {
        this.context = context;
        this.vacancies = vacancies;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_some_data, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final NewsViewHolder viewHolder = (NewsViewHolder) holder;
        databaseHelper = App.getDatabaseInstance();
        viewHolder.experience.append(": "+vacancies.get(position).getExperience());
        viewHolder.salary.append(": "+vacancies.get(position).getSalary());
        String skills="";
        List<Integer> skillIds = databaseHelper.getVacancySkillsJoinDao().getSkills(vacancies.get(position).getId());
        for (Integer skillId : skillIds)
        skills+=databaseHelper.getSkillsDao().getSkill(skillId).toString();
        viewHolder.skills.append(": "+skills);
        String company = databaseHelper.getCompanyDao().getCompany(vacancies.get(position).getCompanyId());
        viewHolder.company.append(": "+company);
    }

    @Override
    public int getItemCount() {
        return vacancies.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.skillsId_item)
        public TextView skills;
        @BindView(R.id.salary_item)
        public TextView salary;
        @BindView(R.id.companyId_item)
        public TextView company;
        @BindView(R.id.experience_item)
        public TextView experience;
        @BindView(R.id.delete)
        public TextView delete;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            delete.setOnClickListener(view -> {
                onDeleteListener.onDelete(vacancies.get(getAdapterPosition()));
                vacancies.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
            });
        }
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    public interface OnDeleteListener {
        void onDelete(Vacancy vacancy);
    }
}
