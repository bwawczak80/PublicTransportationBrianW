package net.wawczak.brian.publictransportationbrianw;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Integer[] transitMode = {R.drawable.amtrak, R.drawable.ctabus, R.drawable.ctael
            , R.drawable.metra, R.drawable.ohare, R.drawable.pace};

    Integer[] transitMaps = {R.drawable.amtrackmap, R.drawable.ctabusmap, R.drawable.elmap
            , R.drawable.metramap, R.drawable.oharemap, R.drawable.pacemap};

    String[] titles = {"Amtrak", "CTA Bus", "CTA Elevated Train", "Metra", "Ohare Airport", "Pace Bus"};

    ImageView map;

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = findViewById(R.id.gridView);
        final ImageView map = findViewById(R.id.imgMap);
        title = findViewById(R.id.idTitleTxt);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                title.setText(titles[position]);
                map.setImageResource(transitMaps[position]);

            }
        });

    }

    public class ImageAdapter extends BaseAdapter {

        private Context context;

        ImageAdapter(Context c) {

            context=c;
        }

        @Override
        public int getCount() {
            return transitMode.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            map = new ImageView(context);
            map.setImageResource(transitMode[position]);
            map.setScaleType(ImageView.ScaleType.FIT_XY);
            map.setLayoutParams(new GridView.LayoutParams(330,300));
            return map;
        }
    }
}
