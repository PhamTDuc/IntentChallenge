package duc.phamtrung.intentchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private final int APP_CONTACT = 1;
    ImageView phone;
    ImageView web;
    ImageView location;
    ImageView emoji;
    LinearLayout layout;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        layout.setVisibility(View.GONE);
        phone = findViewById(R.id.phone);
        web = findViewById(R.id.web);
        emoji = findViewById(R.id.emoji);


        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, duc.phamtrung.intentchallenge.AddContact.class);
                startActivityForResult(intent, APP_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == APP_CONTACT)
        {
            switch (resultCode)
            {
                case RESULT_OK:

                    break;
                case RESULT_CANCELED:
                    break;
            }
        }
    }
}