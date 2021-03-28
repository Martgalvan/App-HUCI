package com.example.navigationdrawerfinal.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawerfinal.R;


public class Main_fragment extends Fragment{
    @Nullable
    //@Override
    private Dialog WebDialog1,WebDialog2;
    private WebView URL1, URL2;
    private Button btnURL1,btn2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);
        btnURL1 = (Button) view.findViewById(R.id.buttonHome);

        btnURL1.setOnClickListener(new View.OnClickListener()
        {

            @Override

            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.es/maps/place/Hospital+Universitario+del+Sureste/@40.2969232,-3.4590947,17z/data=!3m1!4b1!4m5!3m4!1s0xd423fa11de6e051:0x6d67ccb2c5579586!8m2!3d40.2969232!4d-3.456906"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);



            }});
            btn2 = (Button) view.findViewById(R.id.buttonPhone);
            btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:918394000"));
                startActivity(intent);
            }



        });

        return view;
    }
}
