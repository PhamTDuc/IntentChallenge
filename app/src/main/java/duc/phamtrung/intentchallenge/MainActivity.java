package duc.phamtrung.intentchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int APP_CONTACT = 1;
    ImageView ivphone, ivweb, ivemoji, ivlocation;
    LinearLayout layout;
    Button btnAdd;
    String mood, name, phone, web, addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        layout.setVisibility(View.GONE);
        ivphone = findViewById(R.id.phone);
        ivweb = findViewById(R.id.web);
        ivlocation=findViewById(R.id.location);
        ivemoji = findViewById(R.id.emoji);
        btnAdd = findViewById(R.id.btnAdd);

        ivphone.setOnClickListener(MainActivity.this);
        ivweb.setOnClickListener(MainActivity.this);
        ivlocation.setOnClickListener(MainActivity.this);
        ivemoji.setOnClickListener(MainActivity.this);
        btnAdd.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnAdd: {
                Intent intent = new Intent(MainActivity.this, duc.phamtrung.intentchallenge.AddContact.class);
                startActivityForResult(intent, APP_CONTACT);
                break;
            }

            case R.id.phone: {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);
                break;
            }

            case R.id.location:{
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+addr));
                startActivity(intent);
                break;
            }
            case R.id.web: {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+web));
                startActivity(intent);
                break;
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == APP_CONTACT)
        {
            switch (resultCode)
            {
                case RESULT_OK:
                    name = data.getStringExtra("name");
                    phone = data.getStringExtra("phone");
                    web = data.getStringExtra("web");
                    addr = data.getStringExtra("addr");
                    mood = data.getStringExtra("mood");
                    switch (mood)
                    {
                        case "smile":
                            ivemoji.setImageResource(R.drawable.emoji_smile);
                            break;
                        case "norm":
                            ivemoji.setImageResource(R.drawable.emoji_normal);
                            break;
                        case "angry":
                            ivemoji.setImageResource(R.drawable.emoji_angry);
                            break;
                    }
                    layout.setVisibility(View.VISIBLE);
                    break;
                case RESULT_CANCELED:
                default:
                    break;
            }
        }
    }


}