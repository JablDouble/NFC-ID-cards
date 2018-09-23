package com.jabl.nfc_id_cards;

import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ImageView mImageNfc;
    private Button mShowInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView_main);
        mImageNfc = (ImageView) findViewById(R.id.icon_nfc);
        mShowInfo = (Button) findViewById(R.id.show_nfc_info);


        NfcAdapter mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter == null) {
            mTextView.setText(R.string.nfc_not_found);
            mImageNfc.setImageResource(R.drawable.nfc_not_found_icon);
            //mShowInfo.setVisibility(View.VISIBLE);
        } else {
            if (!mNfcAdapter.isEnabled()) {
                mTextView.setText(R.string.nfc_disabled);
                mImageNfc.setImageResource(R.drawable.nfc_icon_disabled);
            } else {
                mTextView.setText(R.string.nfc_found);
                mImageNfc.setImageResource(R.drawable.nfc_icon_found);
            }
        }
    }
}
