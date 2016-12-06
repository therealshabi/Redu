package testing.example.com.r_edu;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StreamActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    public String EXTRA_CATEGORY = "";
    DataHelper mDataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_stream_recycler_view);
        EXTRA_CATEGORY = getIntent().getStringExtra("EXTRA_CATEGORY");
        mDataHelper = new DataHelper(getBaseContext());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_name);
            getSupportActionBar().setTitle("Your Area of Interest");
        }
        ArrayList<CourseModel> list = new ArrayList<>();
        list = mDataHelper.getCourseList(EXTRA_CATEGORY);
        ArrayList<CenterModel> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.addAll(mDataHelper.getCentresList(list.get(i).getCourseName()));
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        RecyclerAdapter mRecyclerAdapter = new RecyclerAdapter(newList, getBaseContext());
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(StreamActivity.this, MainScreen.class));

                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        ArrayList<CenterModel> list = new ArrayList<>();
        Context mContext;

        public RecyclerAdapter(ArrayList l, Context context) {
            list = l;
            mContext = context;
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getBaseContext()).inflate(getResources().getLayout(R.layout.activity_stream_recycler_view_item), parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.mCentreText.setText("" + list.get(position).getCenterName());
            holder.mCourseText.setText("" + list.get(position).getCenterCourse());
            holder.mNumOfPeople.setText("" + list.get(position).getCenterPeopleNumber());
            holder.mRatingText.setText("" + list.get(position).getCenterRating());
            holder.mCost.setText("" + list.get(position).getCenterPrice());

            if(list.get(position).getCenterName().toUpperCase().equals("PLURALSIGHT")){
                holder.mImage.setImageDrawable(getResources().getDrawable(R.drawable.plural));
            }
            else if(list.get(position).getCenterName().toUpperCase().equals("UDACITY")){
                holder.mImage.setImageDrawable(getResources().getDrawable(R.drawable.udacity));
            }
            else if(list.get(position).getCenterName().toUpperCase().equals("COURSERA")){
                holder.mImage.setImageDrawable(getResources().getDrawable(R.drawable.download));
            }
            else if(list.get(position).getCenterName().toUpperCase().equals("LYNDA")){
                holder.mImage.setImageDrawable(getResources().getDrawable(R.drawable.lynda));
            }

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mCentreText;
        TextView mCourseText;
        TextView mRatingText;
        TextView mNumOfPeople;
        TextView mCost;
        CircleImageView mImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mCentreText = (TextView) itemView.findViewById(R.id.centerName);
            mCourseText = (TextView) itemView.findViewById(R.id.courseName);
            mRatingText = (TextView) itemView.findViewById(R.id.rating);
            mNumOfPeople = (TextView) itemView.findViewById(R.id.numofpeople);
            mCost = (TextView) itemView.findViewById(R.id.price);
            mImage = (CircleImageView) itemView.findViewById(R.id.imageCard);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(StreamActivity.this,DetailActivity.class);
            intent.putExtra("CENTRE",mCentreText.getText().toString());
            intent.putExtra("COURSE",mCourseText.getText().toString());
            startActivity(intent);
        }
    }
}
