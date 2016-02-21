package me.andybarlow.android.compile;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

public class MainActivity extends Activity {
    CardContainer cardContainer;
    CardModel cardx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        cardContainer = (CardContainer) findViewById(R.id.layoutview);
        cardContainer.setOrientation(Orientations.Orientation.Disordered);
        Resources r = getResources();

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

        adapter.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.andysmallcard)));

        adapter.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.andysmallcard)));

        adapter.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.andysmallcard)));

        adapter.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.andysmallcard)));
        CardModel cardModel = new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.andysmallcard));
        cardModel.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                Log.d("Debug", "pressed the card");
            }
        });

        cardModel.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                Log.d("Debug", "liked the card");
            }

            @Override
            public void onDislike() {
                Log.d("Debug", "disliked the card");
            }
        });
        adapter.add(cardModel);
        cardContainer.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
