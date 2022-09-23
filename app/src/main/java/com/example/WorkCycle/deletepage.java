package com.example.WorkCycle;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.WorkCycle.databinding.ActivityDeletepageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class deletepage extends AppCompatActivity {
    ActivityDeletepageBinding binding;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeletepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ename = binding.username.getText().toString();
                if(!ename.isEmpty()){
                    deleteData(ename);
                }else {
                    Toast.makeText(deletepage.this, "Enter a username", Toast.LENGTH_SHORT).show();
                }
            }

            private void deleteData(String ename) {

                reference = FirebaseDatabase.getInstance().getReference("Event");
                reference.child(ename).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(deletepage.this, "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                            binding.username.setText("");
                        }else{
                            Toast.makeText(deletepage.this, "Delete Data ", Toast.LENGTH_SHORT).show();
                            binding.username.setText("");
                        }
                    }
                });
            }
        });
    }
}