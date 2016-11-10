package test.project.a1110_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String[] fruits = {"蘋果","西瓜","芒果","水梨"};
    String[] cities = {"台北","桃園","台中","高雄"};
    String[] codes  = {"02","03","04","07"};
    int[] icons = {R.drawable.tpe,R.drawable.ty,R.drawable.tc,R.drawable.ks};
    ArrayList<Map<String,Object>> mylist;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);

        //ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,
        //            android.R.layout.simple_list_item_1,fruits);

        mylist = new ArrayList<>();
        for (int i=0;i<cities.length;i++)
        {
            Map m = new HashMap();
            m.put("city", cities[i]);
            m.put("code", codes[i]);
            m.put("img", icons[i]);
            mylist.add(m);
        }

        SimpleAdapter ad = new SimpleAdapter(MainActivity.this,
                mylist, R.layout.myitem,
                new String[] {"city","code","img"},
                new int[] {R.id.textView,R.id.textView2,R.id.imageView2});

        lv.setAdapter(ad);
    }
}
