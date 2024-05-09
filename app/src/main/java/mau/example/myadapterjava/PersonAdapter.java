package mau.example.myadapterjava;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolderNew> {
    ArrayList<Person> personList;

    // crear contexto
    Context context;

    /*public PersonAdapter(ArrayList<Person> personArrayList, Context applicationContext) {
    }*/
    public PersonAdapter(ArrayList<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolderNew onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, null, false);
        return new ViewHolderNew(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolderNew holder, int position) {
        final Person person = personList.get(position);

        holder.tvName.setText(personList.get(position).getName()); // personList.get(position).getName() ** ojo **
        holder.tvDescription.setText(personList.get(position).getDescription());//person.getDescription()
        holder.ivImage.setImageResource(personList.get(position).getImage());
        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, person.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", person.getName());
                intent.putExtra("description", person.getDescription());
                intent.putExtra("image", person.getImage());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    // 2
    @Override
    public int getItemCount() {
        return personList.size();
    }

    // 1
    public class ViewHolderNew extends RecyclerView.ViewHolder {
        // atts
        TextView tvName, tvDescription;
        ImageView ivImage;

        public ViewHolderNew(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_desc);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_img);

        }
    }

}


