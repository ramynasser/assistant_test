package mno.mohamed_youssef.assistant_test;

import android.widget.BaseAdapter;

/**
 * Created by Mohamed Yossif on 30/04/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskListAdapter  extends BaseAdapter{

    private Context context;
    private ArrayList<Schedule_Assistant> schedual_assistant;
    private static LayoutInflater inflater=null;


    public TaskListAdapter(Context context,ArrayList<Schedule_Assistant> schedule_assistant) {
        this.context = context;
        this.schedual_assistant=schedule_assistant;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return schedual_assistant.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row,parent,false);

        TextView subject =   (TextView)vi.findViewById(R.id.subject);
        TextView year    =   (TextView)vi.findViewById(R.id.year);
        TextView group   =   (TextView)vi.findViewById(R.id.group);
        TextView begin   =   (TextView)vi.findViewById(R.id.begin);
        TextView place   =   (TextView)vi.findViewById(R.id.place);
        TextView end     =   (TextView)vi.findViewById(R.id.end);



        subject.setText(schedual_assistant.get(position).getSubject());
        year.setText(Integer.toString(schedual_assistant.get(position).getYear()));
        group.setText(schedual_assistant.get(position).getGroup());
        place.setText(schedual_assistant.get(position).getPlace());
        end.setText(Double.toString(schedual_assistant.get(position).getEnd()));
        begin.setText(Double.toString(schedual_assistant.get(position).getBegin()));

        return vi;
    }
}
