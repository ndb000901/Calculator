package xyz.wuhen.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    NavController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this,controller);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle(R.string.app_name);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (controller.getCurrentDestination().getId() == R.id.questionFragment) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.dialog_title_message));
            builder.setPositiveButton(R.string.dialog_positive_message, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    controller.navigateUp();
                }
            });

            builder.setNegativeButton(R.string.dialog_negative_message, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        } else if (controller.getCurrentDestination().getId() == R.id.loseFragment) {
            controller.navigate(R.id.action_loseFragment_to_titleFragment);
        } else if (controller.getCurrentDestination().getId() == R.id.winFragment) {
            controller.navigate(R.id.action_winFragment_to_titleFragment);
        }

        return super.onSupportNavigateUp();
    }


}