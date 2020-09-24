package duc.phamtrung.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContact extends AppCompatActivity implements View.OnClickListener {

    EditText inputName;
    EditText inputPhone;
    EditText inputWeb;
    EditText inputAddr;
    Button btnSubmit;
    ImageView emoji_smile;
    ImageView emoji_normal;
    ImageView emoji_angry;
    String mood="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        inputName = findViewById(R.id.inputName);
        inputPhone  = findViewById(R.id.inputPhone);
        inputWeb = findViewById(R.id.inputWeb);
        inputAddr = findViewById(R.id.inputAddr);
        btnSubmit = findViewById(R.id.btnSubmit);
        emoji_smile = findViewById(R.id.smile);
        emoji_normal = findViewById(R.id.norm);
        emoji_angry = findViewById(R.id.angry);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString().trim();
                String phone = inputPhone.getText().toString().trim();
                String web = inputWeb.getText().toString().trim();
                String addr = inputAddr.getText().toString().trim();

                if(name.isEmpty()|| phone.isEmpty() || web.isEmpty() || addr.isEmpty()||AddContact.this.mood.isEmpty())
                {
                    Toast.makeText(AddContact.this, "You must fill all the fields", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("Web", web);
                intent.putExtra("addr", addr);
                intent.putExtra("mood", AddContact.this.mood);
                setResult(RESULT_OK, intent);
                AddContact.this.finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.smile:
                this.mood="smile";
                break;
            case R.id.norm:
                this.mood="norm";
                break;
            case R.id.angry:
                this.mood="angry";
                break;
        }
    }
}