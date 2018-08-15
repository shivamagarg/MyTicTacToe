package com.example.sccubs.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 int myplayerturn=0;
 int roundCount=0;
 int [] gameState={2,2,2,2,2,2,2,2,2};
 //0 is cross and 1 is circle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageTapped(View view) {
        ImageView imageTap=(ImageView) view;
        int tagvalue=Integer.parseInt(imageTap.getTag().toString());
        if (gameState[tagvalue]==2)
        {
            gameState[tagvalue]=myplayerturn;
            if(myplayerturn==0)
            {
                imageTap.setImageResource(R.drawable.cross);
                imageTap.animate().rotation(imageTap.getRotation()+360).setDuration(1500);
                myplayerturn=1;
            }
            else
            {
                imageTap.setImageResource(R.drawable.circle);
                imageTap.animate().rotation(imageTap.getRotation()+360).setDuration(1500);
                myplayerturn=0;
            }
            roundCount++;
            if(checkforwin())
            {
                if(myplayerturn==1)
                {
                    Toast.makeText(this,"Cross Wins",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this,"Circle Wins",Toast.LENGTH_SHORT).show();
                }
                reset();
            }
            if(roundCount==9)
            {
                Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
                reset();
            }
        }


    }
    public void reset()
    {
        myplayerturn=0;

        roundCount=0;

        for (int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }


        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.l1);
        for (int i=0;i<linearLayout.getChildCount();i++)
        {
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayout2=(LinearLayout)findViewById(R.id.l2);
        for (int i=0;i<linearLayout2.getChildCount();i++)
        {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayout3=(LinearLayout)findViewById(R.id.l3);
        for (int i=0;i<linearLayout3.getChildCount();i++)
        {
            ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }

    public boolean checkforwin()
    {
        int i=0;
        for(i=0;i<=8;i++)
        {
            if(i==0||i==3||i==6)
            {
                if(gameState[i]==gameState[i+1]&&gameState[i+2]==gameState[i+1]&& gameState[i]!=2)
                {
                    return true;
                }

            }
            if(i==0||i==1||i==2)
            {
                if(gameState[i]==gameState[i+3]&&gameState[i+3]==gameState[i+6]&&gameState[i]!=2)
                {
                    return true;
                }

            }
            if(i==0)
            {
                if(gameState[i]==gameState[i+4]&&gameState[i+4]==gameState[i+8]&&gameState[i]!=2)
                {
                    return true;
                }

            }
            if(i==2)
            {
                if(gameState[i]==gameState[i+2]&&gameState[i+2]==gameState[i+4]&&gameState[i]!=2)
                {
                    return true;
                }

            }

        }
        return false;
    }

    public void playAgain(View view) {
        reset();
    }
}
