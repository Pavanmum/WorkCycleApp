package com.example.WorkCycle;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Acceptd extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<acccept> usersArrayList;
    clientdsadp clientdsadp;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    String UserId;
    //FirebaseUser user;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptd);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Showing Details.....");
        progressDialog.show();
        recyclerView = findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        recyclerView = findViewById(R.id.rc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        usersArrayList = new ArrayList<acccept>();
        clientdsadp = new clientdsadp(Acceptd.this,usersArrayList);

        recyclerView.setAdapter(clientdsadp);

        EventChangeListener();
    }

    private void EventChangeListener() {

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        String userId = fAuth.getCurrentUser().getUid();

        fStore.collection("user").document(userId).collection("Jobs").orderBy("Name", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null) {
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("firestore error", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                usersArrayList.add(dc.getDocument().toObject(acccept.class));
                            }

                            clientdsadp.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
//                        }


                        }
                    }
                });
    }

}