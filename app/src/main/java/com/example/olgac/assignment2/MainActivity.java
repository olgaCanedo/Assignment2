package com.example.olgac.assignment2;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Create Navigation drawer and inflate layout
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked())
                    menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                mDrawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){
                    //Replacing the main content with ContentFragment Which is View;
                    case R.id.action_tutor:
                        Log.d(TAG, "tutor home clicked ");
                        return true;
                    case R.id.action_favorites:
                        Log.d(TAG, "favorite home clicked ");
                        return true;
                    case R.id.action_campus:
                        Log.d(TAG, "campus home clicked ");
                        return true;
                    default:
                        Log.d(TAG, "?? ");
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,myToolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        final Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
        Button entry = (Button) findViewById(R.id.btnContinue);
        entry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getOrder()) {
            case 10:
                displayToast(getString(R.string.action_tutor));
                final Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(intent);
                        return false;
                    }
                });
                return true;

            case 20:
                displayToast(getString(R.string.action_favorites));
                Log.d(TAG, "You selected Favorites.");
                return true;

            case 15:
                displayToast(getString(R.string.action_campus));
                final Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(intentMain);
                        return false;
                    }
                });
                return true;

            case 30:
                displayToast(getString(R.string.action_settings));
                Log.d(TAG, "You selected Settings.");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.btHialeah:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Hialeah));
                break;
            case R.id.btInterAmerican:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.InterAmerican));
                break;
            case R.id.btWest:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.West));
                break;
            case R.id.btWolfson:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Wolfson));
                break;
            case R.id.btNorth:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.North));
                break;
            case R.id.btKendall:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Kendall));
                break;
            case R.id.btHomestead:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Homestead));
                break;
            default:
                Log.d(TAG, getString(R.string.nothing_clicked));
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void btnClick(View view) {
        final Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
        Button entry = (Button) findViewById(R.id.btnContinue);
        entry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}

