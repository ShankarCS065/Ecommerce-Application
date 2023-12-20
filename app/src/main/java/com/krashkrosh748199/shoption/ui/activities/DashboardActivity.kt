package com.krashkrosh748199.shoption.ui.activities

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.krashkrosh748199.shoption.R

// TODO Step 1: Create the Dashboard Activity as the Bottom Navigation Activity.
// START
/**
 *  Dashboard Screen of the app.
 */
class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.setBackgroundDrawable(
            ContextCompat.getDrawable(
                this@DashboardActivity,
                R.drawable.app_gradient_color_background
            )
        )
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_dashboard) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        doubleBackToEXit()
    }
}
// END
