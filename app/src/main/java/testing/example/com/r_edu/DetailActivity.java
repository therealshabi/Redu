package testing.example.com.r_edu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shahbaz on 6/12/16.
 */

public class DetailActivity extends AppCompatActivity {

    DataHelper mDataHelper;
    TextView mInfo;
    ImageView mImageView;
    TextView mCourseLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        mInfo = (TextView) findViewById(R.id.info);
        mImageView = (ImageView) findViewById(R.id.courseImage);
        mCourseLink = (TextView) findViewById(R.id.link);

        String center = getIntent().getStringExtra("CENTRE");
        String course = getIntent().getStringExtra("COURSE");
        mDataHelper = new DataHelper(getBaseContext());


        CenterModel model = mDataHelper.getCentre(center, course);
        CourseModel model1 = mDataHelper.getCourse(course);

        mInfo.setText(model1.getCourseInfo());
        mCourseLink.setText(model.getCenterInfo());

        if (center.toUpperCase().equals("UDACITY")) {
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.udacity));
        } else if (center.toUpperCase().equals("PLURALSIGHT")) {
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.plural));
        } else if (center.toUpperCase().equals("LYNDA")) {
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.lynda));
        } else if (center.toUpperCase().equals("COURSERA")) {
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.download));
        }
    }
}
