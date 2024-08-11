package com.example.mykisanapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.Model.Employee;
import com.example.mykisanapp.R;

import java.util.List;

public class empAdapterr extends RecyclerView.Adapter<EmployHolder> {

   private List<Employee> employeeList;
    Context context;

    public empAdapterr(Context context, List<Employee> employeeList){

        this.employeeList = employeeList;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_emp_items, parent ,false);

        return new EmployHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployHolder holder, int position) {
          Employee emp = employeeList.get(position);
          holder.name.setText(emp.getName());
          holder.city.setText(emp.getCity());
          holder.branch.setText(emp.getBranch());

    }

    @Override
    public int getItemCount() {
        return (employeeList != null ? employeeList.size() : 0);
    }
}
