package mau.example.myadapterjava;

import android.os.Bundle;
//import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    // lista de items
    ArrayList<Person> personArrayList;
    RecyclerView recyclerView;

//    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.rv_id);

        personArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));//??

        //datos
        addPersons();

        //adapter
        PersonAdapter personAdapter = new PersonAdapter(personArrayList, getApplicationContext());
        // enviar recyclerview al adapter
        recyclerView.setAdapter(personAdapter);
    }

    private void addPersons() {
        //personArrayList.add(new Person("a", "b", R.drawable.send_icon));
        personArrayList.add(new Person("a", "b", R.drawable.send_icon));
        personArrayList.add(new Person("alfa", "aaaa", R.drawable.campana));
        personArrayList.add(new Person("alfa", "aaaa", R.drawable.campana));
        personArrayList.add(new Person("beta", "bbbb", R.drawable.circular));
        personArrayList.add(new Person("gamma", "cccc", R.drawable.send_icon));

    }
}