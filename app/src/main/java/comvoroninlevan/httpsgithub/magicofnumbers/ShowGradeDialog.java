package comvoroninlevan.httpsgithub.magicofnumbers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Levan on 29.10.2017.
 */
//TODO
public class ShowGradeDialog extends AlertDialog{

    protected ShowGradeDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        hide();

    }

    public void showGrade(final Context context, final Class parentClass){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.grade_dialog, null);
        builder.setView(dialogView);
        ImageView gradingDiamonds = (ImageView)dialogView.findViewById(R.id.gradingDiamonds);

        ImageButton backToEasyMenu = (ImageButton)dialogView.findViewById(R.id.backToEasyMenu);
        backToEasyMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, parentClass);
                context.startActivity(intent);
            }
        });
        ImageButton nextQuiz = (ImageButton)dialogView.findViewById(R.id.nextQuiz);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void hide() {
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Hide action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
