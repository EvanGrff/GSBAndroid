
package sio.evan.gsbandroid;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import sio.evan.login.Login;

public class Main extends Activity
{
    private TextView tv;
    public static final int RESULT_Main = 1;

    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);

        //Appel de la page de Login
        startActivityForResult(new Intent(Main.this, Login.class), RESULT_Main);

        tv = new TextView(this);
        setContentView(tv);
    }

    private void startup(Intent i)
    {
        // Récupère l'identifiant
        int user = i.getIntExtra("userid",-1);

        //Affiche les identifiants de l'utilisateur
        tv.setText("UserID: "+String.valueOf(user)+" logged in");
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == RESULT_Main && resultCode == RESULT_CANCELED)
            finish();
        else
            startup(data);
    }
}