package com.example.projectphase1.main;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a17l_4343_ui_design.JobsClass;
import com.example.a17l_4343_ui_design.R;

import java.util.List;

public class JobAdopter extends RecyclerView.Adapter<JobAdopter.MyViewHolder> {


    Context mcontext;
    List<JobsClass> jobsClassList;
    EditText text;
    EditText editText;
    Dialog dialog;

    public JobAdopter(Context mcontext, List<JobsClass> jobsClassList) {
        this.mcontext = mcontext;
        this.jobsClassList = jobsClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mcontext).inflate(R.layout.job_item,parent,false);
        final MyViewHolder myViewHolder=new MyViewHolder(view);

        dialog=new Dialog(mcontext);
        dialog.setContentView(R.layout.dailogue_job_request);

        myViewHolder.linearLayout_Job_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView rID=(TextView) dialog.findViewById(R.id.rIDd);
                final TextView rName=(TextView) dialog.findViewById(R.id.job_request_name);
                ImageView rImage=(ImageView)dialog.findViewById(R.id.job_request_image);
                rID.setText(""+jobsClassList.get(myViewHolder.getAdapterPosition()).getJobId());
                rName.setText(""+jobsClassList.get(myViewHolder.getAdapterPosition()).getJobName());
                rImage.setImageResource(jobsClassList.get(myViewHolder.getAdapterPosition()).getJobPhoto());
                dialog.show();
                text=dialog.findViewById(R.id.job_task_request_description);
                editText=dialog.findViewById(R.id.job_task_location);
                final Button dialogueButton=(Button) dialog.findViewById(R.id.job_request_btn);
                dialogueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(TextUtils.isEmpty(editText.getText()) ||TextUtils.isEmpty(text.getText()))
                        {
                            Toast.makeText(mcontext,"Enter the proper required details",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(mcontext, "the request for task " + rName.getText() + " has sent", Toast.LENGTH_SHORT).show();
                            dialog.hide();

                            editText.setText("");
                            text.setText("");
                        }
                    }
                });
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.job_name.setText(jobsClassList.get(position).getJobName());
        holder.job_image.setImageResource(jobsClassList.get(position).getJobPhoto());

    }

    @Override
    public int getItemCount() {
        return jobsClassList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private LinearLayout linearLayout_Job_item;
        private TextView job_name;
        private ImageView job_image;
        public MyViewHolder( View itemView) {
            super(itemView);

            linearLayout_Job_item=(LinearLayout)itemView.findViewById(R.id.job_item_id);
            job_name= (TextView)itemView.findViewById(R.id.job_namee_id);
            job_image= (ImageView) itemView.findViewById(R.id.job_item_imagee);

        }
    }
}
