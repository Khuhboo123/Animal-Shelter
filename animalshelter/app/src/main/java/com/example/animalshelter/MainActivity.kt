package com.example.animalshelter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDatabase = FirebaseDatabase.getInstance().getReference("animal")
        mRecyclerView = findViewById(R.id.listView)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        logRecyclerView()



    }
    private fun logRecyclerView() {
        var FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<animal, animalViewHolder>
            animal::class.java,
            R.layout.list_layout,
            animalViewHolder::class.java,
            mDatabase
        ){
            override fun populateViewHolder(viewHolder: animalViewHolder, model: animal, position: Int){

                viewHolder.mView.AnimalType.setText(model.AnimalType)
                viewHolder.mView.ConditionFound.setText(model.ConditionFound)
                viewHolder.mView.Description.setText(model.Description)
                viewHolder.mView.Location.setText(model.Location)
                Picasso.with(this@MainActivity).load(model.Image).into(viewHolder.mView.userimageView)

            }
        }

        mRecyclerView.adapter = FirebaseRecyclerAdapter
    }




    class animalViewHolder(var mView: View) : RecyclerView.ViewHolder(mView){

    }


}




