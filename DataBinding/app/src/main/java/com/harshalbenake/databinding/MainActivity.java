package com.harshalbenake.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.harshalbenake.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Presenter{
    private int mCounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the content view (replacing `setContentView`)
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //adding data to pojoobject
        DataPojo dataPojo=new DataPojo("Harshal","harshalbenake@gmail.com");
        //setting datapojo to binding
        binding.setDataPojo(dataPojo);
        //set listner to9 binding
        binding.setPresenter(this);
        //setting textview appearance without creating textview object
        binding.tvName.setTextSize(25f);
    }

    @Override
    public void onSaveClick(View view, DataPojo dataPojo) {
        mCounter=mCounter+1;
        Toast.makeText(this,"Name: "+dataPojo.getName()+"\nEmail: "+dataPojo.getEmail()+"\n"+mCounter,Toast.LENGTH_SHORT).show();
    }


    /**
     * Inner static class Utils
     */
    public static class Utils {
        Context mContext;
        public Utils(Context context) {
            this.mContext=context;
        }

        /**
         * appends Surname
         * @param strText
         * @return
         */
        public static String appendSurname(String strText){
            return strText+" Benake";
        }
    }

}
