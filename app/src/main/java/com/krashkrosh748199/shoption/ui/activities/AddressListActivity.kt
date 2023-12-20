package com.krashkrosh748199.shoption.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krashkrosh748199.shoption.R
import com.krashkrosh748199.shoption.firestore.FireStoreClass
import com.krashkrosh748199.shoption.models.Address
import com.krashkrosh748199.shoption.ui.adapters.AddressListAdapter
import com.krashkrosh748199.shoption.utils.SwipeToEditCallback

class AddressListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_list)
        setupActionBar()

        findViewById<TextView>(R.id.tv_add_address).setOnClickListener {
            val intent = Intent(this@AddressListActivity, AddEditAddressActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setupActionBar() {

        setSupportActionBar(findViewById(R.id.toolbar_address_list_activity))

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_address_list_activity).setNavigationOnClickListener { onBackPressed() }
    }

    override fun onResume() {
        super.onResume()
        getAddressList()
    }

    private fun getAddressList() {

        // Show the progress dialog.
        showProgressDialog(resources.getString(R.string.please_wait))

        FireStoreClass().getAddressesList(this@AddressListActivity)
    }

    fun successAddressListFromFirestore(addressList: ArrayList<Address>) {

        // Hide the progress dialog
        hideProgressDialog()

        if (addressList.size > 0) {

            findViewById<RecyclerView>(R.id.rv_address_list).visibility = View.VISIBLE
            findViewById<TextView>(R.id.tv_no_address_found).visibility = View.GONE

            findViewById<RecyclerView>(R.id.rv_address_list).layoutManager = LinearLayoutManager(this@AddressListActivity)
            findViewById<RecyclerView>(R.id.rv_address_list).setHasFixedSize(true)

            val addressAdapter = AddressListAdapter(this@AddressListActivity, addressList)
            findViewById<RecyclerView>(R.id.rv_address_list).adapter = addressAdapter

            val editSwipeHandler = object : SwipeToEditCallback(this) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    val adapter = findViewById<RecyclerView>(R.id.rv_address_list).adapter as AddressListAdapter
                    adapter.notifyEditItem(
                        this@AddressListActivity,
                        viewHolder.adapterPosition
                    )

                }
            }

            val editItemTouchHelper=ItemTouchHelper(editSwipeHandler)
            editItemTouchHelper.attachToRecyclerView(findViewById(R.id.rv_address_list))

        } else {
            findViewById<RecyclerView>(R.id.rv_address_list).visibility = View.GONE
            findViewById<TextView>(R.id.tv_no_address_found).visibility = View.VISIBLE
        }

    }
}